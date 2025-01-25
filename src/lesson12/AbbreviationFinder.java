package lesson12;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AbbreviationFinder {
    public static void main(String[] args) {
        infoExtractor();
    }
    public static void abbreviationsFinder(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter line: ");
        String input = scanner.nextLine();

        String regex = "\\b[A-Z]{2,6}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        System.out.println("Abbreviations found: ");
        while (matcher.find()){
            System.out.println(matcher.group());
        }
        scanner.close();
    }

    public static void infoExtractor(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter line: ");
        String input = scanner.nextLine();

        String emailRegex = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}\\b";
        String documentRegex = "\\b\\d{4}-\\d{4}-\\d{2}\\b";
        String phoneRegex = "\\+\\(\\d{2}\\)\\d{7}\\b";

        Pattern emailPattern = Pattern.compile(emailRegex);
        Pattern docementsPattern = Pattern.compile(documentRegex);
        Pattern phonePattern = Pattern.compile(phoneRegex);

        Matcher emailMatcher = emailPattern.matcher(input);
        Matcher documentMatcher = docementsPattern.matcher(input);
        Matcher phoneMatcher = phonePattern.matcher(input);

        while (emailMatcher.find()){
            System.out.println("Email: " + emailMatcher.group());
        }
        while (documentMatcher.find()){
            System.out.println("Document: " + documentMatcher.group());
        }
        while (phoneMatcher.find()){
            System.out.println("Phone: " + phoneMatcher.group());
        }
        scanner.close();
    }
}
