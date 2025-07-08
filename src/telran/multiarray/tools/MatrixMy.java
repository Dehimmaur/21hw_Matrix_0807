package telran.multiarray.tools;

public class MatrixMy {
    int[][] matrix;


    public MatrixMy(int[][] matrix) {
        this.matrix = copy2DArray(matrix);
        if (!isMatrix(this.matrix)) {throw new IllegalArgumentException("All matrix rows must be the same length");}
    }

    public MatrixMy(MatrixMy matrix) {
        int[][] arr = matrix.matrix;
        this.matrix = copy2DArray(arr);
    }

    public MatrixMy transp() {
        int length = matrix.length;
        int height = matrix[0].length;
        int[][] res = new int[height][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < height; j++) {
                res[j][i] = matrix[i][j];
            }
        }
        return new MatrixMy(res);
    }

    public int[][] getData() {
        return copy2DArray(matrix);
    }

    public boolean equalsMatrix(MatrixMy matrix1) {
        int[][] m1 = matrix1.matrix;
        int[][] m2 = this.matrix;
        if (m1.length != m2.length || m1[0].length != m2[0].length) {return false;}
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[0].length; j++) {
                if (m1[i][j] != m2[i][j]) {return false;}
            }
        }
        return true;
    }

    public MatrixMy multiply(MatrixMy secondMatrix) {
        int[][] otherMatrix = secondMatrix.matrix;
        int length = matrix.length;
        int height = otherMatrix[0].length;
        int vals = matrix[0].length;
        int[][] result = new int[length][height];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < height; j++) {
                for (int k = 0; k < vals; k++) {
                    result[i][j] += matrix[i][k] * otherMatrix[k][j];
                }
            }
        }
        return new MatrixMy(result);
    }

    public int sum() {
        int sum = 0;
        for (int[] row : this.matrix)
            for (int val : row)
                sum += val;
        return sum;
    }

    public boolean changeCell(int x,int y, int val){
        this.matrix[x][y] = val;
        return true;
    }

    public void showMatrix(){
        int[][] arr = this.matrix;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }

    private int[][] copy2DArray(int[][] matrix) {
        int[][] arr = new int[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            arr[i] = new int[matrix[i].length];
            for (int j = 0; j < matrix[i].length; j++) {
                arr[i][j] = matrix[i][j];
            }
        }
        return arr;
    }

    private boolean isMatrix(int[][] matrix) {
        int length = matrix.length;
        if (length == 1) {return true;}
        int height = matrix[0].length;
        for (int i = 1; i < length; i++) {
            if (height != matrix[i].length) {return false;}
        }
        return true;
    }

}
