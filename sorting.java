import java.util.random.*;
public class sorting {
    public static void main(String[] args){
//bubble
        
        int[] list = {1,5,3,6,32,27,54,13,7,19};
        int[] sortedList = bubble(list);
        for(int i=0; i<list.length; i++){
            System.out.print(sortedList[i] + ", ");
        }
//insert

        int[] list2 = {1,3,34,27,16,8,13,2,4,31,42};
        sortedList = insert(list2);
        System.out.println();
        for(int i=0; i<list2.length; i++){
            System.out.print(sortedList[i] + ", ");
        }
//select

        int[] list3 = {23,2,56,4,34,17,12,6,9,29};
        sortedList = select(list3);
        System.out.println();
        for(int i=0; i<list3.length; i++){
            System.out.print(sortedList[i] + ", ");
        }
//merge
        //int[] list4 = 
    }


    public static int[] bubble(int[] list){
        int swap = 0;
        for(int i = 0; i<list.length; i++){
            for(int j=0; j<list.length-1; j++){
                if(list[j] > list[j+1]){
                    swap = list[j];
                    list[j] = list[j+1];
                    list[j+1] = swap;
                }
            }
        }
        return list;
    }
    public static int[] insert(int[] list2){
        int swap = 0;
        for(int i=1; i<list2.length;i++){
            int x = i;
            for(int j=0; j<=i-1; j++){;
                if(list2[x]<list2[x-1]){
                    swap = list2[x];
                    list2[x] = list2[x-1];
                    list2[x-1] = swap;
                }
                else{
                    break;
                }
                x -= 1;
            }
        }
        return list2;
    }
    public static int[] select(int[] list3){
        int x = 0;
        int swap = 0;
        for(int j=0; j < list3.length; j++){
            int smallest = 100;
            int smallestindex = 0;
            for(int i = x; i<list3.length; i++){
                if(list3[i] < smallest){
                    smallest = list3[i];
                    smallestindex = i;
                }
            }
            swap = list3[x];
            list3[x] = list3[smallestindex];
            list3[smallestindex] = swap;
            x += 1;
        }
        return list3;
    }
}
