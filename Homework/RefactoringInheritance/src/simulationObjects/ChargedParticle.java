package simulationObjects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.Random;

public class ChargedParticle extends Particle {
	Color ringColor1, ringColor2;
	Random r;

	public ChargedParticle(int x, int y) {
		super(x, y);
		r = new Random();
		ringColor1 = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
		ringColor2 = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
		color = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
		// TODO Auto-generated constructor stub
	}
	@Override
	public void drawOn(Graphics2D g) {
		// TODO Auto-generated method stub
//		ringColor1 = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
//		ringColor2 = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
//		color = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
		super.drawOn(g);
		g=(Graphics2D)g.create();
		g.setColor(ringColor1);
		g.drawOval(centerX-(radius*2), centerY-(radius/2), radius*4, radius);
		g.setColor(ringColor2);
		g.drawOval(centerX-(radius/2), centerY-(radius*2), radius, radius*4);
		
	}
	private void updateColor() {
		ringColor1 = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
		ringColor2 = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
		color = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
	}
	@Override
	public void bounce(SimulatedObject other) {
		// TODO Auto-generated method stub
		super.bounce(other);
		updateColor();
	}
}
