/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sentencia;

import java.awt.event.KeyEvent;
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
    
    @FXML private Label label;
    @FXML private TextArea area;
    
    Analizador lexico; 
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        
    }
    
    @FXML
    private void limpiar(ActionEvent event) {
        area.setText("");
        
    }
    
    @FXML
    private void descomponer(ActionEvent event) {
        lexico = new Analizador(area.getText());
        lexico.validateSentence();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
