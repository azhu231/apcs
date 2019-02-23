import gpdraw.*;
import java.awt.*;
/**
    This class describes a background that fills up the entire drawing space. You must supply the dimensions of the drawing space 
    along with a drawing tool, the color of the lower half of the background, and the color of the upper half of the background
   
    Example usage:
    <PRE>

    Background coolbackground = new Background(500, 500, ground, sky, pen);
    coolbackground.draw();
    
    </PRE>
*/
public class P2_Anthony_Zhu_Background {
    //declaring attributes
    /** The width of the drawing pad */
    int widthOfDrawingPad;
    /** The height of the drawing pad */
    int heightOfDrawingPad;
    /** The color of the lower half of the background */
    Color lowerhalf;
    /** The color of the upper half of the background */
    Color upperhalf;
    /** The drawing tool used to draw the background */
    DrawingTool pen;
    
    /** This constructor creates a background that fills up the entire drawing pad space. You must pass in
     * the height/width of the drawing pad, 2 colors, and a DrawingTool.
     * @param width The width of the drawing pad
     * @param height The height of the drawing pad
     * @param frontColor The color of the lower half of the background
     * @param backColor The color of the upper half of the background
     * @param penname The Drawing Tool used to draw the background
     */
    public P2_Anthony_Zhu_Background(int width, int height, Color frontColor, Color backColor, DrawingTool penname) {
        widthOfDrawingPad = width;
        heightOfDrawingPad = height;
        lowerhalf = frontColor;
        upperhalf = backColor;
        pen = penname;
    }
    /** This method draws the background with the properties specified by each attribute */
    public void draw(){
        pen.move(0 , 0);
        pen.down();
        pen.move(0, -(heightOfDrawingPad/4));
        pen.setColor(lowerhalf);
        pen.fillRect(widthOfDrawingPad, heightOfDrawingPad/2);
        pen.up();
        pen.move(0, heightOfDrawingPad/4);
        pen.down();
        pen.setColor(upperhalf);
        pen.fillRect(widthOfDrawingPad, heightOfDrawingPad/2);
        
    }
}