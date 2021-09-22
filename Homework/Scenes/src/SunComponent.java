import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

public class SunComponent extends JComponent {
	private static final double LITTLE_SUN_SIZE = 30.0;
	private static final double LITTLE_SUN_SEPARATION = 100.0;
	private static final int NUM_LITTLE_SUNS = 5;
	private static final double LITTLE_SUNS_Y = 400.0;
	private static final Color LITTLE_SUN_COLOR = Color.RED;
	private static final double LITTLE_SUNS_X_OFFSET = 50;

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Graphics2D graphics2 = (Graphics2D) g;

		Sun sun = new Sun(100, 100, 100,Color.yellow);
		sun.drawOn(graphics2);
	}
}
