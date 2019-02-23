/*Anthony Zhu, Period 2, Ferrante, 12/4/2018
 * 200 minutes
 * This lab was definitely on the more difficult sides. The individual parts were easy to do but it was 
 * such a big lab it was hard for me to mentally keep track of everything. In addition to this, I struggled 
 * with catching every statement that would throw my program into an IndexOutOf Bounds error and I messed up
 * the index of source stacks because I did not realize the SpiderSolitaire class accounts for ArrayLists
 * starting at 0. Overall, I think I put a very good effort on this lab although there are definitely a few mistakes
 * left that I will fix tomorrow.
 */

import java.util.*;
import java.awt.*;
import java.io.*;
import java.lang.reflect.*;
import javax.swing.*;
public class Board
{   
    /* *** TO BE IMPLEMENTED IN ACTIVITY 4 *** */
    // Attributes
    
    ArrayList<Deck> stacks = new ArrayList<Deck>();
    Deck drawPile = new Deck();
    
    /**
     *  Sets up the Board and fills the stacks and draw pile from a Deck
     *  consisting of numDecks Decks.  The number of Cards in a Deck
     *  depends on the number of suits. Here are examples:
     *  
     *  # suits     # numDecks      #cards in overall Deck
     *      1            1          13 (all same suit)
     *      1            2          26 (all same suit)
     *      2            1          26 (one of each suit)
     *      2            2          52 (two of each suit)
     *      4            2          104 (two of each suit)
     *      
     *  Once the overall Deck is built, it is shuffled and half the cards
     *  are placed as evenly as possible into the stacks.  The other half
     *  of the cards remain in the draw pile.  If you'd like to specify
     *  more than one suit, feel free to add to the parameter list.
     */    
    public Board(int numStacks, int numDecks) {
       String[] symbols = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
       int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
       for (int i = 1; i <= numDecks; i++){
           for (int j = 0; j < symbols.length; j++){
               drawPile.add(symbols[j], values[j]);
           }
       }
       
       for(int i = 1; i <= numStacks; i++){
           stacks.add(new Deck());
       }
       
       drawPile.shuffle();
       
       int numCards = drawPile.size();
       
       int stackTracker = numStacks;
       while(drawPile.size() > numCards/2){
           stacks.get(stackTracker%numStacks).add(drawPile.getCard(0));
           drawPile.remove(0);
           stackTracker++;
       }
     
       for(int i = 0; i < numStacks; i++){
           (stacks.get(i)).getCard(stacks.get(i).size()-1).setFaceUp(true);
       }
       
       
    }

    /**
     *  Moves a run of cards from src to dest (if possible) and flips the
     *  next card if one is available.  Change the parameter list to match
     *  your implementation of Card if you need to.
     */
    public void makeMove(String symbol, int src, int dest) {
        if(src < stacks.size() && src >= 0 && dest < stacks.size() && dest >= 0){
            Deck source = stacks.get(src);
            Deck destination = stacks.get(dest);
            int cardLocation = -1;
            boolean canMove = false;
            for(int i = source.size()-1; i >= 0 && source.getCard(i).isFaceUp(); i--){
                if (source.getCard(i).getSymbol().equals(symbol)){
                    cardLocation = i;
                    break;
                }
            }
            
            if(cardLocation > -1){
                canMove = true;
                for(int i = cardLocation; i < source.size()-1; i++){
                    if (source.getCard(i).getValue() - 1 != source.getCard(i+1).getValue()){
                        canMove = false;
                    }
                }
                
                if(destination.size() == 0){
                    canMove = canMove;
                }
                else if(source.getCard(cardLocation).getValue() + 1 != destination.getCard(destination.size()-1).getValue()){
                    canMove = false;
                }
                if (canMove){
                    while(source.size()-1 >= cardLocation){
                        destination.add(source.getCard(cardLocation));
                        source.remove(cardLocation);
                    }
                    if(source.size() >= 1){
                        source.getCard(cardLocation-1).setFaceUp(true);
                    }
                }
            }
            if (!canMove){
                if(cardLocation > -1){
                    System.out.println("Invalid Move! You can not make that move.");
                }
                else{
                    System.out.println("Invalid Move! Card not found in source stack.");
                }
            }
        }
        else{
            System.out.println("Invalid stack numbers!");
        }
    }

    /** 
     *  Moves one card onto each stack, or as many as are available
     */
    public void drawCards() {
        boolean allFull = true;
        
        for(int i = 0; i < stacks.size(); i++){
            if (stacks.get(i).size() == 0){
                allFull = false;
            }
        }
        
        if (allFull){
            for (int i = 0; i < stacks.size(); i++){
                 if (drawPile.size() != 0){
                     Card currentCard = drawPile.getCard(0);
                     currentCard.setFaceUp(true);
                     stacks.get(i).add(currentCard);
                     drawPile.remove(0);
                 }
             }
        }
    }

    /**
     *  Returns true if all stacks and the draw pile are all empty
     */ 
    public boolean isEmpty() {
        for(int i = 0; i < stacks.size(); i++){
            if (stacks.get(i).size() != 0){
                return false;
            }
        }
        if (drawPile.size() != 0){
            return false;
        }
        return true;
    }

    /**
     *  If there is a run of A through K starting at the end of sourceStack
     *  then the run is removed from the game or placed into a completed
     *  stacks area.
     *  
     *  If there is not a run of A through K starting at the end of sourceStack
     *  then an invalid move message is displayed and the Board is not changed.
     */
    public void clear(int sourceStack) {
        
        
        if(sourceStack < stacks.size() && sourceStack >= 0){
            Deck currentStack = stacks.get(sourceStack);
            int[] value = {13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
            int valueTracker = 12;
            boolean removable = true;
            
            if (currentStack.size() >= 13){
                for (int i = currentStack.size()-1; i >= currentStack.size()-13; i--){
                    if (currentStack.getCard(i).getValue() == value[valueTracker] &&
                        currentStack.getCard(i).isFaceUp()){
                        valueTracker--;
                    }
                    else{
                        removable = false;
                    }
                }
            }
            else{
                removable = false;
            }
            
            if (removable){
                int sizeAfterRemoval = currentStack.size()-13;
                while (currentStack.size() > sizeAfterRemoval){
                    currentStack.remove(currentStack.size()-1);
                }
                if(sizeAfterRemoval > 0){
                    currentStack.getCard(currentStack.size()-1).setFaceUp(true);
                }
            }
            else{
                System.out.println("Invalid move! There is not a removable run.");
            }
        }
        else{
            System.out.println("Invalid Stack Number!");
        }
    }

    /**
     * Prints the board to the terminal window by displaying the stacks, draw
     * pile, and done stacks (if you chose to have them)
     */
    public void printBoard() {
        for (int i = 0; i < stacks.size(); i++){
            int stackNum = i+1;
            System.out.println("" + stackNum + ": "+ stacks.get(i));
        }
        
        System.out.println("Draw Pile: ");
        System.out.println(drawPile);
    }
    
    public void save(){
            
            try {
                 EventQueue.invokeAndWait(new Runnable() {
                      @Override
                      public void run() {
             
                            // Create a JFileChooser that points to the current directory
                            JFileChooser chooser = new JFileChooser(".");
                            
                            // Tell the JFileChooser to show a Save dialog window
                            chooser.showSaveDialog(null);
                            
                            // Ask the JFileChooser for the File the user typed in or selected and write in that file
                            FileWriter wFile;
                            try{
                                File sFile = chooser.getSelectedFile();
                                wFile = new FileWriter(sFile);
                                for(int d = 0; d < stacks.size(); d++){
                                    wFile.write(stacks.get(d).stringState() + "\n");
                                }       
                                wFile.write(drawPile.stringState());
                                wFile.close();
                            }
                            catch (IOException i){
                                System.out.println("Please type out valid file!");
                            }
            
            
                      }
                 });
            }
            catch (InterruptedException e) {
                 System.out.println("Error: " + e.getMessage());
            }
            catch (InvocationTargetException e) {
                 System.out.println("Error: " + e.getMessage());
            }
    }
    
    public void load(){
        try {
             EventQueue.invokeAndWait(new Runnable() {
                  @Override
                  public void run() {
                        //Create a JFileChooser that points to the current directory
                        JFileChooser chooser = new JFileChooser(".");
                        
                        //Tell the JFileChooser to show a Open dialog window
                        chooser.showOpenDialog(null);
                        
                        Scanner translator = new Scanner(System.in);
                        try{
                            File sFile = chooser.getSelectedFile();
                            translator = new Scanner(sFile);
                        }
                        catch(IOException i){
                            System.out.println("Could not find selected file!");
                        }
                        
                        //reset board
                        stacks.clear();
                        
                        int stackCounter = 0;
                        while(translator.hasNextLine()){
                            String currentLine = translator.nextLine();
                            if(translator.hasNextLine()){
                                stacks.add(new Deck(currentLine));
                                stackCounter++;
                            }
                            else{
                                drawPile = new Deck(currentLine);
                            }
                        }
                  }
             });
        }
        catch (InterruptedException e) {
             System.out.println("Error: " + e.getMessage());
        }
        catch (InvocationTargetException e) {
             System.out.println("Error: " + e.getMessage());
        }
    }
}