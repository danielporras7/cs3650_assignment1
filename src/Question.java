

abstract class Question {
	
	private String question;
	private String type;
	private String answer;
	private String[] options;
	
	public void setQuestion (String question) {
		this.question = question;
	}
	
	public String getQuestion () {
		return this.question;
	}
	
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public String getAnswer() {
		return this.answer;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return this.type;
	}
	
	public void setOptions(String[] options) {
		this.options = options;
	}
	
	public String[] getOptions() {
		return this.options;
	}
	
}