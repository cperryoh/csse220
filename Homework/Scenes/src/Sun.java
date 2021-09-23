import java.awt.Color;
import java.awt.Graphics2D;
public class Sun {
	private static final Color BORDER_COLOR = Color.BLACK;
	 private static final int NUMBER_OF_RAYS = 8;
	 private static final double RAY_LENGTH_SCALE = 0.5;
	 private static final double RAY_WIDTH_SCALE = 0.1;
	 private static final double RAY_DISTANCE_FROM_SUN_SCALE = .2;
	 private static final double DEFAULT_SUN_DIAMETER = 100.0;
	 private static final double DEFAULT_SUN_X = 100.0;
	 private static final double DEFAULT_SUN_Y = 100.0;
	 private static final Color DEFAULT_SUN_COLOR = Color.YELLOW;
	 private static final double LITTLE_SUNS_X_OFFSET = 50; 
	 double x,y,circleDiameter,rayLength,rayWidth, rayDistanceFromSun;
	 Color color;
	public Sun(double x, double y, double circleDiameter, Color color) {
		super();
		this.x =  x;
		this.y =  y;
		this.circleDiameter = (int) circleDiameter;
		this.color = color;
	}
	public Sun() {
		this.x=DEFAULT_SUN_X;
		this.y=DEFAULT_SUN_Y;
		this.circleDiameter=DEFAULT_SUN_DIAMETER;
		this.color=DEFAULT_SUN_COLOR;
	}
	public void drawOn(Graphics2D g2) {
		g2.setColor(color);
		g2.fillOval((int)x, (int)y, (int)circleDiameter, (int)circleDiameter);
		g2.setColor(BORDER_COLOR);
		g2.drawOval((int)x, (int)y, (int)circleDiameter+2, (int)circleDiameter+2);
		double centerOfSunX=(circleDiameter/2)+x;
		double centerOfSunY=(circleDiameter/2)+y;
		for(int i = 0;i<360;i+=45) {
			drawRay(g2, i, centerOfSunX, centerOfSunY);
		}
		
		
	}
	void drawRay(Graphics2D g2,double angle,double x,double y) {
		double radians = (angle*Math.PI)/180.0;
		g2.setColor(color);
		int rayW=(int) (circleDiameter*RAY_WIDTH_SCALE);
		
		int rayH=(int) (circleDiameter*RAY_LENGTH_SCALE);
		int rayDis=(int)((RAY_DISTANCE_FROM_SUN_SCALE*circleDiameter)+(circleDiameter/2.0));
		
		g2.translate(x, y);
		g2.rotate(radians);
		g2.translate(0, rayDis);
		g2.fillRect(-(rayW/2),0, rayW,rayH);
		g2.setColor(Color.black);
		g2.drawRect(-(rayW/2),0, rayW,rayH);
		//g2.fillRect(0, 0, (int)(RAY_WIDTH_SCALE*circleDiameter), (int)(RAY_LENGTH_SCALE*circleDiameter));
		g2.translate(0, -rayDis);
		g2.rotate(-radians);
		g2.translate(-x, -y);
	}
}
