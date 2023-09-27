package assignment8;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AddContentToFile {
    public static void main(String[] args) {
        String fileName = "myProgram.txt";

        try {
            
            FileWriter fileWriter = new FileWriter(fileName, true);
            
            
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String contentToAdd = "This is the new content that will be added to the file.";

            bufferedWriter.write(contentToAdd);
            bufferedWriter.newLine(); 

            bufferedWriter.close();

            System.out.println("Content added to the file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}