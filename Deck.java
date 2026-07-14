import java.util.Random;
public class Deck {
    private Card[] stack;
    private int cardNumber;
    public Deck(){
        cardNumber = 52;
        stack = new Card[cardNumber];
        String suit = "";
        for(int i = 0; i<4; i++){
            if(i == 0){
                suit = "spades";
            }
            else if(i == 1){
                suit = "hearts";
            }
            else if(i == 2){
                suit = "clubs";
            }
            else{
                suit = "diamonds";
            }
            for(int j = 1; j<14; j++){
                stack[j + i*13-1] = new Card(suit, j);
                //System.out.println(stack[j+i*13-1]);
            }
        }
    }
    public static void main(String[] args){
        Deck deck = new Deck();
        deck.shuffle();
        for(int i=0; i<52; i++){
            System.out.println(deck.drawCard());
        }
    }
    public int getCardNumber(){
        return cardNumber;
    }
    public Card drawCard(){
        cardNumber --;
        return stack[cardNumber];
        
    }
    public void shuffle(){
        cardNumber = 51;
        Random rand = new Random();
        for(int i=0; i<100; i++){
            int a = rand.nextInt(0, 51);
            int b = rand.nextInt(0, 51);
            Card swap = stack[b];
            stack[b] = stack[a];
            stack[a] = swap;
        }   


    }
}
