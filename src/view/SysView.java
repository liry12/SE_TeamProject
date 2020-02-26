package view;

//import java classes for GUI components
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import Utils.GameUtil;
import controller.SysController;
import model.Card;
import model.SysModel;

/**
* @author: Ruoyu Li
* @author: 2431975L
* @date: 19-12-01
* @description: Display the game content, passing the click event to the
*               Controller, and use the Model to reset or update content
*/
public class SysView extends JFrame {

	private SysController mControllerObject;
	private SysModel mModelObject;

	/** the mSpinBtn, mNewGameBtn are used for two operation buttons */
	public JButton mSpinBtn, mNewGameBtn;

	/**
	 * the mBalanceTxt, mStateTxt, mResultTxt are used to display game information
	 * statement
	 */
	private JLabel mBalanceTxt, mStateTxt, mResultTxt;

	/** the mLeftCard, mMiddleCard, mRightCard are used to display 3 cards */
	private JLabel mLeftCard, mMiddleCard, mRightCard;

	/** the mMainPanel is used to store the contents of view */
	private JPanel mMainPanel;

	/**
	 * Initialize the game frame, passing Model and Controller objects to
	 * constructor.
	 * 
	 * @param model      The game model.
	 * @param controller The game controller.
	 */
	public SysView(SysModel model, SysController controller) {
		this.mControllerObject = controller;
		this.mModelObject = model;

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("FruitMachine GUI");
		this.setSize(700, 400);
		this.setLocation(100, 100);

		// Initialize game frame
		layoutComponents();
		// Initialize game content
		resetView();
	}

	/**
	 * Initialize game frame.
	 * 
	 */
	private void layoutComponents() {
		// Create the mainPanel as a 2x2 GridLayout.
		this.mMainPanel = new JPanel(new GridLayout(2, 2, 5, 5));
		this.mMainPanel.setBorder(new MatteBorder(15, 15, 15, 15, Color.white));
		this.mMainPanel.setOpaque(true);
		this.mMainPanel.setBackground(Color.white);

		// Create a vertical textPanel to store three labels (balance, state, result)
		// This textPanel is placed in the upper left corner
		JPanel txtPanel = new JPanel(new GridLayout(3, 1));
		txtPanel.setBorder(new MatteBorder(5, 5, 5, 5, Color.white));
		txtPanel.setOpaque(true);
		txtPanel.setBackground(Color.white);

		this.mBalanceTxt = new JLabel();
		this.mStateTxt = new JLabel();
		this.mResultTxt = new JLabel();

		// add 3 text labels to textPanel
		txtPanel.add(mBalanceTxt);
		txtPanel.add(mStateTxt);
		txtPanel.add(mResultTxt);
		// add textPanel to the upper left corner of main panel
		mMainPanel.add(txtPanel);

		// Create an empty panel to store nothing but occupy a position in main panel.
		// This textPanel is placed in the upper right corner
		JPanel emptyPanel = new JPanel();
		emptyPanel.setOpaque(true);
		emptyPanel.setBackground(Color.white);
		mMainPanel.add(emptyPanel);

		// Create a horizontal cardPanel to store three cards
		// This cardPanel is placed in the lower left corner
		JPanel cardPanel = new JPanel(new GridLayout(1, 3, 10, 0));
		cardPanel.setOpaque(true);
		cardPanel.setBackground(Color.white);
		cardPanel.setSize(60, 250);

		this.mLeftCard = new JLabel();
		this.mLeftCard.setHorizontalAlignment(SwingConstants.CENTER);
		this.mLeftCard.setBorder(new MatteBorder(2, 2, 2, 2, Color.black));
		this.mLeftCard.setOpaque(true);
		this.mLeftCard.setBackground(Color.yellow);

		this.mMiddleCard = new JLabel();
		this.mMiddleCard.setHorizontalAlignment(SwingConstants.CENTER);
		this.mMiddleCard.setBorder(new MatteBorder(2, 2, 2, 2, Color.black));
		this.mMiddleCard.setOpaque(true);
		this.mMiddleCard.setBackground(Color.yellow);

		this.mRightCard = new JLabel();
		this.mRightCard.setHorizontalAlignment(SwingConstants.CENTER);
		this.mRightCard.setBorder(new MatteBorder(2, 2, 2, 2, Color.black));
		this.mRightCard.setOpaque(true);
		this.mRightCard.setBackground(Color.yellow);

		// add 3 card labels to cardPanel
		cardPanel.add(mLeftCard);
		cardPanel.add(mMiddleCard);
		cardPanel.add(mRightCard);
		// add cardPanel to the lower left corner of main panel
		mMainPanel.add(cardPanel);

		// Create a vertical buttonPanel to store two buttons.
		// This buttonPanel is placed in the lower right corner
		JPanel btnPanel = new JPanel(new GridLayout(2, 1));
		btnPanel.setOpaque(true);
		btnPanel.setBackground(Color.white);

		this.mSpinBtn = new JButton("Spin");
		// add actionListener to mSpingBtn, passing the event to game controller
		this.mSpinBtn.addActionListener(mControllerObject);
		this.mNewGameBtn = new JButton("New Game");
		// add actionListener to mNewGameBtn, passing the event to game controller
		this.mNewGameBtn.addActionListener(mControllerObject);

		// add 2 buttons to btnPanel
		btnPanel.add(mSpinBtn);
		btnPanel.add(mNewGameBtn);
		// add btnPanel to the lower right corner of main panel
		mMainPanel.add(btnPanel);

		// add main panel to the game view
		this.add(mMainPanel);
	}

	/**
	 * reset game content.
	 * 
	 */
	public void resetView() {
		this.mSpinBtn.setEnabled(true);
		this.mNewGameBtn.setEnabled(false);

		// Get updated data from model and update view
		Card[] cards = mModelObject.getCurrentCards();
		this.mLeftCard.setText(cards[0].getName());
		this.mMiddleCard.setText(cards[1].getName());
		this.mRightCard.setText(cards[2].getName());

		this.mBalanceTxt.setText(mModelObject.getBalanceString());
		this.mStateTxt.setText(mModelObject.getStateString());
		this.mResultTxt.setText(mModelObject.getResuleString());

		// Refresh to show reset content
		this.mMainPanel.revalidate();
	}

	/**
	 * update game content.
	 * 
	 */
	public void updateView() {
		// Get updated data from model and update view
		Card[] cards = mModelObject.getCurrentCards();
		this.mLeftCard.setText(cards[0].getName());
		this.mMiddleCard.setText(cards[1].getName());
		this.mRightCard.setText(cards[2].getName());

		this.mBalanceTxt.setText(mModelObject.getBalanceString());
		this.mStateTxt.setText(mModelObject.getStateString());
		this.mResultTxt.setText(mModelObject.getResuleString());

		// If the player wins or loses, end the game
		if (GameUtil.shouldEndGame(mModelObject.getResultState())) {
			endGame();
		}

		// Refresh to show updated content
		this.mMainPanel.revalidate();
	}

	/**
	 * end game by disable spin button and enable new-game button.
	 */
	private void endGame() {
		this.mSpinBtn.setEnabled(false);
		this.mNewGameBtn.setEnabled(true);
	}
}