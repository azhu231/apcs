/* Anthony Zhu
 * November 4th 2018
 * Period 2 Ferrante
 * Time: 130 minutes 
 * This lab was definitely easier because of the top down approach that we were instructed to use. Each 
 * helper method itself was pretty challenging, but by logically analyzing the rules of the game and 
 * how java works, I was able to figure out the psuedocode for each of them. After figuring out the pseudocode,
 * the acutal game method was very easy because of all the helper methods I made. One challenging part about the
 * main method was how to accept the input to make sure that the program would not crash. However, by using
 * lots of if/else statements to account for different exceptions, I was able to do it. Overall, this has
 * been one of the more challenging labs.
 */


import java.util.Scanner;

public class P2_Zhu_Anthony_StringCraft{
    public void playGame(){
        Scanner keyboard = new Scanner(System.in);
        int strLen = promptForStringLength();
        int move = 0;
        String randString = generateRandomString(strLen);
        System.out.println(randString + " is worth " + score(randString) + " points");
        while (canMove(randString)){
            Boolean badIndex = true;
            int index1 = 0;
            int index2 = 0;
            while (badIndex){
                System.out.println("Enter the indexes of the characters you would like to swap: ");
                String str1 = keyboard.nextLine();
                Scanner stringScanner = new Scanner(str1);
                if (stringScanner.hasNextInt()){
                    index1 = stringScanner.nextInt();
                    if (stringScanner.hasNextInt()){
                        index2 = stringScanner.nextInt();
                        if (index1 < randString.length() && index2 < randString.length()
                            && index1 >= 0 && index2 >= 0){
                            badIndex = false;
                        }
                        else{
                            System.out.println("Indexes must exist in the string!");
                            badIndex = true;
                        }
                        if (stringScanner.hasNextInt()){
                            badIndex = true;
                            System.out.println("You have entered too many numbers, try again!");
                        }
                    }
                    else{
                        badIndex = true;
                        System.out.println("You need to enter two indexes!");
                    }
                }
                else{
                    badIndex = true;
                    System.out.println("You need to enter two indexes!");
                }
            }
            if (isLegal(randString, swap(randString, index1, index2))){
                randString = swap(randString, index1, index2);
                move++;
                System.out.println(randString + " is worth " + (score(randString)-move) + " points");
            }
            else{
                System.out.println("Move is illegal because score would be lowered to " + 
                (score(swap(randString, index1, index2))-move-1));
            }
        }
        System.out.println("Game Over! Your final score is " + (score(randString)-move) + " points");
    }
    
    public String generateRandomString(int length){
        String finalstring = "";
        for (int i = 0; i < length; i++){
            finalstring = finalstring + (char)((int)(Math.random()*26+65));
        }
        return finalstring;
    }
    
    public int promptForStringLength(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Welcome to String Craft \nEnter the length of the string you would like to craft");
        return keyboard.nextInt();
    }
    
    public boolean isLegal(String str1, String str2){
        int score1 = score(str1);
        int score2 = score(str2);
        return score2-1 >= score1;
    }
    
    public boolean canMove(String str){
        for (int i = 0; i < str.length(); i++){
            for (int j = 0; j < str.length(); j++){
                if (i != j && isLegal(str, swap(str, i, j))){
                    return true;
                }
            }
        }
        return false;
    }
    
    public int score(String str){
        int score = 0;
        int increment = 1;
        for (int i = 0; i < str.length(); i++){
            if(i==0){
                score = score + increment;
            }
            else if (str.charAt(i) == str.charAt(i-1)){
                increment += 2;
                score += increment;
            }
            else if (str.charAt(i) ==str.charAt(i-1)+1 || (str.charAt(i) == 'A' && str.charAt(i-1) == 'Z')){
                increment += 1;
                score += increment;
            }
            else{
                increment = 1;
                score += increment;
            }
        }
        return score;
    }
    
    public String swap(String str, int a, int b){
        if (a>b){
            int c = a;
            a = b;
            b = c;
        }
        if (a == b){
            return str;
        }
        else{
            String finalstring = str.substring(0,a) + str.charAt(b) + str.substring(a+1, b) + 
            str.charAt(a) + str.substring(b+1, str.length());
            return finalstring;
        }
    }
    
    public static void main(String[] args){
        P2_Zhu_Anthony_StringCraft fun = new P2_Zhu_Anthony_StringCraft();
        fun.playGame();
    }
}

