package com.codefury.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class MapperUtils {
	
	public static <T> List<T> stringToListOfObjects(String inputString) {
        List<T> objectList = new ArrayList<>();
        
        // Split the input string by commas
        String[] stringArray = inputString.split(",");
        
       
        for (String str : stringArray) {
           
            objectList.add((T) convertStringToType(str));
        }
        
        return objectList;
    }

    private static <T> T convertStringToType(String str) {
        
        return (T) Integer.valueOf(str);
    }
    
    
    public static <K, V> Map<K, V> stringToMap(String inputString) {
        Map<K, V> resultMap = new HashMap<>();

        // Remove curly braces and split the string by commas to get key-value pairs
        String[] keyValuePairs = inputString
                .replace("{", "")
                .replace("}", "")
                .split(",");

        // Iterate over key-value pairs and populate the map
        for (String pair : keyValuePairs) {
            String[] keyValue = pair.split(":");
            if (keyValue.length == 2) {
                String key = keyValue[0].trim().replaceAll("\"", "");
                String value = keyValue[1].trim().replaceAll("\"", "");
                resultMap.put((K) key, (V) value);
            }
        }

        return resultMap;
    }
  
        
    
	

}
