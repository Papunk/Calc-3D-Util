public class Vector implements Comparable<Vector> {

    private double xComp, yComp, zComp;
    private static final String sep = ",", lBrace = "<", rBrace = ">";

    public double getxComp() {
        return xComp;
    }
    public double getyComp() {
        return yComp;
    }
    public double getzComp() {
        return zComp;
    }

    public Vector(String vector) {
        Vector ref = stringToVector(vector);
        if (ref != null) {
            this.xComp = ref.getxComp();
            this.yComp = ref.getyComp();
            this.zComp = ref.getzComp();
        } else {
            this.xComp = 0;
            this.yComp = 0;
            this.zComp = 0;
        }
    }

    public Vector(double xComp, double yComp, double zComp) {
        this.xComp = xComp;
        this.yComp = yComp;
        this.zComp = zComp;
    }

    // METHODS
    public double getMagnitude() {
        return Math.sqrt(Math.pow(this.xComp, 2) + Math.pow(this.yComp, 2) + Math.pow(this.zComp, 2));
    }

    public void multiplyByScalar(int magnitude) {
        this.xComp *= magnitude;
        this.yComp *= magnitude;
        this.zComp *= magnitude;
    }

    public Vector getUnitVector() {
        return new Vector(this.xComp / this.getMagnitude(),this.yComp / this.getMagnitude(), this.zComp / this.getMagnitude());
    }

    // STATIC METHODS

    public static double getAngle(Vector v1, Vector v2) {
        return Math.toDegrees(Math.acos(dotProduct(v1, v2) / (v1.getMagnitude() * v2.getMagnitude())));
    }

    public static double dotProduct(Vector v1, Vector v2) {
        return (v1.getxComp() * v2.getxComp()) + (v1.getyComp() * v2.getyComp()) + (v1.getzComp() * v2.getzComp());
    }

    public static Vector crossProduct(Vector v1, Vector v2) {
        double x = v1.getyComp()*v2.getzComp() - v1.getzComp()*v2.getyComp();
        double y = v1.getzComp()*v2.getxComp() - v1.getxComp()*v2.getzComp();
        double z = v1.getxComp()*v2.getyComp() - v1.getyComp()*v2.getxComp();
        return new Vector(x, y, z);
    }

    public static boolean arePerpendicular(Vector v1, Vector v2) {
        return dotProduct(v1, v2) == 0;
    }

    public static Vector stringToVector(String vector) throws NumberFormatException{
        if (vector.startsWith(lBrace) && vector.endsWith(rBrace)) {
            if (vector.length() > 3) {
                vector = vector.substring(1, vector.length() - 1);
                String[] components = vector.split(sep);
                int[] numericComps = new int[components.length];
                for (int i = 0; i < components.length; i++) {
                    numericComps[i] = Integer.valueOf(components[i]);
                }
                return new Vector(numericComps[0], numericComps[1], numericComps[2]);
            }
        }
        return null;
    }


    @Override
    public String toString() {
        return lBrace + xComp + sep + yComp + sep + zComp + rBrace;
    }


    @Override
    public int compareTo(Vector o) {
        return (int) (this.getMagnitude() - o.getMagnitude());
    }
}
