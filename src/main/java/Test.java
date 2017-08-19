import java.util.*;


public class Test {

    public static void main(String args[]){
        String str = "caterpiller";
        Set<String> words = new HashSet<>();
        words.add("cat");
        words.add("dog");
        words.add("cater");
        words.add("piller");
        words.add("caterpiller");

        String temp = "";
        List<String> wordsFound = new ArrayList<>();
        for (int i=0;i<str.length();i++){
            temp = temp + str.charAt(i);
            boolean contains = words.contains(temp);
            if(contains){
                wordsFound.add(temp);
                temp = "";
            }
        }

        System.out.println(wordsFound);
    }
}
