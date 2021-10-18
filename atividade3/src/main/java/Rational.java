import java.util.Objects;

/**
 * Abstraction for a rational number.
 */
public class Rational {
    private int numerator;
    private int denominator;

    public Rational(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    /**
     * Computes the greatest common divisor between p and q.
     * @param p the first operand
     * @param q the second operand
     * @return the gcd between both operands
     */
    private int gcd(int p, int q) {
        while (q != 0) {
            int temp = q;
            q = p % q;
            p = temp;
        }
        return p;
    }

    /**
     * Computer the least common multiple between p and q.
     * @param p the first operand
     * @param q the second operand
     * @return the lmm between both operands
     */
    private int lmm(int p, int q) {
        return (p * q) / gcd(p, q);
    }

    /**
     * Adds two rational numbers.
     * @param b the right operand
     * @return the addition of this rational to b
     */
    public Rational plus(Rational b) {
        // TODO: Completar
        int denominador;
        int numerador;
        int mmc;
        int mdc;
        numerador = this.getNumerator();
        denominador = this.getDenominator();
        mmc = lmm(denominador, b.denominator);
        numerador = (mmc / denominador) * numerador + (mmc / b.denominator) * b.numerator;
        mdc = gcd(numerador, mmc);
        mmc = mmc / mdc;
        numerador = numerador / mdc;

        return new Rational(numerador, mmc);
    }

    /**
     * Substracts two rational numbers.
     * @param b the right operand
     * @return the subtraction of this rational to b
     */
    public Rational minus(Rational b) {
        int denominador;
        int numerador;
        int mmc;
        int mdc;
        numerador = this.getNumerator();
        denominador = this.getDenominator();
        mmc = lmm(denominador, b.denominator);
        numerador = (mmc / denominador) * numerador - (mmc / b.denominator) * b.numerator;
        mdc = gcd(numerador, mmc);
        mmc = mmc / mdc;
        numerador = numerador / mdc;


        return new Rational(numerador, mmc);
    }

    /**
     * Multiplies two rational numbers.
     * @param b the right operand
     * @return the multiplication of this rational to b
     */
    public Rational times(Rational b) {
        // TODO: Completar
        int numerador;
        int denominador;
        int mdc;
        numerador = this.getNumerator() * b.numerator;
        denominador = this.getDenominator() * b.denominator;
        mdc = gcd(numerador, denominador);
        denominador = denominador / mdc;
        numerador = numerador / mdc;

        return new Rational(numerador, denominador);
    }

    /**
     * Divides two rational numbers.
     * @param b the right operand
     * @return the division of this rational by b
     */
    public Rational divides(Rational b) {
        // TODO: Completar
        int numerador;
        int denominador;
        int mdc;
        numerador = this.getNumerator() * b.denominator;
        denominador = this.getDenominator() * b.numerator;
        mdc = gcd(numerador, denominador);
        denominador = denominador / mdc;
        numerador = numerador / mdc;

        return new Rational(numerador, denominador);
    }

    /**
     * Checks if the given rational is equal to this.
     * @param b the right operand
     * @return true, if both are equal, false otherwise
     */
    public boolean isEqual(Rational b) {
        // TODO: Completar
        int denominador = this.getDenominator();
        int numerador = this.getNumerator();
        int mdc = gcd(denominador, numerador);
        denominador = denominador / mdc;
        numerador = numerador / mdc;
        return denominador == b.denominator && numerador == b.numerator ? true : false;
    }

    /**
     * Overload java internal equality semantics.
     * @param b the other parameter
     * @return true if both are equal, false otherwise
     */
    @Override
    public boolean equals(Object b) {
        if (this == b) {
            return true;
        }
        if (b == null || getClass() != b.getClass()) {
            return false;
        }
        return this.isEqual((Rational) b);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    /**
     * Shows the real number as fraction, the signal normalized
     * so that it appears only in the numerator, if any.
     *
     * @return the string representation
     */
    @Override
    public String toString() {
        String signal = this.numerator < 0 || this.denominator < 0 ? "-" : "";

        return signal + Math.abs(this.numerator) + "/" + Math.abs(this.denominator);
    }
}
