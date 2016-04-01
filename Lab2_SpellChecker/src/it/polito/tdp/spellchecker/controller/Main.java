package it.polito.tdp.spellchecker.controller;
	
import it.polito.tdp.spellchecker.db.DictionaryDAO;
import it.polito.tdp.spellchecker.model.*;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("SpellChecker.fxml"));
			BorderPane root = (BorderPane)loader.load();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			EnglishDictionary eng= new EnglishDictionary();
			DictionaryDAO ita = new DictionaryDAO();
			
		  SpellCheckerController contr = loader.getController();
		  contr.setModel(eng , ita);
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
