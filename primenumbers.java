import java.util.Scanner;

public class primenumbers {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        boolean isPrime = true;
        System.out.println("Give me a number and I'll tell you if it's prime");
        int answer = scan.nextInt();
        for(int i=2; i<=(answer-1); i++){
            if(answer % i == 0){
                System.out.println("Your number is not prime");
                isPrime = false;
                break;
            }
        }
        if(isPrime == true){
            System.out.println("Your number is prime");
        }
                
            
            
        
        scan.close();
    }
}