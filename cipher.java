import java.util.Scanner;
public class cipher {
    public static void main(String[] args){
        System.out.println("Enter a string");
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        System.out.println("How much will you shift the string?");
        int shift = scan.nextInt();
        System.out.println(encrypt(s, shift));
        








        scan.close();
    }
    public static String encrypt(String s, int shift){
        String final2 = "";
        for(int i = 0; i<s.length(); i++){
            char letter = s.charAt(i);
            if(letter != ' '){
                for(int j = 0; j<shift; j++){
                    letter += 1;
                    if(letter == '{'){
                        letter = 'a';
                    }
                }
            }
            final2 += letter;
        }
        return final2;
    }
}
