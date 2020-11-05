package Solutions;

public class HappyNumber {

    public boolean isHappy(int n){

        int slow = n;
        int fast = n;
        while (slow != 1 && fast != 1){
            slow = sumSqure(slow);
            fast = sumSqure(sumSqure(fast));
            if (slow == fast && slow !=1){
                return false;
            }
        }
        return true;

    }

    public int sumSqure(int n) {
        int res = 0;
        while (n != 0){
            int a = n%10;
            res += a*a;
            n = n/10;
        }
        return res;
    }

    public static void main(String[] args) {
        HappyNumber happyNumber = new HappyNumber();
        System.out.println(happyNumber.sumSqure(555));
    }
}
