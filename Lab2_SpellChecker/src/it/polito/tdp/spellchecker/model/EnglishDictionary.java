package it.polito.tdp.spellchecker.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

public class EnglishDictionary extends Dictionary {
	
	public boolean loadDictionary(){
		try{
			FileReader fr = new FileReader ("rsc/English.txt");
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			while(line!=null){
				StringTokenizer st = new StringTokenizer(line);
				dictionary.add(st.nextToken().trim().toLowerCase());
				}
		}
		catch(IOException e){
			
		}
		return true;
	}

}
