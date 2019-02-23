import gpdraw.*;
import java.awt.Color;
/**
    This class describes a tree with lemons capable of changing its location, size(proportinoally), and leaf colors.
    In order to create a tree, you must provide a location (x, y) that will determine where the center of the circular
    part of the tree is located, drawing tool, and color.

    The default values for a tree are <BR>
        - radius of tree is 30 <BR>
        - Tree trunk is brown <BR>
        - Lemons are yellow <BR>

    Example usage:
    <PRE>
    
    Tree tree1 = new Tree(-150, 0, pen, blue);
    tree1.setRadius(50);
    tree1.draw();
    
    </PRE>
*/
public class P2_Anthony_Zhu_Tree{
  
   //declaring attributes
   /** X-Position of the center of the circular part of the tree */
   int xPos;
   /** Y-Position of the center of the circular part of the tree */
   int yPos;
   /** Color of the circular part of the tree */
   Color color;
   /** DrawingTool used to draw the tree */
   DrawingTool pen;
   /** Radius of the circular part of the tree */
   int treeradius = 30; //default length of tree raidus
   /** Default color of tree trunk */
   Color treetrunk = new Color(222, 184, 135);
   /** Default color of lemons */
   Color fruit = new Color(255, 255, 0);
   
   /** This constructor creates a Tree with the center of its circular part located at (x, y) using the Drawing Tool and Color Passed in.
    * The default value for a Tree is a radius of 30.
    * @param x The x-value of the center of the circular part of the tree.
    * @param y The y-value of the center of the circular part of the tree.
    * @param penname The DrawingTool used to draw the tree
    * @param coloroftree The color of the circular part/leaves of the tree
    */
   public P2_Anthony_Zhu_Tree(int x,int y, DrawingTool penname, Color coloroftree){
      // assinging inputs to variables
      xPos = x;
      yPos = y;
      color = coloroftree;
      pen = penname;
      
      
   }
   
   /** This method sets the radius of the Tree and the rest of the tree proportionally to the radius. This method will
    * not change the radius of any Tree already drawn.
    * @param r The new radius of the Tree.
    */
   public void setRadius(int r) {
    
      treeradius = r;
      
       
    }

 
   /** This method draws the tree with the properties specified by each attribute */
    public void draw() {
   
    
        //drawing the tree
        pen.setColor(color);
        pen.up();
        pen.move(xPos , yPos);
        pen.setDirection(180);
        pen.down();
        pen.fillCircle(treeradius);
        
        //drawing the trunk
        pen.setColor(treetrunk);
        pen.setWidth(treeradius/6);
        pen.up();
        pen.turnLeft(90);
        pen.forward(treeradius);
        pen.down();
        pen.forward(50*treeradius/30);
        
        //drawing the fruit
        pen.turnLeft(180);
        pen.forward(50*treeradius/30);
        pen.up();
        pen.setColor(fruit);
        pen.forward(10*treeradius/30);
        pen.down();
        pen.fillOval(5*treeradius/30, 10*treeradius/30);
        pen.up();
        pen.forward(34*treeradius/30);
        pen.down();
        pen.fillOval(5*treeradius/30, 10*treeradius/30);
        pen.up();
        pen.turnRight(90);
        pen.forward(10*treeradius/30);
        pen.turnRight(90);
        pen.forward(16*treeradius/30);
        pen.down();
        pen.fillOval(5*treeradius/30, 10*treeradius/30);
        pen.up();
        pen.turnRight(80);
        pen.forward(20*treeradius/30);
        pen.turnRight(90);
        pen.forward(26*treeradius/30);
        pen.down();
        pen.fillOval(5*treeradius/30, 10*treeradius/30);
   }
}


    