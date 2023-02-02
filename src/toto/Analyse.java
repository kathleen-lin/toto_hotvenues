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
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Analyse {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        Reader r = new FileReader("./HotVenues.txt");
        BufferedReader br = new BufferedReader(r);
        Writer w = new FileWriter("./SortedVenues.txt");
        BufferedWriter bw = new BufferedWriter(w);
        
        Map<String, Integer> venue = new HashMap<>();

        String line = "";
        while (null != (line = br.readLine())){
            // split by spaces
            line = line.strip();
            if (line.equals("")){
                continue; 
            } else {                
                //System.out.println(line);
                //bw.write(line);
                //bw.write("\n");
                if (venue.containsKey(line)){
                    // increase count of that word
                    int newCount = venue.get(line) + 1;
                    venue.put(line, newCount);
                         
                } else {
                    venue.put(line, 1);
                }
            }    

            }
        //System.out.println(Arrays.asList(venue)); // method 1

        LinkedHashMap<String, Integer> SortedMap = new LinkedHashMap<>();
 
        venue.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEachOrdered(word -> SortedMap.put(word.getKey(), word.getValue()));

        //System.out.println(Arrays.asList(reverseSortedMap));

        // got a LinkedHashMap name reverseSortedMap
        for (int i = 1; i < SortedMap.size(); i++){
            Map.Entry<String,Integer> topVenues = SortedMap.entrySet().iterator().next();
            String key= topVenues.getKey();
            Integer value=topVenues.getValue();
            String output = key + ", " + String.valueOf(value) + " \n";
            bw.write(output);
            SortedMap.remove(key);
        }

        bw.close();
        br.close();
        }

        

        
}  



