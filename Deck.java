import java.util.*;

public class Deck
{
    ArrayList<Card> cardsInDeck;
    public Deck(){
        cardsInDeck = new ArrayList<Card>();
    }
    
    public Deck(String s){
        Scanner stringReader = new Scanner(s);
        cardsInDeck = new ArrayList<Card>();
        while (stringReader.hasNext()){
            String symbol = stringReader.next();
            int value = stringReader.nextInt();
            Card current = new Card(symbol, value);
            if(stringReader.next().equals("true")){
                current.setFaceUp(true);
            }
            cardsInDeck.add(current);
        }
    }
    
    public void shuffle(){
        int size = cardsInDeck.size();
        for (int i = 0; i < size; i++){
            int switchPos = (int)(size*Math.random());
            Card iterCard = cardsInDeck.get(i);
            Card randCard = cardsInDeck.get(switchPos);
            cardsInDeck.add(switchPos, iterCard);
            cardsInDeck.remove(switchPos+1);
            cardsInDeck.add(i, randCard);
            cardsInDeck.remove(i+1);
        }
    }
    
    public void add(String symbol, int value){
        cardsInDeck.add(new Card(symbol, value));
    }
    
    public void add(Card card){
        cardsInDeck.add(card);
    }
    
    public int size(){
        return cardsInDeck.size();
    }
    
    public void remove(int i){
        cardsInDeck.remove(i);
    }
    
    public Card getCard(int index){
        return cardsInDeck.get(index);
    }
    
    @Override
    public String toString(){
        String finalString = "[";
        for(int i = 0; i < cardsInDeck.size(); i++){
            Card current = cardsInDeck.get(i);
            if(i == cardsInDeck.size()-1){
                finalString = finalString + current;
            }
            else{
                finalString = finalString + current + ", ";
            }
        }
        finalString += "]";
        return finalString;
    }
    
    public String stringState(){
        String finalString = "";
        for(int i = 0; i < cardsInDeck.size(); i++){
            Card current = cardsInDeck.get(i);
            finalString = finalString + current.getSymbol() + " " + current.getValue() + " " + current.isFaceUp() + " ";
        }
        return finalString;
    }
    
    public void clear(){
        cardsInDeck.clear();
    }
    
    void selectionSort() {
    	for(int i = cardsInDeck.size()-1; i>0; i-- ) {
    		int largeIndex = 0;
    		for(int j = 1; j <= i; j++) {
    			if(cardsInDeck.get(j).compareTo(cardsInDeck.get(largeIndex)) > 0) {
    				largeIndex = j; 
    			}
    		}
    		Card temp1 = cardsInDeck.get(i);
	        Card temp2 = cardsInDeck.get(largeIndex);
	        cardsInDeck.add(largeIndex, temp1);
	        cardsInDeck.remove(largeIndex+1);
	        cardsInDeck.add(i, temp2);
	        cardsInDeck.remove(i+1);
    	}
    }
}

	
