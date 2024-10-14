package Math_Stuff;

public class Driver {
    public static void main(String[] args) {
        Polynomial temp = new Polynomial(new double[] { 6, 5, 4, 3, 2, 1 });
        DoubleRounder roundTen = new DoubleRounder(10), roundOne = new DoubleRounder(1);
        for (double a = -10; a <= 10; a++)
            System.out.println(
                    "f(" + DoubleOrInt.doubleOrInt(roundOne.round(a)) + ") = "
                            + DoubleOrInt.doubleOrInt(roundTen.round(temp.getValue(a))));
        System.out.println(temp.getFunction());
        System.out.println(temp.getDerivitive().getFunction());
        System.out.println(temp.getDerivitive().getDerivitive().getFunction());
    }
}