import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

public class PinesComponents extends JComponent {

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Graphics2D graphics2 = (Graphics2D) g;

		PineTree tree = new PineTree(100, 100, 100, 200);
		tree.drawOn(graphics2);

		PineTree littleTree = new PineTree(300, 200, 50, 100);
		littleTree.drawOn(graphics2);
	}
}
