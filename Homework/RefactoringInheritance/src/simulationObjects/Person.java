package simulationObjects;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Dimension2D;

/**
 * This class represents a Person who can either be healthy (green), infected (orange), or recovered (pink).
 * Once a Person becomes infected, they will remain infected for a certain length of time before they
 * become recovered. Once recovered, the Person cannot be infected again.
 * 
 * Inspired by this article: https://www.washingtonpost.com/graphics/2020/world/corona-simulator/
 * 
 * To visualize a population of Persons over time you should provide a method that says if a Person 
 * isHealthy, isSick, or isRecovered.
 * 
 * 
 * This class should use inheritance to make it simple to write. You should not need to copy and paste
 * 
 * TODO: Part 4 You can change this file but will need to provide each of the methods started in order to get full 
 * functionality.
 * 
 * @author YOUR_NAME
 *
 */
public class Person extends SimulatedObject {
	
	

	public static final int PERSON_RADIUS = 10;
	public static final int PERSON_SPEED = 2;
	
	//How many timesteps to recover once infected
	public static final int TIME_TO_RECOVER = 100;
	int countDown=-1;
	
	public static final Color HEALTHY_COLOR = new Color(134, 184, 184);
	public static final Color INFECTED_COLOR = new Color(204, 102, 0);
	public static final Color RECOVERED_COLOR = new Color(196, 116, 195);
	PersonState state;
	
	//TODO: add instance variables
	
	//TODO: add constructors
	public Person(int x, int y,PersonState state) {
		super(x, y);
		this.state=state;
		if(isHealthy()) {
			this.color=HEALTHY_COLOR;
		}else if(isInfected()) {
			this.color=INFECTED_COLOR;
		}else {
			this.color=RECOVERED_COLOR;
		}
		this.radius = PERSON_RADIUS;
		this.moveSpeed = PERSON_SPEED;
		// TODO Auto-generated constructor stub
		normalizeVelocity();
	}

	public void update(Dimension2D dim) {
		super.update(dim);
		if(isInfected()&&countDown==-1) {
			countDown=TIME_TO_RECOVER;
		}
		if(isInfected()&&countDown>0) {
			countDown--;
		}
		if(isInfected()&&countDown==0) {
			changeState(PersonState.Recovered);
		}
	}
	public void changeState(PersonState state) {
		this.state=state;
		if(this.state.equals(PersonState.Infected)) {
			color=INFECTED_COLOR;
		}
		else if(this.state.equals(PersonState.Healthy)) {
			color=HEALTHY_COLOR;
		}
		else {
			color=RECOVERED_COLOR;
		}
	}
	public void bounce(Person other) {
		//TODO Infect healthy people when they bounce off of infected people
		super.bounce(other);
		
	}
	
	public boolean isHealthy() {
		// TODO return true if this person is healthy.  False if infected or recovered
		return state.equals(PersonState.Healthy);
	}

	public boolean isInfected() {
		// TODO return true if this person is sick.  False if infected or recovered
		return state.equals(PersonState.Infected);
	}
	
	public boolean isRecovered() {
		// TODO return true if this person is recovered.  False if infected or healthy
		return state.equals(PersonState.Recovered);
	}

	public boolean overlapsWith(Person other) {
		// TODO return true if the person is within range of another
		boolean overlap = super.overlapsWith(other);
		if(overlap&&other.isInfected()&&isHealthy()) {
			changeState(PersonState.Infected);
		}
		return overlap;
	}


}
