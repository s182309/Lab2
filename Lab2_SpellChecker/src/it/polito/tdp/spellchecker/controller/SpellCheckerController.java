package it.polito.tdp.spellchecker.controller;


import java.util.List;
import java.math.RoundingMode;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.LinkedList;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import it.polito.tdp.spellchecker.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

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
    private TextFlow txtOutput;

    @FXML
    private Label txtResult;

    @FXML
    private Label txtTime;
  
    
    private EnglishDictionary english; 
   private ItalianDictionary italian;
   
    
    public void setModel( EnglishDictionary eng , ItalianDictionary ita){
    	english = eng;
    	italian = ita;
    	}
   
    @FXML
    void doLoad(ActionEvent event) {
    	if(box.getValue().compareTo("English")==0){
    		
            boolean car = english.loadDictionary();
    		if(car==false)
    			txtResult.setText("File Error! Try to choose the language again");
    	}
    	else{
    		
    		boolean car = italian.loadDictionary();
    		if(car==false)
    			txtResult.setText("File Error! Try to choose the language again");
    	}
    		

    }

    @FXML
    void doClearText(ActionEvent event) {
    	txtInput.setText("");
    	txtOutput.getChildren().clear();
    //	txtOutput.setText("");

    }

    @FXML
    void doSpellCheck(ActionEvent event) {
    	
    	double start = System.nanoTime() /1e9;
    	double fin = 0.0 ;
    	txtOutput.getChildren().clear();
    	txtOutput.setVisible(false);
    	
    	if(box.getValue()==null) {
    		txtResult.setText("Choose a language!");
    	     return;}
    	
    	String text = new String(txtInput.getText().trim().toLowerCase());
    	
    	for(int i =0 ; i<text.length() ; i++)
    	{  if(Character.isDigit(text.charAt(i))  ) {
    		txtResult.setText("Wrong Format!");
    		return;}
    	
    	}
    	
    	List <String> param = new LinkedList <String>();
    	List <RichWord> result = new LinkedList <RichWord> ();
    	String output = "";
    	
    	
    	if(box.getValue()=="English"){
    		StringTokenizer st = new StringTokenizer(text);
    		while(st.hasMoreTokens())
    		{  String token = st.nextToken();
    					param.add(token.replaceAll("[^a-zA-Z]", ""));
    			
    		}
    		result = english.spellCheckText(param);
    		for(RichWord r : result){
    		       //parte relativa al txtflow...l'outuput mi serve solo per capire se la stringa degli errori e' vuota
        		Text txt = new Text(r.getWord()+" ");
        			if(r.isCorrect()==false)
        			txt.setFill(Color.RED);
        			txtOutput.getChildren().add(txt);
    		
    		if(r.isCorrect()==false)
    			output += r.getWord()+" ";
    			} 
    		
    	}
    	
    	if(box.getValue()=="Italian"){
    		StringTokenizer st = new StringTokenizer(text);
    		while(st.hasMoreTokens())
    		{  String token = st.nextToken();
    			
    				param.add(token.replaceAll("[^a-zA-Z]", ""));
    			
    		}
    		result = italian.spellCheckText(param);
    		
    		
    		
    		for(RichWord r : result) {
    		if(r.isCorrect()==false)
    			output += r.getWord()+" ";
    			
                //parte relativa al txtflow...l'outuput mi serve solo per capire se la stringa degli errori e' vuota
    		Text txt = new Text(r.getWord()+" ");
    			if(r.isCorrect()==false)
    			txt.setFill(Color.RED);
    			txtOutput.getChildren().add(txt);
    		}
    	
    	}
    	if(output.length()==0)
    		txtResult.setText("Your text is correct!");
    		else{
    			
    			txtResult.setTextFill(Color.RED);
    			txtResult.setText("Your text contains errors !");
    
    		}
    	
    	fin = System.nanoTime() / 1e9 ;
    	
     //  txtOutput.setText(output);
    	
    	txtOutput.setVisible(true);
    	
    	
    	double time = (double) fin-start   ;
    	 // DecimalFormat (di default arrotondamento in stile Math.rint())
        DecimalFormat decForm = new DecimalFormat("#.######", new DecimalFormatSymbols());
        decForm.setRoundingMode(RoundingMode.CEILING); // solo da JAVA 6 in poi
         
    	txtTime.setText("Spell check completed in " + decForm.format(time) + " seconds.");
    	return;

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
