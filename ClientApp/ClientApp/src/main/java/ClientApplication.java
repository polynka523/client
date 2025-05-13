import java.awt.*;
import java.io.*;
import java.net.*;

public class ClientApplication {


    private static final int port = 8081;
    private static final String hostName = "localhost";
    public static void main(String[] args) throws IOException {

        Window appWindow = new Window();
        Client client = new Client(port,hostName);
        client.createConnection();
        if (appWindow.getButtonText().equals("Start")){
            client.sendMessage("Start");
            client.receiveData();
        } else if (appWindow.getButtonText().equals("Stop")) {
            client.sendMessage("Stop");
        }
    }
}