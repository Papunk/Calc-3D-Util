public class Vector extends Matrix {

    private boolean columnVector;
    private int length;

    public Vector(int n, boolean columnVector) {
        super(columnVector? n:1, columnVector? 1:n);
        this.columnVector = columnVector;
        this.length = n;
    }

    public Vector(double[][] matrix) {
        super(matrix);
    }

    // Methods

    public double getMagnitude() {
        double sum = 0;
        for (double elem: this.asList()) {
            sum += Math.pow(elem, 2);
        }
        return Math.sqrt(sum);
    }

    // Static Methods

    public static Vector dotProduct(Vector v1, Vector v2) {
        if (Matrix.sameDimensions(v1, v2)) {
            double sum = 0;
            for (int i = 0; i < v1.getHeight(); i++) {
                sum += v1.getValueAt(i) * v2.getValueAt(i);
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

    public double getValueAt(int n) {
        return isColumnVector()? matrix[n][1]:matrix[1][n];
    }

    public double[] asList() {
        double[] list = new double[this.length];
        int listIndex = 0;
        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getWidth(); j++) {
                list[listIndex] = matrix[i][j];
            }
        }
        return list;
    }

}
