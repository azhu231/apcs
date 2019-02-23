import gpdraw.*;
import java.awt.*;

public class Sphere {
    //Attributes
    int radius;
    Color color;
    int xPos;
    int yPos;
    int zPos;
    DrawingTool pen;
    
    //Constructors
    //default constructor
    public Sphere(){
        xPos = 0;
        yPos = 0;
        zPos = 0;
        radius = 20;
        color = Color.BLACK;
        DrawingTool pen = new DrawingTool();
    }
    public Sphere(int x, int y, int z, Color colorname, DrawingTool penname){
        xPos = x;
        yPos = y;
        zPos = z;
        radius = 70;
        color = colorname;
        pen = penname;
    }
    //methods
    /*Getter and Setter methods */
    public int getXPosition(){
        return(xPos);   
    }
    public int getYPosition(){
        return(yPos);
    }
    public int getZPosition(){
        return(zPos);
    }
    public int getRadius(){
        return(radius);
    }
    public Color getColor(){
        return(color);
    }
    public void setPosition(int x, int y, int z){
        xPos = x;
        yPos = y;
        zPos = z;
    }
    public void setDrawingTool(DrawingTool penname){
        pen = penname;
    }
    public void setRadius(int r){
        radius = r;
    }
    public void setColor(Color c){
        color = c;
    }
    
    /* Other methods */
    public void draw(){
    double visualXPos = (xPos)-2.8284*(zPos);
    double visualYPos = (yPos)-2.8284*(zPos);
    pen.up();
    pen.move(visualXPos, visualYPos);
    pen.setColor(color);
    pen.down();
    pen.drawCircle(radius);
    pen.setDirection(90);
    pen.forward(radius);
    pen.backward(2*radius);
    pen.forward(radius);
    pen.drawOval(radius*13/7 , 2*radius);
    pen.drawOval(radius*12/7 , 2*radius);
    pen.drawOval(radius*11/7 , 2*radius);
    pen.drawOval(radius*10/7 , 2*radius);
    pen.drawOval(radius*9/7 , 2*radius);
    pen.drawOval(radius*8/7 , 2*radius);
    pen.drawOval(radius*7/7 , 2*radius);
    pen.drawOval(radius*6/7 , 2*radius);
    pen.drawOval(radius*5/7 , 2*radius);
    pen.drawOval(radius*4/7 , 2*radius);
    pen.drawOval(radius*3/7 , 2*radius);
    pen.drawOval(radius*2/7 , 2*radius);
    pen.drawOval(radius*1/7 , 2*radius);
    
    }
    public double calculateVolume(){
        double rcubed = radius^3;
        double v = 4.0/3.0*3.1415*(rcubed);
        return(v);
    }
    public double calculateSurfaceArea(){
        double sa = (radius^2)*4*3.1415;
        return(sa);
    }
    public double maxAreaOfCrossSection(){
        double cs = (radius^2)*3.1415;
        return(cs);
    }
    
    
}
