import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class PersonReader {
    public static void main(String[] args) {
        System.out.println("=== Person Reader ===");

        // JFileChooser to pick file
        JFileChooser chooser = new JFileChooser(".");
        int result = chooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            Path file = chooser.getSelectedFile().toPath();

            try (BufferedReader reader = Files.newBufferedReader(file)) {
                System.out.printf("%-8s %-12s %-12s %-8s %-6s%n", "ID#", "Firstname", "Lastname", "Title", "YOB");
                System.out.println("====================================================");

                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",\\s*");

                    if (parts.length == 5) {
                        String id = parts[0];
                        String first = parts[1];
                        String last = parts[2];
                        String title = parts[3];
                        String yob = parts[4];
                        System.out.printf("%-8s %-12s %-12s %-8s %-6s%n", id, first, last, title, yob);
                    }
                }
            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
            }
        } else {
            System.out.println("No file selected. Program ending.");
        }
    }
}
