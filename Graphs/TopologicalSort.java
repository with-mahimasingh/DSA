/*There are two approach two solve this question.

1-> DFS approach
* Take a stack, and start traversing the graph in DFS way.
* Once you have visited all the adjacent node of that node, push it into the stack.
* Take care of visited nodes. If u have visited that node already, don't visit it again.
* Pop all the element of the stack and store them in an array, and return them. */

//________________DFS____________________

import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String st[] = read.readLine().trim().split("\\s+");
            int edg = Integer.parseInt(st[0]);
            int nov = Integer.parseInt(st[1]);

            for (int i = 0; i < nov + 1; i++)
                list.add(i, new ArrayList<Integer>());

            int p = 0;
            for (int i = 1; i <= edg; i++) {
                String s[] = read.readLine().trim().split("\\s+");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                list.get(u).add(v);
            }

            int[] res = new Solution().topoSort(nov, list);

            if (check(list, nov, res) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
    static boolean check(ArrayList<ArrayList<Integer>> list, int V, int[] res) {
        
        if(V!=res.length)
        return false;
        
        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res[i]] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : list.get(i)) {
                if (map[i] > map[v]) return false;
            }
        }
        return true;
    }
}
// } Driver Code Ends


/*Complete the function below*/


class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        Stack<Integer> s= new Stack<>();
        int vis[]= new int[V];
        
        for(int i=0;i<V;i++)
        {
            if(vis[i]==0) //not visited
            {
                findTopo(i,vis,adj,s);
            }
        }
        int ans[]= new int[V];
        int i=0;
        while(!s.isEmpty())
        {
            ans[i++]=s.pop();
        }
        return ans;
    }
    
     static void findTopo(int node, int[] vis, ArrayList<ArrayList<Integer>> adj, Stack<Integer> s)
     {
         vis[node]=1;
         
         for(Integer it: adj.get(node))
         {
             if(vis[it]==0)
                findTopo(it,vis,adj,s);
         }
         s.push(node);
     }
   
}

/*2-> BFS approach (Kahn's)
* calculate the indegree and outdegree of every node.
* Take a queue, and push all the node which have indegree zero( because we can't back to this node again).
* If there is no node of degree zero, there would be cycle, so topological sorting is not possible.
* Now we traverse the queue, and pop out element one by one, all the node which are adjacent to it, decrease there indegree by one.
* If we find out any node whose degree has become zero now, push it into the stack.
* While popping out the element from queue, store it into a vector also, it will be the answer.*/

//____________BFS_________________

import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String st[] = read.readLine().trim().split("\\s+");
            int edg = Integer.parseInt(st[0]);
            int nov = Integer.parseInt(st[1]);

            for (int i = 0; i < nov + 1; i++)
                list.add(i, new ArrayList<Integer>());

            int p = 0;
            for (int i = 1; i <= edg; i++) {
                String s[] = read.readLine().trim().split("\\s+");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                list.get(u).add(v);
            }

            int[] res = new Solution().topoSort(nov, list);

            if (check(list, nov, res) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
    static boolean check(ArrayList<ArrayList<Integer>> list, int V, int[] res) {
        
        if(V!=res.length)
        return false;
        
        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res[i]] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : list.get(i)) {
                if (map[i] > map[v]) return false;
            }
        }
        return true;
    }
}
// } Driver Code Ends


/*Complete the function below*/


class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        Queue<Integer> q= new LinkedList<>();
        int ans[]= new int[V];
        int indegree[]= new int[V];
        for(int i=0;i<V;i++) //indegree calculation
        {
            for(Integer it: adj.get(i))
             indegree[it]++;
        }
        //adding once with 0 indegree into queue
        for(int i=0;i<V;i++)
        {
            if(indegree[i]==0)
             q.add(i);
        }
        int idx=0;
        while(!q.isEmpty())
        {
            Integer node=q.poll();
            ans[idx++]=node;
            
            for(Integer it: adj.get(node))
            {
                indegree[it]--;
                if(indegree[it]==0)
                {
                    q.add(it);
                }
            }
        }
        return ans;
    }
}

