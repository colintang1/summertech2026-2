import java.util.Scanner;
import java.util.Random;
public class tictactoe {
    public static void main(String[] args){
        char[][] board = new char[3][3];
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        int cpu = 0;
        boolean end = false;
        boolean valid = false;
        char player = '-';
        for(int i = 0; i<3;i++){
            for(int j = 0; j<3; j++){
                board[i][j] = '-';
            }
        }
        printBoard(board);
        while(end == false){
            valid = false;
            while(valid == false){
                System.out.println("\nWhere do you want to place your X? [Enter your row and column]");
                int place = scan.nextInt(); 
                if(board[place/10][place%10] == '-'){
                    board[place/10][place%10] = 'X';
                    valid = true;
                }
                else{
                    System.out.println("Invalid!");
                }
            }
            printBoard(board);
            player = 'X';
            end = checkWin(board, player);
            if(end == true){
                break;
            }
            valid = false;
            while(valid == false){
                cpu = rand.nextInt(0, 3) * 10 + rand.nextInt(0, 3); 
                if(board[cpu/10][cpu%10] == '-'){
                    board[cpu/10][cpu%10] = 'O';
                    valid = true;
                }
            }
            printBoard(board);
            player = 'O';
            end = checkWin(board, player);
        }
    }
    public static void printBoard(char[][] board){
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                System.out.print(board[i][j]);
                if(j == 0 || j == 1){
                    System.out.print(" | ");
                }
            }
            if(i == 0 || i == 1){
                System.out.println("\n---------");
            }
        }
        System.out.println("\n");
    }
    public static boolean checkWin(char[][] board, char player){
        for(int i=0; i<3;i++){
            if(board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] == player){
                System.out.println(player + " wins!");
                return true;
            }
        }
        for(int i=0; i<3;i++){
            if(board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] == player){
                System.out.println(player + " wins!");
                return true;
            }
        }
        if(board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] == player){
            System.out.println(player + " wins!");
            return true;
        }
        if(board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] == player){
            System.out.println(player + " wins!");
            return true;
        }
        return false;
    }
}
