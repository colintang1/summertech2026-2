public class Linkedlist {
    public int size;
    public Node head;
    public Linkedlist(){
        size = 0;
        head = null;
    }

    public void add(char value){
        if(head != null){
            size += 1;
            Node count = head;
            while(count.nextN != null){
                count = count.nextN;
            }
            count.nextN = new Node(null, value);
        }
        else{
            size += 1;
            head = new Node(null, value);
        }
    }

    public Node get(int index){
        Node count = head;
        for(int i = 0; i<(index-1); i++){
            count = count.nextN;
        }
        return count;
    }
    public Node remove(int index){
        Node count = head;
        if(size == 1){
            Node delete = head;
            head = null;
            size -= 1;
            return delete;
        }
        else{
            for(int i = 0; i<(index-1); i++){
                count = count.nextN;
            }
            Node delete = count.nextN;
            count.nextN = (count.nextN).nextN;
            size -= 1;
            return delete;
        }
        

    }
    public String toString(){
        String str = "";
        Node count = head;
        for(int i = 0; i<size; i++){
            str += count.value + ", ";
            count = count.nextN;
        }
        return str;
    }
}