package javmos;

import java.awt.BasicStroke;
import java.awt.Color;

public class CartesianPlane extends java.lang.Object {

    public final JavmosGUI gui;

    public CartesianPlane(JavmosGUI gui) {
        this.gui = gui;
    }

    public void drawPlane(java.awt.Graphics2D graphics2D) {
        int test = (int) gui.getZoom();
        graphics2D.clearRect(0, 0, 800, 800);
        
        for (int i = 0; i < 800 / test; i++) {
            graphics2D.drawLine(400 - test * i, 0,400 - test * i, 800); //(x1, y1, x2, y2) draws thin vertical line every 50px
            graphics2D.drawLine(0,400 - test * i, 800,400 - test * i);
        } // Draws all the horizontal lines in Q1 and Q2 and all vertical lines in Q2 and Q3
        
        for (int i = 0; i < 800 / test; i++) {
            graphics2D.drawLine(400 + test * i, 0,400 + test * i, 800); //(x1, y1, x2, y2) draws thin vertical line every 50px
            graphics2D.drawLine(0,400 + test * i, 800,400 + test * i);
        } // Draws all the horizontal lines in Q3 and Q4 and all vertical lines in Q1 and Q4
        
        graphics2D.setStroke(new BasicStroke(3));
        graphics2D.drawLine(400, 0, 400, 800); //y-axis
        graphics2D.drawLine(0, 400, 800, 400); //x-axis

        for (int i = 0; i < 800 / test; i++) {
            graphics2D.drawLine(400 - test * i, 395,400 - test * i, 405); //(x1, y1, x2, y2) draws thin vertical line every 50px
            graphics2D.drawLine(395,400 - test * i, 405,400 - test * i);
            graphics2D.drawString(Integer.toString(-i), 405 - test * i, 399); // Draws horizontal axis numbers
            graphics2D.drawString(Integer.toString(i), 405, 399 - test * i); // Draws horizontal axis numbers
        }
        
        for (int i = 0; i < 800 / test; i++) {
            graphics2D.drawLine(400 + test * i, 395,400 + test * i, 405); //(x1, y1, x2, y2) draws thin vertical line every 50px
            graphics2D.drawLine(395,400 + test * i, 405,400 + test * i);
            graphics2D.drawString(Integer.toString(i), 405 + test * i, 399); // Draws horizontal axis numbers
            graphics2D.drawString(Integer.toString(-i), 405, 399 + test * i); // Draws horizontal axis numbers
        }

    }
}
