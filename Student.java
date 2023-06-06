
import java.util.Random;

public class Student {

	private String ID;
	private String answer;
	
	public Student (String ID) {
		this.ID = ID;
	}
	
	public String getID() {
		return ID;
	}
	
	public void setAnswer(Question question) {
		
		int questionLength = question.getOptions().length;
		
		Random rand = new Random();
		String temp = "";
		
		//Randomly generate number of answers the Student will have.
		int numOfAnswers = rand.nextInt(questionLength) + 1;
		temp = "";
			
		for (int j = 0; j < numOfAnswers; j++) {
			String studentAnswer = Integer.toString(rand.nextInt(questionLength));
			temp += studentAnswer;
			answer = temp;
		}
		
	}
	
	public String getAnswer() {
		return answer;
	}
}