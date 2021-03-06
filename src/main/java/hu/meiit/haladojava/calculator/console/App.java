package hu.meiit.haladojava.calculator.console;

import java.util.Objects;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    private static final String errorResponse = "-";

    public enum Operations{
        ADD('+'),
        MINUS('-'),
        MULTIPLY('*'),
        DIVIDE('/');

        public final char label;

        Operations(char label) {
            this.label = label;
        }

        public static Operations getOp(char exp){
            for(Operations o : values()){
                if(o.label==exp){
                    return o;
                }
            }
            return null;
        }
    }

    private static String[] parse(String exp){
        String[] s;
        if(exp.contains(" ")){
            s = exp.split(" ");
        }else{
            s = exp.split("");
        }


        return s;
    }

    private static String getExp(){
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    private static void assertExp(String[] parts){
        if (parts.length != 3) {
            throw new RuntimeException("wrong input!");
        }
    }

    private static Expression getAsExp(String[] parts){
        return new Expression(
                Integer.parseInt(parts[0]),
                parts[1],
                Integer.parseInt(parts[2])
        );
    }

    public static String execExp(Expression expression){
        String result = errorResponse;
        Executor exec = new Executor();
        Operations op = Operations.getOp(expression.getOperator());

        switch (Objects.requireNonNull(op)){
            case ADD:
                result = String.valueOf(exec.add(expression.getOperand1(),expression.getOperand2()));
                break;
            case MINUS:
                result = String.valueOf(exec.minus(expression.getOperand1(),expression.getOperand2()));
                break;
            case MULTIPLY:
                result = String.valueOf(exec.multiply(expression.getOperand1(),expression.getOperand2()));
                break;
            case DIVIDE:
                result = String.valueOf(exec.divide(expression.getOperand1(),expression.getOperand2()));
                if(result.equals("0.0")){
                    result = errorResponse;
                }
                break;
        }

        return result;
    }

    public static void main( String[] args )
    {

        String result = errorResponse;

        try {
            String exp = getExp();
            String[] parts = parse(exp);
            assertExp(parts);
            Expression expression = getAsExp(parts);
            result = execExp(expression);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        System.out.println(result);
    }
}
