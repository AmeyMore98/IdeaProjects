package BusinessLogic.expressionComponents;
/**
 * Created by Amay on 4/1/2018.
 */
public class Operator implements Expr {
    private Expr le, re;
    private char op;

    public Operator(char op, Expr le, Expr re){
    	this.op = op;
        this.le = le;
        this.re = re;
    }
    
    @Override
    public double evaluate() {
    	switch(this.op) {
    	case '+': return le.evaluate() + re.evaluate();
    	case '-': return le.evaluate() - re.evaluate();
    	case '*': return le.evaluate() * re.evaluate();
    	case '/': return le.evaluate() / re.evaluate();
    	default: throw new UnsupportedOperationException("Invalid Operation");
    	}
    }
}
