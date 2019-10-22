/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sentencia;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

/**
 *
 * @author Jose Pablo Sandoval
 */
public class FXMLDocumentController implements Initializable {    
    @FXML private TextArea area;
    private String[] datos;
    
    @FXML
    private void limpiar(ActionEvent event) {
        System.out.println("limpio!");        
        area.setText("");
    }
    
    @FXML
    private void descomponer(ActionEvent event) {
        System.out.println("sucio!");
        System.out.println(area.getText());        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
