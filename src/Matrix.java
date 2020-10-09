import java.util.Arrays;

public class Matrix {

    private int height, width;
    private Double[][] matrix;

    public Matrix(int height, int width) {
        this.height = height;
        this.width = width;
        this.matrix = new Double[height][width];
        for (Double[] vector: this.matrix) {
            Arrays.fill(vector, 0);
        }
    }

    public Matrix (Double[][] matrix) {
        if (matrix.length > 0 && matrix[0].length > 0){
            this.height = matrix.length;
            this.width = matrix[0].length;
            this.matrix = matrix;
        }
    }

    public Boolean isSquare() {
        return height == width;
    }

    public Boolean isDiagonal() {
        if (!this.isSquare()) // only a square matrix can be diagonal
            return false;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i == j && matrix[i][j] == 0) { // values within the diagonal must not be zero
                    return false;
                }
                if (i != j && matrix[i][j] != 0){ // values outside the diagonal must be zero
                    return false;
                }
            }
        }
        return true;
    }

    public static Matrix add(Matrix m1, Matrix m2) {
        if (m1.getHeight() == m2.getHeight() && m1.getWidth() == m2.getWidth()) {
            Matrix m = new Matrix(m1.getHeight(), m1.getWidth());
            for (int i = 0; i < m.getHeight(); i++) {
                for (int j = 0; j < m.getWidth(); j++) {
                    m.setValue(i, j, m1.getValue(i, j) * m2.getValue(i, j));
                }
            }
            return m;
        } else {
            return null;
        }
    }

    public void setValue(int row, int col, Double newValue) {
        matrix[row][col] = newValue;
    }

    public Double getValue(int row, int col) {
        return matrix[row][col];
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
