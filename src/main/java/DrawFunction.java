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

    public class Coordinate2D{
        int x, y;
        public Coordinate2D(int x, int y){
            this.x = x;
            this.y = y;
        }

        public int getPixelPointX(){
            return x0 + x;
        }
        public int getPixelPointY(){
            return y0 - y;
        }
    }

    class NewPanel extends JPanel{
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            G = g;
            setOrigin(W / 2, H / 2);
            // in the following, draw what you want draw!
            for(int i = -W / 2; i <= W / 2; i++){
                draw(i, work(i));
            }
        }
    }
    int work(int x){
        return (int)(F(x / timesx) * timesy);
    }

    public void draw(int x, int y){
        int X = new Coordinate2D(x, y).getPixelPointX();
        int Y = new Coordinate2D(x, y).getPixelPointY();
        G.drawLine(X, Y, X, Y);
    }

    public void drawRec(int x1, int y1, int x2, int y2){
        int dx = x1 < x2 ? 1 : -1;
        int dy = y1 < y2 ? 1 : -1;
        for(int i = x1; i != x2 + dx; i += dx){
            for(int j = y1; j != y2 + dy; j += dy){
                draw(i, j);
            }
        }
    }

    public void drawLine(int x1, int y1, int x2, int y2){
        int dx = x1 < x2 ? 1 : -1;
        if(x1 == x2) {
            drawRec(x1, y1, x2, y2);
        }
        else {
           double d = (double)(y2 - y1) / (x2 - x1);
           for(int i = x1; i != x2 + dx; i += dx){
               draw(i, (int)(y1 + (i - x1) * d));
           }
        }
    }

    public void drawString(String s, int x, int y){
        int X = new Coordinate2D(x, y).getPixelPointX();
        int Y = new Coordinate2D(x, y).getPixelPointY();
        G.drawString(s, X, Y);
    }

    public static void main(String[] args){
        DrawFunction frame = new DrawFunction();
        frame.setTitle("DrawFunction");
        frame.setSize(W, H);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
    }
}
