/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordcounter;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

/**
 *
 * @author mezem
 */
public class FXMLDocumentController implements Initializable {
    @FXML
    private Label wordCountLabel;
    @FXML
    private Label dotCountLabel;
    @FXML
    private Label sentenceCountLabel;
    @FXML
    private TextArea wordCounter;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
