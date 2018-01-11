
/**
 * Write a description of getRankAssign2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class getRankAssign2_3 {    
public int getRank(int year, String name, String gender){
    int rank = 0;
    FileResource fr = new FileResource("us_babynames/us_babynames_by_year/yob"+year+".csv");
 
    for (CSVRecord rec : fr.getCSVParser(false)){
        if (rec.get(1).equals(gender)){
        rank = rank+1;
    }
    
    if(rec.get(0).equals(name)){
        break;
    }
             }
         System.out.println(rank);
 
return rank;
}
public void testGetRank() {
        System.out.println(getRank(1881, "Alice", "F"));
    }
    
    public String getName(int year, int rank, String gender){
        FileResource fr = new FileResource("us_babynames/us_babynames_by_year/yob"+year+".csv");
        String name = "NO NAME";
        int currentRank = 0;
         //for each name in the file, determine its rank
        for (CSVRecord rec : fr.getCSVParser(false)){

            //for each name in the list, get the rank
            currentRank = getRank(year, rec.get(0), gender);
            
            //is the rank for the current name same as the input rank?
            if(rank == currentRank){
                name = rec.get(0);
            }
               
         }
            return name;
         }
         
         public void testGetName() {
        System.out.println(getName(1881,3, "F"));
        }
        
        
    
    public int yearOfHighestRank (String name, String gender) {
        DirectoryResource dr = new DirectoryResource ();
        int maxRank = 0, maxRankYear = 0;
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            for (CSVRecord rec: fr.getCSVParser(false)) {
                if (rec.get(0).equals(name) && rec.get(1).equals(gender)) {
                    // System.out.print ( f.getName() + ">>> Name: " + rec.get(0) +
                    // ", gender: " + rec.get(1) + ", rank: " + rec.get(2));
                    if (Integer.parseInt(rec.get(2)) > maxRank) {
                        maxRankYear = yearFromFileName(f);
                        maxRank = Integer.parseInt(rec.get(2));
                        //System.out.println (" max Rank!");
                    } //else System.out.println();
                }
            }
        }
        return maxRankYear;
    }

    
    public void testYearOfHighestRank() {
        System.out.println(yearOfHighestRank("Mason", "M"));
    }
    
    }
