package Utils;

/**
 * @author: Ruoyu Li
 * @author: 2431975L
 * @date: 19-12-01
 * @description: Stores the constants used in games
 */
public class GameConstants {
	/** The INITIAL_BALANCE is used for the initial balance */
	public static final int INITIAL_BALANCE = 100;

	/** The CARDS_COUNT is used for the count of total cards */
	public static final int CARDS_COUNT = 5;

	/** The INITIAL_BALANCE_STRING is used to form balance information string */
	public static final String INITIAL_BALANCE_STRING = "The balance is ";

	/** The STATE_STRING_INITIAL is used for the initial state string */
	public static final String STATE_STRING_INITIAL = "Welcome!";

	/**
	 * The STATE_STRING_TWO_OF_A_KIND is used for the state string when 2 cards are
	 * same and contains no Joker
	 */
	public static final String STATE_STRING_TWO_OF_A_KIND = "Two of a kind - you win 20 points.";

	/**
	 * The STATE_STRING_THREE_OF_A_KIND is used for the state string when 3 cards
	 * are same and contains no Joker
	 */
	public static final String STATE_STRING_THREE_OF_A_KIND = "Three of a kind - you win 50 points.";

	/**
	 * The STATE_STRING_NOT_CHANGE is used for the state string when balance not
	 * changed
	 */
	public static final String STATE_STRING_NOT_CHANGE = "Balance unchanged.";

	/** The RESULT_STRING_INITIAL is used for the initial result string */
	public static final String RESULT_STRING_INITIAL = "";

	/** The RESULT_STRING_WIN is used for the result string when user wins */
	public static final String RESULT_STRING_WIN = "You win!";

	/** The RESULT_STRING_LOSE is used for the result string when user loses */
	public static final String RESULT_STRING_LOSE = "You lose.";

	/** The GAME_RESULT_STATE_INITIAL is used to represent initial game state */
	public static final int GAME_RESULT_STATE_INITIAL = 0;

	/** The GAME_RESULT_STATE_WIN is used to represent game state when user wins */
	public static final int GAME_RESULT_STATE_WIN = 1;

	/**
	 * The GAME_RESULT_STATE_LOSE is used to represent game state when user loses
	 */
	public static final int GAME_RESULT_STATE_LOSE = 2;

	/**
	 * The INITIAL_CARDS_INDEX_1 is used to represent the first initial card King's
	 * index
	 */
	public static final int INITIAL_CARDS_INDEX_1 = 1;

	/**
	 * The INITIAL_CARDS_INDEX_2 is used to represent the first initial card Queen's
	 * index
	 */
	public static final int INITIAL_CARDS_INDEX_2 = 2;

	/**
	 * The INITIAL_CARDS_INDEX_3 is used to represent the first initial card Jack's
	 * index
	 */
	public static final int INITIAL_CARDS_INDEX_3 = 3;
}
