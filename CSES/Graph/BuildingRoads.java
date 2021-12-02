import java.util.*;
import java.io.*;

public class CSESGraph {

    public static void dfs(Integer node,ArrayList<Integer>[] adj, boolean[] vis)
    {
        vis[node]=true;
        for(Integer it: adj[node])
        {
            if(!vis[it])
                dfs(it,adj,vis);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m =Integer.parseInt(st.nextToken());
        ArrayList<Integer> adj[]=new ArrayList[n+1];
        for(int i=0;i<=n;i++) adj[i]=new ArrayList<>();
        for (int j = 0; j < m; j++)
        {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }
        int c=0;
        boolean[] vis= new boolean[n+1];
        ArrayList<Integer> join=new ArrayList<>();
        for(int i=1;i<=n;i++) {
            if (!vis[i]) {
                dfs(i, adj, vis);
                c++;
                join.add(i);
            }
        }
        out.println(c-1);
        for(int i=1;i<join.size();i++)
            out.print(join.get(i-1)+" "+join.get(i)+"\n");

        out.close();
    }
}
