import java.util.Scanner;

public class shoppinglist {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("How long do you want your list to be?");
        int length = scan.nextInt();
        String a = scan.nextLine();
        String[] shoppingList = new String[length];
        for(int i = 1; i <= length; i+=1){
            System.out.println("What do you want your " + i + "th item to be?");
            String answer = scan.nextLine();
            shoppingList[i - 1] = answer;
        }
        System.out.println("Here is your list:");
        for(int i = 0; i < length; i+=1){
            System.out.println(shoppingList[i]);
        }
    }
}
