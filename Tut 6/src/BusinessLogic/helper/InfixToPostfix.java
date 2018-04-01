package BusinessLogic.helper;
import java.util.*;
public class InfixToPostfix {
    public int Prec(char ch){
        switch (ch){
            case '+':
            case '-': return 1;
            case '*':
            case '/': return 2;
            case '^': return 3;
        }
        return -1;
    }
    public String convert(String exp)
    {
        String result = new String("");
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i<exp.length(); ++i)
        {
            char c = exp.charAt(i);
            if (Character.isDigit(c))
            	result += c;
            else if (c == '(')
                stack.push(c);
            else if (c == ')')
            {
                while (!stack.isEmpty() && stack.peek() != '(')
                    result += stack.pop();
                if (!stack.isEmpty() && stack.peek() != '(')
                    return "Invalid Expression"; 
                else
                    stack.pop();
            }
            else
            {
                while (!stack.isEmpty() && Prec(c) <= Prec(stack.peek()))
                    result += stack.pop();
                stack.push(c);
            }

        }
        while (!stack.isEmpty())
            result += stack.pop();
        
        return result;
    }
}
