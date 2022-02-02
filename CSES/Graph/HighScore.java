import java.util.*;
import java.io.*;

public class CSESGraph {
    //static int dist[]= new int[0];
    static int INF=1000000001;
    static int NINF=-1*INF;

    static class Node{
        int u,v,weight;
        Node(int u, int v, int weight)
        {
            this.u=u;
            this.v=v;
            this.weight=weight;
        }
        public int getU()
        {
            return u;
        }
        public int getV()
        {
            return v;
        }
        public int getWt()
        {
            return weight;
        }
    }
    static void bellman_ford(int[] dist, ArrayList<Node> edges,int n)
    {
        for(int i = 1; i < n; ++i)
        {
            for(Node e: edges)
            {
                int u = e.getU();
                int v = e.getV();
                int d = e.getWt();
                if(dist[u] == INF) continue;
                dist[v] = Math.min(dist[v], d+dist[u]);
                dist[v] = Math.max(dist[v], NINF);
            }
        } // n-1 relaxations

        for(int i = 1; i < n; ++i)
        {
            for(Node e: edges)
            {
                int u = e.getU();
                int v = e.getV();
                int d = e.getWt();
                if(dist[u] == INF) continue;
                dist[v] = Math.max(dist[v], NINF);
                if(dist[u]+d < dist[v]) // if after n-1 relaxations, still value decrementing, it mans there is a -ve cycle
                {
                    dist[v] = NINF;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] dist= new int[n+1];
        ArrayList<Node> edges= new ArrayList<>();

        for(int i = 0; i < m; ++i)
        {
            st = new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            c *= -1;
            edges.add(new Node(a,b,c));
        }

        for(int i = 2; i <= n; ++i)
        {
            dist[i] = INF;
        }

        bellman_ford(dist,edges,n);
        if(dist[n] == NINF || dist[n]>=INF)
        {
            System.out.println(-1);
        }
        else
            System.out.println(dist[n] * (-1));
    }
}
