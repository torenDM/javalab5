package ru.demidov.task1;

public class Fraction implements Measurable {
    private int numerator;
    private int denominator;
    private Double cachedValue;

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю");
        }

        if (denominator < 0) {
            this.numerator = -numerator;
            this.denominator = -denominator;
        } else {
            this.numerator = numerator;
            this.denominator = denominator;
        }

        this.cachedValue = null;
    }

    @Override
    public double getValue() {
        if (cachedValue == null) {
            cachedValue = (double) numerator / denominator;
        }
        return cachedValue;
    }

    @Override
    public void setNumerator(int numerator) {
        this.numerator = numerator;
        this.cachedValue = null;  // Invalidate cache
    }

    @Override
    public void setDenominator(int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero");
        }

        // Ensure denominator is always positive
        if (denominator < 0) {
            this.numerator = -numerator;
            this.denominator = -denominator;
        } else {
            this.denominator = denominator;
        }
        this.cachedValue = null;  // Invalidate cache
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Fraction fraction = (Fraction) obj;
        return numerator == fraction.numerator && denominator == fraction.denominator;
    }

    @Override
    public int hashCode() {
        return 31 * numerator + denominator;
    }
}