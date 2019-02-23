/*Anthony Zhu, Period 2, Ferrante, 12/6/2018
 * 30 minutes
 * Activity 6 Reflection
 * This activity was much more easier than activity 5. I was able to do it with some simple try catch statements. In the Spider Solitaire Class
 * I only caught if the user did not enter what the scanner was looking for. I caught indexOutofBounds errors in my board class
 * using if/else statements. It took me a while to figure out how to separate all my errors so that they would have unique error
 * statements but once I did, my game became pretty much finished except for the saving aspect. Overall, I enjoyed making my
 * game uncrashable through this activity. This activity did not take very long as I had already done most of my error catching
 * in the Board class, and I only had to add two try/catch statemnts in the Spider Solitaire class.
 * 
 * Anthony Zhu, Period 2, Ferrante, 12/9/2018
 * 1 hour
 * Activity 7 Reflection
 * This activity was also generally easier than the game logic part of creating Spider Solitaire. I simply followed the instructions
 * from the worksheet and the loopmail that Mr. Ferrante sent out. Originally I was confused because I could only open the
 * file window once every time I ran the program, and it would stop showing up which bascially broke my game. However, once I did
 * what the loopmail said to do, my program worked fine. I also had a good review of file writing/reading although I had to look
 * back at previous lessons and labs. I should review these techniques so that I can write them automatically. Overall, this entire
 * lab was very good review of files, loops, strings, arraylists/arrays, classes, and methods.
 */



import java.util.*;

public class SpiderSolitaire
{
    /** Number of stacks on the board **/
    public final int NUM_STACKS = 7;

    /** Number of complete decks used in the game.  
     *  The number of cards in a deck depends on the
     *  type of Card used.  For example, a 1-suit deck
     *  of standard playing cards consists of only 13 cards
     *  whereas a 4-suit deck consists of 52 cards.
     */
    public final int NUM_DECKS = 4;

    /** A Board contains stacks and a draw pile **/
    private Board board;

    /** Used for keyboard input **/
    private Scanner input;

    public SpiderSolitaire()
    {
        // Start a new game with NUM_STACKS stacks and NUM_DECKS of cards
        board = new Board(NUM_STACKS, NUM_DECKS);
        input = new Scanner(System.in);
    }

    /** Main game loop that plays games until user wins or quits **/
    public void play() {

        board.printBoard();
        boolean gameOver = false;

        while(!gameOver) {
            System.out.println("\nCommands:");
            System.out.println("   move [card] [source_stack] [destination_stack]");
            System.out.println("   draw");
            System.out.println("   clear [source_stack]");
            System.out.println("   restart");
            System.out.println("   save");
            System.out.println("   load");
            System.out.println("   quit");
            System.out.print(">");
            String command = input.next();

            if (command.equals("move")) {
                try{
                    String symbol = input.next();
                    int sourceStack = input.nextInt();
                    int destinationStack = input.nextInt();
                    board.makeMove(symbol, sourceStack - 1, destinationStack - 1);
                }
                catch (InputMismatchException i){
                    System.out.println("Invalid Command! Please enter one card, and two stack numbers for command move.");
                }
            }
            else if (command.equals("draw")) {
                board.drawCards();
            }
            else if (command.equals("clear")) {
                try{
                    int sourceStack = input.nextInt();
                    board.clear(sourceStack - 1);
                }
                catch (InputMismatchException i){
                    System.out.println("Invalid Command! Please enter stack number for command clear.");
                }
            }
            else if (command.equals("restart")) {
                board = new Board(NUM_STACKS, NUM_DECKS);
            }
            else if (command.equals("quit")) {
                System.out.println("Goodbye!");
                System.exit(0);
            }
            else if (command.equals("save")) {
                System.out.println("Game Saved!");
                board.save();
            }
            else if (command.equals("load")){
                System.out.println("Loading game");
                board.load();
            }
            else {
                System.out.println("Invalid command.");
            }

            board.printBoard();

            // If all stacks and the draw pile are clear, you win!
            if (board.isEmpty()) {
                gameOver = true;
            }
        }
        System.out.println("Congratulations!  You win!");
    }
}
