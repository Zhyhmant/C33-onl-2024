package Lesson14;

import java.io.*;

public class DocumentValidator {
    public static void main(String[] args) {
        if(args.length == 0 ){
            System.out.println("src/Lesson14/Documents");
            return;
        }
        String inputFile = args[0];
        String validFile = "";
        String invalidFile = "";


        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter validWriter = new BufferedWriter(new FileWriter(validFile));
             BufferedWriter invalidWriter = new BufferedWriter(new FileWriter(invalidFile))){

            String line;
            while ((line = reader.readLine()) != null){
                String reason = validateDocumentNumber(line);
                if (reason == null){
                    validWriter.write(line);
                    validWriter.newLine();
                }else{
                    invalidWriter.write(line + " - " + reason);
                    invalidWriter.newLine();
                }
            }
        }catch (IOException e){
            System.err.println("File processing error: " + e.getMessage());
        }
        System.out.println("Processing is completed.Check the files ");
    }
    public static  String validateDocumentNumber(String number){
        if (number.length() != 15){
            return "Incorrect length(should be 15 characters)";
        }
        if(!number.matches("\"^(docnum|contract)\\\\w+$\"")){
            return "Must start with 'docum' or 'contract'";
        }
        return null;
    }
}
