
/**
 * Write a description of totalBirths here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;

public class TotalBirthsAssign1{

public void totalBirths (FileResource fr){
        int totalbirths = 0; int totalboys = 0; int totalgirls = 0;
        for(CSVRecord rec: fr.getCSVParser(false)){
            int newborn = Integer.parseInt(rec.get(2));
            totalbirths+= newborn;
            if(rec.get(1).equals("M")){
                totalboys+=newborn;
            }
            else{
                totalgirls+=newborn;
            }
        } 
        System.out.println("Total number of 'Girls' born are= "+totalgirls);
        System.out.println("Total number of 'Boys' born are= "+totalboys);
        System.out.println("Total number of 'Births' are= "+totalbirths);
    }
    
    public void test_total_births(){
        FileResource fr = new FileResource();
        totalBirths(fr);
    }
}