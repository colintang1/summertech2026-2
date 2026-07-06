import java.util.Scanner;
public class madlib {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a noun");
        String x = scan.nextLine();
        System.out.println("Enter a verb");
        String y = scan.nextLine();
        System.out.println("bob is a " + x + ". He likes to " + y);
       
    }
}

