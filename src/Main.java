public class Main {

    public static void main(String[] args) {
        Vector3d v1 = new Vector3d(1,-5,4),
                v2 = new Vector3d(4,4,-3);
        System.out.println(Vector3d.getAngle(v1, v2));
    }
}

//TODO Test all classes