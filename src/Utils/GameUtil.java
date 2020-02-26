package Utils;

import java.util.Random;

import model.Card;

/**
 * @author: Ruoyu Li
 * @author: 2431975L
 * @date: 19-12-01
 * @description: game aid class for calculation, etc.
 */
public class GameUtil {

	/**
	 * get the initial three cards King,Queen and Jack
	 * 
	 * @return {@code Card[]} the initial cards
	 */
	public static Card[] getInitialCards() {
		Card[] cards = new Card[3];
		// get three cards through the agreed card index
		cards[0] = Card.getCardByIndex(GameConstants.INITIAL_CARDS_INDEX_1); // King
		cards[1] = Card.getCardByIndex(GameConstants.INITIAL_CARDS_INDEX_2); // Queen
		cards[2] = Card.getCardByIndex(GameConstants.INITIAL_CARDS_INDEX_3); // Jack

		return cards;
	}

	/**
	 * get the spun three cards randomly
	 * 
	 * @return {@code Card[]} the randomly obtained cards
	 */
	public static Card[] getSpinCards() {
		Card[] cards = new Card[3];
		for (int i = 0; i < cards.length; i++) {
			// get and store a random-new card.
			cards[i] = GameUtil.getRandomCard();
		}

		return cards;
	}

	/**
	 * get a new card randomly
	 * 
	 * @return {@code Card} the randomly obtained card
	 */
	public static Card getRandomCard() {
		Random random = new Random();
		int randomColumnIndex;
		randomColumnIndex = random.nextInt(GameConstants.CARDS_COUNT);
		// return a new card by a random obtained index within the count of total cards.
		return Card.getCardByIndex(randomColumnIndex);
	}

	/**
	 * Calculate balance changes
	 * 
	 * @param cards the 3 randomly obtained cards
	 * @return {@code Integer} the change of balance, Positive for increase,
	 *         negative for decrease, 0 means no change
	 */
	public static int StrikeBalance(Card[] cards) {
		int result = 0;
		boolean containsJoker = false;

		// First determine if a joker is included and how many jokers are included
		for (int i = 0; i < cards.length; i++) {
			if (cards[i].isJoker()) {
				containsJoker = true;
				// One joker minus 25
				result -= 25;
			}
		}

		// If includes joker, return the result directly
		if (containsJoker) {
			return result;
		}

		// If there is no joker, it is judged that there are several identical cards.
		// Add 20 for the same two cards, 50 for the same three cards
		Card firstCard = cards[0];
		Card secondCard = cards[1];
		Card thirdCard = cards[2];

		if (firstCard.equals(secondCard)) {
			if (firstCard.equals(thirdCard)) {
				return 50;
			} else {
				return 20;
			}
		} else if (firstCard.equals(thirdCard) || secondCard.equals(thirdCard)) {
			return 20;
		}

		// If none of the above conditions are met, return 0
		return 0;
	}

	/**
	 * Get the full statement string of the balance
	 * 
	 * @param balance the current balance of the user.
	 * @return {@code String} the full statement string of the balance
	 */
	public static String getBalanceString(int balance) {
		return GameConstants.INITIAL_BALANCE_STRING + balance;
	}

	/**
	 * Get the full statement string of the balance change state
	 * 
	 * @param changedPoints The balance changes.
	 * @return {@code String} the full statement string of the balance change state:
	 *         Increase, decrease or remain unchanged
	 */
	public static String getStateString(int changedPoints) {
		if (changedPoints >= 0) {
			if (changedPoints == 20) {
				return GameConstants.STATE_STRING_TWO_OF_A_KIND;
			} else if (changedPoints == 50) {
				return GameConstants.STATE_STRING_THREE_OF_A_KIND;
			} else {
				return GameConstants.STATE_STRING_NOT_CHANGE;
			}

		} else {
			int absChangedPoints = Math.abs(changedPoints);
			int jokerCounts = absChangedPoints / 25;
			return jokerCounts + " jokers: you lose " + absChangedPoints + " points";
		}
	}

	/**
	 * Get the full statement string of the game result
	 * 
	 * @param resultState the current result state of the game:0 for no result, 1
	 *                    for win, 2 for lose
	 * @return {@code String} the full statement string of the game result: no
	 *         result, win or lose
	 */
	public static String getResultString(int resultState) {
		String resultString = "";
		switch (resultState) {
		case GameConstants.GAME_RESULT_STATE_INITIAL:
			resultString = GameConstants.RESULT_STRING_INITIAL;
			break;
		case GameConstants.GAME_RESULT_STATE_WIN:
			resultString = GameConstants.RESULT_STRING_WIN;
			break;
		case GameConstants.GAME_RESULT_STATE_LOSE:
			resultString = GameConstants.RESULT_STRING_LOSE;
			break;
		}
		return resultString;
	}

	/**
	 * judge if the game already has a result.
	 * 
	 * @param resultState the current result state of the game:0 for no result, 1
	 *                    for win, 2 for lose
	 * @return {@code true} if the game ends {@code false} otherwise.
	 */
	public static boolean shouldEndGame(int resultState) {
		return (resultState == GameConstants.GAME_RESULT_STATE_WIN
				|| resultState == GameConstants.GAME_RESULT_STATE_LOSE);
	}

	/**
	 * judge if the use already wins.
	 * 
	 * @param balance the current balance of the user.
	 * @return {@code true} if the current balance is at least 150 points
	 *         {@code false} otherwise.
	 */
	public static boolean alreadyWin(int balance) {
		return balance >= 150;
	}

	/**
	 * judge if the use already loses.
	 * 
	 * @param balance the current balance of the user.
	 * @return {@code true} if the current balance is less than 0 point
	 *         {@code false} otherwise.
	 */
	public static boolean alreadyLose(int balance) {
		return balance < 0;
	}
}
