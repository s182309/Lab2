package it.polito.tdp.spellchecker.controller;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.spellchecker.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class SpellCheckerController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> box;

    @FXML
    private TextArea txtInput;

    @FXML
    private TextArea txtOutput;

    @FXML
    private Label txtResult;

    @FXML
    private Label txtTime;
    
    private Dictionary dictionary;
    private Dictionary wordList;
    
    public void setDictionary(Dictionary d){
    	dictionary = d;
    }
    
    @FXML
    void doLoad(ActionEvent event) {
    	if(box.getValue().compareTo("English")==0){
    		wordList = new EnglishDictionary();
    		boolean car = wordList.loadDictionary();
    		if(car==false)
    			txtResult.setText("File Error! Try to choose the language again");
    	}
    	else{
    		wordList = new ItalianDictionary();
    		boolean car = wordList.loadDictionary();
    		if(car==false)
    			txtResult.setText("File Error! Try to choose the language again");
    	}
    		

    }

    @FXML
    void doClearText(ActionEvent event) {
    	txtInput.setText("");
    	txtOutput.setText("");

    }

    @FXML
    void doSpellCheck(ActionEvent event) {
    	if(box.getValue()==null)
    		txtResult.setText("Choose a language!");
    	
    	String text = new String(txtInput.getText().trim().toLowerCase());
    	for(int i =0 ; i<text.length() ; i++)
    	{  if(Character.isLetter(text.charAt(i))==false &&
    	
    			Character.isWhitespace(text.charAt(i)) == false &&
    			String.valueOf(text.charAt(i)).matches("[\\p{Punct}]")== false)
    		txtResult.setText("Wrong Format!");
    	
    	
    	
    	
    	}
    	

    }

    @FXML
    void initialize() {
        assert box != null : "fx:id=\"box\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtInput != null : "fx:id=\"txtInput\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtOutput != null : "fx:id=\"txtOutput\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtTime != null : "fx:id=\"txtTime\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        txtResult.setText("");
        txtTime.setText("");
        box.getItems().addAll("English" , "Italian");
        

    }
}
