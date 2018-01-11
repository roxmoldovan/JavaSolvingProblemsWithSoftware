
/**
 * Write a description of assign2 here.
 * 
 * @author (Roxana Moldovan) 
 * @version (v2)
 */
public class assign2 {
    public void findAbc(String input) {
    int index = input.indexOf("abc");
    while (true) {
        if (index == -1 || index >= input.length() - 3) {
            break;
        }
        //System.out.println("index " + index);
        //code
        //System.out.println("index after updating " + index);
        String found = input.substring(index+1, index+4);
        System.out.println(found);
        index = input.indexOf("abc", index+3);
    }
}
   public void test() {
     //findAbc("abcd");
     //findAbc("abcdabc");
     findAbc("abcabcabcabca");
}
}



 
    