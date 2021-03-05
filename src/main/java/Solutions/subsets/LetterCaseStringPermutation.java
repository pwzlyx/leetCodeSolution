package Solutions.subsets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://www.educative.io/courses/grokking-the-coding-interview/xVlKmyX542P
 * Given a string, find all of its permutations preserving the character sequence but changing case.
 */
public class LetterCaseStringPermutation{
    public static List<String> findLetterCaseStringPermutations(String str) {
        List<String> permutations = new ArrayList<>();
        Queue<List<Character>> strList = new LinkedList<>();
        strList.offer(new ArrayList<>());
        char[] chars = str.toCharArray();
        for (char nowChar: chars
             ) {
            int n = strList.size();
            for (int i =0;i < n;i++){
                List<Character> oldList = strList.poll();
                if (Character.isDigit(nowChar)){
                    oldList.add(nowChar);
                    if (oldList.size() == str.length()){
                        permutations.add(oldList.toString());
                    }else{
                        strList.offer(oldList);
                    }
                }else{
                    List<Character> newList1 = new ArrayList<>(oldList);
                    List<Character> newList2 = new ArrayList<>(oldList);
                    newList1.add(nowChar);
                    char newChar = Character.isLowerCase(nowChar) ? Character.toUpperCase(nowChar) : Character.toLowerCase(nowChar);
                    newList2.add(newChar);
                    if (newList1.size() == str.length()){
                        permutations.add(newList1.toString());
                        permutations.add(newList2.toString());
                    }else{
                        strList.offer(newList1);
                        strList.offer(newList2);
                    }
                }
            }
        }
        return permutations;
    }

    public static void main(String[] args) {
        List<String> result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ad52");
        System.out.println(" String permutations are: " + result);

        result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ab7c");
        System.out.println(" String permutations are: " + result);
    }
}
