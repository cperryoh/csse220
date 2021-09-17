import java.util.ArrayList;
import java.util.HashMap;

/**
  * 
  * TODO (1) Implement this class and (2) Document using Javadoc comments as well as regular comments
  * 
  * If you are running a recent version of Eclipse, you can command Eclipse to generate the Javadoc .html file
  * by using the command from the menu bar: Project | Generate Javadoc...
  *
  * 
 */
public class Quiz {
	int id;
	ArrayList<Question> questions;
	
	/**
	 * @param questions list of questions to be on the quiz
	 * @param id number that identifies the quiz
	 */
	public Quiz(ArrayList<Question> questions, int id) {
		this.questions=questions;
		this.id=id;
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * @return id of the quiz
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * @param id of a question that is on this quiz object
	 * @return the question that has the same id as the parameter
	 */
	public Question getQuestion(int id) {
		for(Question q:questions) {
			if(q.getId()==id) {
				return q;
			}
		}
		return null;
	}
	/**
	 * @return Returns at list of all questions on the quiz, listed in order, as a string 
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String out = "";
		for(int i = 0; i < questions.size();i++) {
			out+=i+") "+questions.get(i);
		}
		return out;
	}
	
	/**
	 * 
	 * @return The array of questions that are on the quiz 
	 */
	public ArrayList<Question> getQuestions() {
		return questions;
	}
}
