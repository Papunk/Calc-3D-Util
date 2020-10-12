public class Vector extends Matrix {

    private boolean columnVector;

    public Vector(int n, boolean columnVector) {
        super(columnVector? n:1, columnVector? 1:n);
        this.columnVector = columnVector;
    }

    public Vector(double[][] matrix) {
        super(matrix);
    }

    public static Vector dotProduct(Vector v1, Vector v2) {
        if (Matrix.sameDimensions(v1, v2)) {
            double sum = 0;
            for (int i = 0; i < v1.getHeight(); i++) {
            }
        }
        return null;
    }

    // Setters and Getters

    public boolean isColumnVector() {
        return columnVector;
    }

    public int getDimension() {
        return isColumnVector()? getHeight():getWidth();
    }

    public void setValueAt(int n, double value) {
        matrix[isColumnVector()? n:1][isColumnVector()? 1:n] = value;
    }

    public double getValueAt(int n, double value) {
        return isColumnVector()? matrix[n][1]:matrix[1][n];
    }

}
