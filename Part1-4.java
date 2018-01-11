
/**
 * Write a description of part4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
public class Part4 {
    public void findURL(){
        URLResource url = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
        for (String word: url.lines()){
            String youtube = "youtube.com";
            word.toLowerCase();
            if (youtube.equalsIgnoreCase("YouTube.com")){
                int youtubeIndex = word.indexOf(youtube);
                String quotes = "\"";
                if (youtubeIndex != -1){
                    int lastQuoteIndex = word.indexOf(quotes,youtubeIndex);
                    int firstQuoteIndex = word.lastIndexOf(quotes,youtubeIndex);
                        String youtubeLink = word.substring(firstQuoteIndex+1, lastQuoteIndex);
                        System.out.println(youtubeLink);
                }
            }
}
}
}
