package it.polito.tdp.spellchecker.model;

import java.io.*;
import java.util.List;
import java.util.StringTokenizer;

public class ItalianDictionary extends Dictionary{
	
	
	
	public boolean loadDictionary(){
		try{
			FileReader fr = new FileReader ("rsc/Italian.txt");
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			while(line!=null){
				StringTokenizer st = new StringTokenizer(line);
				dictionary.add(st.nextToken().trim().toLowerCase());
				}
		}
		catch(IOException e){
			return false;
		}
		return true;
		
	}

}
