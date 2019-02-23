/* Anthony Zhu, 8/22/18, Period 2
 * 1 hour 
 * I think that his project went well for me overall. I was able to meet all of the requirements and my goal was to make
 * the program as complex as I could with the skills that I currently have. Doing this Lab, I learned to comment and space 
 * out my code so it was easier for me to both understand my code and to go back and fix things. Additionaly, I realized
 * the importance planning out the entire structure of your code before starting and keeping track of the attributes 
 * of my DrawingTool pen. I struggled with coming up with something more complex than I did because I did not know how to 
 * do that. For the next version of this lab, I want to learn how to make bricks and how to fill in my roof.
 */

import gpdraw.*; //importing DrawingTool and SketchPad
import java.awt.Color;





public class P2_Anthony_Zhu_HouseDriver {
    
    public static void main(String[] args) { 
    SketchPad paper = new SketchPad(500, 500); //making a paper object
    DrawingTool pen = new DrawingTool(paper); //making a pen object
    Color red = new Color(255, 0, 0); 
    Color green = new Color(0, 255, 0);
    Color blue = new Color(0, 0, 255);
    Color brown = new Color(222, 184, 135);
    Color yellow = new Color(255, 255, 0);
    Color ground = new Color(212, 183, 200);
    Color sky = new Color (173,216,230);
    Color glass = new Color (76, 248, 255);
  
    P2_Anthony_Zhu_Background coolbackground = new P2_Anthony_Zhu_Background(500, 500, ground, sky, pen);
    coolbackground.draw();
    
    //drawinghousebody
    P2_Anthony_Zhu_HouseBody coolhouse = new P2_Anthony_Zhu_HouseBody(0, 0, pen, brown, glass);
    coolhouse.setWidth(100);
    coolhouse.draw();
    
    //drawingflaggedroof
    P2_Anthony_Zhu_FlaggedRoof blueroof = new P2_Anthony_Zhu_FlaggedRoof(50, 67, pen, ground);
    blueroof.setWidth(100);
    blueroof.draw();
    
    //drawing first tree
    P2_Anthony_Zhu_Tree tree1 = new P2_Anthony_Zhu_Tree(-150, 0, pen, blue);
    tree1.setRadius(50);
    tree1.draw();
    
    //drawing second tree
    P2_Anthony_Zhu_Tree tree2 = new P2_Anthony_Zhu_Tree(100, 3, pen, green);
    tree2.setRadius(30);
    tree2.draw();
    //drawing third tree
    P2_Anthony_Zhu_Tree tree3 = new P2_Anthony_Zhu_Tree(200, 3, pen, red);
    tree3.setRadius(35);
    tree3.draw();
    
    //drawing the sun
    P2_Anthony_Zhu_Sun sun1 = new P2_Anthony_Zhu_Sun(200, 200, 50, pen);
    sun1.draw();
    
    
    
    
    
    
    }
}
