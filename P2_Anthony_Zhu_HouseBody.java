import gpdraw.*;
import java.awt.*;
/**
    This class describes a rectangluar house body with a window capable of changing its location, size(proportinoally), and colors.
    In order to create a tree, you must provide a location (x, y) that will determine where the center of the house body is located
    ,drawing tool, and color.

    The default values for the HouseBody are <BR>
        - width is 60 <BR>
    
    Example usage:
    
    <PRE>
    
    HouseBody coolhouse = new HouseBody(0, 0, pen, brown, glass);
    coolhouse.setWidth(100);
    coolhouse.draw();
    
    </PRE>
*/

public class P2_Anthony_Zhu_HouseBody {
    //declaring attributes
    /** x-position of House body */
    int xPos;
    /** y-position of House body */
    int yPos;
    /** Color of House body */
    Color color;
    /** DrawingTool used to draw House body*/
    DrawingTool pen;
    /** width of House body */
    int width = 60;
    /** Color of House body */
    Color colorofbody;
    /** Color of window on House body */
    Color colorofwindow;
    
    /** This constructor creates a House body at the position (x, y) that is passed in. In order to create a house body 
     * you must pass in the position, a DrawingTool and 2 colors, one for the house body and one for the window
     * @param x The x-position of the house body
     * @param y The y-position of the house body
     * @param tool The drawing tool used to draw the house body
     * @param color The color of the house body
     * @param color2 The color of the window on the house body
     */
    public P2_Anthony_Zhu_HouseBody(int x, int y, DrawingTool tool, Color color, Color color2) {
        //assigning inputs to variables
        xPos = x;
        yPos = y;
        pen = tool;
        colorofbody = color;
        colorofwindow = color2;
    }
    /** This method sets a new width for the house body and changes the size of the entire house body in proportion to the change of the width
     * This method will not change the width of any house body already drawn.
     * @param w The new width of the house body
     */
    public void setWidth(int w){
        width = w; //setting the width
    }
    /** This method draws the house body according to its attributes */
    public void draw(){
        //drawing the body
        pen.setWidth(2);
        pen.move(xPos, yPos);
        pen.down();
        pen.setColor(colorofbody);
        pen.fillRect(width,80*width/60);
        
        //drawing the window
        pen.setColor(colorofwindow);
        pen.fillRect(40*width/60,40*width/60);
        
        //drawing semioval part of window
        pen.setDirection(90);
        pen.forward(20*width/60);
        pen.fillOval(40*width/60,20*width/60);
    }
}