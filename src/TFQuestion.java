

public class TFQuestion extends Question {
	
	public TFQuestion(String question, String answer) {
		setQuestion(question);
		setAnswer("B: FALSE");
		setType("Pick only one");
		setOptions(new String[] {"A", "B"});
	}

}