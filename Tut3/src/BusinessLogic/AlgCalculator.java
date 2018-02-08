package BusinessLogic;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by Amay on 2/8/2018.
 */
public class AlgCalculator extends Calculator{
    private StringTokenizer token;
    private ArrayList<Integer> arrlist;
    @Override
    public double cal(String expr) {
        
        token=new StringTokenizer(expr,"(");
        String tempt=token.nextToken();
        String temp=token.nextToken();
        
        token=new StringTokenizer(temp,")");
        temp=token.nextToken();
        
        token=new StringTokenizer(temp,",");
        arrlist=new ArrayList<>();
        
        while(token.hasMoreTokens()){
            arrlist.add(Integer.parseInt(token.nextToken()));
        }
        
        int arr[]=new int[arrlist.size()];
        for(int i=0;i<arrlist.size();i++)
        {
            arr[i]=(int)arrlist.get(i);
        }
        if(tempt.equals("min"))
        {
            return min(arr);
        }
        else if(tempt.equals("max"))
        {
            return max(arr);
        }
        else if(tempt.equals("mean"))
        {
            return mean(arr);
        }
        else if(tempt.equals("sd"))
        {
            return stddev(arr);
        }
        else if(tempt.equals("var"))
        {
            return var(arr);
        }
        return (double) 0.0;
    }
    @Override
    public double add(double a, double b) {
        return a + b;
    }

    @Override
    public double sub(double a, double b) {
        return a - b;
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

    public double min(int[] arr) {
        int min=arr[0];
        for(int k=1;k<arr.length;k++)
        {
            if(arr[k]<min)
                min=arr[k];
        }
        return min;
    }

    public double max(int[] arr) {
        int max=arr[0];
        for(int k=1;k<arr.length;k++)
        {
            if(arr[k]>max)
                max=arr[k];
        }
        return max;
    }

    public double stddev(int[] arr) {
        double sum = 0.0, standardDeviation = 0.0;

        for(double num : arr) {
            sum += num;
        }

        double mean = sum/10;

        for(double num: arr) {
            standardDeviation += Math.pow(num - mean, 2);
        }
        return Math.sqrt(standardDeviation/10);
    }

    public double var(int[] arr) {
        double sd=stddev(arr);
        return Math.pow(sd,2);
    }

    public double mean(int[] arr) {
        double sum=0.0;
        for(double num : arr) {
            sum += num;
        }
        int length=arr.length;
        double mean=sum/length;
        return mean;
    }
}
