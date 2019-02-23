/**Anthony Zhu, 10/2/18, Period 2
 * 1 hour
 * This lab was very enjoyable for me to complete. It took me a while to figure out how to make the T-fractal although at first it seemed really simple
 * I realized that I had to be very careful about the logic of things and make sure I was drawing at the lengths and angles I wanted to. Afterwards,
 * I felt like just having the black fractal was way too simple so I added some color with math.random. Overall, I think that I used a good amount
 * of effort and creativity in completing this lab. 
 */

import gpdraw.*;
import java.awt.Color;
public class P2_Zhu_Anthony_MyFractal{
    //attributes
    SketchPad pad;
    DrawingTool pen;
    
    //constructor
    public P2_Zhu_Anthony_MyFractal() {
        pad = new SketchPad(1000, 1000);
        pen = new DrawingTool(pad);
    }
    
    public void drawFractal(int level, double length){
        //base case
        if (level==0){
            Color color = new Color((int)(255*Math.random()), (int)(255*Math.random()), (int)(255*Math.random()));
            pen.setColor(color);
            pen.setColor(color);
            pen.fillRect(length, length);
            
        }
        //Recursive case draw a square centered at every vertex 
        else{
            Color color = new Color((int)(255*Math.random()), (int)(255*Math.random()), (int)(255*Math.random()));
            pen.setColor(color);
            double x = pen.getXPos();
            double y = pen.getYPos();
            double dir = pen.getDirection();
            //move to upper right vertex
            pen.forward(length/2);
            pen.turnLeft(90);
            pen.forward(length/2);
            
            //draw fractal
            dir = pen.getDirection();
            drawFractal(level-1, length/2);
            pen.setDirection(dir);
            
            //move to lower right vertex
            pen.turnLeft(90);
            pen.forward(length);
            
            //draw fractal
            dir = pen.getDirection();
            drawFractal(level-1, length/2);
            pen.setDirection(dir);
            //move to lower left vertex
            pen.turnLeft(90);
            pen.forward(length);
            
            //draw fractal
            dir = pen.getDirection();
            drawFractal(level-1, length/2);
            pen.setDirection(dir);
            
            //move to upper right vertex
            pen.turnLeft(90);
            pen.forward(length);
            
            //draw fractal
            dir = pen.getDirection();
            drawFractal(level-1, length/2);
            pen.setDirection(dir);
            //draw final square
            pen.setDirection(dir);
            pen.move(x , y);
            pen.fillRect(length, length);
        }
        

        
    }
    public static void main(String [] args){
        P2_Zhu_Anthony_MyFractal fractal = new P2_Zhu_Anthony_MyFractal();
        fractal.drawFractal(7, 300);
    
    }
}
