import java.io.*;
import java.util.*;
 
public class CSESGraph {
 
    static class Pair {
        int x;
        int y;
 
        Pair(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }
    static char[][] ar=new char[1001][1001];
    static char[][] br= new char[1001][1001];
    static boolean[][] vis= new boolean[1001][1001];
    static int n , m;
    static ArrayList<Character> path= new ArrayList<>();
 
    static boolean isValid(int i, int j){
 
        if(i < 0 || i >= n || j < 0 || j >=m || ar[i][j] == '#' || vis[i][j]) return false;
 
        return true;
    }
    static boolean bfs(int x , int y)
    {
        Queue<Pair> q= new LinkedList<>();
        q.add(new Pair(x , y));
        vis[x][y] = true;
 
        while(!q.isEmpty()){
            int a = q.peek().x;
            int b = q.peek().y;
 
            q.poll();
            if(ar[a][b] == 'B'){
                while(true){
                    path.add(br[a][b]);
 
                    if(path.get(path.size()-1) == 'L') b++;
                    if(path.get(path.size()-1) == 'R') b--;
                    if(path.get(path.size()-1) == 'U') a++;
                    if(path.get(path.size()-1) == 'D') a--;
 
                    if(a == x && b == y)
                        break;
                }
                return true;
            }
            //left
            if(isValid(a , b - 1)) {
                br[a][b-1] = 'L' ;
                q.add(new Pair(a , b-1));
                vis[a][b-1] = true;
            }
 
 
            //right
            if(isValid(a , b + 1)) {
                br[a][b+1] = 'R' ;
                q.add(new Pair(a , b+1));
                vis[a][b+1] = true;
            }
 
            //up
            if(isValid(a-1 , b )) {
                br[a-1][b] = 'U' ;
                q.add(new Pair(a-1, b));
                vis[a-1][b] = true;
            }
            //down
            if(isValid(a+1 , b)) {
                br[a+1][b] = 'D' ;
                q.add(new Pair(a+1 , b));
                vis[a+1][b] = true;
            }
        }
        return false;
    }
 
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
         n = Integer.parseInt(st.nextToken());
         m = Integer.parseInt(st.nextToken());
 
        int p=0,q = 0;
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++)
            {
                ar[i][j]=s.charAt(j);
                if(ar[i][j]=='A') {
                    p=i;
                    q=j;
                }
            }
        }
        if(bfs(p, q)){
            out.println("YES \n"+ path.size());
            int size= path.size()-1;
            while(size>=0)
                out.print(path.get(size--));
        }
        else{
            out.println("NO");
        }
        out.close();
    }
}
