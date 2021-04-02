package Product;

import java.util.*;

public class FAQ {
	private final String id;
	private String question;
	private String answer;

	public FAQ() {
		this.id = UUID.randomUUID().toString();
	}

	public String getID() {
		return this.id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "\nFAQ {" +
				 "id= " + id + '\n' +
				 " question= " + question + '\n' +
				 " answer= " + answer + '\n' +
				 "}";
	}
}