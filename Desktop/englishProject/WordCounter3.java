// File: WordCounter.java
// Program from Section 5.7 to illustrate the use of TreeMaps and Iterators.
// The program opens and reads a file called words.txt. Each line in this
// file should consist of one or more English words separated by spaces.
// The end of each line must not have any extra spaces after the last word.
// The program reads the file and then a table is printed of
// all words and their counts.

import java.util.*;  // Provides TreeMap, Iterator, Scanner
import java.io.*;    // Provides FileReader, FileNotFoundException

public class WordCounter3
{
private static String nameOfFolder = "englishDocs"; //Put folder name here
private static String nameOfPath = "/Users/user/Desktop/"; //put path name here
   public static void main(String[ ] args)  
   {   
      TreeMap<String, Integer> frequencyData = new TreeMap<String, Integer>( );

      readWordFile(frequencyData); 
      printAllCounts(frequencyData);
     // System.out.println(getMaxCount(frequencyData));
     //replace englishDocs with your folder name
    // ArrayList<String> x= listFilesForFolder("englishDocs");
    // for(String n : x)
    // System.out.println(n);
   }
   
   public static int getMaxCount(TreeMap<String, Integer> frequencyData){
        int max = 0; 
       for(String word : frequencyData.keySet( ))
      {
         if(max<frequencyData.get(word)){
             max = frequencyData.get(word);
            }
      }
      return max;
    }

   public static int getCount
   (String word, TreeMap<String, Integer> frequencyData)
   {
      if (frequencyData.containsKey(word))
      {  // The word has occurred before, so get its count from the map
       return frequencyData.get(word); // Auto-unboxed
      }
      else
      {  // No occurrences of this word
         return 0;
      }
   }

   public static void printAllCounts(TreeMap<String, Integer> frequencyData)
   {
      for(int i = getMaxCount(frequencyData); i >0 ; i--){
                boolean firstLine = true;
      for(String word : frequencyData.keySet( ))
      {
          if( frequencyData.get(word) == i){
          if(firstLine){      
      System.out.println("\n    Occurrences    Word");
      System.out.println("-----------------------------------------------");
      firstLine = false;
    }
         System.out.printf("%15d    %s\n", frequencyData.get(word), word);
        }
      }
   }  
}

   public static void readWordFile(TreeMap<String, Integer> frequencyData)
   {
      Scanner wordFile;
      String word;     // A word read from the file
      Integer count;   // The number of occurrences of the word
      ArrayList<String> x= listFilesForFolder(nameOfFolder); //Replace your folder name here
      for(String n:x){
      try
      {
         wordFile = new Scanner(new FileReader(n));
      }
      catch (FileNotFoundException e)
      {
     System.err.println(e);
     return;
      }
      
      while (wordFile.hasNext( ))
      {
          // Read the next word and get rid of the end-of-line marker if needed:
      word = wordFile.next( );
         word = word.replace("," , "");
         word = word.replace("." , "");
         word = word.replace("!" , "");
         word = word.replace("?" , "");
         word = word.replace("-" , "");
         word = word.replace(";" , "");
         word = word.toLowerCase();
          // Get the current count of this word, add one, and then store the new count:
          count = getCount(word, frequencyData) + 1;
          frequencyData.put(word, count);
      }
   }
   } 
       public static ArrayList<String> listFilesForFolder(String foldername) {
        ArrayList<String> results = new ArrayList<String>();
         //******Replace the below line with your path
        String myPath = nameOfPath;
        //******Replace the above line with your path
        String a = myPath +foldername;
        
       File[] files = new File(a).listFiles();
       //If this pathname does not denote a directory, then listFiles() returns null. 

       for (File file : files) {
         if (file.isFile()) {
            results.add(myPath+foldername+"/"+file.getName());
         }
     }
      return results;
    }
}




