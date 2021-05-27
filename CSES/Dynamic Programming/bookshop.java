//Book Shop Task 1158
//Based on: 0/1 Knapsack
import java.io.*;
import java.util.*;

class bookshop {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String l1[] = br.readLine().trim().split(" ");
        String l2[] = br.readLine().trim().split(" ");
        String l3[] = br.readLine().trim().split(" ");

        int n = Integer.parseInt(l1[0]);
        int x = Integer.parseInt(l1[1]);

        int price[] = new int[n];
        int pages[] = new int[n];

        for (int i = 0; i < n; i++) {
            price[i] = Integer.parseInt(l2[i]);
            pages[i] = Integer.parseInt(l3[i]);
        }

        int[][] dp = new int[n + 1][x + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < x + 1; j++) {
                if (price[i - 1] > j)
                    dp[i][j] = dp[i - 1][j];

                else
                    dp[i][j] = Math.max(pages[i - 1] + dp[i - 1][j - price[i - 1]], dp[i - 1][j]);
            }
        }
        System.out.println(dp[n][x]);
    }
}
