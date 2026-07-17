public class Linkedlisttest {
    public static void main(String[] args) {
        Linkedlist link = new Linkedlist();
        link.add('1');
        link.remove(0);
        link.add('2');
        link.add('3');
        link.add('4');
        link.add('5');
        System.out.println(link.get(3).value); 
        //link.remove(4);
        System.out.println(link.toString()); 
    }
}
