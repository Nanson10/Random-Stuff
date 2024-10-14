package Math_Stuff;

import java.security.InvalidParameterException;

public class Polynomial {
    private double[] coefficients;
    private int derivitiveDegree;

    public Polynomial(double[] coefficients) {
        if (coefficients == null)
            throw new InvalidParameterException();
        this.coefficients = coefficients;
        derivitiveDegree = 0;
    }

    public Polynomial(double[] coefficients, int derivitiveDegree) {
        if (coefficients == null)
            throw new InvalidParameterException();
        this.coefficients = coefficients;
        this.derivitiveDegree = derivitiveDegree;
    }

    public double getValue(double input) {
        double value = 0;
        for (int a = 0; a < coefficients.length; a++)
            value += coefficients[coefficients.length - 1 - a] * Math.pow(input, a);
        return value;
    }

    public String getFunction() {
        String temp = "f";
        for (int a = 0; a < derivitiveDegree; a++)
            temp += "'";
        temp += "(x) = ";
        for (int a = 0; a < coefficients.length; a++)
            if (a == coefficients.length - 1)
                temp += DoubleOrInt.doubleOrInt(coefficients[a]);
            else if (a == coefficients.length - 2)
                temp += DoubleOrInt.doubleOrInt(coefficients[a]) + "x + ";
            else
                temp += DoubleOrInt.doubleOrInt(coefficients[a]) + "x^" + (coefficients.length - 1 - a) + " + ";
        return temp;
    }

    public Polynomial getDerivitive() {
        double[] temp = new double[coefficients.length - 1];
        for (int a = 0; a < temp.length; a++)
            temp[a] = coefficients[a] * (coefficients.length - 1 - a);
        return new Polynomial(temp, derivitiveDegree + 1);
    }
}
