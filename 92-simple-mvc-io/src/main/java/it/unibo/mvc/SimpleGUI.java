package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * A very simple program using a graphical interface.
 */
public final class SimpleGUI {
    private static final int PROPORTION = 5;
    private final JFrame frame = new JFrame();
    private final Controller controller = new Controller();

    /**
     * sets up the GUI interface.
     */
    public SimpleGUI() {
        //components declaration
        final JPanel mainPanel = new JPanel();
        final JTextArea textArea = new JTextArea();
        final JButton save = new JButton("Save");

        //GUI
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(textArea, BorderLayout.CENTER);
        mainPanel.add(save, BorderLayout.SOUTH);

        //frame
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //listeners
        save.addActionListener(e -> controller.writeString(textArea.getText()));
    }

    /**
     * displays the GUI (based on the screen size of the host machine).
     * PROPORTION constant scales up or down the window size.
     */
    private void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    /**
     * main method for testing the interface.
     * 
     * @param args standard main metod arguments
     */
    public static void main(final String[] args) {
        new SimpleGUI().display();
    }
}
