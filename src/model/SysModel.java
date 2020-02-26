package model;

import Utils.GameConstants;
import Utils.GameUtil;

/**
 * @author: Ruoyu Li
 * @author: 2431975L
 * @date: 19-12-01
 * @description: Store and calculate game-related data and information to be
 *               displayed by GameView
 */
public class SysModel {

	/** the mCurrentCards is used for the current 3 cards */
	private Card[] mCurrentCards;

	/** the mCurrentCards is used for the current balance of user */
	private int mCurrentBalance;

	/**
	 * the mResultState is used for the game result: 0 for no result, 1 for win, 2
	 * for lose
	 */
	private int mResultState;

	/** mBalanceString is used for the full statement string of the balance */
	private String mBalanceString;

	/**
	 * mBalanceString is used for the full statement string of the balance change
	 * state
	 */
	private String mStateString;

	/**
	 * mResultString is used for the full statement string of the game result: win
	 * or lose
	 */
	private String mResultString;

	/**
	 * Initialize the data of game.
	 * 
	 */
	public SysModel() {
		resetGame();
	}

	/**
	 * reset the data of game.
	 * 
	 */
	public void resetGame() {
		// use GameUtil get initial Cards[]
		this.mCurrentCards = GameUtil.getInitialCards();
		this.mCurrentBalance = GameConstants.INITIAL_BALANCE;
		this.mResultState = GameConstants.GAME_RESULT_STATE_INITIAL;

		this.mBalanceString = GameUtil.getBalanceString(mCurrentBalance);
		this.mStateString = GameConstants.STATE_STRING_INITIAL;
		this.mResultString = GameConstants.RESULT_STRING_INITIAL;
	}

	/**
	 * spin cards by get three new cards randomly, and then calculate and update the
	 * data.
	 * 
	 */
	public void spinCards() {
		// use GameUtil get spin Cards
		this.mCurrentCards = GameUtil.getSpinCards();
		// calculate the change of balance.
		int changedPoints = GameUtil.StrikeBalance(mCurrentCards);
		// calculate the new-current balance
		this.mCurrentBalance += changedPoints;

		// update the resultState by updated currentBalance
		if (GameUtil.alreadyWin(mCurrentBalance)) {
			this.mResultState = GameConstants.GAME_RESULT_STATE_WIN;
		} else if (GameUtil.alreadyLose(mCurrentBalance)) {
			this.mResultState = GameConstants.GAME_RESULT_STATE_LOSE;
		}

		// update the strings of game statement.
		this.mBalanceString = GameUtil.getBalanceString(mCurrentBalance);
		this.mStateString = GameUtil.getStateString(changedPoints);
		this.mResultString = GameUtil.getResultString(mResultState);
	}

	/**
	 * Get the current balance of the game
	 * 
	 * @return {@code Integer} the current balance value.
	 */
	public int getCurrentBalance() {
		return mCurrentBalance;
	}

	/**
	 * Get the current three cards of the game
	 * 
	 * @return {@code Card[]} the current three cards of game
	 */
	public Card[] getCurrentCards() {
		return mCurrentCards;
	}

	/**
	 * Get the current result state of game
	 * 
	 * @return {@code Integer} the current game result value: 0 for no result, 1 for
	 *         win, 2 for lose.
	 */
	public int getResultState() {
		return mResultState;
	}

	/**
	 * Get the current balance information
	 * 
	 * @return {@code String} The full statement used to state the current balance
	 *         to the player in the game
	 */
	public String getBalanceString() {
		return mBalanceString;
	}

	/**
	 * Get the current state information
	 * 
	 * @return {@code String} The full statement used to state the change of this
	 *         card spun on the balance
	 */
	public String getStateString() {
		return mStateString;
	}

	/**
	 * Get the current result information
	 * 
	 * @return {@code String} The full statement is used to state the current game
	 *         result
	 */
	public String getResuleString() {
		return mResultString;
	}

}