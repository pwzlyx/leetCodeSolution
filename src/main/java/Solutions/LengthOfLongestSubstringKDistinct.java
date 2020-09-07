package Solutions;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LengthOfLongestSubstringKDistinct {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if ("".equals(s)){
            return 0;
        }
        if (k == 0){
            return 0;
        }
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<Character, Integer>(k);
        int start = 0;
        int end = 0;
        int max = 1;
        map.put(chars[0], 0);
        while (end < chars.length-1){
            end++;
            char nowChar = chars[end];
            map.put(nowChar, end);
            if (map.size() > k){
                int hashValue = Collections.min(map.values());
                start = hashValue + 1;
                map.remove(chars[hashValue]);
            }
            max = Math.max(max, end-start+1);
        }
        return max;
    }

    public int lengthOfLongestSubstringKDistinct4LinkedMap(String s, int k){
        if ("".equals(s) || k == 0){
            return 0;
        }
        char[] chars = s.toCharArray();
        int start = 0;
        int end = 0;
        int max = 1;
        Map<Character, Integer> map = new LinkedHashMap<Character, Integer>(k+1);
        map.put(chars[0], 0);
        while (end < chars.length - 1){
            end++;
            char nowChar = chars[end];
            if (map.containsKey(nowChar)) {
                map.remove(nowChar);
            }
            map.put(nowChar, end);
            if (map.size() > k){
                Map.Entry<Character, Integer> left = map.entrySet().iterator().next();
                map.remove(left.getKey());
                start = left.getValue()+1;
            }
            max = Math.max(max, end-start+1);
        }
        return max;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstringKDistinct lengthOfLongestSubstringKDistinct = new LengthOfLongestSubstringKDistinct();
        int res = lengthOfLongestSubstringKDistinct.lengthOfLongestSubstringKDistinct("AAAA", 1);
        System.out.println(res);
    }
}
