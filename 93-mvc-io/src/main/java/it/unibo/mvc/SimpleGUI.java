package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A very simple program using a graphical interface.
 */
public final class SimpleGUI {
    private static final int PROPORTION = 5;
    private final JFrame frame = new JFrame();
    private final SimpleController controller = new SimpleController();

    /**
     * contructor sets up the whole view.
     */
    public SimpleGUI() {
        //dichiariazioni
        final JPanel mainPanel = new JPanel();
        final JPanel buttonsPanel = new JPanel();
        final JTextField field = new JTextField();
        final JTextArea historyDisplay = new JTextArea();
        final JButton print = new JButton("print");
        final JButton showHistory = new JButton("show history");

        //GUI mainPanel
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(field, BorderLayout.NORTH);
        mainPanel.add(historyDisplay, BorderLayout.CENTER);
        mainPanel.add(buttonsPanel, BorderLayout.SOUTH);
        historyDisplay.setEditable(false);

        //GUI buttonsPanel
        buttonsPanel.setLayout(new GridLayout(1, 2));
        buttonsPanel.add(print);
        buttonsPanel.add(showHistory);

        //frame
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //listeners
        print.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                controller.setString(field.getText());
                controller.printString();
            }
        });
        showHistory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                historyDisplay.setText(controller.getHistory().toString());
            }
        });
    }

    /**
     * displays the frame.
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
     * main method for testing.
     * 
     * @param args standard main method parameters
     */
    public static void main(final String[] args) {
        new SimpleGUI().display();
    }
}
