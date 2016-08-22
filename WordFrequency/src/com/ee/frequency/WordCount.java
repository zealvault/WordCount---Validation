package com.ee.frequency;

/**
 * Created by Vishal on 21-08-2016.
 * AIM:The following java code takes a .txt file and displays word frequency.
 */

import java.util.*;
import java.io.*;

public class WordCount {

    private static final int MIN_FREQUENCY_VALUE = 0 ;

    private String fileName = null;
    private Map<String,Integer> map = null;
    private int cutOff = 0;

    public WordCount(String fileName, int cutOff){
        if(cutOff >= MIN_FREQUENCY_VALUE) {
            this.cutOff = cutOff;
        }
        else{
            System.out.println("Frequency can't be negative");
        }
        if(fileName!= null) {
            if (fileName.endsWith(".txt"))
                this.fileName = fileName;
            else
                this.fileName = fileName + ".txt";
        }else{
            System.out.println("File name can't be null");
        }
    }


    public Map<String, Integer> getMap() {
        return map;
    }



    public void setFileName(String fileName) {
        if(fileName.endsWith(".txt"))
            this.fileName = fileName;
        else
            this.fileName=fileName+".txt";

    }

    public void findFrequency() throws  FileNotFoundException{
        boolean isNotValidFile;
        Scanner inputStream = null;
         do {
             try {
                 isNotValidFile = false;
                 inputStream = new Scanner(new File(fileName));
                 Map<String, Integer> wordCounts = new TreeMap<String, Integer>();
                 while (inputStream.hasNext()) {
                     String word = inputStream.next().toLowerCase().replace('.',' ').replace(',',' ').trim();
                     if (!wordCounts.containsKey(word)) {
                         wordCounts.put(word, 1);
                     } else {
                         wordCounts.put(word, wordCounts.get(word) + 1);
                     }
                 }
                 this.map = wordCounts;
             } catch (FileNotFoundException e) {
                 System.out.println("Please provide the correct .txt file");
                 isNotValidFile = true;
             }
         }while(isNotValidFile);
       }

    public void displayFrequency(){
        System.out.println("WORD \t COUNT");
        for (String word : map.keySet()) {
            int count = map.get(word);
            if (count >= cutOff)
                System.out.println(word + "\t\t" + count);
        }
    }

}
