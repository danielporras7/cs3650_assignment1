

public class MCQuestion extends Question {
	
	public MCQuestion(String question, String answer) {
		setQuestion(question);
		setAnswer("[C,B]: CS, Chemisty ");
		setType("Select all that apply");
		setOptions(new String[] {"A", "B", "C", "D"});	
		
	}

}