package it.polito.tdp.spellchecker.model;

import java.io.*;
import java.util.List;
import java.util.StringTokenizer;

public class ItalianDictionary extends Dictionary{
	
	
	
	public ItalianDictionary() {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean loadDictionary(){
		try{
			FileReader fr = new FileReader ("rsc/Italian.txt");
			BufferedReader br = new BufferedReader(fr);
			String line;
			while( (line = br.readLine()) !=null){
				StringTokenizer st = new StringTokenizer(line);
				dictionary.add(st.nextToken().trim().toLowerCase());
				}
			br.close();
			fr.close();
		}
		catch(IOException e){
		System.out.println("Errore nella lettura del file");
			return false;
		}
		return true;
		
	}

}
