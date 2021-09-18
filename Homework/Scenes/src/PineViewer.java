import java.awt.Dimension;

import javax.swing.JFrame;

public class PineViewer {
public static final Dimension pineWindowSize = new Dimension(500, 400);
	
	/**
	 * Constructs and displays the JFrame which displays Houses via a
	 * HousesComponent. 
	 * 
	 * @param args
	 *            Command-line arguments, ignored here.
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame();

		frame.setSize(pineWindowSize);

		frame.add(new PinesComponents());

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
