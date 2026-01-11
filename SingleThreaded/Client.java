import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public void run() throws UnknownHostException, IOException {
        int port = 8010;// This specifies which port number the client will connect to on the server.
        InetAddress address = InetAddress.getByName("localhost");//This gets the IP address of the local machine (usually 127.0.0.1), meaning the client will connect to a server running on the same computer.
        Socket socket = new Socket(address, port);//This creates a client socket and connects to the server at localhost on port 8010.
        PrintWriter toSocket = new PrintWriter(socket.getOutputStream());
        BufferedReader fromSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        toSocket.println("Hello from the Client");//to give something to the socket...
        String line = fromSocket.readLine();// accept from the socket...
        System.out.println("Response from the socket is :" + line);
        toSocket.close();
        fromSocket.close();
        socket.close();
    }
    
    public static void main(String[] args) {
        try {
            Client client = new Client();
            client.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
