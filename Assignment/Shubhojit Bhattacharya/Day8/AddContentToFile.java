package Day8;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AddContentToFile {
    public static void main(String[] args) {
        String fileName = "Day8/example.txt"; // Specify the name of your file

        try {
            // Create a FileWriter with the specified file name and set append mode to true
            FileWriter fileWriter = new FileWriter(fileName, true);
            
            // Create a BufferedWriter for efficient writing
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Content to be added to the file
            String contentToAdd = "This is the new content that will be added to the file.";

            // Write the content to the file
            bufferedWriter.write(contentToAdd);
            bufferedWriter.newLine(); // Add a newline character if needed

            // Close the buffered writer
            bufferedWriter.close();

            System.out.println("Content added to the file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
