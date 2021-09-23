import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

public class SceneComponent extends JComponent {
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.green);
		g2.fillRect(0, 0, 750, 600);
		g2.setColor(Color.blue);
		g2.fillRect(0, 0, 750, 375);
		int houseW=100;
		for(int i = (houseW+10);i<=((houseW+10)*5);i+=houseW+10) {
			House house = new House(i, 500, Color.red);
			house.drawOn(g2);
		}
		int tinyPineW=10,tinyPineH=40, bigPineW=20,bigPineH=80;
		int startingX=200;
		int spacing=10;
		for(int i = 0;i<25;i++) {
			PineTree tree = new PineTree(startingX+((spacing+tinyPineW)*i), 350, tinyPineW, tinyPineH);
			tree.drawOn(g2);
		}
		startingX=225;
		for(int i = 0;i<15;i++) {
			PineTree tree = new PineTree(startingX+((spacing+bigPineW)*i), 370, bigPineW, bigPineH);
			tree.drawOn(g2);
		}
		(new Sun()).drawOn(g2);
	}
}
