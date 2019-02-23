/*Anthony Zhu, Period 2, Ferrante, 12/2/2018
 * 90 minutes
 * This lab was generally easy for me to complete. It was a good review of arrays and arrayLists as ways of 
 * storing multiple objects. I also had to use loops to solve problems where I had to perform the same action
 * over and over again. I also learned new concepts such as tagging overrides so that Java ensures that you
 * actually override a method. I have not written javadoc comments in a long time so I needed to review them,
 * but they're format is pretty easy to understand. Overall, I think that I covered everything that you can do
 * with decks and cards in my lab
 */

public class DeckTester
{
    public static void main(String[] args) {
        Deck testing1 = new Deck();
        String[] symbols = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        for(int i = 0; i < symbols.length; i++){
        	Card addedCard = new Card(symbols[i], values[i]);
        	addedCard.setFaceUp(true);
        	testing1.add(addedCard);
        }
        
        System.out.println(testing1);
        
        testing1.shuffle();
        
        System.out.println(testing1);
        
        testing1.selectionSort();
        
        System.out.println(testing1);
        
        Card testing2 = testing1.getCard(0);
        System.out.println(testing2);
        testing2.setFaceUp(true);
        System.out.println(testing2);
        
        System.out.println(testing1);
        
        String version = testing1.stringState();
        
        Deck testing3 = new Deck(version);
        System.out.print(testing3);
    }
}
