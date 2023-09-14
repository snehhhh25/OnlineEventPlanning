package com.codefury.utils;

import java.util.*;

public class StringToList {
	public static <T> List<T> convertToList(String string, Class<T> elementType) {
      
        string = string.substring(1, string.length() - 1);
        String[] elements = string.split(", ");
        List<T> resultList = new ArrayList<>();

        if (elementType.isEnum()) {
        	 for (String value : elements) {
        		 T enumValue = (T)Enum.valueOf((Class<Enum>) elementType,value);
                 resultList.add(enumValue);
             }
        } else if (elementType.equals(String.class)) {
            Collections.addAll(resultList, (T[]) elements);
        } else if (elementType.equals(Long.class)) {
            for (String element : elements) {
                resultList.add((T)Long.valueOf(element));
            }
            
}
        return resultList;
	}
	}
