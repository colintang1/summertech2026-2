public class Card {
    private String suit;
    private int number;
    public Card (String s, int n){
        suit = s;
        number = n;
    }
    public int getNumber(){
        return number;
    }
    public String getSuit(){
        return suit;
    }
    public String toString(){
        if(1 < number && number < 11){
            return number + " of " + suit;
        }
        else if(number == 11){
            return "Jack of " + suit;
        }
        else if(number == 12){
            return "Queen of " + suit;
        }
        else if(number == 13){
            return "King of " + suit;
        }
        else{
            return "Ace of " + suit;
        }
    }
}
