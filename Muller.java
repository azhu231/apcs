import gpdraw.*;
import java.awt.Color;

public class Muller{
    //declaring attributes
    int horizontalLength;
    int verticalDistance;
    Color color;
    DrawingTool pen;
    //constructor 
    public Muller(int hl, int vd, DrawingTool pn){
        horizontalLength = hl;
        verticalDistance = vd;
        pen = pn;
    }
    
    public void drawarrow(int angle, int x, int y){
        pen.up();
        pen.move(x , y);
        pen.down();
        pen.setDirection(angle);
        pen.forward(10);
        pen.backward(10);
        pen.setDirection(-angle);
        pen.forward(10);
        pen.backward(10);
    }
    
    public void drawline(int y){
        pen.up();
        pen.move(0 , y);
        pen.setDirection(180);
        pen.down();
        pen.forward(horizontalLength/2);
        pen.backward(horizontalLength);
        pen.forward(horizontalLength/2);
    }
    
    public void draw(){
        drawline(verticalDistance/2);
        drawline(-(verticalDistance/2));
        drawarrow(45 , horizontalLength/2 , -(verticalDistance/2));
        drawarrow(45 , -(horizontalLength/2) , verticalDistance/2);
        drawarrow(135 , horizontalLength/2 , verticalDistance/2);
        drawarrow(135 , -(horizontalLength/2) , -(verticalDistance/2));
    }
}