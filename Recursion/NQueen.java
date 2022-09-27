package Recursion;

public class NQueen {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] arr = new char[n][n];
        for(int i = 0;i<n;i++)
        {
            for(int j = 0;j<n;j++)
            {
                arr[i][j] = '.';
            }
        }
        
        solve(n, ans, arr, 0);
        return ans;
    }
    
    
    public void solve(int n, List<List<String>> ans, char[][] arr, int col)
    {
        if(col == n) {
            List<String> temp = resultBuilder(arr);
            ans.add(temp);
            return;
        }
        
        for(int row = 0;row<n;row++)
        {
            if(isSafe(arr, row, col, n))
            {
                arr[row][col] = 'Q';
                solve(n, ans, arr, col+1);
                arr[row][col] = '.';
            }
        }
    }
    
    public boolean isSafe(char[][] arr, int row, int col, int n)
    {
        int x = row;
        int y = col;
        
        while(y >= 0) 
        {
            if(arr[x][y] == 'Q'){
                return false;
            }
            y--;
        }
        
        x = row;
        y = col;
        
        while(x >= 0 && y >= 0) {
            if(arr[x][y] == 'Q') {
                return false;
            }
            x--;
            y--;
        }
        
        x = row;
        y = col;
        
        while(x < n && y >= 0) {
            if(arr[x][y] == 'Q') {
                return false;
            }
            x++;
            y--;
        }
        
        return true;
    }
    
    public List<String> resultBuilder(char[][] matrix){
        List<String> temp = new ArrayList<>();
        for(int i=0;i<matrix.length;i++){
            temp.add(new String(matrix[i]));
        }
        return temp;
    }
}
