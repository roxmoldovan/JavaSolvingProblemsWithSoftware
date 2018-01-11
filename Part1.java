
/**
 * Write a description of Part1 here.
 * 
 * @author (Roxana Moldovan) 
 * @version (1.0, 7/20/2017)
 */

//Write the method findSimpleGene that has one String parameter dna, representing a string of DNA. This method does the following:

//Finds the index position of the start codon “ATG”. If there is no “ATG”, return the empty string.
//Finds the index position of the first stop codon “TAA” appearing after the “ATG” that was found. If there is no such “TAA”, return the empty string.
//If the length of the substring between the “ATG” and “TAA” is a multiple of 3, then return the substring that starts with that “ATG” and ends with that “TAA”.

public class Part1 {
    
    public String findSimpleGene(String dna){
        String result = "";
        int startIndex = dna.indexOf("ATG");  
        if (startIndex == -1){//no ATG 
            return "";
        }
    
        int stopIndex = dna.indexOf("TAA",startIndex+3);
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
System.out.println("DNA strand is" + dna);
String gene = findSimpleGene(dna);
System.out.println("Gene is" + gene);

dna = "AATATGGGAATCTTTGAGT";
System.out.println("DNA strand is" + dna);
gene = findSimpleGene(dna);
System.out.println("Gene is" + gene);

dna = "AATAGGGAATCTTTGAGT";
System.out.println("DNA strand is" + dna);
gene = findSimpleGene(dna);
System.out.println("Gene is" + gene);

dna = "AATATGGGAATCTAATTGAGT";
System.out.println("DNA strand is" + dna);
gene = findSimpleGene(dna);
System.out.println("Gene is" + gene);

dna = "AATATGGGAATTAATTGAGT";
System.out.println("DNA strand is" + dna);
gene = findSimpleGene(dna);
System.out.println("Gene is" + gene);
}
}