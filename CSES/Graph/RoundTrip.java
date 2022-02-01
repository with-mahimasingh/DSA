//Task: 1669

import java.util.*;
import java.io.*;
 
public class CSESGraph {
   static  long start, end;
    static boolean dfs(long u, long p, boolean[]vis, long[]parent, ArrayList<Long>[]adj)
    {
        vis[(int) u] = true;
        parent[(int) u] = p;
        for(Long v: adj[(int) u])
        {
            if(v == p) continue;
            if(!vis[Math.toIntExact(v)]) {
                if (dfs(v, u, vis, parent, adj))
                    return true;
 
            }
            else if (v != p)
            { start =v; end=u;return true;}
        }
        return false;
    }
 
 
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m =Integer.parseInt(st.nextToken());
        ArrayList<Long>[] adj =new ArrayList[n+1];
        for(int i=0;i<=n;i++) adj[i]=new ArrayList<>();
        for (int j = 0; j < m; j++)
        {
            st = new StringTokenizer(br.readLine());
            long u = Long.parseLong(st.nextToken());
            long v = Long.parseLong(st.nextToken());
            adj[(int) u].add(v);
            adj[(int) v].add(u);
        }
        //ArrayList<Integer> route= new ArrayList<>();
        boolean[] vis= new boolean[n+1];
        long[]parent= new long[n+1];
 
        boolean flag=false;
        for(int i=1;i<=n;i++)
            if(!vis[i])
            {
                if(dfs(i,-1,vis,parent,adj))
                {flag=true; break;}
            }
        if(!flag)
            System.out.println("IMPOSSIBLE");
        else
        {
            long tv = end;
            ArrayList<Long> ans= new ArrayList<>();
            ans.add(end);
            while(tv != start)
            {
                ans.add(parent[(int) tv]);
                tv = parent[(int) tv];
            }
            ans.add(end);
            System.out.println(ans.size());
            for(long c: ans)
            {
                System.out.print(c + " ");
            }
        }
 
        out.close();
    }
}
