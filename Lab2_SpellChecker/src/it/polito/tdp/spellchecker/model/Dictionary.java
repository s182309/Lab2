package it.polito.tdp.spellchecker.model;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Dictionary {
	protected List<String> dictionary;

	public Dictionary() {
		dictionary = new LinkedList<String>();
	}

	public List<RichWord> spellCheckText(List<String> inputTextList) {
		List<RichWord> ret = new LinkedList<RichWord>();
		for (String s : inputTextList) {
			RichWord temp = new RichWord(s);
			if (dictionary.contains(s))
				temp.setCorrect(true);
			else
				temp.setCorrect(false);

			ret.add(temp);

		}
		return ret;
	}

	// Ricerca dicotomica
	public List<RichWord> spellCheckTextDicotomico(List<String> inputTextList) {
		List<RichWord> ret = new LinkedList<RichWord>();
		for (String s : inputTextList) {
			RichWord temp = new RichWord(s);
			if (this.ricercaDicotomica(s))
				temp.setCorrect(true);
			else
				temp.setCorrect(false);

			ret.add(temp);

		}
		return ret;
	}

	public boolean ricercaDicotomica(String txt) {
		int index = dictionary.size() / 2;
		if (txt.compareTo(dictionary.get(index)) > 0) {
			for (int i = index; i < dictionary.size(); i++) {
				if (txt.compareTo(dictionary.get(i)) == 0)
					return true;
			}
		} 
		else {

			for (int i = 0; i < index; i++) {
				if (txt.compareTo(dictionary.get(i)) == 0)
					return true;
			}

		}

		return false;
	}

	public boolean loadDictionary() {
		return false;
	}

	public static void main(String[] args) {
		Dictionary d = new EnglishDictionary();
		boolean t = d.loadDictionary();
		System.out.println(t);

	}

}
