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
	
	/**
	 * Constructor for question class 
	 * @param data - question prompt
	 * @param id - number that represents question
	 */
	public Question(String data, int id) {
		this.data=data;
		this.id=id;
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @return data from object instance
	 */
	public String getData() {
		return data;
	}
	
	/**
	 * @return id from object instance
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * @param data value to change data to
	 */
	public void setData(String data) {
		this.data = data;
	}
	
	/**
	 * @return the value of the class as a string, in this case the data of the question
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return data;
	}
}
