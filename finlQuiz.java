
/**
 * Write a description of finalQuiz here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
    import edu.duke.*;

public class finlQuiz {
	public void processGenes(StorageResource sr)	{	
	    int c9=0,cg=0;		
	    String max="";		
	    for(String item:sr.data())		{		
	        if(item.length()>=60)			
	        {c9++;
	           }			
	        if(item.length()>max.length())				
	        max=item;}		
	        System.out.println("Greater than 60 :"+c9);		
	        for(String item:sr.data())		
	        {			
	        if(cgRatio(item)>=0.35)			
	        {
	        cg++;} }		
	        System.out.println("CG Ratio :"+cg);		
	        System.out.println("Max length"+max.length());    
	       }	
	        
	            
	            public float cgRatio (String dna) {
        int cCount = 0;
        int gCount = 0;
        int index = dna.indexOf("C");
        while(index != -1) {
            cCount++;
            index = dna.indexOf("C", index + 1);
        }
        index = dna.indexOf("G");
        while (index != -1) {
            gCount++;
            index = dna.indexOf("G", index + 1);
        }
        float ratio = (float) cCount / gCount;
        return ratio;
    }
public void processGene(StorageResource sr) {
    int countHighCG = 0;
    for (String gene : sr.data())   {
        if (cgRatio(gene) > 0.35)   {
            countHighCG++;
        }
    }

    System.out.println("Number of genes with CG ratio higher than 0.35: " + countHighCG);
	} 
	public int findStopCodon(String dna, int startIndex, String stopCodon){
        int currIndex = dna.indexOf(stopCodon, startIndex+3);
        while (currIndex != -1){
            int diff = currIndex - startIndex;
            if (diff % 3 == 0){
                return currIndex;
            }
            else {
              currIndex = dna.indexOf(stopCodon, currIndex+1);
            }
        }
        return  -1;
    }
	public String findGene(String dna, int where){
        int startIndex = dna.indexOf("ATG", where);
        if (startIndex == -1){
            return "";
        }
        int taaIndex = findStopCodon (dna, startIndex, "TAA");
        int tagIndex = findStopCodon (dna, startIndex, "TAG");
        int tgaIndex = findStopCodon (dna, startIndex, "TGA");
        int minIndex = 0;
        if (taaIndex == -1 || (tgaIndex != -1 && tgaIndex < taaIndex)){
            minIndex = tgaIndex;
        }
        else{
            minIndex = taaIndex;
        }
        if (minIndex == -1 || (tagIndex != -1 && tagIndex < minIndex)){
            minIndex = tagIndex;
        }
        if (minIndex == -1){
            return "";
        }
        return dna.substring(startIndex, minIndex + 3);
    }
	public void ProcessGenes (StorageResource sr){
        int nCount = 0;
        int rCount = 0;
        int sCount = 0;
        int geneLength = 0;
        String longestGene = "";
        for (String d: sr.data()){
            if (d.length()>9){
                System.out.println("DNA strands longer than 9 characters: " + d);
                nCount = nCount + 1;
                System.out.println("Number of DNA strands longer than 9 characters: " + nCount);
            }
            float ratio = cgRatio(d);
            if (ratio>0.35){
                System.out.println("DNA strands that have a higher CG ration than 0.35: " + d);
                rCount = rCount + 1;
                System.out.println("Number of DNA strands that have a higher CG ration than 0.35: " + rCount);
            }
            if (d.length() > geneLength){
                geneLength = d.length();  
                longestGene = d;
                System.out.println("The Longest Gene in the DNA strand is: " + longestGene);
            }
            if (d.length()>60){
                sCount = sCount+1;
                System.out.println("DNA strands that have 60 or more characters: " + d);
                System.out.println("Number of DNA strands that have 60 or more characters: " + sCount);
            }
        }
    }
    public StorageResource getAllGenes(String dna){
        int startIndex = 0;
        int count = 0;
        StorageResource geneList = new StorageResource();
        while (true){
            String currentGene = findGene(dna, startIndex);
            if (currentGene.isEmpty()){
                break;
            }
            geneList.add(currentGene);
            startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();
            count = count + 1;
        }
        System.out.println("Number of Genes is/are: " + count);
        return geneList;
    }  
	public void testProcessGenesFromFile(){
        URLResource fr = new URLResource("https://users.cs.duke.edu/~rodger/GRch38dnapart.fa");
        String dna = fr.asString().toUpperCase();
        System.out.println("DNA is: " + dna);
        StorageResource geneList = getAllGenes(dna);
        ProcessGenes(geneList);
    }
}
