import java.util.*;
import java.io.*;

public class CSESGraph {
    static int dist[]= new int[0];

    static class Pair{
        int v,weight;
        Pair(int v, int weight)
        {
            this.v=v;
            this.weight=weight;
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

    static void dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
       
        dist= new int[V+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[S]=0;
        PriorityQueue<Pair> pq= new PriorityQueue<>((a,b)-> a.weight-b.weight);
        pq.add(new Pair(S, dist[S]));
        while(!pq.isEmpty())
        {
            int u=pq.poll().getV();
            for(ArrayList<Integer> ls :adj.get(u))
            {
                int v = ls.get(0);
                int weight = ls.get(1);

                if(dist[v]>dist[u]+weight)
                {
                    dist[v] = dist[u]+weight;
                    pq.add(new Pair(v, dist[v]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m =Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<ArrayList<Integer>>> adj =new ArrayList<>();
        for(int i=0;i<=n;i++)
            adj.add(i,new ArrayList<>());
        for (int j = 0; j < m; j++)
        {
            st = new StringTokenizer(br.readLine());
            long u = Long.parseLong(st.nextToken());
            long v = Long.parseLong(st.nextToken());
            long w = Long.parseLong(st.nextToken());
            ArrayList<Integer> child= new ArrayList<>();
            child.add((int) v);child.add((int) w);
            adj.get((int) u).add(child);
        }
        dijkstra(n,adj,1);
        for(int i = 1; i <=n; ++i )
            System.out.print(dist[i]+" ");


        out.close();
    }
}
