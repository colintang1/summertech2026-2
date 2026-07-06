import java.util.Random;
import java.util.Scanner;

public class rockpaperscissors {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        int score = 0;
        boolean continue1 = true;
        while(continue1 == true){
            System.out.println("Pick one [rock, paper, scissors]");
            String input = scan.next().toLowerCase();
            if(!input.equals("rock")  && !input.equals("paper") && !input .equals( "scissors")){
                System.out.println("Invalid choice");
            }
            int cpu = rand.nextInt(0, 3);
            String cpuchoice = "-";
            if(cpu == 0){
                cpuchoice = "rock";
            }
            else if(cpu == 1){
                cpuchoice = "paper";
            }
            else{
                cpuchoice = "scissors";
            }
            System.out.println("The CPU chose " + cpuchoice);
            if((input.equals( "rock") && cpuchoice.equals( "scissors")) || (input .equals( "paper") && cpuchoice .equals( "rock")) || (input .equals( "scissors") && cpuchoice .equals( "paper")) ){
                System.out.println("You won");
                score += 1;
                System.out.println("Your score is " + score);
            }
            else if((input .equals( "rock") && cpuchoice .equals( "paper")) || (input .equals( "paper") && cpuchoice .equals( "scissors")) || (input .equals( "scissors") && cpuchoice .equals( "rock")) ){
                System.out.println("You lost");
                score -= 1;
                System.out.println("Your score is " + score);
            }
            else if(input .equals(cpuchoice)){
                System.out.println("Draw");
                System.out.println("Your score is " + score);
            }
            else{
                System.out.println("You lost cuz your choice is invalid");
            }
            System.out.println("Do you want to continue? [Y] [N]");
             String answer = scan.next().toUpperCase();
             if(answer.equals("N")){
                continue1 = false;
                System.out.println("Your final score is " + score);
                if(score < 0){
                    System.out.println("My grandma can do better");
                }
             }
        }





    }
}
