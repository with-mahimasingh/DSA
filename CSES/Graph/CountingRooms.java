import java.io.*;
import java.util.*;
 
public class CSESGraph {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
 
        char[][] a = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s= sc.next();
            for (int j = 0; j < s.length(); j++)
            {
                a[i][j]=s.charAt(j);
            }
        }
        System.out.println(numRooms(a));
 
    }
        public static int numRooms(char[][] grid) {
            int count=0;
            int n=grid.length;
            if(n==0) return 0;
            int m=grid[0].length;
 
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<m;j++)
                {
                    if(grid[i][j]=='.')
                    {
                        destroyRoom(grid,i,j);
                        count++;
                    }
                }
            }
            return count;
        }
        static void destroyRoom(char[][]grid, int i,int j)
        {
            if(i<0 || i>=grid.length || j<0 || j>=grid[i].length || grid[i][j]=='#')
                return;
 
            grid[i][j]='#';
            destroyRoom(grid,i+1,j);
            destroyRoom(grid,i,j+1);
            destroyRoom(grid,i-1,j);
            destroyRoom(grid,i,j-1);
        }
}
