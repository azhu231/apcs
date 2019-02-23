/**
 * Card.java
 *
 * <code>Card</code> represents a basic playing card.
 */
public class Card implements Comparable<Card>
{
    /** String value that holds the symbol of the card.
    Examples: "A", "Ace", "10", "Ten", "Wild", "Pikachu"
     */
    private String symbol;

    /** int value that holds the value this card is worth */
    private int value;

    /** boolean value that determines whether this card is face up or down */
    private boolean isFaceUp;

    /**
     * Creates a new <code>Card</code> instance.
     *
     * @param symbol  a <code>String</code> value representing the symbol of the card
     * @param value an <code>int</code> value containing the point value of the card
     * @param suit a <code>String</code> value representing the suit of the card
     */    
    public Card(String symbol, int value) {
        this.symbol = symbol;
        this.value = value;
    }

    /**
     * Getter method to access this <code>Card</code>'s symbol.
     * 
     * @return this <code>Card</code>'s symbol.
     */
    public String getSymbol() {
        return symbol;
    }
    
    /**
     * Getter method to access this <code>Card</code>'s value.
     * 
     * @return this <code>Card</code>'s symbol
     */
    public int getValue() {
        return value;
    }
    
    /**
     * Returns whether or not this <code>Card</code> is equal to another
     * 
     * @return whether or not this Card is face up.
     */
    public boolean isFaceUp() {
        return isFaceUp;
    }
    
    /**
     * Setter method that sets the card face up or down.
     * 
     * @state to set this card face up or face down
     */
    public void setFaceUp(boolean state) {
        isFaceUp = state;
    }

    /**
     * Returns whether or not this <code>Card</code> is equal to another
     *  
     *  @return whether or not this Card is equal to other.
     */
    public boolean equals(Card other) {
        if(value == other.getValue()){
            return true;
        }
        else{
            return false;
        }
    }
    
    @Override
    /**
     * Compares the difference in value of this card to another card
     * 
     * @param c the card being compared to this card
     * 
     * @return the difference in value of this card and the card being passed in
     */
    public int compareTo(Card c){
        return value-c.getValue();
    }
    
    /**
     * Returns this card as a String.  If the card is face down, "X"
     * is returned.  Otherwise the symbol of the card is returned.
     *
     * @return a <code>String</code> containing the symbol of the card.
     */
    @Override
    public String toString() {
        if(isFaceUp()){
            return symbol;
        }
        else{
            return "X";
        }
    }
}
