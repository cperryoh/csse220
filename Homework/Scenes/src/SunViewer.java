import java.awt.Dimension;

import javax.swing.JFrame;

public class SunViewer {
	public static final Dimension sunViewerSize = new Dimension(500, 400);
	public static void main(String[] args) {
		JFrame frame = new JFrame();

		frame.setSize(sunViewerSize);
		
		frame.add(new SunComponent());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
