import java.util.*;

public class exercise2 {
    public static void main(String[] args){
        //Anagrams
        //Check for anagrams in a list of words.

        //Takes in a default list of words.
        List<String> input = Arrays.asList("vase", "bat", "gods", "latte", "name", "apres", "spit", "joke", "ham", "dog", "act","tale", "parse", "pits", "asper", "tab" ,"table", "mane", "late", "god", "cat"
        ,"table", "save", "spare");

        for(int i = 0; i < input.size(); i ++){
            for(int j = i + 1; j < input.size(); j++){
                String s1 = input.get(i); 
                String s2 = input.get(j);
                if(isAnagram(s1, s2)){
                    System.out.println(s1 + " " + s2);
                }
            }
        }

    }

    public static boolean isAnagram(String word1, String word2) {

        if (word1.length() != word2.length()) {
            return false; // improves efficiency slightly.
        }
        int[] characterMap = new int[26];
        Arrays.fill(characterMap, 0);

        for (char c : word1.toCharArray()) {
            characterMap[c - 'a']++; // takes count of each character in a word.
        }

        for (char c : word2.toCharArray()) {
            characterMap[c - 'a']--;
        }

        for (int n : characterMap) {
            if (n != 0) {
                return false; // incorrect num of character found
            }
        }

        return true;
    }
}