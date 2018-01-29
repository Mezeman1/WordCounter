/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordcounter;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author mezem
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label wordCountLabelFill;
    @FXML
    private Label tokenCountLabelFill;
    @FXML
    private Label sentenceCountLabelFill;
    @FXML
    private TextArea wordCounter;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //On key released eventlistener.
        wordCounter.addEventHandler(KeyEvent.KEY_RELEASED, new EventHandler() {
            @Override
            public void handle(Event event) {
                checkChanged();
            }
        });
        
    }

    private void checkChanged() {
        String text = wordCounter.getText();
        countLetters(text);
        countWords(text);
        countSentence(text);
    }

    private void countLetters(String text) {
        String[][] replacements = {{".", ""},
            {"!", ""}, {"?", ""}, {",", ""}, {" ", ""},
            {"<", ""}, {">", ""}, {"'", ""}, {"\"", ""},
            {"@", ""}, {"#", ""}, {"$", ""}, {"%", ""},
            {"^", ""}, {"&", ""}, {"*", ""}, {"(", ""},
            {")", ""}, {"-", ""}, {"+", ""}, {"=", ""},
            {"_", ""}, {"`", ""}, {"/", ""}, {":", ""},
            {"{", ""}, {"[", ""}, {"]", ""}, {";", ""},
            {"}", ""}, {"\\", ""}, {"|", ""}};
        
        String toCheck = text;
        for(String[] replacement : replacements){
            toCheck = toCheck.replace(replacement[0], replacement[1]);
        }
        
        tokenCountLabelFill.setText(" " + toCheck.length());
    }

    private void countWords(String text) {
       String toCheck = text;
       //TODO: Multiple spaces adds words.
       String[] words = toCheck.split(" ");
       int amountOfWords = words.length;
        for(String x : words){
            if(x.isEmpty()){
                amountOfWords = amountOfWords - 1;
            }
        }
       
       
       
       wordCountLabelFill.setText(" " + amountOfWords);
    }

    private void countSentence(String text) {
        String toCheck = text;
        
        //TODO: Fix problem placing multiple characters adding sentence.
        int amountOfSentences = toCheck.split("[!?.:]+").length;;

        sentenceCountLabelFill.setText(" " + amountOfSentences);
    }
}
