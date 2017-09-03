import javax.swing.*;

public class DrawFunction extends JFrame {
    static double timesx = 10, timesy = 10;
    double F(double x){
        return Math.sin(x) / Math.pow(1.1, -x); //函数表达式；
    }
    int x0, y0;
}
