
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
public String findSimpleGene(String dna){
        String result = "";

		int startCodon = dna.indexOf("ATG"); 	
		int stopCodon = dna.indexOf("TAA");       
 		int startIndex = dna.indexOf("startCodon");  
        if (startIndex == -1){//no ATG 
            return "";
        }
    
        int stopIndex = dna.indexOf("stopCodon",startIndex+3);
        if (stopIndex == -1){ //no TAA
            return "";
        }
    
    result = dna.substring(startIndex,stopIndex+3);
    if ((stopIndex-startIndex)%3 == 0)
    {
        return result;
    }
    else
    {
        return"";
    }
        
    
}

public void testSimpleGene(){
String dna = "AATAGGGAATCTTTAAGAGT";
String startCodon = "ATG";
String stopCodon = "TAA";
System.out.println("DNA strand is" + dna);
String gene = findSimpleGene(dna);
System.out.println("Gene is" + gene);

dna = "AATATGGGAATCTTTGAGT";
startCodon = "ATG";
stopCodon = "TAA";
System.out.println("DNA strand is" + dna);
gene = findSimpleGene(dna);
System.out.println("Gene is" + gene);

dna = "AATAGGGAATCTTTGAGT";
startCodon = "ATG";
stopCodon = "TAA";
System.out.println("DNA strand is" + dna);
gene = findSimpleGene(dna);
System.out.println("Gene is" + gene);

dna = "AATATGGGAATCTAATTGAGT";
startCodon = "ATG";
stopCodon = "TAA";
System.out.println("DNA strand is" + dna);
gene = findSimpleGene(dna);
System.out.println("Gene is" + gene);

dna = "AATATGGGAATTAATTGAGT";
startCodon = "ATG";
stopCodon = "TAA";
System.out.println("DNA strand is" + dna);
gene = findSimpleGene(dna);
System.out.println("Gene is" + gene);
}
}


