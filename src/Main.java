public class Main {

    public static void main(String[] args) {
        Vector v1 = new Vector(1,-5,4),
                v2 = new Vector(4,4,-3);
        System.out.println(Vector.getAngle(v1, v2));
    }
}