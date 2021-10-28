package linearLightsOut;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Runs the Linear Lights Out application.
 * 
 * @author Cole Perry. Created Jan 18, 2010.
 */
public class LinearMain {
	static ArrayList<XOButton> buttons;
	static JFrame myFrame;
	static boolean hasWinner = false;

	/**
	 * Main function, program starts here
	 */
	public static void main(String[] args) {
		reset();

		// you'll want to think about how you want to manage the state of the game
		// also you want to add some buttons and stuff
	}

	/**
	 * Resets the game and has the user go through the process of creating a new
	 * window
	 */
	public static void reset() {
		buttons = new ArrayList<XOButton>();
		myFrame = new JFrame();
		hasWinner=false;
		Panel playPnl = new Panel();
		Panel botPnl = new Panel();
		Random rnd = new Random();
		String nButtonsString;
		myFrame.setTitle("Linear Lights Out!");

		// loop until user gives valid number
		do {
			nButtonsString = JOptionPane.showInputDialog("How many buttons would you like?");
			if (!nButtonsString.equals(null)) {
				if (nButtonsString.equals("0") || nButtonsString.equals("1")) {
					nButtonsString = "s";
				}
			}
		} while (!isNumber(nButtonsString));

		// parse valid input
		int nButtons = Integer.parseInt(nButtonsString);

		// action for game buttons
		ActionListener action = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!hasWinner) {
					// TODO Auto-generated method stub

					// get the button pushed as an XOButton
					XOButton button = (XOButton) e.getSource();

					// using the state of the current button decide the new state
					button.setState((button.getState().equals(XO.x)) ? XO.o : XO.x);

					// set the state of the near by buttons
					setAtIndex(button.index - 1, button.state);
					setAtIndex(button.getIndex() + 1, button.state);

					// check if player won
					if (isWinner()) {
						myFrame.setTitle("We have a winner!");
					}
				}
			}
		};

		// loop x amount of times, x being how many buttons user wants to play with
		for (int i = 0; i < nButtons; i++) {
			XO state = (rnd.nextFloat() < 0.5) ? XO.x : XO.o;
			XOButton btn = new XOButton(state, i);
			btn.addActionListener(action);
			buttons.add(btn);
			playPnl.add(btn);
		}

		// create restet button and action
		JButton reset = new JButton("Reset");
		reset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				// close current window
				myFrame.dispatchEvent(new WindowEvent(myFrame, WindowEvent.WINDOW_CLOSING));

				// create new window
				reset();
			}
		});

		// create quit button and action
		JButton quit = new JButton("Quit");
		quit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				// exit the game
				System.exit(0);
			}
		});

		// build the window
		botPnl.add(quit);
		botPnl.add(reset);
		myFrame.add(botPnl);
		myFrame.add(botPnl, BorderLayout.SOUTH);
		myFrame.add(playPnl, BorderLayout.CENTER);
		myFrame.pack();
		myFrame.setVisible(true);
	}

	/**
	 * Using the array of button this function decides if there is a winner
	 * 
	 * @return
	 */
	public static boolean isWinner() {

		// get the first button state
		XO prev = buttons.get(0).getState();

		// if all of the buttons are the same as this state, there is a winner
		for (XOButton btn : buttons) {
			if (!prev.equals(btn.getState())) {
				return false;
			}
		}
		hasWinner = true;
		return true;
	}

	/**
	 * isNumber takes in a string and returns true or false base off of if that
	 * string can be converted into an integer.
	 * 
	 * @param str - String that will be checked if it is a number or not.
	 * @return Returns true if str can be formatted to a number, false if it can't
	 *         be.
	 */
	public static boolean isNumber(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (Exception e) {
			return false;
			// TODO: handle exception
		}
	}

	/**
	 * Handles the setting of a button at a index
	 * 
	 * @param index : Index of the button we want to change.
	 * @param state : State that we would like to change the button to.
	 */
	public static void setAtIndex(int index, XO state) {
		if (index < buttons.size() && index >= 0) {
			buttons.get(index).setState(state);
		}
	}
}
