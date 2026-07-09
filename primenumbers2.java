import java.util.Scanner;
public class primenumbers2 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int index = 1;
        int number = 3;
        System.out.println("How many primes do you want to be generated?");
        int amount = scan.nextInt();
        int[] primeList = new int[amount];
        System.out.println();
        primeList[0] = 2;
        while(index < amount){
            boolean isPrime = true;
            for(int i=0; primeList[i]<Math.sqrt(number); i++){
                if(number % primeList[i] == 0){
                    isPrime = false;
                }
                
            }
            if(isPrime == true){
                primeList[index] = number;
                index += 1;
            }
            number += 2;
        }
        for(int i = 0; i < amount; i++){
            System.out.println(primeList[i]);
        }
        scan.close();
    }
}
