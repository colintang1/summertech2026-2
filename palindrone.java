import java.util.Scanner;
public class palindrone {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Give me a word and I will check if it is a palindrone.");
        String answer = scan.next();
        for(int i=answer.length()-1; i >= 0; i--){
            if(answer.charAt(i) != (answer.charAt(answer.length()-i-1))){
                System.out.println("Your word is not a palindrone");
                break;
            }
            else if(i == 0){
                System.out.println("Your word is a palindrone");
            }
        }
        scan.close();
    }
}