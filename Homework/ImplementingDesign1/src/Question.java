/**
  * 
  * TODO (1) Implement this class and (2) Document using Javadoc comments as well as regular comments
  *
  * If you are running a recent version of Eclipse, you can command Eclipse to generate the Javadoc .html file
  * by using the command from the menu bar: Project | Generate Javadoc...
  * 
 */
public class Question {
	String data;
	int id;
	public Question(String data, int id) {
		this.data=data;
		this.id=id;
		// TODO Auto-generated constructor stub
	}
	public String getData() {
		return data;
	}
	public int getId() {
		return id;
	}
	public void setData(String data) {
		this.data = data;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return data;
	}
}
