package Web_scrapping.src.toto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class TopNums {
    
    public static void main (String[] args)throws FileNotFoundException, IOException {
        Reader r = new FileReader("./PopularNumbers.txt");
        BufferedReader br = new BufferedReader(r);
        Writer w = new FileWriter("./PopularNumbers.csv");
        BufferedWriter bw = new BufferedWriter(w);
        
        Map<String, Integer> num = new LinkedHashMap<>();

        String line = "";

        while (null != (line = br.readLine())){


            if (num.containsKey(line)){
                    // increase count of that word
                    int newCount = num.get(line) + 1;
                    num.put(line, newCount);
                    System.out.println("Number found in map, updating count to " + newCount);

                         
                } else {
                    num.put(line, 1);
                    System.out.println("Line not found in map, adding with count 1");

                }
        } 
        
        for (int i  = 1; i < 50; i++){
            String output = String.valueOf(i) + ", " + num.get(String.valueOf(i)) + "\n"; // method 1
            bw.write(output);

        }
       
    
/*

        for (int i = 1; i < num.size(); i++){
            Map.Entry<String,Integer> top_num = num.entrySet().iterator().next();
            String key= top_num.getKey();
            Integer value=top_num.getValue();
            String output = key + ", " + String.valueOf(value) + " \n";
            bw.write(output);
            num.remove(key);
        }
 
 */
        bw.close();
        br.close();



    }
}
