/* Anthony Zhu
 * September 3rd 2018
 * Period 2 Ferrante
 * Time: 90 minutes 
 * This lab was generally easy to complete because I am familiar with how to create objects out of classes and using
 * the draw method to place it on the drawing pad. One challenge I had was figuring out exactly how each class worked
 * and at times, it took me a few tries to see how exactly each class worked. For example, the door class I used 
 * did not have the pen.up() method before it moved to the location of the door so it left a huge line in my picture.
 * I had to manually do pen.up() to remove the line. By fidgeting with the code and playing with the parameters, I was 
 * able to work out each class I used. 
 */

import p2_house_parts.*;
import gpdraw.*;
import java.awt.*;

public class P2_Zhu_Anthony_CoolHouse {

    public static void main(String[] args) {
    SketchPad paper = new SketchPad(800, 800, 0);
    DrawingTool pen = new DrawingTool(paper);
    Color yellow = new Color(255, 255, 0);
    Color orange = new Color(255, 200, 0);
    Color ground = new Color(212, 183, 200);
    Color sky = new Color (173,216,230);
    
    P2_Anthony_Zhu_Background coolback = new P2_Anthony_Zhu_Background(800 , 800, ground, sky, pen);
    coolback.draw();
    
    P2_Christine_Kim_Clouds cloud = new P2_Christine_Kim_Clouds(pen);
    cloud.drawClouds(-200, 200);
    cloud.drawClouds(0,300);
 
    P2_Preetha_Kumar_Tree tree = new P2_Preetha_Kumar_Tree(pen, -300, -50, 10, 40);
    tree.draw();
    
    P2_Preetha_Kumar_Tree tree1 = new P2_Preetha_Kumar_Tree(pen, -350, -42, 10, 40);
    tree1.draw();
    
    P2_Preetha_Kumar_Tree tree2 = new P2_Preetha_Kumar_Tree(pen, 352, -53, 10, 40);
    tree2.draw();
    
    P2_Preetha_Kumar_Tree tree3 = new P2_Preetha_Kumar_Tree(pen, 321, -20, 10, 40);
    tree3.draw();
    
    P2_Emily_Han_Sun sun = new P2_Emily_Han_Sun(300,250,60,pen);
    sun.setColors(yellow, orange);
    sun.setDimensions(10, 30);
    sun.draw();
    
    P2_Vanitha_Vemula_House house = new P2_Vanitha_Vemula_House(0, -100, pen);
    house.setHouseColor(Color.BLUE);
    house.setRoofColor(Color.GRAY);
    house.setDimensions(400,270);
    house.draw();
    
    P2_Bill_Xiang_Door door = new P2_Bill_Xiang_Door(0, -200, 40, 70, pen);
    pen.up();
    door.draw();
    
    P2_Aashna_Shah_SquareWindow window = new P2_Aashna_Shah_SquareWindow(-100, -100, 50, 50, pen);
    window.draw();
    
    
    }
        

}
