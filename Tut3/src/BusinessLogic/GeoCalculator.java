package BusinessLogic;

import java.util.Stack;

/**
 * Created by Amay on 2/8/2018.
 */
public class GeoCalculator extends Calculator{
    private char[] tokens;
    private Stack<Double> values;
    private Stack<Character> ops;

    @Override
    public double cal(String expr) {
        tokens = expr.toCharArray();
        values = new Stack<Double>();
        ops = new Stack<Character>();
        for (int i = 0; i < tokens.length; i++)
        {
            if (tokens[i] == ' ')
                continue;
            if (tokens[i] >= '0' && tokens[i] <= '9')
            {
                StringBuffer sbuf = new StringBuffer();
                while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9')
                    sbuf.append(tokens[i++]);
                values.push(Double.parseDouble(sbuf.toString()));
            }
            else if(tokens[i] == 's'){
                i=i+3;				//sin45 + cos45
                StringBuffer temp = new StringBuffer();
                while(i<tokens.length && tokens[i] >= '0' && tokens[i]<='9'){
                    temp.append(tokens[i++]);
                }
                values.push(Double.parseDouble(""+sin(Double.parseDouble(temp.toString()))));
            }
            else if(tokens[i] == 'c'){
                i=i+3;				//sin45 + cos45
                StringBuffer temp = new StringBuffer();
                while(i<tokens.length && tokens[i] >= '0' && tokens[i]<='9'){
                    temp.append(tokens[i++]);
                }
                values.push(Double.parseDouble(""+cos(Double.parseDouble(temp.toString()))));
            }
            else if(tokens[i] == 't'){
                i=i+3;				//sin45 + cos45
                StringBuffer temp = new StringBuffer();
                while(i<tokens.length && tokens[i] >= '0' && tokens[i]<='9'){
                    temp.append(tokens[i++]);
                }
                values.push(Double.parseDouble(""+tan(Double.parseDouble(temp.toString()))));
            }
            else if (tokens[i] == '(')
                ops.push(tokens[i]);
            else if (tokens[i] == ')')
            {
                while (ops.peek() != '(')
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                ops.pop();
            }
            else if (tokens[i] == '+' || tokens[i] == '-' ||
                    tokens[i] == '*' || tokens[i] == '/')
            {
                while (!ops.empty() && hasPrecedence(tokens[i], ops.peek()))
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                ops.push(tokens[i]);
            }
        }
        while (!ops.empty())
            values.push(applyOp(ops.pop(), values.pop(), values.pop()));
        return values.pop();
    }
    public boolean hasPrecedence(char op1, char op2)
    {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }
    public double applyOp(char op, double b, double a)
    {
        double a1=Double.parseDouble(a+"");
        double b1=Double.parseDouble(b+"");
        switch (op)
        {
            case '+':
                return add(a1,b1);
            case '-':
                return sub(a1,b1);
            case '*':
                return mul(a1,b1);
            case '/':
                if (b1 != 0)
                    return div(a1,b1);
        }
        return 0;
    }

    @Override
    public double add(double a, double b) {
        return a + b;
    }

    @Override
    public double sub(double a, double b) {
        return a- b;
    }

    @Override
    public double mul(double a, double b) {
        return a * b;
    }

    @Override
    public double div(double a, double b) {
        if(b == 0)
            throw new UnsupportedOperationException("Cannot divide by zero");
        return a/b;
    }

    public double sin(double a) {
        return Math.sin(a);
    }

    public double cos(double a) {
        return Math.cos(a);
    }

    public double tan(double a) {
        return Math.tan(a);
    }
}
