package Views;

/**
 * Created by Amay on 2/22/2018.
 */
import java.util.Scanner;

public class cmd {
    private String exp = new String();
    private int result;
    public String getExp(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Expression:");
        exp = sc.nextLine();
        if(exp.length() > 20){
            System.out.println("Maximum length of 20");
            getExp();
        }
        return exp;
    }

    public void display(int res) {
        System.out.println("Result: " + res);
    }
}