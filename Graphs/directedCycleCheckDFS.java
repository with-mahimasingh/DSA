import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for(int i = 0; i < V+1; i++)
                list.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if(new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else System.out.println("0");
        }
    }
}// } Driver Code Ends


/*Complete the function below*/

class Solution 
{
    //Function to detect cycle in a directed graph.
    public boolean checkCycle(int node, ArrayList<ArrayList<Integer>> adj, int[] vis, int[] dfsVis)
    {
        if(dfsVis[node]==1) return true;
        if(vis[node]==1) return false;
        
        vis[node]=1;
        dfsVis[node]=1;
        for(Integer it: adj.get(node))
        {
            if(checkCycle(it,adj,vis,dfsVis))
                return true;
        }
        dfsVis[node]=0; //backtrack
        return false;
    }
    
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // code here
        int[] vis= new int[V];
        int[] dfsVis= new int[V];

        for(int i=0;i<V;i++)
        {
                if(checkCycle(i,adj,vis,dfsVis))
                  return true;
        }
        return false;
    }
    
}
