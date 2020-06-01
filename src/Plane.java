public class Plane {

    private Vector normalVector;
    private Point point;

    public Vector getNormalVector() {
        return normalVector;
    }

    public Plane(Vector normalVector, Point point) throws InvalidPlaneException {
        if (Vector.arePerpendicular(normalVector, new Vector(point))) {
            this.normalVector = normalVector;
            this.point = point;
        }
        else throw new InvalidPlaneException();
    }

    public Plane(Vector normalVector) {
        this.normalVector = normalVector;
    }


    /**
     * @param point point to be compared
     * @return true if point is in plane, false otherwise
     */
    public boolean planeContains(Point point) {
        return Vector.arePerpendicular(normalVector, new Vector(point));
    }




    public static class InvalidPlaneException extends Exception {

        public InvalidPlaneException() {
            super("Point not perpenducular to normal vector");
        }
    }
}
