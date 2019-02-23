import gpdraw.*;
import java.awt.Color;
/**
    This class describes a triangular roof with a flag capable of changing its location, size(proportinoally), and colors.
    In order to create a Flagged Roof, you must supply a location (x, y) that will determine where the bottom right corner
    of the roof is located, a color, and a drawing tool.

    The default values for a window are <BR>
        - width is 60 <BR>
       

    Example usage:
    <PRE>

        FlaggedRoof blueroof = new FlaggedRoof(50, 67, pen, ground);
        blueroof.setWidth(100);
        blueroof.draw();
    
    </PRE>
*/
public class P2_Anthony_Zhu_FlaggedRoof {
    //declaring attributes
    /** X position of the right corner of the roof */
    int xPos;
    /** Y position of the right corner of the roof */
    int yPos;
    /** Color of the roof and flag */
    Color color;
    /** DrawingTool used to draw the roof and flag */
    DrawingTool pen;
    /** The width of the roof */
    int width = 60;
    
    
    /**
		This constructor creates a Flagged Roof with its right corner located at (x, y) using the DrawingTool and color passed in.
		The default value for a new Flagged Roof created by this constructor are:

		- width is 80

		@param x The new x-coordinate of the roof's right corner
		@param y The new y-coordinate of the roof's right corner
		@param penName The DrawingTool used to draw this window
		@param colorOfRoof The color of the object created
	*/
    public P2_Anthony_Zhu_FlaggedRoof(int x, int y, DrawingTool penName, Color colorOfRoof){
        //assinging inputs to variables
        xPos = x;
        yPos = y;
        pen = penName;
        color = colorOfRoof;
    
    }
    
    /** This method sets width and the rest of the roof's size proportionally to the width. This method
     * will not change the width of any windows that have already been drawn.<BR>
       @param w The new width of the Flagged Roof.*/
    public void setWidth(int w){
        width = w;
    }
    /** This method draws the Flagged Roof with the properties specified by each attribute */
    public void draw(){
    
    //drawing the triangle roof
    pen.setWidth(5);
    pen.setColor(color);
    pen.up();
    pen.move(xPos, yPos);
    pen.down();
    pen.setDirection(120);
    pen.forward(width);
    pen.setDirection(240);
    pen.forward(width);
    
    //drawing the flag
    pen.turnLeft(180);
    pen.forward(20*width/60);
    pen.turnLeft(30);
    pen.forward(40*width/60);
    pen.turnLeft(90);
    pen.forward(15*width/60);
    pen.fillRect(30*width/60 ,20*width/60);
    }
        
}