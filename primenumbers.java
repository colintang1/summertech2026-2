import java.util.Scanner;

public class primenumbers {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        boolean isPrime = true;
        System.out.println("Give me a number and I'll tell you if it's prime");
        int answer = scan.nextInt();
        if(answer % 2 == 0){
            System.out.println("Your number is not prime");
            isPrime = false;
        }
        else{
            for(int i=3; i<=(answer/2); i+=2){
                if(answer % i == 0){
                    System.out.println("Your number is not prime");
                    isPrime = false;
                    break;
                }
            }
        }
        if(isPrime == true){
            System.out.println("Your number is prime");
        }
                
            
            
        
        scan.close();
    }
}