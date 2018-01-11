
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
public float cgRatio(String dna) {
        int index = 0;
        int sum = 0;
        String one;
        while (index < dna.length()) {
            one = dna.substring(index, index + 1);
            if (one.equals("C") || one.equals("G")) {
                ++sum;
            }
            ++index;
        }
        float l = dna.length();
        return sum / l;
    }
    public void test() {
        System.out.println(cgRatio("ATGCCATAG"));
    }
    public int countCTG(String dna) {
		int startIndex = 0;
		int ctgCount = 0;
		int currIndex = dna.indexOf("CTG", startIndex);
		while (currIndex != -1) {
			currIndex = dna.indexOf("CTG", currIndex + 3);
			ctgCount++;
		} // end while
		return ctgCount;
	} // end countCTG
	public void test2() {
        System.out.println(countCTG("ATGTGCTGCATAG"));
    }
        
}
        
    