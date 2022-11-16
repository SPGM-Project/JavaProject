public class App {
    public static void main(String[] args) throws Exception {
        ArrayList al = new ArrayList(10);
        Queue q = new Queue(10);
        Stack s = new Stack(10);
        LinkedList ll = new LinkedList();
        ll.insert(5);
        ll.insert(5);
        ll.insert(3);
        ll.insert(4);
        ll.printAll();
        ll.delete(5);
        ll.printAll();
    }
}