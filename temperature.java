import java.util.Scanner;
public class temperature {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Convert to celsius or fahrenheit? [C] [F]");
        char convertTo = scan.next().toUpperCase().charAt(0);
        System.out.println("What temperature would you like to convert?");
        double temperature = scan.nextDouble();
        System.out.println(convert(temperature, convertTo));
    }
    public static double convert(double temperature, char convertTo){
        if(convertTo == 'F'){
            temperature = temperature * 1.8 + 32;
        }
        else if(convertTo == 'C'){
            temperature = (temperature - 32) * 5/9;
        }
        return temperature;
    }
}