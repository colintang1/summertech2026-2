import java.util.ArrayList;
import java.util.Scanner;

public class Blackjack {
    public static void main(String[] args){
        int ms = 0;
        Scanner scan = new Scanner(System.in);
        Deck deck = new Deck();
        int playerScore = 0;
        int dealerScore = 0;
        boolean stop = false;
        while(stop == false){
            String hitstand = "";
            deck.shuffle(); 
            ArrayList<Card> playerHand = new ArrayList<Card>();
            ArrayList<Card> dealerHand = new ArrayList<Card>();
            playerHand.add(deck.drawCard());
            playerHand.add(deck.drawCard());
            dealerHand.add(deck.drawCard());
            dealerHand.add(deck.drawCard());
            printHand(playerHand);
            System.out.println("Your total is " + calcHand(playerHand));
            wait(300);
            System.out.println("\nThe dealer has a " + dealerHand.get(0));
            while(!hitstand.equals("S")){
                System.out.println("Hit or stand? [H] [S]");
                hitstand = scan.next();
                if(hitstand.equals("H")){
                    playerHand.add(deck.drawCard());
                    printHand(playerHand);
                    System.out.println("Your total is " + calcHand(playerHand) + "\n");
                    if(calcHand(playerHand) > 21){
                        System.out.println("Your total is higher than 21!");
                        wait(300);
                        break;
                    }
                }
                else if(!hitstand.equals("S")){
                    System.out.println("Invalid!");
                }
                wait(300);
            }
            while(calcHand(dealerHand) <= calcHand(playerHand) && calcHand(playerHand) <= 21){
                dealerHand.add(deck.drawCard());
            }
            System.out.println("The dealer's total is " + calcHand(dealerHand));
            if(calcHand(playerHand) <= 21){
                if((calcHand(dealerHand) >= calcHand(playerHand)) && (calcHand(dealerHand) <= 21)){
                    System.out.println("Dealer wins!");
                    dealerScore += 1;
                }
                else{
                System.out.println("Player wins!");
                playerScore += 1;
                }
                if(calcHand(playerHand) > calcHand(dealerHand)){
                    System.out.println("Player wins!");
                    playerScore += 1;
                }
            }
            else{
            System.out.println("Dealer wins!");
            dealerScore += 1;
            }
            System.out.println("The score is " + playerScore + " : " + dealerScore);
            if(dealerScore - 3 >= playerScore){
                System.out.print("(You're kind of losing)");
            }
            System.out.println("\nDo you want to continue? [Y] [N]");
            String continue1 = scan.next();
            if(continue1.equals("N")){
                stop = true;
            }
            else if(continue1.equals("Y") && (dealerScore - 3 >= playerScore)){
                System.out.println("Why do you keep gambling???");
            }
            wait(600);
        }
        
        scan.close();
    }
    public static void printHand(ArrayList<Card> hand){
        System.out.println("\nYou have: ");
        for(int i=0; i<hand.size(); i++){
            System.out.println(hand.get(i));
        }
    }
    public static int calcHand(ArrayList<Card> hand){
        int total = 0;
        for(Card c : hand){
            if(c.getNumber() > 1 && c.getNumber() < 11){
                total += c.getNumber();
            }
            else if(c.getNumber() > 10){
                total += 10;
            }
            else{
                if(total + 11 > 21){
                    total += 1;
                }
                else{
                    total += 11;
                }
            }
        }
        return total;
    }
    public static void wait(int ms){
        try{
            Thread.sleep(ms);
        } catch(InterruptedException e){

        }
    }
}
