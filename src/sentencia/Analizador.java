/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sentencia;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Isaac A. Marin
 */
public class Analizador {
    
    private String sentencia;
    private ArrayList<String> sentenciaPartes;
    private String caracter;
    
    public Analizador(String sentencia){
        this.sentencia = sentencia;
        sentenciaPartes = new ArrayList<>();
    }

    public void setSentencia(String tencia) {
        this.sentencia = sentencia;
    }
    
    public void validateSentence(){
        separed();
        imprimir();
    }
    
    private void separed(){
        
        String[] aux = sentencia.split("");
        int va = 0;
        String valor= "";
//        while(va<aux.length){
//            if(aux[va].equals(" ")){
//                sentenciaPartes.add(valor);
//                valor="";
//                va++;
//            } else {
//                valor+=aux[va];
//                va++;
//            }
//        }
        
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
            }else if(aux[i].equals('"')){
                if(valor.equals(" ")){
                }else{
                    if(valor.equals("")){
                    }else{
                        sentenciaPartes.add(valor);
                    }
                    sentenciaPartes.add("'");
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
        for(String aux : sentenciaPartes){
            System.out.println(aux);
        }
    }
    
}
