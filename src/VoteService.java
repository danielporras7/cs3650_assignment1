

import java.util.Hashtable;

public class VoteService {
	
	private Question question;
	private int[] count;
	private Hashtable<String, String> roster;
	
	public VoteService(Question question) {
		this.question = question;
		count  = new int[question.getOptions().length];
		
		//Create the Hash Table to handle the submissions.
	    roster = new Hashtable<String, String>();
	}
	
	public void submitAnswer(Student student) {
		//If the Student already exists in the Roster, remove their previous answer from the total Count.
	    if (roster.containsKey(student.getID())) {
	    	String oldAnswer = roster.get(student.getID());
	    	
	    	for (int i = 0; i < oldAnswer.length(); i++) {
				int temp = Character.getNumericValue(oldAnswer.charAt(i));
				count[temp] = count[temp] - 1;
			}
	    }

	    //Register their new answer to the Count.
	    String answer = student.getAnswer();
		for (int i = 0; i < answer.length(); i++) {
			int temp = Character.getNumericValue(answer.charAt(i));
			count[temp] = count[temp] + 1;
		}
		
		//Update the Roster (Hash Table) with Students and their answers.
	    this.roster.put(student.getID(), answer);
	}
	
	public int[] getCount() {
		return count;
	}

	public void printResults() {
		//Print the Count for each possible answer to the Question.
		System.out.println("Type of question:  " + question.getType());
	    System.out.println("QUESTION:  " + question.getQuestion());
	    
		System.out.println("Final Results: ");
		for (int i = 0; i < question.getOptions().length; i++) {
			System.out.println(question.getOptions()[i] + ": " + count[i] + " Students");
		}
		System.out.println(count[1] + " students got the correct answer");
		System.out.println("The correct answer is: " + question.getAnswer());
		
		System.out.println("******************************************");
	}
}
