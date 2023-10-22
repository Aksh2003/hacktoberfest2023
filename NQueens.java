import java.util.*;
public class nqueens {
    static int board[][];
    static ArrayList<ArrayList<String> >ans;
    static void addsolution(int board[][],int n)
    {
         ArrayList<String>temp = new ArrayList<String>();
         for(int i=0;i<n;i++)
         { 
            String s = "";
            for(int j=0;j<n;j++)
            {
                if(board[i][j] == 1)
                {
                    s+='Q';
                }
                else{
                    s+='.';
                }
            }
            temp.add(s);
         }
         ans.add(temp);
    }
    static boolean safe(int board[][],int r,int c,int n)
    {
        for(int i =0;i< r;i++)
        {
            if(board[i][c] == 1)
               return false;
        }
        for(int row =r-1, col = c-1; row >=0 && col >=0; row--,col-- )
        {
            if(board[row][col] == 1)
               return false;
        }
        for(int row =r-1, col = c+1; row >=0 && col<n; row--,col++ )
        {
            if(board[row][col] == 1)
               return false;
        }

        return true;
    }
    static void findsolution(int[][]board,int n,int r)
    {
          if(r == n)
          {
              addsolution(board,n);
              return;
          }

          for(int i=0;i<n;i++)
          {
            if(safe(board,r,i,n))
            {
                board[r][i] =1;
                findsolution(board,n,r+1);
                board[r][i] =0;
            }
          }
    }
    public static void main(String[]args)
    {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        board = new int[n][n];
        ans = new ArrayList<ArrayList<String>>();
        findsolution(board,n,0);
        for(int i = 0;i< ans.size();i++)
        {
            for(String str : ans.get(i))
            {
                System.out.println(str);
            }
            System.out.println();
        }
        sc.close();
    }
}
