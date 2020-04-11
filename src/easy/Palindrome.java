/**
 * Created by xwx_ on 2020/1/26
 */
public class Palindrome {
    private static boolean isPalindrome(int x){
        int theNum = x ;
        if (x == 0){
            return true;
        }
        if (x < 0 || (x % 10) ==0) {
            return false;
        }
        int temp = 0;
        while (x != 0){
            temp = temp * 10 + x % 10;
            x /= 10;
        }
        return theNum == temp;
    }
    public static void main(String[] args){
        int x = 102343201;
        System.out.println(isPalindrome(x));
    }
}
