import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

                public class PersonGenerator {
                public static void main(String[] args) {
                    Scanner in = new Scanner(System.in);
                    ArrayList<String> people = new ArrayList<>();
                    boolean more = true;

                    System.out.println("=== Person Generator ===");

                    while (more) {
                        String id = SafeInput.getNonZeroLenString(in, "Enter ID");
                        String first = SafeInput.getNonZeroLenString(in, "Enter First Name");
                        String last = SafeInput.getNonZeroLenString(in, "Enter Last Name");
                        String title = SafeInput.getNonZeroLenString(in, "Enter Title (Mr., Ms.,etc.)");
                        int year = SafeInput.getInt(in, "Enter Year of Birth");

                        String record = id + ", " + first + ", " + last + ", " + title + ", " + year;
                        people.add(record);

                        more = SafeInput.getYNConfirm(in, "Do you want to add another person?");
                    }
                    String filename = SafeInput.getNonZeroLenString(in, "Enter filename to save (include .txt)");
                    Path file = Path.of(filename);

                    try (BufferedWriter writer = Files.newBufferedWriter(file)) {
                        for (String person : people) {
                            writer.write(person);
                            writer.newLine();
                        }
                        System.out.println("Data saved to " + filename);
                    } catch (IOException e) {
                        System.out.println("Error writing file: " + e.getMessage());
                    }
                }
            }
