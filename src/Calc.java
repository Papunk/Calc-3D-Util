public class Calc {

    public static final String
            sep = ",",
            lBrace = "<", rBrace = ">",
            lPar = "(", rPar = ")",
            equals = "=", plus = "+", minus = "-",
            x = "x", y = "y", z = "z";


    /**
     * adjusts the decimal places of a double
     * @param num the number to be trimmed
     * @param decimalSpaces the number of desired decimal spaces
     * @return double with the given number of decimal places
     */
    public static double trimDouble(double num, int decimalSpaces) {
        return (int) (num * Math.pow(10, decimalSpaces)) / Math.pow(10, decimalSpaces);
    }
}
