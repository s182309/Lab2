package it.polito.tdp.spellchecker.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import it.polito.tdp.spellchecker.model.RichWord;

public class DictionaryDAO {
	
	
	
	
	private String jdbcURL = "jdbc:mysql://localhost/dizionario?user=root&password=root";
	
	public List<RichWord> spellCheckText(List<String> inputTextList) {
	
		List<RichWord> list = new LinkedList <RichWord> ();
		
		try {
			Connection conn = DriverManager.getConnection(jdbcURL);
			Statement st = conn.createStatement();
			for(String s : inputTextList) {
			String sql = "select id from parola where nome=\"" + s +"\"" ;
			ResultSet res= st.executeQuery(sql);
			RichWord temp = new RichWord (s);
			if (res.next()){
				//parola corretta
				
				temp.setCorrect(true);
			}
			else{
				//parola non corretta
				temp.setCorrect(false);
				}
			
			list.add(temp);
			
			
			
			                          }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		return list;
		
		}
	
	

}
