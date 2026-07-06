import java.util.Scanner;
public class fibonacci{
    public static void main(String[] args){
        System.out.println("How many numbers of the fibonacci sequence would you like to print?");
        Scanner scan = new Scanner(System.in);
        int answer = scan.nextInt();
        int[] fibonacci = new int[answer];
        fibonacci[0] = 0;
        fibonacci[1] = 1;
        for(int i = 2; i <answer;i++){
            fibonacci[i] = fibonacci[i-2] + fibonacci[i-1];
        }
        for(int i = 0; i <answer; i++){
            System.out.println(fibonacci[i]);
        }
    }
}