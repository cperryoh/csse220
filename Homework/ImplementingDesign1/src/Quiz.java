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
	public Quiz(ArrayList<Question> questions, int id) {
		this.questions=questions;
		this.id=id;
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public Question getQuestion(int id) {
		for(Question q:questions) {
			if(q.getId()==id) {
				return q;
			}
		}
		return null;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String out = "";
		for(int i = 0; i < questions.size();i++) {
			out+=i+") "+questions.get(i);
		}
		return out;
	}
	public ArrayList<Question> getQuestions() {
		return questions;
	}
}
