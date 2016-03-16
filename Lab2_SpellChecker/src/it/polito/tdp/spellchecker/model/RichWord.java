package it.polito.tdp.spellchecker.model;

public class RichWord {
	private String word;
	private boolean correct;
	
	
	
	public RichWord(String word) {
		super();
		this.word = word;
	}



	public String getWord(){
		return word;
	}



	public void setCorrect(boolean correct) {
		this.correct = correct;
	}



	public boolean isCorrect() {
		return correct;
	}
	
	

}
