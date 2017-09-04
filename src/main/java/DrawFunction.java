import javax.swing.*;
import java.awt.*;

public class DrawFunction extends JFrame {
    static double timesx = 10, timesy = 10;
    double F(double x){
        return Math.sin(x) / Math.pow(1.1, -x); //函数表达式；
    }
    int x0, y0;
    static int W = 1024, H = 768;
    static double L = -W / 2, R = W / 2;
    Graphics G;

    public void setOrigin(int x, int y){
        this.x0 = x;
        this.y0 = y;
        //show coordinate axis

    }
}
