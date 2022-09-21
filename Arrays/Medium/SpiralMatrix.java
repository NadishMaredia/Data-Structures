package Arrays.Medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        int r = matrix.length;
        int c = matrix[0].length;
        
        List<Integer> ans = new ArrayList<>();
        
        int len = r * c;
        int count = 0;
        
        int startRow = 0;
        int endRow = r - 1;
        int startCol = 0;
        int endCol = c - 1;
        
        while(count < len)
        {
            // left to right, 00,01,02
            for(int i = startCol;i<=endCol && count < len;i++) {
                ans.add(matrix[startRow][i]);
                count++;
            }
            startRow++;
            
            //topleft to bottomleft, 12,22
            for(int i = startRow;i<=endRow && count < len;i++) {
                ans.add(matrix[i][endCol]);
                count++;
            }
            endCol--;
            
            //bottomright to bottomleft, 21,20
            for(int i = endCol;i>=startCol && count < len;i--) {
                ans.add(matrix[endRow][i]);
                count++;
            }
            endRow--;
            
            //bottomleft to topright, 11
            for(int i = endRow;i>=startRow && count < len;i--) {
                ans.add(matrix[i][startCol]);
                count++;
            }
            startCol++;
        }
        
        return ans;
    }
}
