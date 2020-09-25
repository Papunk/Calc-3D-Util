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
        return null;
    }


}
