
/**
 * Write a description of WhichCountriesExport here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import org.apache.commons.csv.*;

public class WhichCountriesExport {
    
      
   public void countryInfo (CSVParser parser, String country) {
             for(CSVRecord record : parser){
            String countryInfo = record.get("Country");
            if(countryInfo.contains(country)){
                System.out.println(record.get("Country")+ " : ");
                System.out.println(record.get("Exports")+" : ");
                System.out.println(record.get("Value (dollars)"));
                           
            }
            else{
                System.out.println("Country not found");
                
            }
              
    }

}
public void tester () {
       FileResource fr = new FileResource();
       CSVParser parser = fr.getCSVParser();
       parser = fr.getCSVParser();
    countryInfo(parser,"Peru");
       
   }
}
