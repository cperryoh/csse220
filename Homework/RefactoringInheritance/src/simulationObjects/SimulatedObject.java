package simulationObjects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Dimension2D;

public class SimulatedObject {
	int centerX, centerY, radius, velX, velY, moveSpeed;
	Color color;

	public SimulatedObject(int x, int y) {
		this.centerX = x;
		this.centerY = y;
		this.velX = (int) (moveSpeed - Math.random() * moveSpeed * 2);
		this.velY = (int) (moveSpeed - Math.random() * moveSpeed * 2);
		
	}

	protected void normalizeVelocity() {
		// move down, right if velocity is set to zero
		if (this.velX == 0 && this.velY == 0) {
			this.velX = 1;
			this.velY = 1;
		}
		// normalize vector
		double vectorLength = Math.sqrt(velX * velX + velY * velY);
		this.velX = (int) (this.velX / vectorLength * moveSpeed * 2);
		this.velY = (int) (this.velY / vectorLength * moveSpeed * 2);
	}
	public void drawOn(Graphics2D g) {

		//avoid having to untranslate by mutating a copy of the graphics content
		g = (Graphics2D)g.create();
		g.setColor(this.color);
		g.translate(centerX-radius, centerY-radius);
		g.fillOval(0, 0, radius*2, radius*2);	
	}
	public boolean overlapsWith(SimulatedObject other) {
		int xDiff =  centerX - other.centerX;
		int yDiff =  centerY - other.centerY;
		double distance = Math.sqrt(  xDiff*xDiff + yDiff * yDiff );
		return this.radius + other.radius >= distance;
	}
	public void bounce(SimulatedObject other) {
		velX = this.centerX - other.centerX;
		velY = this.centerY - other.centerY;
		normalizeVelocity();
	}
	public void update(Dimension2D dim) {
		centerX += velX;
		centerY += velY;
		if (centerX > dim.getWidth() || centerX < 0) {
			centerX = (int)Math.min( Math.max(centerX, 0), dim.getWidth());
			velX = -velX;
		}
		if (centerY > dim.getHeight() || centerY < 0) {
			velY = -velY;
			centerY = (int)Math.min( Math.max(centerY, 0), dim.getHeight());
		}
	}
}
