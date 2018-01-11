
/**
 * Write a description of avgtemp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class avgtemp {
public void averageTemperatureInFile() {
        FileResource storage = new FileResource();
        CSVParser parser = storage.getCSVParser();
        double humidity = 0;
        double sumTemp = 0;
        double avgTemp = 0;
        int count = 0;
        for (CSVRecord currentRow : parser) {
            String currentTemp = currentRow.get("TemperatureF");
            
            double currTemp = Double.parseDouble(currentTemp);
            
            if (currTemp > 0) {
                count +=1;
                sumTemp += currTemp;
            }
        }
        avgTemp = sumTemp / count;
        System.out.println(avgTemp);
    } 
    
    public CSVRecord lowestHumidityInFile (CSVParser parser){
    CSVRecord smallestSoFar = null;
    for (CSVRecord currentRow : parser) {
        if(smallestSoFar == null){
            smallestSoFar = currentRow;
        }
        else{
            double currentTemp = Double.parseDouble(currentRow.get("Humidity"));
            double smallestTemp = Double.parseDouble(smallestSoFar.get("Humidity"));
            if (currentTemp < smallestTemp) {
                smallestSoFar = currentRow;
            }
        }
    }
return smallestSoFar;   
}
    public void lowestHumidityInManyFiles(){
        CSVRecord lowestHumiditySoFar = null;
        DirectoryResource dr = new DirectoryResource();
        File fileName = null;
        
       
        for(File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVParser parser = fr.getCSVParser();
            
            CSVRecord currentFile = lowestHumidityInFile(parser);
             
            if(lowestHumiditySoFar == null){
                 lowestHumiditySoFar = currentFile;
                }else{
                double currentHum = Double.parseDouble(currentFile.get("Humidity"));
                double lowestHum = Double.parseDouble(lowestHumiditySoFar.get("Humidity"));
                
                if(currentHum < lowestHum && currentHum > -9999){
                    lowestHumiditySoFar = currentFile;
                    fileName = f;
                }
                
            }
        }       
        System.out.println("Lowest humidity on that day was: " + lowestHumiditySoFar.get("Humidity") + "at" + lowestHumiditySoFar.get("DateUTC")); 
        System.out.println("Lowest humidity was in file" + fileName.getPath());   
                  
      
    }
    public void  testLowestHumidityInManyFiles(){
        
    }
}
