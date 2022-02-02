import java.util.*;
import java.io.*;
 
public class CSESGraph {
    //static int dist[]= new int[0];
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
 
        int[][]g= new int[n+1][n+1];
 
        for (int i = 1; i <= n; ++i) {
            for (int j = i + 1; j <= n; ++j) {
                g[i][j] = g[j][i] = Integer.MAX_VALUE;
            }
        }
 
        for (int i = 0; i < m; ++i) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
 
            g[u][v] = g[v][u] = Math.min(g[u][v], c);
        }
 
        for (int k = 1; k <= n; ++k) {
            for (int i = 1; i <= n; ++i) {
                for (int j = 1; j <= n; ++j) {
                    if (g[i][k] == Integer.MAX_VALUE || g[k][j] == Integer.MAX_VALUE)
                        continue;
                    g[i][j] = Math.min(g[i][j], g[i][k] + g[k][j]);
                }
            }
        }
 
        for (int i = 0; i < q; ++i) {
            st = new StringTokenizer(br.readLine());
 
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
 
            if (g[u][v] == Integer.MAX_VALUE)
                g[u][v] = -1;
           System.out.println(g[u][v]);
        }
    }
}
