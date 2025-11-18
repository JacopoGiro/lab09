package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {
    private final JFrame frame = new JFrame();
    private final Controller controller = new Controller();
    private static final int PROPORTION = 5;
    
    public SimpleGUI(){
        //components declaration
        JPanel mainPanel = new JPanel();
        JTextArea textArea = new JTextArea();
        JButton save = new JButton("Save");

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

    protected void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleGUI().display();
    }
}
