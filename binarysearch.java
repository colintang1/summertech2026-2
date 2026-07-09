import java.util.Scanner;
public class binarysearch {
    public static void main(String[] args){
        int[] list = {1, 2, 4, 7, 13, 23, 28, 30, 38, 55};
        Scanner scan = new Scanner(System.in);
        System.out.println("What number are you searching for?");
        int number = scan.nextInt();
        int index = list.length / 2;
        System.out.println(search(number, list, 0, list.length, index));
        scan.close();
    }
    public static int search(int number, int[] list, int min, int max, int index){
        if(min > max || index >= list.length){
            return -1;
        }
        if(list[index] == number){
            return index;
        }
        if(number > list[index]){
            min = index+1;
            index = (min + max)/2;
        }
        else if(number < list[index]){
            max = index-1;
            index = (min + max)/2;
        }
        return search(number, list, min, max, index);
    }
}
