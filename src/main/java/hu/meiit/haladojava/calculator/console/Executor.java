package hu.meiit.haladojava.calculator.console;

public class Executor {

    public int add(int a, int b){
        return a + b;
    }

    public int minus(int a, int b){
        return a - b;
    }

    public int multiply(int a, int b){
        return a * b;
    }

    public double divide(int a, int b){
        try{
            return a / b;
        }catch (ArithmeticException e){
            e.printStackTrace();
        }

        return 0;
    }
}
