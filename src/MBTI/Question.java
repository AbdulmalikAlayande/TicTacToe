package MBTI;

public class Question {
	
	private String optionA;
	private String optionB;
	
	public String getOptionA() {
		return optionA;
	}
	
	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}
	
	public String getOptionB() {
		return optionB;
	}
	
	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Question{");
		sb.append("optionA='").append(optionA).append('\'');
		sb.append(", optionB='").append(optionB).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
