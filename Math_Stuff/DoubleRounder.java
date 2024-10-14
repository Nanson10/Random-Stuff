package Math_Stuff;

public class DoubleRounder {
    private int round;

    public DoubleRounder(int round) {
        this.round = round;
    }

    public double round(double number) {
        return (double) (Math.round(number * Math.pow(10, round)) / Math.pow(10, round));
    }
}