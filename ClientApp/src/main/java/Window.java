import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.net.Socket;
import java.io.*;

public class Window {
    private JFrame frame;
    private JPanel buttonPanel;
    private JButton startStopButton;
    public void setUpWindow(){
        frame = new JFrame();
        buttonPanel = new JPanel();
        startStopButton = new JButton("Start");
        startStopButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                JButton sourceButton = (JButton) e.getSource();
                if (sourceButton.getText().equals("Start")){
                    try {
                        Socket clientSocket = new Socket("localhost", 8081);
                        PrintWriter out = new PrintWriter(clientSocket.getOutputStream());
                        out.println("Start");
                        out.close();
                        clientSocket.close();
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    sourceButton.setText("Stop");
                    try {
                        Socket clientSocket = new Socket("localhost",8081);
                        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                        System.out.println(in.readLine());
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }

                }
                else {
                    try {
                        Socket clientSocket = new Socket("localhost", 8081);
                        PrintWriter out = new PrintWriter(clientSocket.getOutputStream());
                        out.println("Stop");
                        out.close();
                        clientSocket.close();
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    sourceButton.setText("Start");
                }

            }
        });
        buttonPanel.add(startStopButton);
        frame.getContentPane().add(BorderLayout.SOUTH, buttonPanel);

        frame.setVisible(true);
        frame.setSize(400,400);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

}
