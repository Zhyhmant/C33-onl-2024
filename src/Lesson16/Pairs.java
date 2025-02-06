package Lesson16;

import java.util.HashMap;
import java.util.Map;

public class Pairs {
    public static Map<String,String> pairs(String[] strings){
        Map<String,String> result = new HashMap<>();

        for (String str : strings){
            if (!str.isEmpty()){
                String firstChar = String.valueOf(str.charAt(0));
                String lastChar = String.valueOf(str.charAt(str.length() - 1));
                result.put(firstChar,lastChar);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(pairs(new String[]{"code", "bug"}));
        System.out.println(pairs(new String[]{"man","moon","main"}));
        System.out.println(pairs(new String[]{"man","moon","good","night"}));
    }
}
