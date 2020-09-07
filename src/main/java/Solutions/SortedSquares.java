package Solutions;

public class SortedSquares {
    public int[] sortedSquares(int[] A) {
        if (A.length == 0){
            return null;
        }
        if (A.length == 1){
            int[] res = {A[0]*A[0]};
            return res;
        }
        int[] res = new int[A.length];
        int right = A.length/2;
        int left = right-1;
        int index = 0;
        for (int i = 0; i < A.length; i++){
            if (left == -1 || right == A.length){
                index = i;
                break;
            }
            if (Math.abs(A[left]) < Math.abs(A[right])){
                res[i] = A[left]*A[left];
                left--;
            }else{
                res[i] = A[right]*A[right];
                right++;
            }
        }
        if (left == -1){
            for (; index < A.length; index++, right++){
                res[index] = A[right]*A[right];
            }
        }else {
            for (; index < A.length; index++,left--){
                res[index] = A[left]*A[left];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SortedSquares sortedSquares = new SortedSquares();
        int[] A = {4,-1,0,3,10};
        int[] res = sortedSquares.sortedSquares(A);
        System.out.println(A);
    }
}
