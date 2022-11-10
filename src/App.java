public class App {
    public static void main(String[] args) throws Exception {
        ArrayList al = new ArrayList(10);
        Queue q = new Queue(10);
        Stack s = new Stack(10);
        al.init();
        al.insert(1);
        al.insert(2);
        al.insert(3);
        al.printAll();
        q.init();
        q.enQueue(4);
        q.enQueue(5);
        q.enQueue(6);
        q.printAll();
        s.init();
        s.push(7);
        s.push(8);
        s.push(9);
        s.peek();
        s.pop();
        s.pop();
        s.pop();
    }
}