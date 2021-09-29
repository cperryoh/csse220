package teamGradebook;
import java.util.ArrayList;


public class Team {
	
	// You'll need to add fields, constructors, and methods here
	ArrayList<Double> grades;
	String name;
	public Team(String name) {
		this.name = name;
		grades = new ArrayList<>();
		// TODO Auto-generated constructor stub
	}
	public ArrayList<Double> getGrades(){
		return grades;
	}
	public void addGrade(double grade) {
		grades.add(grade);
	}
	public String getName() {
		return name;
	}
	public double getAverage() {
		if(grades.size()!=0) {
			double sum=0;
			for(double grade:grades) {
				sum+=grade;
			}
			return sum/grades.size();
		}else {
			return 0;
		}
		
	}
	
	
	
	// HINT: 
	// Implement a toString method that returns a String containing the values in the object's fields
	// After adding fields to this class, use the Eclipse command: Source | Generate toString
	// When debugging, call this toString method on Team objects from a System.out.println command
}
