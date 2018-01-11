package TemperaturePractice;


/**
 * Write a description of CSVMin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class CSVMin {

    public CSVRecord coldestHourInFile(CSVParser parser) {
    CSVRecord smallestSoFar = null;
    for (CSVRecord currentRow : parser) {
        if(smallestSoFar == null){
            smallestSoFar = currentRow;
        }
        else{
            double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
            double smallestTemp = Double.parseDouble(smallestSoFar.get("TemperatureF"));
            if (currentTemp < smallestTemp) {
                smallestSoFar = currentRow;
            }
        }
    }
return smallestSoFar;   
}

public void testColdestHourInFile() {
    FileResource fr = new FileResource ();
    CSVRecord smallest = coldestHourInFile(fr.getCSVParser());
    System.out.println("coldest temperature was" + smallest.get("TemperatureF") + "at" + smallest.get("TimeEST"));
}

 public void fileWithColdestTemperature(){
        CSVRecord coldestSoFar = null;
        DirectoryResource dr = new DirectoryResource();
        File fileName = null;
        
       
        for(File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVParser parser = fr.getCSVParser();
            
            CSVRecord currentFile = coldestHourInFile(parser);
             
            if(coldestSoFar == null){
                 coldestSoFar = currentFile;
                }else{
                double currentTemp = Double.parseDouble(currentFile.get("TemperatureF"));
                double coldestTemp = Double.parseDouble(coldestSoFar.get("TemperatureF"));
                
                if(currentTemp < coldestTemp && currentTemp > -9999){
                    coldestSoFar = currentFile;
                    fileName = f;
                }
                
            }
        }       
        System.out.println("Coldest temperature on that day was: " + coldestSoFar.get("TemperatureF")); 
        System.out.println("Coldest day was in file" + fileName.getPath());   
                  
      
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

public void testlowestHumidityInFile() {
    FileResource fr = new FileResource ();
    CSVRecord smallest = lowestHumidityInFile(fr.getCSVParser());
    System.out.println("lowest humidity was" + smallest.get("Humidity") + "at" + smallest.get("DateUTC"));
}



    public void averageTempInFile() {
        FileResource storage = new FileResource();
        CSVParser parser = storage.getCSVParser();
        double humidity = 0;
        double sumTemp = 0;
        double avgTemp = 0;
        int count = 0;
        for (CSVRecord currentRow : parser) {
            String currentTemp = currentRow.get("TemperatureF");
            String humScore = currentRow.get("Humidity");
            double currTemp = Double.parseDouble(currentTemp);
            double currHumidity = Double.parseDouble(humScore);
            if (currTemp > 0 &&  currHumidity >= 80) {
                count +=1;
                sumTemp += currTemp;
            }
        }
        avgTemp = sumTemp / count;
        System.out.println(avgTemp);
    } 
    
}


    