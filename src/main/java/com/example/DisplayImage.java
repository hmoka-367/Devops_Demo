import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class DisplayImage extends JFrame {

    public DisplayImage() {
        // Set the title of the JFrame
        setTitle("Image Display");

        // Set the default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the size of the JFrame
        setSize(800, 600);

        // Create an ImageIcon from the image file
        try {
            ImageIcon imageIcon = new ImageIcon(ImageIO.read(new File("image.jpg"))); // Ensure image.jpg exists in your project
            JLabel label = new JLabel(imageIcon);  // Add the image to a JLabel

            // Set the layout of the JFrame to a simple FlowLayout
            setLayout(new FlowLayout());

            // Add the label (with the image) to the JFrame
            add(label);
        } catch (IOException e) {
            System.out.println("Error loading image: " + e.getMessage());
        }

        // Set the JFrame to be visible
        setVisible(true);
    }

    public static void main(String[] args) {
        // Create an instance of DisplayImage to run the program
        new DisplayImage();
    }
}
