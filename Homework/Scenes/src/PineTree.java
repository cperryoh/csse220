import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;

public class PineTree {
	double x,y,w,h;
	double trunkW,trunkH;
	Color brown = new Color(145,112,33), green= new Color(40,135,22);
	public PineTree(double x, double y, double w, double h) {
		super();
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		
		trunkW=w*(1.0/3.0);
		trunkH=h*(1.0/3.0);
	}
	public void drawOn(Graphics2D g2){
		g2.setColor(brown);
		g2.fillRect((int)(((w/2.0)-(trunkW/2.0))+x),(int)((h*(2.0/3.0))+y), (int)trunkW, (int)trunkH);
		g2.setColor(green); 

  		Polygon triangle = new Polygon();
		triangle.addPoint((int)x, (int)(y+(h*(2.0/3.0))));
		triangle.addPoint((int)(x+w), (int)(y+(h*(2.0/3.0))));
		triangle.addPoint((int)(x+(w/2.0)), (int)y);
		g2.fillPolygon(triangle);
	}
}
