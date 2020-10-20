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

    public int[] squares(int[] A){
        if (A.length == 0){
            return null;
        }
        int i = 0, j=0;
        while (i < A.length && A[i] < 0){
            i++;
        }
        int[] res = new int[A.length];
        int left = i-1;
        int right = i;

        while (left >= 0 && right < A.length){
            if ((A[left]*A[left]) > (A[right]*A[right])){
                res[j] = A[right]*A[right];
                right++;
            }else {
                res[j] = A[left]*A[left];
                left--;
            }
            j++;
        }

        while (left >= 0){
           res[j] = A[left]*A[left];
           left--;
           j++;
        }
        while (right < A.length){
            res[j] = A[right]*A[right];
            right++;
            j++;
        }
        return res;
    }

    public static void main(String[] args) {
        SortedSquares sortedSquares = new SortedSquares();
        int[] A = {0,2};
        //int[] res = sortedSquares.sortedSquares(A);
        //System.out.println(A);
        int[] res = sortedSquares.squares(A);
        for (int a: res
             ) {
            System.out.print(a+",");
        }
    }
}
