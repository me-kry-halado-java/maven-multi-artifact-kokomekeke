package hu.meiit.haladojava.calculator;

public class Executor {

    public double add(int a, int b){
        return a + b;
    }

    public double minus(int a, int b){
        return a - b;
    }

    public double multiply(int a, int b){
        return a * b;
    }

    public double divide(int a, int b){
        try{
            return (double)a / b;
        }catch (ArithmeticException e){
            e.printStackTrace();
        }

        return 0;
    }
}
