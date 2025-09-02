import javax.swing.*;
        import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ProductReader {
    public static void main(String[] args) {
        System.out.println("=== Product Reader ===");


        JFileChooser chooser = new JFileChooser(".");
        int result = chooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            Path file = chooser.getSelectedFile().toPath();

            try (BufferedReader reader = Files.newBufferedReader(file)) {
                System.out.printf("%-8s %-15s %-30s %-10s%n", "ID#", "Name", "Description", "Cost");
                System.out.println("=======================================================================");

                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",\\s*");

                    if (parts.length == 4) {
                        String id = parts[0];
                        String name = parts[1];
                        String desc = parts[2];
                        String cost = parts[3];
                        System.out.printf("%-8s %-15s %-30s %-10s%n", id, name, desc, cost);
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
