import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
private int port;
private String hostname;
private Socket clientSocket;
private PrintWriter outMessage;
private Scanner inMessage;


public Client(int port, String hostname) {
    this.hostname = hostname;
    this.port = port;
}

public void createConnection() throws IOException {

    clientSocket = new Socket(hostname,port);
    outMessage = new PrintWriter(clientSocket.getOutputStream(),true);
    inMessage = new Scanner(clientSocket.getInputStream());

}

public void sendMessage(String message){
    outMessage.println(message);
    System.out.printf("This \" %s\" sent", message);
}

public void receiveData() throws IOException{
    String someData = " ";
    while (someData != null){
        someData = inMessage.nextLine();
        System.out.printf("Received someData: %s",someData);
    }
}

}
