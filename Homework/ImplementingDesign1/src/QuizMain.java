import java.io.ObjectOutputStream.PutField;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
  *  This class is used to demonstrate a functional design
  *  involving Quizzes and Questions which can be updated and displayed
  * 
  */
public class QuizMain {
	
	//TODO add instance variables here
	HashMap<Integer, Question> questions;
	ArrayList<Quiz> quiz;
	
	/**
	 * Initializes the class as an example 
	 */
	public QuizMain() {
		
		questions =new HashMap<Integer,Question>() {{
				put(1,new Question("What is 1+1?",1));
				put(2, new Question("What is 9+10?",2));
				put(3, new Question("What is 5+5?",3));
				put(4, new Question("What is 6+6?",3));
				
		}};
		quiz=new ArrayList<Quiz>() {{
			ArrayList<Question> quiz1 = new ArrayList<Question>() {{
				add(questions.get(1));
				add(questions.get(3));
				add(questions.get(5));
			}};
			ArrayList<Question> quiz2 = new ArrayList<Question>() {{
				add(questions.get(2));
				add(questions.get(4));
				add(questions.get(5));
			}};
			ArrayList<Question> quiz3 = new ArrayList<Question>() {{
				add(questions.get(1));
				add(questions.get(2));
				add(questions.get(5));
			}};
			add(new Quiz(quiz1, 1));
			add(new Quiz(quiz2, 2));
			add(new Quiz(quiz3, 3));
		}};
		
		// TODO In order to demonstrate functionality, please follow the TODOs below
		// You will have to create questions and quizzes when a QuizMain is created
		
		
		// TODO 1 Create five questions (can be silly/basic questions) use id 1,2,3,4,5 ...
	

		// TODO 2 Create three or more quizzes  use id 1,2,3...
		//      (One quiz should share at least one question with another )

		
		
	}
	
	
	
	public static void main(String[] args) {
		//We want to use instance variables of the QuizMain class so we need to construct a QuizMain object
		QuizMain myQuizSimulator = new QuizMain();
		
		// TODO 3 Display three or more different quizzes
		System.out.println("--------------------------------------------------");
		System.out.println("Showing three or more original quizzes:");
		System.out.println("--------------------------------------------------");
		myQuizSimulator.handleDisplayQuiz(1);
		myQuizSimulator.handleDisplayQuiz(2);
		myQuizSimulator.handleDisplayQuiz(3);
		
		
		
		// TODO 4 Change two quiz questions 
		// A. (One should be shared with two or more quizzes)
		// B. (One should be unique to one quiz)
		myQuizSimulator.handleUpdateQuizQuestion(1,"What is different 1?");
		myQuizSimulator.handleUpdateQuizQuestion(2,"What is different 2?");

		
		// TODO 5 Display the same three (or more) quizzes
		//	   A. One that has a unique question which changed
		//	   B. Two which share a question that has been changed		
		System.out.println("--------------------------------------------------");
		System.out.println("Showing three or more changed quizzes:");
		System.out.println("--------------------------------------------------");
		myQuizSimulator.handleDisplayQuiz(1);
		myQuizSimulator.handleDisplayQuiz(2);
		myQuizSimulator.handleDisplayQuiz(3);
		
	}
	
	/**
	 *  This method should display a quiz in a very similar fashion to the output provided
	 *  in exampleOutput.txt, which is located in your repository
	 * 
	 * 
	 * @param quizId
	 */
	public void handleDisplayQuiz(int quizId) {
		//TODO complete this method
		System.out.println(questions.get(quizId));
	}
	
	/**
	 * 
	 * This method should replace the data in the question with id=questionId with the new questionData 
	 * 
	 * @param questionId
	 * @param questionData
	 */
	public void handleUpdateQuizQuestion(int questionId, String questionData) {
		//TODO complete this method
		questions.get(questionId).setData(questionData);
	}

}
