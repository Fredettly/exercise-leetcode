import java.util.Arrays;

/**
 * Created by xwx_ on 2020/1/23
 */
public class reverse_integer {

        public static int reverse(int x) {
            long n = 0;
            while(x != 0){
                n = n*10 + x%10;
                x = x/ 10;
            }
            return (int)n==n? (int)n:0;
        }
    public static void main(String[] args) {
            int x= 123;
        System.out.println(reverse(x));
    }
    }
