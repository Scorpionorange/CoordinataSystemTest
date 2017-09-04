import javax.swing.*;
import java.awt.Graphics;

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
        drawLine(-W / 2, 0, W / 2, 0);
        drawLine(0, -H / 2, 0, H / 2);
        drawString("X", W / 2 - 30, -20);
        drawString("Y", -20, H / 2 - 20);
        //draw a arrow at the end of axis
        for(int i = 1; i <= 10; i++){
            draw(W / 2 - i - 6, i);
            draw(W / 2 - i - 6, -i);
        }
        for(int i = 1; i <= 10; i++){
            draw(-i, H / 2 - i);
            draw(i, H / 2 - i);
        }
    }

    public DrawFunction(){
        add(new NewPanel());
    }
}
