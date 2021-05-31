//Problem: Coin Combinations II (1636)
//Link: https://cses.fi/problemset/task/1636
//Approach: Bottom Up

import java.io.*;
import java.util.*;

public class coincombinations2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int sum = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] coins = new int[n];
        for (int i = 0; i < n; i++)
            coins[i] = Integer.parseInt(st.nextToken());

        int[][]dp = new int[n+1][sum + 1];

        for(int i=0;i<n+1;i++)
            dp[i][0]=1;
        for(int j=1;j<sum+1;j++)
            dp[0][j]=0;

        for (int i = 1; i <n+1; i++) {
            for (int j = 1; j < sum+1; j++)
              if(j-coins[i-1]>=0)
                  dp[i][j]= (dp[i-1][j]+dp[i][j-coins[i-1]])%1000000007;
              else
                  dp[i][j]=dp[i-1][j]%1000000007;
        }
        System.out.println(dp[n][sum]);
    }
}
