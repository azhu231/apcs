import gpdraw.*;
import java.awt.*;
/** This class describes a circular sun with eyeballs, capable of having different radiuses and positions. <BR>
 * Defaults include: <BR>
 * -The yellow color of the Sun <BR>
 * -The black and white colors of the eyes <BR>
 * 
 * Example usage: <PRE>
 * Sun sun1 = new Sun(200, 200, 50, pen);
 * sun1.draw();
    
 * </PRE>
 */
    
public class P2_Anthony_Zhu_Sun{
    //declaring Colors
    /** The white color of the eyeballs */
    Color white = new Color(255,255,255);
    /** The black color of the eyeballs */
    Color black = new Color(0,0,0);
    /** The yellow color of the eyeballs */
    Color yellow = new Color(218,165,32);
    //declaring attributes
    /** The X position of the center of the sun */
    int xPos;
    /** The Y position of the center of the sun */
    int yPos;
    /** The radius of the sun */
    int radiusOfSun;
    DrawingTool pen;
    /** This constructor creates a sun with center located at (x, y) and specified radius and drawing tool. You must 
     * pass all of these in in order to construct a Sun.
     * @param x The new X coordinate of the center of the sun 
     * @param y The new Y coordinate of the center of the sun
     * @param radius The new radius of the sun.
     * @param penName The new DrawingTool used to draw the sun.
     */
    public P2_Anthony_Zhu_Sun(int x, int y, int radius, DrawingTool penName){
        xPos = x;
        yPos = y;
        radiusOfSun = radius;
        pen = penName;
    }
    /** This method draws the sun according to its specified attributes  and default colors.*/
    public void draw(){
        pen.up();
        pen.move(xPos, yPos);
        pen.down();
        pen.setColor(yellow);
        pen.fillCircle(radiusOfSun);
        pen.setDirection(180);
        pen.up();
        pen.forward(radiusOfSun/2);
        pen.down();
        pen.setColor(white);
        pen.fillCircle(radiusOfSun/7);
        pen.setColor(black);
        pen.fillCircle(radiusOfSun/10);
        pen.up();
        pen.backward(radiusOfSun);
        pen.down();
        pen.setColor(white);
        pen.fillCircle(radiusOfSun/7);
        pen.setColor(black);
        pen.fillCircle(radiusOfSun/10);
        
    }
        
}
