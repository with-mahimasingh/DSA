import java.util.*;
import java.io.*;

public class CSESGraph {

    public static void shortestPath(ArrayList<Integer>[] adj, boolean[] vis, int[] before,int src, int n)
    {
        Queue<Integer> q= new LinkedList<>();
        vis[src]=true;
        before[src]=src;
        q.add(src);
        while(!q.isEmpty())
        {
            int node=q.poll();
            vis[node]=true;
            if(node==n) break;
            for(int it: adj[node])
            {
                if(!vis[it])
                {
                    q.add(it);
                    vis[it]=true;
                    before[it]=node;
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
        ArrayList<Integer>[] adj =new ArrayList[n+1];
        for(int i=0;i<=n;i++) adj[i]=new ArrayList<>();
        for (int j = 0; j < m; j++)
        {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }

        boolean[] vis= new boolean[n+1];
        int[] before= new int[n+1];
        shortestPath(adj,vis,before,1,n);
        //System.out.println(Arrays.toString(vis)+" "+Arrays.toString(before));
        if(!vis[n])
            System.out.println("IMPOSSIBLE");
        else
        {
            ArrayList<Integer> path = new ArrayList<Integer>();
            path.add(n);
            int v = before[n];
            while(v != 1) {
                path.add(v);
                v = before[v];
            }
            path.add(1);

            System.out.println(path.size());
            Collections.reverse(path);
            for(int i:path)
                System.out.print(i+" ");
        }

        out.close();
    }
}
