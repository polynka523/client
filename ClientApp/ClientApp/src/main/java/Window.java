import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.BorderLayout.*;

public class Window {

    JButton button;

    JFrame mainFrame;
    JPanel mainPanel;
    JPanel buttonPanel;
    public Window(){
        mainFrame = new JFrame();
        mainPanel = new JPanel();
        buttonPanel = new JPanel();
        button = new JButton("Start");



        buttonPanel.add(button);


        mainFrame.getContentPane().add(buttonPanel, SOUTH);

        mainFrame.setSize(400,400);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (button.getText().equals("Start")){
                    button.setText("Stop");
                    System.out.println(button.getText());
                }
                else if (button.getText().equals("Stop")){
                    button.setText("Start");
                    System.out.println(button.getText());
                }
            }
        });

    }
    public String getButtonText(){
        if (button.getText().equals("Start")){
            return "Stop";
        } else if (button.getText().equals("Stop")) {
            return "Start";
        }
        return "Eror";
    }
}