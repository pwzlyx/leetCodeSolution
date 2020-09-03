package Solutions;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstringKDistinct {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<Character, Integer>(k);
        int start = 0;
        int end = 0;
        int max = 1;
        for (int i = 0; i < chars.length; i++){
            end++;
            char nowChar = chars[end];
            map.put(nowChar, end);
            if (map.size() > k){
               int hashValue = Collections.min(map.values());
               start = hashValue + 1;
               map.remove(chars[hashValue]);
            }
        }
        max = Math.max(max, end-start+1);
        return max;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstringKDistinct lengthOfLongestSubstringKDistinct = new LengthOfLongestSubstringKDistinct();
        int res = lengthOfLongestSubstringKDistinct.lengthOfLongestSubstringKDistinct("abbba", 1);
        System.out.println(res);
    }
}
