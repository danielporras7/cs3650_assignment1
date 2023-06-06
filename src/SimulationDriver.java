

import java.util.Random;

public class SimulationDriver {

	public static void main(String[] args) {
		System.out.println("");
		
		//Create an array of Students using the createClass method.
	    Student[] totalStudents = createClass();
	    
	    //Run the simulation for True/False and Multiple Choice questions.
	    simulation(totalStudents, "TF", "(T/F) Will I get an A for this?", "T");
	    simulation(totalStudents, "MC", "Select All the STEM majors", "CS, Chemisty");
	}
	
	public static void simulation(Student[] totalStudents, String questionType, String questionText, String answer) {
		//Generate a question using the createQuestion method.
	    Question question = createQuestion(questionType, questionText, answer);
	    
	    //Create an ICS to handle the Students and their answers.
	    VoteService ICS = new VoteService(question);
	    
	    //Simulate Students picking their answers and submitting to the ICS.
	    for (int i = 0; i < totalStudents.length; i++) {
	    	totalStudents[i].setAnswer(question);
	    	ICS.submitAnswer(totalStudents[i]);
	    }
	    
	    //Simulate a random Student changing their answer.
	    Random rand = new Random();
	    int selectedStudent = rand.nextInt(totalStudents.length);
	    totalStudents[selectedStudent].setAnswer(question);
	    ICS.submitAnswer(totalStudents[selectedStudent]);
    	
	    //Print the results.
	   
	    ICS.printResults();    
	}
	
	public static Student[] createClass() {
		//Create a class of 1-100 Students.
		Random rand = new Random();
	    int numOfStudents = rand.nextInt(75) + 1;
	    
	    Student[] totalStudents = new Student[numOfStudents];
	    
	    for (int i = 0; i < totalStudents.length; i++) {
	    	int studentID = rand.nextInt(100) + 1;
	    	totalStudents[i] = new Student(Integer.toString(studentID));
	    }
	    
	    return totalStudents; 
	}
	
	public static Question createQuestion(String questionType, String questionText, String answer) {
		//Create a Question for the Students to answer.
	    Question question = null;
	    
	    if (questionType.equals("MC")) {
		    question = new MCQuestion(questionText, answer);
	    } else if (questionType.equals("TF")) {
		    question = new TFQuestion(questionText, answer);
	    }
	    
	    return question;
	}
}