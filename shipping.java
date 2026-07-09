public class shipping {
    public static void main(String[] args) {
        String[] items = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l" };
        String[][] storage = new String[6][4];
        int countX = 0;
        int countY = 0;
        for(int i = 0; i<items.length; i++){
            storage[countY][countX] = items[i];
            System.out.println(storage[countY][countX]);
            countX += 1;  
            if(countX == 4){
                countX = 0;
                countY += 1;
            }
        }
        for(int i = 3; i<6; i++){
            for(int j = 0; j<4; j++){
                storage[i][j] = storage[5-i][j];
            }
        }
        for(int i = 0; i<6; i++){
            for(int j = 0; j<4; j++){
                System.out.print(storage[i][j] + " ");
            }
            System.out.println();
        }
    }
}
