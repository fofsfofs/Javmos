package javmos;

import java.awt.BasicStroke;
import java.awt.Font;
import java.text.DecimalFormat;

public class CartesianPlane extends java.lang.Object {

    public final JavmosGUI gui;

    public CartesianPlane(JavmosGUI gui) {
        this.gui = gui;
    }

    public void drawPlane(java.awt.Graphics2D graphics2D) {
        int pixel = (int) gui.getZoom();
        double d = gui.getDomainStep();
        double r = gui.getRangeStep();
        DecimalFormat thousandth = new DecimalFormat("#.###");
        graphics2D.clearRect(0, 0, 800, 800);
        graphics2D.setFont(new Font("TimesRoman", Font.BOLD, 14)); //Sets font size and font type

        for (int i = 0; i < 800 / pixel; i++) {
            graphics2D.setStroke(new BasicStroke(1)); //Sets thin line stroke
            graphics2D.drawLine(400 - pixel * i, 0, 400 - pixel * i, 800); //(x1, y1, x2, y2) draws thin vertical lines 
            graphics2D.drawLine(0, 400 - pixel * i, 800, 400 - pixel * i);//(x1, y1, x2, y2) draws thin horizontal line 
            graphics2D.drawLine(400 + pixel * i, 0, 400 + pixel * i, 800); //(x1, y1, x2, y2) draws thin vertical line 
            graphics2D.drawLine(0, 400 + pixel * i, 800, 400 + pixel * i);//(x1, y1, x2, y2) draws thin horizontal line 
            graphics2D.setStroke(new BasicStroke(3));//Sets thick line stroke
            graphics2D.drawLine(400, 0, 400, 800); //y-axis
            graphics2D.drawLine(0, 400, 800, 400); //x-axis
            graphics2D.drawLine(400 - pixel * i, 395, 400 - pixel * i, 405); //Draws axis tick marks
            graphics2D.drawLine(395, 400 - pixel * i, 405, 400 - pixel * i);//Draws axis tick marks
            graphics2D.drawLine(400 + pixel * i, 395, 400 + pixel * i, 405); //Draws axis tick marks
            graphics2D.drawLine(395, 400 + pixel * i, 405, 400 + pixel * i);//Draws axis tick marks
            if (gui.getZoom() != 10) {
                //Draws horizontal axis numbers
                if ((gui.getDomainStep() % 1) == 0) {
                    graphics2D.drawString(String.valueOf((int) (-i * d)), 405 - pixel * i, 399);
                    graphics2D.drawString(String.valueOf((int) (i * d)), 405 + pixel * i, 399);
                } else {
                    graphics2D.drawString(String.valueOf(thousandth.format(-i * d)), 405 - pixel * i, 399);
                    graphics2D.drawString(String.valueOf(thousandth.format(i * d)), 405 + pixel * i, 399);
                }

                // Draws vertical axis numbers
                if ((gui.getRangeStep() % 1) == 0) {
                    graphics2D.drawString(String.valueOf((int) (-i * r)), 405, 399 + pixel * i);
                    graphics2D.drawString(String.valueOf((int) (i * r)), 405, 399 - pixel * i);
                } else {
                    graphics2D.drawString(String.valueOf(thousandth.format(-i * r)), 405, 399 + pixel * i);
                    graphics2D.drawString(String.valueOf(thousandth.format(i * r)), 405, 399 - pixel * i);
                }
            } else { // Spaces out the axis numbers at 10x so that it's readable
                graphics2D.drawString(Double.toString(-2 * i * d), 405 - pixel * 2 * i, 399); // Draws negative horizontal axis numbers
                graphics2D.drawString(Double.toString(2 * i * r), 405, 399 - pixel * 2 * i); // Draws positive vertical axis numbers
                graphics2D.drawString(Double.toString(2 * i * d), 405 + pixel * 2 * i, 399); // Draws positive horizontal axis numbers
                graphics2D.drawString(Double.toString(-2 * i * r), 405, 399 + pixel * 2 * i); // Draws negative vertical axis numbers
            }
        } 
    }
}
