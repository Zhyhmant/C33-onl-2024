package Lesson16;

import java.util.HashMap;
import java.util.Map;

public class WorldMultiple {
    public static Map<String,Boolean> wordMultiple(String[] strings){
        Map<String,Boolean> result = new HashMap<>();
        Map<String,Integer> countMap = new HashMap<>();

        for (String str : strings){
            countMap.put(str,countMap.getOrDefault(str,0) + 1);
        }
        for (Map.Entry<String,Integer > entry : countMap.entrySet()){
            result.put(entry.getKey(),entry.getValue() >= 2);
        }
        return result;
    }
    public static void main(String[] args){
        System.out.println(wordMultiple(new String[]{"a","b","a","c","b"}));
        System.out.println(wordMultiple(new String[]{"c","b","a"}));
        System.out.println(wordMultiple(new String[]{"c","c","c","c"}));
    }

}
