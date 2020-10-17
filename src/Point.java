public class Point {

    double[] coords;

    // constructors

    public Point(double[] coords) {
        this.coords = coords;
    }

    public Point(Vector coords) {
        if (coords != null)
            this.coords = coords.asList();
        else
            this.coords = new double[]{0, 0, 0};
    }

    public Point() {
        this(new double[]{0, 0, 0});
    }

    // methods
    public double distanceFromOrigin() {
        double sum = 0;
        for (double num: coords) {
            sum += Math.pow(num, 2);
        }
        return Math.sqrt(sum);
    }

    public int getDimension() {
        return coords.length;
    }
}
