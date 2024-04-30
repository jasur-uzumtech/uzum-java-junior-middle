package org.uzum.iggytoto.javacore_collections.homework3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Класс для реализации домашнего задания номер три, часть 1.
 */
public class Homework3_1 {
    /**
     * Реализовать метод который считает количество слов встречающихся в заданном тексте.
     * @param text - заданный текст
     * @return - словарь слов и количество их появлений в данном тексте
     */
    public Map<String,Integer> countWords(String text){
        Map<String, Integer> wordCount = new HashMap<>();

        String[] words = text.split("[^\\p{L}0-9]+");

        System.out.println(Arrays.toString(words));

        for (String word : words) {
            String lowercaseWord = word.toLowerCase();

            if (wordCount.containsKey(lowercaseWord)) {
                int count = wordCount.get(lowercaseWord);
                wordCount.put(lowercaseWord, count + 1);
            } else {
                wordCount.put(lowercaseWord, 1);
            }
        }

        return wordCount;
    }
}
