public class Main {

    public static void main(String[] args) {
	    Vector v = new Vector(1,0,0);
	    Point pt = new Point(0,0,1);
	    try {
            Plane pn = new Plane(v, pt);
        } catch (Exception e) {
	        e.printStackTrace();
        }
    }
}