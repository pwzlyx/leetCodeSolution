package Solutions.subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.educative.io/courses/grokking-the-coding-interview/NEXBg8YA5A2
 * For a given number ‘N’, write a function to generate all combination of ‘N’ pairs of balanced parentheses.
 *
 */
class ParenthesesString {
    String str;
    int openCount;
    int closeCount;

    public ParenthesesString(String s, int openCount, int closeCount) {
        str = s;
        this.openCount = openCount;
        this.closeCount = closeCount;
    }
}

public class GenerateParentheses {
    public static List<String> generateValidParentheses(int num) {
        List<String> result = new ArrayList<String>();
        // TODO: Write your code here
        if (num==0){
            return result;
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> result = GenerateParentheses.generateValidParentheses(2);
        System.out.println("All combinations of balanced parentheses are: " + result);

        result = GenerateParentheses.generateValidParentheses(3);
        System.out.println("All combinations of balanced parentheses are: " + result);
    }
}
