package model;

/**
 * @author: Ruoyu Li
 * @author: 2431975L
 * @date: 19-12-01
 * @description: represent the five game cards: Ace, King, Queen, Jack, Joker
 */
public enum Card {
	ACE("Ace", 0), KING("King", 1), QUEEN("Queen", 2), JACK("Jack", 3), JOKER("Joker", 4);

	/** the name is used for the name of a card */
	private String name;

	/** the index is used for the index of a card */
	private int index;

	/**
	 * Initialize a new card, passing name and index to constructor.
	 * 
	 * @param name  The card name.
	 * @param index The card index.
	 */
	private Card(String name, int index) {
		this.name = name;
		this.index = index;
	}

	/**
	 * get a card object by its index
	 * 
	 * @param index The card index.
	 * @return {@code Card} the card with given index.
	 */
	public static Card getCardByIndex(int index) {
		for (Card card : Card.values()) {
			if (card.getIndex() == index) {
				return card;
			}
		}
		return null;
	}

	/**
	 * get a card's name by its index
	 * 
	 * @param index The card index.
	 * @return {@code String} the card's name with given index.
	 */
	public static String getNameByIndex(int index) {
		return getCardByIndex(index).getName();
	}

	/**
	 * get a card's name
	 * 
	 * @return {@code String} the card's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * get a card's index
	 * 
	 * @return {@code Integer} the card's index
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * judge if the object is a Joker
	 * 
	 * @return {@code true} if the object is a Joker {@code false} otherwise.
	 */
	public boolean isJoker() {
		return this.index == Card.JOKER.getIndex();
	}

}