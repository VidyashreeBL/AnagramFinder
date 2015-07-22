package PayPal_java;

import java.io.*;
import java.text.Collator;
import java.util.*;

/**
 * Created by test on 7/21/2015.
 */
public class Anagrams {

    public static void getAnagramsList() throws IOException {
        try {
            String inputFileName = "NewWordList.txt";
            BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
            HashMap<String, ArrayList<String>> word_list = new HashMap<String, ArrayList<String>>();

            String line;
            while ((line = reader.readLine()) != null) {
                //process each line in some way
                String sorted_word = sort(line);
                if(word_list.containsKey(sorted_word)) {
                    word_list.get(sorted_word).add(line);
                }

                else{
                    ArrayList<String> list = new ArrayList<String>();
                    list.add(line);
                    word_list.put(sorted_word, list);
                }
            }

            reader.close();

            String outputFileName = "NewAnagramList.txt";
            BufferedWriter br = new BufferedWriter(new FileWriter(new File(outputFileName)));
             for (ArrayList<String> list:word_list.values())
                 if (list.size() > 1) {
                     br.append(list.toString()+"\n");
                     System.out.println(list);
                 }

            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static String sort(String s){
//        Collator col = Collator.getInstance();
//        String[] s1= s.split("");
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        String sorted = "";
        for (int i = 0; i < arr.length; i++)
        {
            sorted += arr[i];
        }
        return sorted;
    }

    public static void main(String[] args) throws IOException {
        getAnagramsList();
    }
}
