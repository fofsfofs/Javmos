package javmos.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javmos.JavmosGUI;
import javmos.components.JavmosPanel;

public class DrawListener implements ActionListener {

    private final JavmosGUI gui;
    private final JavmosPanel panel;

    public DrawListener(JavmosGUI gui, JavmosPanel panel) {
        this.gui = gui;
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        //panel.setFunction(panel.getFunction());
        gui.setFirstDerivativeLabel(panel.getFunction().getFirstDerivative());
        gui.setSecondDerivativeLabel(panel.getFunction().getSecondDerivative());
        panel.repaint();
    }
}
