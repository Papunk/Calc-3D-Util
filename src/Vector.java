public class Vector extends Matrix {

    private final boolean columnVector;
    private final int length;

    public Vector(int n, boolean columnVector) {
        super(columnVector? n:1, columnVector? 1:n);
        this.columnVector = columnVector;
        this.length = n;
    }

    public Vector(double[] list, boolean columnVector) {
        this(list.length, columnVector);
        int listIndex = 0;
        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getWidth(); j++) {
                matrix[i][j] = list[listIndex];
                listIndex++;
            }
        }
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
     * @throws Matrix.MatrixDimensionMismatch is the vectors are not of equal length
     */
    public static double dotProduct(Vector v1, Vector v2) throws MatrixDimensionMismatch{
        double[] l1 = v1.asList();
        double[] l2 = v2.asList();
        if (l1.length == l2.length) {
            if (v1.isColumnVector() && !v2.isColumnVector()) { // checks what type of vector they are
                System.out.println("Warning: Vectors are not of the same type. Dot product is not mathematically defined in this way");
            }
            double sum = 0;
            for (int i = 0; i < l1.length; i++) {
                sum += l1[i] * l2[i];
            }
            return sum;
        }
        throw new MatrixDimensionMismatch("Dot Product");
    }

    /**
     * @param v1 first vector
     * @param v2 second vector
     * @return true if the vectors are perpendicular and false otherwise
     * @throws Matrix.MatrixDimensionMismatch when vectors are of different length
     */
    public static boolean arePerpendicular(Vector v1, Vector v2) throws MatrixDimensionMismatch{
        return dotProduct(v1, v2) == 0;
    }

    // Override methods

    @Override
    public String toString() {
        String vectorString = "<  ";
        for (double elem: this.asList()) {
            vectorString += Double.toString(elem) + "  ";
        }
        return (isColumnVector()? "col": "row") + ": " + vectorString + ">";
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
                listIndex++;
            }
        }
        return list;
    }

}
