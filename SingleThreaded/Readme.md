Here’s what your Server code is doing, explained in simple sentences 👇

--The server starts and opens a ServerSocket on port 8010, waiting for clients to connect.

--It waits (up to 10 seconds) for a client request using socket.accept().

--When a client connects, the server accepts the connection and prints the client’s IP address and port.

--It creates a PrintWriter to send text messages to the client and a BufferedReader to read text from the client.

--The server sends a greeting message "Hello from the Server" to the connected client.

--The server then goes back to waiting for the next client connection in an infinite loop.