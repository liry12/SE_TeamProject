package controller;

//import java classes for GUI components
import java.awt.event.*;

import model.SysModel;
import view.SysView;

/**
* @author: Ruoyu Li
* @author: 2431975L
* @date: 19-12-01
* @description: Used to receive the button click event of the view, and update
*               the model and view
*/
public class SysController implements ActionListener {

	private SysView viewObject;
	private SysModel modelObject;

	/**
	 * Initialize the game controller, passing Model object to constructor.
	 * 
	 * @param model      The game model.
	 * @param controller The game controller.
	 */
	public SysController(SysModel model) {
		modelObject = model;
		// creates View object, passing Model and Controller objects to constructor.
		viewObject = new SysView(model, this);
		// display the game view.
		viewObject.setVisible(true);
	}

	/**
	 * Recognize and handle response button click events。
	 * 
	 * @param e Click event from game view.
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == viewObject.mSpinBtn) {
			// If the user clicked the spin button
			// call the model and update data
			modelObject.spinCards();
			// call the view to update content.
			viewObject.updateView();
		} else if (e.getSource() == viewObject.mNewGameBtn) {
			// If the user clicked the new-game button
			// call the model and reset data
			modelObject.resetGame();
			// call the view to reset content.
			viewObject.resetView();
		}
	}
}
