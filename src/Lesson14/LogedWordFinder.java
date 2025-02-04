package Lesson14;

import javax.imageio.IIOException;
import java.io.*;

public class LogedWordFinder {
    public static void main(String[] args) {
        String inputFile = "src/Lesson14/Romeo_and_Juliet";
        String outputFile = "src/Lesson14/Romeo_and_Juliet";

        String longestWord = "src/Lesson14/Documents";

        try(BufferedReader reader = new BufferedReader(new FileReader(inputFile))){
            String line;
            while ((line = reader.readLine()) != null){
                String[] words = line.split("\\W+");
                for (String word : words){
                    if(word.length() > longestWord.length()){
                        longestWord = word;
                    }
                }
            }
        }catch (IOException e){
            System.err.println("File reading error" + e.getMessage());
        }
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))){
            writer.write("Longest word: " + longestWord);
        }catch (IOException e){
            System.out.println("File writer error: " + e.getMessage());
        }
        System.out.println("Longest word : " + longestWord);
    }
}
