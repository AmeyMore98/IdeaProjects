/**
 * Created by Amay on 4/1/2018.
 */
package UserInterface;

import java.util.*;

import BusinessLogic.ClientHandler;
import BusinessLogic.expressionComponents.*;

public class Client {
	private static ClientHandler ch;
    public static void main(String args[]) {
    	ch = new ClientHandler();
    	while(true){
	        System.out.println("Enter Expression(without spaces, please): ");
	        Scanner sc = new Scanner(System.in);
	        System.out.println("Answer: " + ch.eval(sc.nextLine()) + "\nContinue(Y/N)?");
	        String choice = sc.nextLine();
	        if(choice.equals("N") || choice.equals("n"))
	            break;
    	}
    }
}
