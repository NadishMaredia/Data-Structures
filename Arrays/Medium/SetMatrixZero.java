package Arrays.Medium;

import java.util.ArrayList;
import java.util.List;

public class SetMatrixZero {
    public void setZeroes(int[][] matrix) {
        
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();
        
        int r = matrix.length;
        int c = matrix[0].length;
        
        for(int i = 0;i<r;i++) {
            for(int j = 0;j<c;j++) {
                if(matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        
        for(int i = 0;i<r;i++) {
            for(int j = 0;j<c;j++) {
                if(rows.contains(i) || cols.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
