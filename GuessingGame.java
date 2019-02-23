import java.util.Scanner;

public class GuessingGame{
    public static void main(String[] args){
        // create a Scanner object named "keyboard"
        Scanner keyboard = new Scanner(System.in);
        //declare variables for the answer, user's guess, and number fo guesses
        int answer;
        int guess;
        int numOfGuess = 0;
        
        boolean done = false;
        answer = (int)(100*Math.random())+1;
        
        //print an introduction that tells the user how to play this game
        System.out.println("Hello user! I will generate a number between 1-100 inclusive and you will try to guess it! I will tell you if your answer is too low or too high after each incorrect guess!");
        do 
        {
         System.out.print("Please enter your guess:");
         guess = keyboard.nextInt();
        if (guess > answer){
            System.out.println("Too high!");
        }
        else if( guess < answer){
            System.out.println("Too low!");
        }
        else{
            done = true;
        }
        numOfGuess += 1;
        } while (done == false);
        
        System.out.println("Congratulations! You're score is " + numOfGuess);
        if (numOfGuess >= 20){
            System.out.println("Rating: You are terrible at this game!");
        }
        else if (numOfGuess >= 10 && numOfGuess <=19){
            System.out.println("Rating: You need more practice!");
        }
        else if (numOfGuess >= 5 && numOfGuess <= 9){
            System.out.println("Rating: Not too bad, But can you get it in fewer than 5 guesses?");
        }
        else if (numOfGuess >= 2 && numOfGuess <= 4){
            System.out.println("Rating: AWESOME. You win a trip to Hawaii!");
        }
        else{
            System.out.println("Rating: That was pure LUCK and you know it!");
        }
        
    }
}