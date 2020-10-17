public class Main {

    public static void main(String[] args) {
        Matrix A = new Matrix(new double[][]{{3, 1, 5}, {-4, 9, 0}, {4, -5, 9}});
        System.out.println(A.toString());
        A.multiplyByScalar(4);
        System.out.println(A);
    }
}

//TODO Test all classes