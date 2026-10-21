# Experiment 04: Client-Server Communication using Java Sockets

## Aim
To implement communication between a client and a server using TCP sockets in Java.

## Requirements
- JDK installed
- Terminal or VS Code

## Files
- `server.java` — starts a TCP server on port 5000, accepts clients, reads one message, and sends a response.
- `client.java` — connects to localhost port 5000, sends a message, and prints the server response.

## How to Compile
Open a terminal in this folder and run:

```powershell
javac server.java client.java
```

## How to Run
1. In Terminal 1, start the server:

```powershell
java server
```

2. Open Terminal 2 in the same folder and run the client:

```powershell
java client
```

3. Type a message when prompted. The client will display the server response.

## Sample Output

Server terminal:
```text
Server starting on port 5000...
Server is ready. Waiting for a client...
Client connected: /127.0.0.1
Client says: Hello Server
Response sent. Waiting for next client...
```

Client terminal:
```text
Enter a message to send to the server: Hello Server
Server response: Message received by server: Hello Server
```

## Result
Client-server communication was implemented successfully using Java TCP sockets.

## Notes
- Start the server before the client.
- Keep the server terminal running while testing.
- If port 5000 is already in use, close the other application using it or change `PORT` in both Java files.
- `.class` files are generated when you compile; they do not need to be committed to GitHub.
