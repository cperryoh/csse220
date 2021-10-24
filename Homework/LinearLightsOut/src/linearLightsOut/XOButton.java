package linearLightsOut;

import java.awt.Color;
import java.lang.constant.Constable;
import java.lang.invoke.ConstantBootstraps;

import javax.swing.JButton;
/**
 * 
 * @author Cole Perry
 * Class that extends JButton class and implements XO button state
 */
public class XOButton extends JButton {
	XO state;
	Color xColor = new Color(255,255,0);
	Color oColor = Color.green;
	int index;
	/**
	 * Constructor class 
	 * @param state
	 * @param index
	 */
	public XOButton(XO state,int index) {
		this.index=index;
		setState(state);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Sets the state of the button and handles any changes that need to be made when doing so.
	 * @param state : The state to change the button to
	 */
	public void setState(XO state) {
		this.setText(state.toString());
		if(state.equals(XO.x)) {
			this.setBackground(xColor);
		}else {
			this.setBackground(oColor);
		}
		this.state=state;
	}
	
	/**
	 * @return Returns the state of the button
	 */
	public XO getState() {
		return state;
	}
	/**
	 * @return The index of the button in the line of buttons
	 */
	public int getIndex() {
		return index;
	}
}
