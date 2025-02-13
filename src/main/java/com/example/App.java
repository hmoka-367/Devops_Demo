package com.example;

import java.io.*;
import java.net.*;

public class App {
    public static void main(String[] args) throws IOException {
        App app = new App();
        app.startServer(80);
    }

    public void startServer(int port) throws IOException {
        // Create a simple HTTP server that listens on the specified port
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server is listening on port " + port);

        while (true) {
            try (Socket clientSocket = serverSocket.accept()) {
                // Handle the client request
                OutputStream outputStream = clientSocket.getOutputStream();
                PrintWriter writer = new PrintWriter(outputStream, true);

                // Send HTTP headers
                writer.println("HTTP/1.1 200 OK");
                writer.println("Content-Type: text/plain");
                writer.println();  // Blank line before body content
                writer.println("Hello, DevOps!");  // Body content

                writer.flush();
            }
        }
    }
}
