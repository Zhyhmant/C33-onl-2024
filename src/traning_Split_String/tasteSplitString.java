package traning_Split_String;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class tasteSplitString {
    public static void main(String[] args) {
        SplitLimit();
    }
    public static void SplitCsv() {
        String csvLine = "John,Doe,30,New York";
        String[] values = csvLine.split(",");

        System.out.println("Separated values: ");
        for (String value : values) {
            System.out.println(value.trim());
        }
    }

    public static void SplitWord(){
        String text = "This is a sample sentence with multiple words";
        String[] words = text.split(" ");

        System.out.println("Sum: " + words.length);
    }

    public static void SplitMultipleDelimiters(){
        String data = "apples,banana;cherry peach orange";
        String[] items = data.split("[,; ]");

        System.out.println("Separated elements: ");
        for (String item : items){
            System.out.println(item.trim());
        }
    }

    public static void SplitReverse(){
        String sentence = "This is a test sentence";
        String[] words = sentence.split(" ");
        Collections.reverse(Arrays.asList(words));
        System.out.println("Words in reverse order: ");
        for (String word : words){
            System.out.println(word + " ");
        }
    }

    public static void SplitUrl(){
        String url = "https://www.example.com/path/to/resource";
        String[] parts = url.split("://|/");

        System.out.println("Protocol: " + parts[0]);
        System.out.println("Domain: " + parts[1]);
        System.out.println("Way: ");

        for (int i=2; i< parts.length; i++){
            System.out.println("/" + parts[i]);
        }
    }

    public static void SplitLimit(){
        String data = "apple-banana-cherry-date";
        String[] parts = data.split("-",3);

        System.out.println("Separated parts: ");
        for (String part : parts){
            System.out.println(part);
        }
    }
}
