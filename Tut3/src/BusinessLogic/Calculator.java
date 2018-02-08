package BusinessLogic;

/**
 * Created by Amay on 2/1/2018.
 */
public abstract class Calculator implements CalInterface {
    public abstract double add(double a, double b);
    public abstract double sub(double a, double b);
    public abstract double mul(double a, double b);
    public abstract double div(double a, double b);
    public abstract double cal(String expr);
}
