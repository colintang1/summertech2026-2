import java.util.Scanner;
public class shapes {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Give me a square length");
        int length = scan.nextInt();
        for(int i = 0; i<length; i++){
            for(int j = 0; j<length; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println("Give me a triangle length");
        length = scan.nextInt();
        for(int i = length; i>0; i--){
            for(int j = 0; j< i; j++){
                System.out.print("  ");
            }
            for(int k = 0; k<=(length-i);k++){
                System.out.print("* ");
            }
            System.out.println();
        }

    }
}
