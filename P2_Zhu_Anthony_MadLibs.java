/* Anthony Zhu, 9/19/18, Period 2
 * 1 hour 
 * I think this lab went well for me overall because I had a firm grasp on how to use the scanning methods and printf. Because of this,
 * it was simple to get down the logic and basic structure for my program. The one issue I had was being careful with syntax, especially
 * for printf. I realized that a tiny mistake would throw the entire program off, and these mistakes are often very hard for me to catch.
 * I would work on this by practicing and testing myself until the syntax becomes second nature.
 */

import java.util.Scanner;


public class P2_Zhu_Anthony_MadLibs{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter your name: ");
        String name = input.next();
        System.out.print("Enter an amount of money in the format dollar.cent: ");
        double money = input.nextDouble();
        System.out.print("Enter a whole number: " );
        int num = input.nextInt();
        System.out.print("Enter a year: ");
        int year = input.nextInt();
        System.out.print("Enter a restaurant name: ");
        String restaurant = input.next();
        System.out.print("Enter a disease: " );
        String disease = input.next();
        System.out.print("Enter a number with lots of decimal places: ");
        Double dub = input.nextDouble();
        System.out.print("Enter a song name: ");
        String song = input.next();
        System.out.print("Enter a monster name:\n" );
        String monster = input.next();
        
        System.out.printf("Hello %s, there. I don't know if you'll read this in time but the year is %d There's not much time for me to say this because they are coming for me. \n", name, year ) ;
        System.out.printf("It all started when I stole about $%f from my parents to go out and eat with my friends. \n", money);
        System.out.printf("I'm actually very popular because I have %d friends who are obsessed with me. \n", num);
        System.out.printf("That's beyond the point though. We had just walked into the %s \n", restaurant);
        System.out.printf("But the whole place was empty. Everyone had been wiped out by an outbreak of %s \n", disease);
        System.out.printf("The door suddenly shut behind us and a %s came and chopped my friends into %.1f pieces \n", monster, dub);
        System.out.printf("I'm the only survivor but it's okay because I'm the most important and I'm hiding in the bathroom to tell you this. \n");
        System.out.printf("It's so strange to hear %s playing in the background - to hear its meaning distorted into something so much more sinister \n", song);
        System.out.printf("They're hear!! Shoot! help me %.3s -", name);
    }
}