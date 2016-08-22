package com.ee.frequency;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Vishal on 22-08-2016.
 */
public class Application {

    public static void main(String[] args) throws FileNotFoundException {

        int cutOff = 0;
        String fileName = getFileName();
            cutOff = getCutOff();

        WordCount wordCount = new WordCount(fileName,cutOff);
        wordCount.findFrequency();
        wordCount.displayFrequency();
        }

     public static String getFileName(){
        Scanner reader = new Scanner(System.in);
        System.out.print("Enter the name of your file .... ");
        String fileName ;
         File file ;
         while(true) {
             fileName = reader.nextLine();
             file = new File(fileName);
             if (!file.exists() || fileName.isEmpty()) {
                 System.out.println("Enter A Valid File Name:");
             }
             else break;
         }

         assert(fileName!=null):"File Name is null";
         assert(fileName.trim().isEmpty()!=true):"File name is empty";
        return fileName;
    }
     public static int getCutOff(){
         int cutOff = 0;
         Scanner scan = new Scanner(System.in);
         System.out.println("Enter Cutoff frequency");
         while(true) {
              cutOff = scan.nextInt();
             if (cutOff < 0 ) {
                 System.out.println("Cutoff cant be negative,Enter again:");
             }
             else break;
         }

        return cutOff;
    }
}
