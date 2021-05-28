//Problem: Removing Digits (1637)
import java.io.*;
import java.util.*;

public class removingdigits {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N= Integer.parseInt(br.readLine());
        int[]dp=new int[N+1];
        Arrays.fill(dp,99999999);
        dp[0]=0;
        for(int i=1;i<=N;i++) {
            int temp = i;
            while (temp > 0) {

                dp[i] = Math.min(dp[i], dp[i - temp % 10] + 1);
                temp /= 10;
            }
        }
        System.out.println(dp[N]);
    }
}
