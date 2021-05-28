//Problem: Dice Combinations (1633)
//Link: https://cses.fi/problemset/task/1633/
//Based on: Unbounded Knapsack
import java.io.*;
import java.util.*;
 
public class dicecombination {
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        Arrays.fill(dp,0);
        dp[0]=1;
 
        for(int i=1;i<=n;i++)
        {
            for(int outcome=1;outcome<=6;outcome++)
            {
                if(outcome>i)
                    break;
                dp[i]=(dp[i]%1000000007+dp[i-outcome]%1000000007)%1000000007;
            }
        }
        System.out.println(dp[n]);
    }
}
