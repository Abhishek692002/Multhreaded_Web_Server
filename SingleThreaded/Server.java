import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    
    public void run() throws IOException{
        int port = 8010;//Server litens to the port...
        ServerSocket socket = new ServerSocket(port);// a socket is open on this port..
        socket.setSoTimeout(10000);//socket waits 10ms after that it will be closed...

        while (true) {
            try{
                System.out.println("Server is litening on port " + port);
                Socket acceptedConnection = socket.accept(); // it accepted the client request...
                System.out.println("Connection accepted from client " + acceptedConnection.getRemoteSocketAddress());// if the client request is accepted then print the client socket address...

                //acceptedConnection.getOutputStream()

            /*
             * Every socket has:
             * an InputStream → to read data from the client
             * an OutputStream → to send data to the client
             * 
             * getOutputStream() returns a byte stream (OutputStream)
             * 
             * Bytes are low-level and not convenient for sending text
             */
            PrintWriter toClient = new PrintWriter(acceptedConnection.getOutputStream());
            /* PrintWriter is a character-based writer.It wraps the OutputStream so you can easily send text using:print(),println().Much easier than manually sending bytes */
            BufferedReader fromClient = new BufferedReader(new InputStreamReader(acceptedConnection.getInputStream()));//This line creates a text reader that lets the server read messages sent by the client line-by-line
            toClient.println("Hello from the Server");
        } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
    }
    public static void main(String[] args) {
        Server server = new Server();
        try {
            server.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}