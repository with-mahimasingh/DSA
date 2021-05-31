//Problem: Coin Combinations I (1635)
//Link: https://cses.fi/problemset/task/1635
//Approach: Top Down

import java.io.*;
import java.util.StringTokenizer;

public class coincombinations1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int sum = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] coins = new int[n];
        for (int i = 0; i < n; i++)
            coins[i] = Integer.parseInt(st.nextToken());

        int[] dp = new int[sum + 1];
        dp[0]=1;
        for (int i = 1; i <=sum; i++) {
            long count=0;
            for (int j = 0; j < n; j++)
                if (i >= coins[j])
                    count+=dp[i - coins[j]];

            dp[i]=(int)(count%1000000007);
        }
        System.out.println(dp[sum]);
    }
}
