package upward.tajwid.quiz;

import java.io.Serializable;

public class Quiz implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1585102783225450813L;

	private String question, answer;
	private String a, b, c, d;
	
	public Quiz(String question, String answer) {
		this.question = question;
		this.answer = answer;
	}

	public void setAnswers(String a, String b, String c, String d){
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}

	public String getQuestion() {
		return question;
	}

	public String getAnswer() {
		return answer;
	}

	public String getA() {
		return a;
	}

	public String getB() {
		return b;
	}

	public String getC() {
		return c;
	}

	public String getD() {
		return d;
	}
}
