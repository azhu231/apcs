/**Anthony Zhu, 9/29/18, Period2
 * 1 hour
 * This lab overall was pretty easy for me. Because we did all of the practice with recursion using worksheets that were pretty challenging
 * for me, I had a pretty firm grasp on the basics of recursion. Because of this, I was able to complete the recursion component
 * of this lab pretty quickly and making the snowflake just used the skills I developed practicing with gpdraw/geometry. The anti-snowflaek
 * was also very easy. I created it by changing some of the angles in the snowflake method. I think that without the structure given to me
 * in the lab instructions, this lab would have been slightly more challenging so I will have to work more on coming up with the recursion structure
 * knowing what I want the outcome to be. 
 */

import gpdraw.*;

public class P2_Zhu_Anthony_KochCurve{
    DrawingTool pen;
    //Constructor
    public P2_Zhu_Anthony_KochCurve(DrawingTool p){
        pen = p;
    }
    public void drawKochCurve(int level, int length){
        if (level < 1){
            pen.forward(length);
        }
        else{
            drawKochCurve(length/3, level-1);
            pen.turnLeft(60);
            drawKochCurve(length/3, level-1);
            pen.turnRight(120);
            drawKochCurve(length/3, level-1);
            pen.turnLeft(60);
            drawKochCurve(length/3, level-1);
        }
    }
    public void drawKochSnowflake(int level, int length){
        drawKochCurve(level,length);
        pen.turnLeft(240);
        drawKochCurve(level, length);
        pen.turnRight(120);
        drawKochCurve(level, length);
    }
    public void drawKochAntiSnowflake(int level, int length){
        drawKochCurve(level,length);
        pen.turnRight(240);
        drawKochCurve(level, length);
        pen.turnLeft(120);
        drawKochCurve(level, length);
    }
    }