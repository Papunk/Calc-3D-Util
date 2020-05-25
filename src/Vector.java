public class Vector {

    private int xComp, yComp, zComp;
    private static final char sep = ',', lBrace = '<', rBrace = '>';

    public int getxComp() {
        return xComp;
    }
    public int getyComp() {
        return yComp;
    }
    public int getzComp() {
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

    public Vector(int xComp, int yComp, int zComp) {
        this.xComp = xComp;
        this.yComp = yComp;
        this.zComp = zComp;
    }

    // METHODS
    public double getMagnitude() {
        return Math.sqrt(Math.pow(this.xComp, 2) + Math.pow(this.yComp, 2) + Math.pow(this.zComp, 2));
    }


    // STATIC METHODS

    public static double getAngle(Vector v1, Vector v2) {
        return Math.toDegrees(Math.acos(dotProduct(v1, v2) / (v1.getMagnitude() * v2.getMagnitude())));
    }

    public static int dotProduct(Vector v1, Vector v2) {
        return (v1.getxComp() * v2.getxComp()) + (v1.getyComp() * v2.getyComp()) + (v1.getzComp() * v2.getzComp());
    }

    public static Vector crossProduct(Vector v1, Vector v2) {
        int x = v1.getyComp()*v2.getzComp() - v1.getzComp()*v2.getyComp();
        int y = v1.getzComp()*v2.getxComp() - v1.getxComp()*v2.getzComp();
        int z = v1.getxComp()*v2.getyComp() - v1.getyComp()*v2.getxComp();
        return new Vector(x, y, z);
    }

    public static boolean arePerpendicular(Vector v1, Vector v2) {
        return dotProduct(v1, v2) == 0;
    }




    public static Vector stringToVector(String vector) {
        if (vector.startsWith(String.valueOf(lBrace)) && vector.endsWith(String.valueOf(rBrace))) {
            if (vector.length() > 3) {
                vector = vector.substring(1, vector.length() - 1);
                String[] components = vector.split(String.valueOf(sep));
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
        return lBrace + String.valueOf(xComp) + sep + String.valueOf(yComp) + sep + String.valueOf(zComp) + rBrace;
    }
}
