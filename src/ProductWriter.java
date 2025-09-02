import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductWriter {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> products = new ArrayList<>();
        boolean more = true;

        System.out.println("=== Product Writer ===");

        while (more) {
            String id = SafeInput.getNonZeroLenString(in, "Enter Product ID");
            String name = SafeInput.getNonZeroLenString(in, "Enter Product Name");
            String desc = SafeInput.getNonZeroLenString(in, "Enter Product Description");
            double cost = SafeInput.getDouble(in, "Enter Product Cost");

            String record = id + ", " + name + ", " + desc + ", " + cost;
            products.add(record);


            more = SafeInput.getYNConfirm(in, "Do you want to add another product?");
        }

        String filename = SafeInput.getNonZeroLenString(in, "Enter filename to save (include .txt)");
        Path file = Path.of(filename);

        try (BufferedWriter writer = Files.newBufferedWriter(file)) {
            for (String product : products) {
                writer.write(product);
                writer.newLine();
            }
            System.out.println("Data saved to " + filename);
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}
