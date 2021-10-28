package ballStrikeCounter;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.stream.Stream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tracker {
	private JLabel label = new JLabel();
	int ballCounter=0,strikeCounter=0;

	// Call this to update the text on the label.
	public void updateLabel() {
		this.label.setText("<html>Balls: " + ballCounter + "<br />Strikes: " +  strikeCounter + "</HTML>");
	}

	public static void main(String[] args) {
		new Tracker();
	}
	//Constructor for tracker class
	public Tracker() {
		ballCounter=0;
		strikeCounter=0;
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JButton ball = new JButton("Ball");
		ball.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ballCounter++;
				if(ballCounter==4) {
					ballCounter=0;
					strikeCounter=0;
				}
				updateLabel();
			}
		});
		JButton strike = new JButton("Strike");
		strike.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				strikeCounter++;
				if(strikeCounter==3) {
					ballCounter=0;
					strikeCounter=0;
				}
				updateLabel();
			}
		});
		frame.add(label, BorderLayout.CENTER);
		frame.add(panel, BorderLayout.SOUTH);
		panel.add(ball);
		panel.add(strike);
		
		
		// TODO: Add buttons and listeners to make things work.
		

		// The following line is given to show you how to use the given method:
		updateLabel();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
