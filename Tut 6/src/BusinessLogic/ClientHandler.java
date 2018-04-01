/**
 * Created by Amay on 4/1/2018.
 */
package BusinessLogic;

import java.util.*;

import BusinessLogic.expressionComponents.*;
import BusinessLogic.helper.*;
public class ClientHandler {
    public boolean isOperator(char c) {
        if (c == '+' || c == '-'
                || c == '*' || c == '/'
                || c == '^') {
            return true;
        }
        return false;
    }
   
    public Expr constructTree(String postfix) {
        Stack<Expr> st = new Stack();
        Expr t, t1, t2;
        for (int i = 0; i < postfix.length(); i++) {
            if (!isOperator(postfix.charAt(i))) {
                 t = new Constant(Double.parseDouble(Character.toString(postfix.charAt(i))));
                 st.push(t);
            } 
            else{
                t1 = st.pop();
                t2 = st.pop();

                t = new Operator(postfix.charAt(i), t2, t1);
                st.push(t);
            }
        }
        t = st.peek();
        st.pop();
        return t;
    }
    public double eval(String expr){
        String postfix = new InfixToPostfix().convert(expr);
        Expr root = constructTree(postfix);
        return root.evaluate();
    }
}
