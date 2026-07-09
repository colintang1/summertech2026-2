public class recursion {
    public static void main(String[] args){
        int x = 6; 
        System.out.println(factorial(6));
        System.out.println(exponent(2,6));
        System.out.println(fibonacci(8));
        System.out.println(palindrone("asdfgdsa"));
    }
    public static void countdown(int x){
        if(x >= 0){
            return;
        }
        System.out.println(x);
        countdown(x-1);
    }
    public static void countup(int x, int y){
        if(x-1 >= y){
            return;
        }
        System.out.println(x);
        countup(x+1, y);
    }
    public static int factorial(int x){
        if(x == 1){
            return 1;
        }
        return x*factorial(x-1);
    }
    public static int exponent(int x, int y){
        if(y == 1){
            return x;
        }
        return x*exponent(x, y-1);
    }
    public static int fibonacci(int x){
        if(x == 1 || x == 2){
            return 1;
        }
        return fibonacci(x-1) + fibonacci(x-2);
    }
    public static boolean palindrone(String x){
        if(x.length() <= 1){
            return true;
        }
        if(x.charAt(0) == x.charAt(x.length()-1)){
            return palindrone(x.substring(1, x.length()-1));
        }
        return false;
    }
}   

