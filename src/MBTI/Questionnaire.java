//
package MBTI;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Questionnaire {
	static Scanner scanner = new Scanner(System.in);
	int introversionCount = 0; int extroversionCount = 0;
	int sensingCount = 0; int intuitiveCount = 0;
	int thinkingCount = 0; int feelingCount = 0;
	int judgingCount = 0; int perceptiveCount = 0;
	
	static String[][] arrayOfQuestions = {
			{"1.) expend energy, enjoy groups", "conserve energy, enjoy one on one"}, {"5.) more outgoing thinking out loud", "more reserved, think to yourself"},
			{"9.) seek many tasks, public activities, interact with others", "seek private, solitary activities with quiet to concentrate"},
			{"13.) external, communicative, express yourself", "internal, reticent, keep to yourself"}, {"17.) active, initiative", "reflective deliberate"},
												 
			{"2.) interpret literally", "look for meaning and possibilities"},{"6.)practical, realistic, experiential", "imaginative, innovative, theoretical"},
			{"10.) standard, usual, conventional", "different, novel, unique"}, {"14.) focus on here and now", "look to the future, global perspective, big picture"},
			{"18.) facts, things, what is", "ideas, dreams, what could be, philosophical"},
			
			{"3.) logical, thinking, questioning", "empathetic, feeling accommodating"}, {"7.) candid, straightforward, frank", "tactful, kind and encouraging"},
			{"11.) firm, tend to criticize, hold the line", "gentle, tend to appreciate, conciliate"}, {"15.) tough minded, just", "tender hearted, merciful"},
			{"19.) matter of fact, issue oriented", "sensitive, people oriented, compassionate"},
			
			{"4.) organized, orderly", "flexible, adaptable"}, {"8.) planned, schedule", "unplanned, spontaneous"},
			{"12.) regulated, structured", "easy going, live and let live"}, {"16.) preparation, plan ahead", "go with the flow, adapt as you go"},
			{"20.) control, govern", "latitude, freedom"},
	};
	List<Question> questions = new ArrayList<>();
	
	public void addQuestionsToList(){
		Question question;
		for (String[] arrayOfQuestion : arrayOfQuestions) {
			question = new Question();
			for (int j = 0; j < 1; j++) {
				question.setOptionA(arrayOfQuestion[0]);
				question.setOptionB(arrayOfQuestion[1]);
			}
			questions.add(question);
		}
	}
	
	public String  introversionVsExtroversion(){
	    Choice choice = getChoice(0, 5);
		introversionCount = choice.getChoiceA();
		extroversionCount = choice.getChoiceB();
		if (introversionCount > extroversionCount) return "I";
		else return "E";
	}
	
	public String intuitionVsSensing(){
		Choice choice = getChoice(5, 10);
		sensingCount = choice.getChoiceA();
		intuitiveCount = choice.getChoiceB();
		if (sensingCount > intuitiveCount) return "S";
		else return "N";
	}
	public String thinkingVsFeeling(){
		Choice choice = getChoice(10, 15);
		thinkingCount = choice.getChoiceA();
		feelingCount = choice.getChoiceB();
		if (thinkingCount > feelingCount) return "T";
		else return "F";
	}
	public String judgingVsPerceptive(){
		Choice choice = getChoice(15, 20);
		judgingCount = choice.getChoiceA();
		perceptiveCount = choice.getChoiceB();
		if (judgingCount > perceptiveCount) return "J";
		return "P";
	}
	private Choice getChoice(int start, int stop) {
		System.out.println("enter A or B");
		int choiceA = 0; int choiceB = 0;
		boolean loopContinues;
		for (int i = start; i < stop; i++) {
			do{
				System.out.print(questions.get(i).getOptionA()+"\t or \t");
				System.out.println(questions.get(i).getOptionB());
				String userChoice = scanner.nextLine();
				switch (userChoice.toUpperCase()) {
					case "A" -> {
						choiceA += 1;
						loopContinues = true;
					}
					case "B" -> {
						choiceB += 1;
						loopContinues = true;
					}
					default -> {
						loopContinues = false;
						scanner.nextLine();
						System.out.println("please enter correct value either A or B");
					}
				}
			}while (!loopContinues);
		}
		return new Choice(choiceA, choiceB);
	}
	
	public static void main(String[] args) {
		System.out.println("Please enter your name: ");
		String name = scanner.nextLine();
		Questionnaire questionnaire = new Questionnaire();
		questionnaire.addQuestionsToList();
		String value= questionnaire.introversionVsExtroversion();
		System.out.println();
		String value1 = questionnaire.intuitionVsSensing();
		System.out.println();
		String value2 = questionnaire.thinkingVsFeeling();
		System.out.println();
		String value3 = questionnaire.judgingVsPerceptive();
		
		String trait = value+value1+value2+value3;
		System.out.println(name+" your personality type is: "+trait);
		System.out.println("Facts about "+value+value1+value2+value3+" is coming soon");
		
		switch (trait){
			case "ISTJ" -> System.out.println(MBTIPersonalities.istjType());
			case "INFJ" -> System.out.println(MBTIPersonalities.getINFJ());
			case "ENFJ" -> System.out.println(MBTIPersonalities.getENFJ());
			case "INTJ" -> System.out.println(MBTIPersonalities.getINTJ());
			case "ESFJ" -> System.out.println(MBTIPersonalities.getESFJ());
			case "INFP" -> System.out.println(MBTIPersonalities.getINFP());
			case "ESFP" -> System.out.println(MBTIPersonalities.getESFP());
			case "ISTP" -> System.out.println(MBTIPersonalities.getISTP());
			case "ENFP" -> System.out.println(MBTIPersonalities.getENFP());
			case "ESTP" -> System.out.println(MBTIPersonalities.getESTP());
			case "ESTJ" -> System.out.println(MBTIPersonalities.getESTJ());
			case "ENTJ" -> System.out.println(MBTIPersonalities.getENTJ());
			case "INTP" -> System.out.println(MBTIPersonalities.getINTP());
			case "ISFJ" -> System.out.println(MBTIPersonalities.getISFJ());
			case "ENTP" -> System.out.println(MBTIPersonalities.getENTP());
			case "ISFP" -> System.out.println(MBTIPersonalities.getISFP());
		}
	}
}
