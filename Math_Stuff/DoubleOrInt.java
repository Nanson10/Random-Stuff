package Math_Stuff;

public class DoubleOrInt {
    public static String doubleOrInt(double value) {
        if ((int) value == value)
            return String.valueOf(((int) value));
        return String.valueOf(value);
    }
}
