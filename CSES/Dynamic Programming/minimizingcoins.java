//Problem: Minimizing Coins (1634)
//Link:  https://cses.fi/problemset/task/1634/
//Based on: Unbounded Knapsack

/*____________________ 2D Solution: _________________*/
import java.io.*;

public class minimizingcoins {
    static final int INF=0x3f3f3f3f;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] l1 = br.readLine().trim().split(" ");
        String[] l2 = br.readLine().trim().split(" ");

        int n = Integer.parseInt(l1[0]);
        int sum = Integer.parseInt(l1[1]);

        int[] coins = new int[n];

        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(l2[i]);
        }
        int[][] dp = new int[n + 1][sum + 1];

        for (int i = 1; i < n + 1; i++) {
           dp[i][0]=0;
        }
        for (int j = 0; j < sum + 1; j++) {
            dp[0][j]=INF;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (j-coins[i - 1]>=0)
                    dp[i][j] = Math.min(1+dp[i][j - coins[i - 1]], dp[i - 1][j]);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
            System.out.println(dp[n][sum]==INF?-1:dp[n][sum]);

    }
}


/*____________________ 1D Solution: _________________
import java.io.*;
import java.util.Arrays;
 
public class minimizingcoins {
    static final int INF=0x3f3f3f3f;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        String[] l1 = br.readLine().trim().split(" ");
        String[] l2 = br.readLine().trim().split(" ");
 
        int n = Integer.parseInt(l1[0]);
        int sum = Integer.parseInt(l1[1]);
 
        int[] coins = new int[n];
 
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(l2[i]);
        }
        int[]dp = new int[sum + 1];
        Arrays.fill(dp,INF);
        dp[0]=0;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                    if(j-coins[i-1]>=0)
                    dp[j]= Math.min(1+dp[j - coins[i-1]], dp[j]);
            }
        }
        System.out.println(dp[sum]==INF?-1:dp[sum]);
 
    }*/
}
