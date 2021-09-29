package teamGradebook;
import java.util.ArrayList;
import java.util.HashMap;


public class Student {
	// TODO: Complete this class
	String name;
	int absences;
	ArrayList<Team>teams = new ArrayList<>();
	public Student(String name) {
		this.name=name;
		// TODO Auto-generated constructor stub
	}
	public void addToTeam(Team team) {
		teams.add(team);
	}
	public ArrayList<Double> getGrades(){
		ArrayList<Double> grades = new ArrayList<>();
		for(Team team:teams) {
			grades.addAll(team.getGrades());
		}
		return grades;
	}
	public int getAverage() {
		double sum=0;
		ArrayList<Double> grades = getGrades();
		for(double grade:grades){
			sum+=grade;
		}
 		return (int)(sum/grades.size()+0.5);
	}
	public void addAbsence() {
		absences++;
	}
	public int getAbsences() {
		return absences;
	}
	// HINT: 
	// Implement a toString method that returns a String containing the values in the object's fields
	// After adding fields to this class, use the Eclipse command: Source | Generate toString
	// When debugging, call this toString method on Student objects from a System.out.println command
}
