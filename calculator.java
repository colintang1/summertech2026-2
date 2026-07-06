import java.util.Scanner;

public class calculator{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        boolean continue1 = true;
        while(continue1 == true){
            System.out.println("Enter your first number");
            double x = scan.nextDouble();
            System.out.println("Enter your second number");
            double y = scan.nextDouble();
            if(x == 13 || y == 78){
                System.out.println("wow you guessed one of my lucky numbers");
            }
            else if(x == 13 && y == 7){
                System.out.println("how did you guess both of my unlucky numbers");
            }
            System.out.println("give me an operation (add, subtract, multiply, divide, stop)");
            String operation = scan.next();
            operation = operation.toLowerCase();
            if(operation .equals( "add")){
                System.out.println(x + y);
            }
            else if(operation .equals( "subtract")){
                System.out.println(x - y);
            }
            else if(operation .equals( "multiply")){
                System.out.println(x * y);
            }
            else if(operation .equals( "divide")){
                System.out.println(x / y);
            }
            else if(operation .equals( "stop")){
                continue1 = false;
            }
            else{
                System.out.println("invalid");
            }
        }
    }
}