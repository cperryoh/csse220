import java.awt.Color;
import java.awt.Graphics2D;

public class House {
	private static final int HEIGHT = 50;
	private static final int WIDTH = 100;
	private static final int ROOF_HEIGHT = 20;

	private Color color;
	int x,y;
	public House(int x, int y, Color color) {
		// TODO: save off the parameters into instance variables
		this.x=x;
		this.y=y;
	}

	public void drawOn(Graphics2D g2) {
		// TODO: Draw the house body (a rectangle) and the roof (3 lines or a
		// Polygon)
		g2.setColor(color);
		g2.fillRect(x, y, WIDTH, HEIGHT);
		g2.drawLine(x, y, x+(WIDTH/2), y-HEIGHT);
		g2.drawLine(x+WIDTH, y, (x+WIDTH)-(WIDTH/2), y-HEIGHT);
	}
}
