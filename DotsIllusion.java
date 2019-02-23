import gpdraw.*;
import java.awt.Color;
public class DotsIllusion{
    //declare attributes
    int width;
    int height;
    int radius;
    DrawingTool pen;
    
    //constructor
    public DotsIllusion( int w ,int h, int r, DrawingTool pn){
        width = w;
        height = h;
        pen = pn;
        radius = r;
    }
    
    //helper methods
    public void drawVLine(int xPos){
        pen.setColor(Color.GRAY);
        pen.up();
        pen.move( xPos, 0);
        pen.down();
        pen.setWidth(10);
        pen.setDirection(90);
        pen.forward(height/2);
        pen.backward(height);
        pen.forward(height/2);
    }
    
    public void drawHLine(int yPos){
        pen.setColor(Color.GRAY);
        pen.up();
        pen.down();
        pen.move(0, yPos);
        pen.setWidth(10);
        pen.setDirection(180);
        pen.forward(width/2);
        pen.backward(width);
        pen.forward(width/2); 
    }
    
    public void rowOfCircles(int yPos){
        pen.setColor(Color.WHITE);
        pen.up();
        pen.move(0 , yPos);
        pen.down();
        pen.fillCircle(radius);
        pen.up();
        pen.move(width/4, yPos);
        pen.down();
        pen.fillCircle(radius);
        pen.up();
        pen.move(width/2 , yPos);
        pen.down();
        pen.fillCircle(radius);
        pen.up();
        pen.move(width/-2 , yPos);
        pen.down();
        pen.fillCircle(radius);
        pen.up();
        pen.move(width/-4 , yPos);
        pen.down();
        pen.fillCircle(radius);
        pen.up();
        pen.move(width/-8 , yPos);
        pen.down();
        pen.fillCircle(radius);
        pen.up();
        pen.move(width/8 , yPos);
        pen.down();
        pen.fillCircle(radius);
        pen.up();
        pen.move(3*width/-4 , yPos);
        pen.down();
        pen.fillCircle(radius);
        pen.up();
        pen.move(3*width/4 , yPos);
        pen.down();
        pen.fillCircle(radius);
        pen.up();
    
    
    }
    
    public void draw(){
        pen.setColor(Color.BLACK);
        pen.fillRect(width, height);
        drawVLine(0);
        drawVLine(width/4);
        drawVLine(width/2);
        drawVLine(width/-2);
        drawVLine(width/-4);
        drawVLine(width/8);
        drawVLine(3*width/4);
        drawVLine(width/-8);
        drawVLine(3*width/-4);
        drawHLine(0);
        drawHLine(height/4);
        drawHLine(height/2);
        drawHLine(height/-2);
        drawHLine(height/-4);
        drawHLine(height/8);
        drawHLine(3*height/4);
        drawHLine(height/-8);
        drawHLine(3*height/-4);
        rowOfCircles(height/4);
        rowOfCircles(height/2);
        rowOfCircles(0);
        rowOfCircles(height/-4);
        rowOfCircles(height/-2);
        rowOfCircles(height/8);
        rowOfCircles(3*height/4);
        rowOfCircles(height/-8);
        rowOfCircles(3*height/-4);
        
    }
    
    
}