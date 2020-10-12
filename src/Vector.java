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

    /**
     * @return magnitude of this vector
     */
    public double getMagnitude() {
        double sum = 0;
        for (double elem: this.asList()) {
            sum += Math.pow(elem, 2);
        }
        return Math.sqrt(sum);
    }

    // Static Methods

    /**
     * @param v1 first vector
     * @param v2 second vector
     * @return returns the dot product of the given vectors
     */
    public static double dotProduct(Vector v1, Vector v2) {
        if (Matrix.sameDimensions(v1, v2)) {
            double sum = 0;
            for (int i = 0; i < v1.getHeight(); i++) {
                sum += v1.getValueAt(i) * v2.getValueAt(i);
            }
            return sum;
        }
        return 0; //TODO throw error
    }

    /**
     * @param v1 first vector
     * @param v2 second vector
     * @return true if the vectors are perpendicular and false otherwise
     */
    public static boolean arePerpendicular(Vector v1, Vector v2) {
        return dotProduct(v1, v2) == 0;
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

    /**
     * @return a list of length n containing the elements of this n-vector
     */
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
