public class Plane {

    private Vector3d normalVector;
    private Point point;

    public Vector3d getNormalVector() {
        return normalVector;
    }

    public Plane(Vector3d normalVector, Point point) throws InvalidPlaneException {
        if (Vector3d.arePerpendicular(normalVector, new Vector3d(point))) {
            this.normalVector = normalVector;
            this.point = point;
        }
        else throw new InvalidPlaneException();
    }

    public Plane(Vector3d normalVector) {
        this.normalVector = normalVector;
    }



    /**
     * @param point point to be compared
     * @return true if point is in plane, false otherwise
     */
    public boolean planeContains(Point point) {
        return Vector3d.arePerpendicular(normalVector, new Vector3d(point));
    }




    public static class InvalidPlaneException extends Exception {

        public InvalidPlaneException() {
            super("Point not perpenducular to normal vector");
        }
    }
}
