package Solutions;


public class CharacterReplacement {

    /**
     * @author: zengleiyixiao
     * @description: TODO
     * @date: 2020-09-07 11:54
     * @param s, k
     * @return length
     */
    public int characterReplacement(String s, int k) {
        if ("".equals(s)){
            return 0;
        }
        char[] S = s.toCharArray();
        int[] chars = new int[26];
        int left = 0, right = 0;
        int max = 0;
        int res = 1;
        chars[S[0]-65]++;

        while (right < s.length() - 1){
            right++;
            chars[S[right] - 65]++;
            max = this.getMax(chars);
            if (right - left+1-max <=k){
                res = Math.max(res, right-left+1);
            }else{
                chars[S[left]-65]--;
                left++;
            }
        }
        return res;
    }

    private int getMax(int[] chars) {
       int max = 0;
       for (int i = 0; i < chars.length; i++){
           max = Math.max(max, chars[i]);
       }
       return max;

    }

    public static void main(String[] args) {
        CharacterReplacement characterReplacement = new CharacterReplacement();
        int res = characterReplacement.characterReplacement("ABAA", 0);
        System.out.println(res);
    }
}