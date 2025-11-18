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
 * 
 */
public final class SimpleGUIWithFileChooser {
    private final JFrame frame = new JFrame();
    private final Controller controller = new Controller();
    private static final int PROPORTION = 5;

    public SimpleGUIWithFileChooser(){
        //components declaration
        JPanel mainPanel = new JPanel();
        JPanel browsePanel = new JPanel();
        JTextArea textArea = new JTextArea();
        JTextField browseField = new JTextField();
        JButton save = new JButton("Save");
        JButton browseButton = new JButton("Browse...");

        //mainPanel
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(textArea, BorderLayout.CENTER);
        mainPanel.add(save, BorderLayout.SOUTH);
        mainPanel.add(browsePanel, BorderLayout.NORTH);
        
        //browsePanel
        browsePanel.setLayout(new BorderLayout());
        browsePanel.add(browseButton, BorderLayout.LINE_END);
        browsePanel.add(browseField, BorderLayout.CENTER);
        browseField.setEditable(false);
        browseField.setText(controller.getPath());

        //frame
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //listeners
        save.addActionListener(e -> controller.writeString(textArea.getText()));
        browseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                final int result = chooser.showSaveDialog(frame);
                switch(result){
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

    protected void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleGUIWithFileChooser().display();
    }
}
