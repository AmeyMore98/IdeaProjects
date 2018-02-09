package BusinessLogic;

import BusinessLogic.Factory.CalFactory;

/**
 * Created by Amay on 2/9/2018.
 */
public class CalHandler {
    private CalFactory cf;
    private Calculator calc;
    public double evaluate(String expr){
        cf = new CalFactory();
        calc = cf.chooser(expr);
        return calc.cal(expr);
    }
}
