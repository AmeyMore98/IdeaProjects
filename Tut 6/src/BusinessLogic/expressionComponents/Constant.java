package BusinessLogic.expressionComponents;
/**
 * Created by Amay on 4/1/2018.
 */
public class Constant implements Expr {
    private double value;
    public Constant(double val){
        value = val;
    }
    @Override
    public double evaluate() {
        return value;
    }
}
