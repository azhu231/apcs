import gpdraw.*;
public class KochDriver{
    public static void main(String[] args){
        DrawingTool pen = new DrawingTool();
        P2_Zhu_Anthony_KochCurve kc = new P2_Zhu_Anthony_KochCurve(pen);
        kc.drawKochAntiSnowflake(3, 60);
    }
}