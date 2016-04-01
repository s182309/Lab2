package it.polito.tdp.spellchecker.model;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Dictionary {
	protected Set <String> dictionary;

	public Dictionary() {
		dictionary = new HashSet <String>();
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

	

	public boolean loadDictionary() {
		return false;
	}

	public static void main(String[] args) {
		Dictionary d = new EnglishDictionary();
		boolean t = d.loadDictionary();
		System.out.println(t);

	}

}
