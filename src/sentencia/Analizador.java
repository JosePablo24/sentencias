/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sentencia;

import java.util.ArrayList;

/**
 *
 * @author Isaac A. Marin
 */
public class Analizador {
    
    private String sentencia;
    private final ArrayList<String> sentenciaPartes;
    private String caracter;
    private String[] auxiliar;
    private int index = 0;
    private boolean correctgb=true;
    private boolean correctg=true;
    private boolean digit=true;
    
    ArrayList<Palabra> sentenciaValidada;
    
    public Analizador(String sentencia){
        this.sentencia = sentencia;
        sentenciaPartes = new ArrayList<>();
        sentenciaValidada = new ArrayList<>();
    }

    public void setSentencia(String sentencia) {
        this.sentencia = sentencia;
    }
    
    public ArrayList<Palabra> validateSentence(){
        separed();
        valida();
        //imprimir();
        return sentenciaValidada;
    }
    
    private void separed(){
        String[] aux = sentencia.split("");
        String valor= "";
        char c = (char)34;
        for(int i = 0;i<aux.length;i++){
            if(aux[i].equals(" ")){
                if(valor.equals("")){
                }else{
                    sentenciaPartes.add(valor);
                }
                valor="";
            }else if(aux[i].equals("=")){
                if(valor.equals(" ")){
                }else{
                    if(valor.equals("")){
                    }else{
                        sentenciaPartes.add(valor);
                    }
                    sentenciaPartes.add("=");
                    valor="";
                }
            }else if(aux[i].equals(">")){
                if(valor.equals(" ")){
                }else{
                    if(valor.equals("")){
                    }else{
                        sentenciaPartes.add(valor);
                    }
                    sentenciaPartes.add(">");
                    valor="";
                }
            }else if(aux[i].equals("<")){
                if(valor.equals(" ")){
                }else{
                    if(valor.equals("")){
                    }else{
                        sentenciaPartes.add(valor);
                    }
                    sentenciaPartes.add("<");
                    valor="";
                }
            }else if(aux[i].equals("!")){
                if(valor.equals(" ")){
                }else{
                    if(valor.equals("")){
                    }else{
                        sentenciaPartes.add(valor);
                    }
                    sentenciaPartes.add("!");
                    valor="";
                }
            }else if(aux[i].equals("'")){
                if(valor.equals(" ")){
                }else{
                    if(valor.equals("")){
                    }else{
                        sentenciaPartes.add(valor);
                    }
                    sentenciaPartes.add("'");
                    valor="";
                }
            }else if(aux[i].charAt(0) == c){
                if(valor.equals(" ")){
                }else{
                    if(valor.equals("")){
                    }else{
                        sentenciaPartes.add(valor);
                    }
                    String com = String.valueOf(c);
                    sentenciaPartes.add(com);
                    valor="";
                }
            }else if(aux[i].equals(",")){
                if(valor.equals(" ")){
                }else{
                    if(valor.equals("")){
                    }else{
                        sentenciaPartes.add(valor);
                    }
                    sentenciaPartes.add(",");
                    valor="";
                }
            }else{
                valor+=aux[i];
            }
            if(aux.length-1 == i){
                sentenciaPartes.add(valor);
            }
        }
        
    }
    
    private void imprimir() {
        sentenciaPartes.forEach((aux) -> {
            System.out.println(aux);
        });
    }
    
    public boolean palabraReservada(String datos){
        String dat = datos.toLowerCase();
        return dat.equals("delete") | dat.equals("from") | dat.equals("or") | dat.equals("and") | dat.equals("where") | dat.equals("using") | dat.equals("order") | dat.equals("by") | dat.equals("limit");
    }

    private void valida() {
        sentenciaPartes.forEach((aux) -> {
            boolean reservada = palabraReservada(aux);
            if(reservada){
                sentenciaValidada.add(new Palabra(aux, 0, 0, "green"));
            }else if(comparaciones(aux)){
                sentenciaValidada.add(new Palabra (aux,0,0,"vio"));
            }else{
                auxiliar = null;
                auxiliar = aux.split("");
                validaFragmento(aux);
            }
        });
    }
    
    void validaNumero(){
        /// numero
        // fecha
        // hora
        if(index<auxiliar.length){
            String val = whatIs(auxiliar[index]);
            if(val.equals("digito")){
                index++;
                validaNumero();
            }else if(val.equals("punto")){
                index++;
                onlyNum();
            }
        }
    }
    
    void onlyNum(){
        if(index<auxiliar.length){
            String val = whatIs(auxiliar[index]);
            if(val.equals("digito")){
                index++;
                onlyNum();
            }else{
                index++;
                digit=false;
            }
        }
    }
    
    void validaFragmento(String fin){
        
        String val = whatIs(auxiliar[index]);
        if(val.equals("digito")){
            index++;
            validaNumero();
            if(digit){
                sentenciaValidada.add(new Palabra(fin,0,0,"white"));
                digit=true;
                index=0;
            }else{
                sentenciaValidada.add(new Palabra(fin,0,0,"red"));
                digit=true;
                index=0;
            }
        }else if(val.equals("letra")){
            index++;
            validaIdP();
            if(correctg && correctgb){
                sentenciaValidada.add(new Palabra(fin,0,0,"white"));
                correctg=true;
                correctgb=true;
                index=0;
            }else{
                sentenciaValidada.add(new Palabra(fin,0,0,"red"));
                correctg=true;
                correctgb=true;
                index=0;
            }
        }
    }
    
    void validaIdP(){
        if(index<auxiliar.length){
            String val = whatIs(auxiliar[index]);
            if(val.equals("letra") || val.equals("digito")){
                index++;
                validaIdP();
            }else if(val.equals("punto")|| val.equals("gb") || val.equals("g")){
                index++;
                validaIdP();
            }else{
                correctg=false;
            }
        }
    }
    
    public boolean comparaciones(String datos){
        return datos.equals("<=") | datos.equals("=") | datos.equals("<>") | datos.equals("<") | datos.equals(">") | datos.equals(">=");
    } 
    
    private void onlyLetra() {
        if(index<auxiliar.length){
            String val = whatIs(auxiliar[index]);
            System.out.println("aqui we---"+auxiliar[index]);
            if(val.equals("letra") || val.equals("digito")){
                System.out.println("entre");
                index++;
                soloLetraAndNum();
            }else{
                correctg=false;
                correctgb=false;
            }
        }else{
            correctg=false;
            correctgb=false;
        }
    }
    
    private void soloLetraAndNum(){
        if(index<auxiliar.length){
            String val = whatIs(auxiliar[index]);
            System.out.println("aqui we---"+auxiliar[index]);
            if(val.equals("letra") || val.equals("digito")){
                System.out.println("entre");
                index++;
                validaIdP();
            }else{
                correctg=false;
                correctgb=false;
            }
        }
    }
    
    private String whatIs(String valor){
        String tipo;
        switch(valor){
            case "0":
                tipo = "digito";
                break;
            case "1":
                tipo = "digito";
                break;
            case "2":
                tipo = "digito";
                break;
            case "3":
                tipo = "digito";
                break;
            case "4":
                tipo = "digito";
                break;
            case "5":
                tipo = "digito";
                break;
            case "6":
                tipo = "digito";
                break;
            case "7":
                tipo = "digito";
                break;
            case "8":
                tipo = "digito";
                break;
            case "9":
                tipo = "digito";
                break;
            case ".":
                tipo = "punto";
                break;
            case "_":
                tipo = "gb";
                break;
            case "-":
                tipo = "g";
                break;
            default:
                tipo = "letra";
                break;
        }
        return tipo;
    }
}