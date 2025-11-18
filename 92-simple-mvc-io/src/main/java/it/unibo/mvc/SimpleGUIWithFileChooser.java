package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * A very simple program using a graphical interface with file chooser.
 */
public final class SimpleGUIWithFileChooser {
    private static final int PROPORTION = 5;
    private final JFrame frame = new JFrame();
    private final Controller controller = new Controller();

    /**
     * sets up the GUI interface.
     */
    public SimpleGUIWithFileChooser() {
        //components declaration
        final JPanel mainPanel = new JPanel();
        final JPanel browsePanel = new JPanel();
        final JTextArea textArea = new JTextArea();
        final JTextField browseField = new JTextField();
        final JButton save = new JButton("Save");
        final JButton browseButton = new JButton("Browse...");

        // mainPanel
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(textArea, BorderLayout.CENTER);
        mainPanel.add(save, BorderLayout.SOUTH);
        mainPanel.add(browsePanel, BorderLayout.NORTH);

        // browsePanel
        browsePanel.setLayout(new BorderLayout());
        browsePanel.add(browseButton, BorderLayout.LINE_END);
        browsePanel.add(browseField, BorderLayout.CENTER);
        browseField.setEditable(false);
        browseField.setText(controller.getPath());

        // frame
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //listeners
        save.addActionListener(e -> controller.writeString(textArea.getText()));
        browseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                final JFileChooser chooser = new JFileChooser();
                final int result = chooser.showSaveDialog(frame);
                switch (result) {
                    case JFileChooser.APPROVE_OPTION:
                        controller.setFile(chooser.getSelectedFile());
                        browseField.setText(controller.getPath());
                    break;
                    case JFileChooser.CANCEL_OPTION: 
                    break;
                    default:
                    JOptionPane.showMessageDialog(frame, "Error");
                    break;
                }
            }
        });
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
        new SimpleGUIWithFileChooser().display();
    }
}
