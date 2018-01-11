

/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;

public class Part1 {
    
    public int findStopCodon (String dnaStr, int startIndex, String stopCodon){
    //find stopCodon starting from (startIndex+3, currIndex)
    int currIndex = dnaStr.indexOf (stopCodon, startIndex+3);
    while (currIndex != -1) {
        int diff = currIndex-startIndex;
        if (diff%3 == 0){
        return currIndex;
        // check if currIndex - startIndex is a multiple of 3
    }
    else {
        currIndex = dnaStr.indexOf(stopCodon, currIndex+1);
    }
        
     }
    return dnaStr.length();
    }

    public String findGene (String dna, int where){
        int startIndex = dna.indexOf("ATG", where);
        if (startIndex == -1){
        return "";
    }
    int taaIndex = findStopCodon (dna, startIndex, "TAA");
    int tagIndex = findStopCodon (dna, startIndex, "TAG");
    int tgaIndex = findStopCodon (dna, startIndex, "TGA");
    int temp = Math.min (taaIndex, tagIndex);
    int minIndex = 0;
    if (taaIndex != -1 ||
        (tgaIndex != -1 && tgaIndex < taaIndex)){
    minIndex=tgaIndex;
}
    else{
        minIndex=taaIndex;
    }
    if (minIndex== -1||
    (tagIndex != -1 && tagIndex < minIndex)){
        minIndex=tagIndex;
    }
    if (minIndex == -1){
            return "";
    }
    
    return dna.substring (startIndex, minIndex+3);
}
    public void testFindStopCodon() {
    String dna = "xxxyyyzzzTAAxxxyyyzzzTAAzz";
    int dex = findStopCodon(dna, 0, "TAA");
    if (dex!=9) System.out.println("error on 9");
    dex = findStopCodon (dna, 9,"TAA");
    if (dex!=21) System.out.println("error on 21");
    System.out.println ("all tests are finished");
}
public void testFindGene(){
     int startIndex = 0;
String dna = "AATAGGGAATCTTTAAGAGT";
System.out.println("DNA strand is" + dna);
String gene = findGene(dna, startIndex);
System.out.println("Gene is" + gene);

dna = "AATATGGGAATCTAATTGAGT";
System.out.println("DNA strand is" + dna);
gene = findGene(dna, startIndex);
System.out.println("Gene is" + gene);

dna = "AATATGGGAATCTTGTAGGGATGA";
System.out.println("DNA strand is" + dna);
gene = findGene(dna, startIndex);
System.out.println("Gene is" + gene);

dna = "AATATGGGAATCTTGTAGGATGA";
System.out.println("DNA strand is" + dna);
gene = findGene(dna, startIndex);
System.out.println("Gene is" + gene);
}
public void printAllGenes(String dna){
     int startIndex = 0;
        while(true){
            //Find first gene.
            String gene = findGene(dna, startIndex);
            //If false, break.
            if (gene.isEmpty()){
                break;
            }
            //Else print gene.
            System.out.println(gene);  

            //Up startIndex +1
            startIndex = dna.indexOf(gene, startIndex) + gene.length();
            
}
}
public StorageResource getAllGenes(String dna){
    StorageResource geneList = new StorageResource();
     int startIndex = 0;
        while(true){
            //Find first gene.
            String gene = findGene(dna, startIndex);
            //If false, break.
            if (gene.isEmpty()){
                break;
            }
            geneList.add(gene);
            //Up startIndex +1
            startIndex = dna.indexOf(gene, startIndex) + gene.length();
            
}
return geneList;
}
public void testOn(String dna){
    System.out.println("Testing getAllGenes on" + dna);
    StorageResource genes = getAllGenes (dna);
    for (String g: genes.data()) {
        System.out.println(g);
}
}
public void test (){
    testOn ("ATGGGGTAATAG");
}
}

