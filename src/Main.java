public class Main {

    public static void main(String[] args) {
        Matrix A = new Matrix(3, 3);
        A.setValueAt(0, 1, 4);
        A.setValueAt(2, 0, 4);
        A.setValueAt(2, 2, 4);
        Matrix A_T = Matrix.transverse(A);

        System.out.println(A.toString());
        System.out.println(A_T.toString());


    }
}

//TODO Test all classes