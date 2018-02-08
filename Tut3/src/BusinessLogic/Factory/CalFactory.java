package BusinessLogic.Factory;

/**
 * Created by Amay on 2/2/2018.
 */

import BusinessLogic.*;

public class CalFactory {
    public Calculator chooser(String exp){
        if(exp == null){
            return null;
        }
        if(exp.contains("sin")|| exp.contains("cos")||exp.contains("tan")){
            return new GeoCalculator();
        }
        else if(exp.contains("min")||exp.contains("max")|| exp.contains("min")||exp.contains("mean")||exp.contains("sd")||exp.contains("var"))
        {
            return new AlgCalculator();
        }
        else{
            return new BasicCalculator();
        }
    }
}
