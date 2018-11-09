
import com.sun.xml.internal.bind.v2.TODO;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;



/**
 *
 * @author Haiping Zhu
 */
public class ParseFile {
    public static void main(String[] args)throws FileNotFoundException, IOException  {
   
        Scanner s= new Scanner(new BufferedReader(new  FileReader("shortwords.txt")));
        HashMap <String,Integer> Dict1= new HashMap<>();
        HashMap <String,Integer> Dict2= new HashMap<>();
        while(s.hasNext()){
            Dict1.put(s.next(),0);
        }
        BufferedReader br= new BufferedReader(new FileReader("Frankenstein.txt"));
        String line;
        String[] words;
        int len=0;
        String current;
        int i=0;
       // int linenumb=0;
        while((line=br.readLine()) != null){
         //   linenumb++
            words = line.split("[ \\.\\?\\,\\:\\?\\!\\*\\#\\;\\-\\s]+");
            len=words.length;
            String sp=" ";
            
            if (len==0)
                continue;
            
            for(i=0;i<len;i++){
                if( Dict1.containsKey(words[i])  ){
                    if(i==0 & i+1<len)
                        current=words[i]+sp+words[i+1];
                    if(i==0 & i+1>=len)
                        current=words[i];
                    if(i>0 & i+1<len)
                        current=words[i-1]+sp+words[i]+sp+words[i+1];
                    if(i>0 & i+1>=len)
                        current=words[i-1]+sp+words[i];
                    else
                        continue;
                    Integer count=Dict2.get(current);
                    if (count==null)
                        Dict2.put(current, 1);
                    else
                        Dict2.put(current, count+1);
                    
                }
                else
                    continue;
            }
        }
        for(String w:Dict2.keySet()){
            int a=0;
            if((a=Dict2.get(w))>=50){
                System.out.println(w+"==>"+a);
            } 
        }
        
        
        
    }
}
