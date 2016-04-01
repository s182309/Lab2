package it.polito.tdp.spellchecker.model;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.StringTokenizer;

public class ItalianDictionary extends Dictionary{
	
	private String jdbcURL = "jdbc:mysql://localhost/dizionario?user=root&password=root";
	
	public ItalianDictionary() {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean loadDictionary(){
		try{
			Connection conn = DriverManager.getConnection(jdbcURL);
			Statement st = conn.createStatement();
			
			String sql = "select nome from parola";
			ResultSet res = st.executeQuery(sql);
			while(res.next()) {
				String temp = res.getString("nome");
				dictionary.add(temp.toLowerCase().trim());
			}
			res.close();
			conn.close();
			}
		catch(SQLException e){
		e.printStackTrace();
		return false;
		}
		return true;
		
	}

}
