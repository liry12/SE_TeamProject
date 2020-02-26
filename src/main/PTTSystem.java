package main;

import controller.SysController;
import model.SysModel;

/**
 * @author: Ruoyu Li
 * @author: 2431975L
 * @date: 19-12-01
 * @description: Run the Fruit machine game.
 */
public class PTTSystem {

	public static void main(String[] args) {
		// Main creates Model object
		SysModel gameModel = new SysModel();
		// Main creates Controller object, passing Model object to constructor.
		// Controller creates View object, passing Model and Controller objects to constructor.
		SysController gameController = new SysController(gameModel);
	}

}