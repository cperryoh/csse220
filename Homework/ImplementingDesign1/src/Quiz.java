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
	ArrayList<Integer>questions = new ArrayList<>();
	HashMap<Integer,Question> fullListOfQuestions = new HashMap<>();
	public Quiz(ArrayList<Integer> questions, HashMap<Integer, Question> fullListOfQuestions, int id) {
		this.questions=questions;
		this.fullListOfQuestions=fullListOfQuestions;
		this.id=id;
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String out = "";
		out+="Quiz (id= "+id+")\n";
		for(int i = 0; i < questions.size();i++) {
			System.out.println((i+1)+") "+fullListOfQuestions.get(questions.get(i)));
		}
		out+="\n";
		return out;
	}
	public ArrayList<Integer> getQuestions() {
		return questions;
	}
}
