import java.util.Scanner;

public class quizgame {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int score = 0;
        System.out.println("rate this program from 1 to 10");
        int q1 = scan.nextInt();
        if(q1 == 10){
            System.out.println("good job");
            score += 1;
        }
        else{
            System.out.println("you failed");
        }
        System.out.println(" If animals could talk, which one would be the rudest?");
        String q2 = scan.next();
        scan.nextLine();
        if(q2 .equals("chimp")){
            System.out.println("good job");
            score += 1;
        }
        else{
            System.out.println("you failed");
        }
        System.out.println("Why did the nation of Iceland officially lose its status as the only country in the world without mosquitoes");
        String q3 = scan.nextLine();
        if(q3 .equals( "i dont care")){
            System.out.println("good job");
            score += 1;
        }
        else{
            System.out.println("you failed");
        }
        System.out.println("Your score is " + score);

    }
}
