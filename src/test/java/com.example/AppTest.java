package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

import java.io.*;
import java.net.*;

public class AppTest {

    @Test
    public void testServerResponse() throws IOException, InterruptedException {
        // Start the server in a separate thread
        new Thread(() -> {
            try {
                App app = new App();
                app.startServer(8080);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        // Wait for the server to start
        Thread.sleep(1000);

        // Connect to the server and read the response
        try (Socket socket = new Socket("localhost", 8080)) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line).append("\n");
            }
            String expectedResponse = "HTTP/1.1 200 OK\nContent-Type: text/plain\n\nHello, DevOps!\n";
            assertEquals(expectedResponse, response.toString());
        }
    }
}
