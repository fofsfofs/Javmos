package javmos.components;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.LinkedList;
import javax.swing.JPanel;
import javmos.JavmosGUI;
import javmos.components.functions.Cosine;
import javmos.components.functions.Function;
import javmos.components.functions.Logarithmic;
import javmos.components.functions.Polynomial;
import javmos.components.functions.Sine;
import javmos.components.functions.Tangent;
import javmos.listeners.PointClickListener;

public class JavmosPanel extends JPanel {

    private final JavmosGUI gui;
    private final LinkedList<JavmosComponent> components;

    public JavmosPanel(JavmosGUI gui) {
        this.gui = gui;
        this.components = new LinkedList<>();
    }

    public Function getFunction() {
        String type = gui.getEquationField();
        // Takes the equation and checks for specific terms that determine what type of function it is
        if (type.contains("log") || type.contains("ln")) {
            return new Logarithmic(gui, gui.getEquationField());
        } else if (type.contains("tan")) {
            return new Tangent(gui, gui.getEquationField());
        } else if (type.contains("sin")) {
            return new Sine(gui, gui.getEquationField());
        } else if (type.contains("cos")) {
            return new Cosine(gui, gui.getEquationField());
        } else {
            return new Polynomial(gui, gui.getEquationField());
        }

    }

    public void setPlane(CartesianPlane plane) {
        components.add(plane);
    }

    public void setFunction(Function function) {
        components.add(function);//Adds the function to the list of components to be drawn
        LinkedList<Point> points = new LinkedList<>();
        points.addAll(function.getXIntercepts());//Adds the points to a seperate linked list for the mouse listener to be added
        points.addAll(function.getCriticalPoints());
        points.addAll(function.getInflectionPoints());
        components.addAll(getFunction().getXIntercepts());//Adds the points to the list of components to be drawn
        components.addAll(getFunction().getCriticalPoints());
        components.addAll(getFunction().getInflectionPoints());
        PointClickListener clickListener = new PointClickListener(gui);
        clickListener.setPoints(points);
        this.addMouseListener(clickListener); //Adds a listener to each point so that they can be clicked
    }

    @Override
    public void paintComponent(Graphics graphics) {
        CartesianPlane plane = new CartesianPlane(gui);
        setPlane(plane);//Sets the plane on the panel

        if (!gui.getEquationField().contains("ENTER")) {//Only sets the function once the equation field no longer contains the default phrase
            setFunction(getFunction());
        }

        for (int i = 0; i < components.size(); i++) {
            components.get(i).draw((Graphics2D) graphics); //Draws all the components that are in the list
        }
    }
}
