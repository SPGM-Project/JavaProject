public class App {
    public static void main(String[] args) throws Exception {
        Queue q = new Queue(10);
        q.init();
        q.printAll();
        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);
        q.enQueue(4);
        q.enQueue(5);
        q.enQueue(6);
        q.enQueue(7);
        q.enQueue(8);
        q.printAll();
        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.printAll();
        q.enQueue(9);
        q.enQueue(10);
        q.printAll();
        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);
        q.printAll();
    }
}
class ArrayList{
    int[] List;
    int numOfDatas;
    int List_Size;

    ArrayList(int List_Size){
        this.List_Size = List_Size;
        this.List = new int[List_Size];
        this.numOfDatas = 0;
    }

    void init(){
        numOfDatas = 0;
    }

    void insert(int insertData){
        if (numOfDatas < List_Size) {
            List[numOfDatas++] = insertData;
        }
        else {
            System.out.println("꽉찼습니다!");
        }
    }

    void printAll() {
        for(int i=0;i<numOfDatas; i++){
            System.out.print("[" + List[i] + "]");
        }
        System.out.println();
    }

    int search(int searchData){
        for (int i : List){
            if(List[i] == searchData)
                return i;
        }
        return -1;
    }

    void delete(int deleteData){
        if (numOfDatas == 0) {
            System.out.println("데이터 없음");
            return;
        }
        for (int i =0;i<numOfDatas;i++)
            if (List[i] == deleteData) {
                for (int j = i+1; j < numOfDatas; j++) { 
                    List[j-1] = List[j];
                }
                numOfDatas -= 1;
                i -=1;	
            }
    }

    void update(int targetData, int updateData){
        if (numOfDatas == 0) {
            System.out.println("데이터 없음");
            return;
        }
        for (int i : List)
            if (List[i] == targetData) {
                List[i] = updateData;
                return;
            }
    }
}

class Stack{
    int[] Stack;
    int topIdx;
    int Stack_Size;
    Stack(int Stack_Size) {
        this.Stack_Size = Stack_Size;
        this.Stack = new int[Stack_Size];
        this.topIdx = -1;
    }

    void init() {
        topIdx = -1;
    }

    void push(int data) {
        if (topIdx < Stack_Size - 1)
            Stack[++topIdx] = data;
    }

    void pop() {
        if (topIdx >= 0) {
            System.out.println("가장 위의 값 꺼냄 : " + Stack[topIdx--]);
            return;
        }
        System.out.println("undefined");
        return;
    }

    void peek() {
        System.out.println("가장 위의 값 : " + Stack[topIdx]); 
    }
}

class Queue{
    int[] Queue;
    int front;
    int rear;
    int Queue_Size;

    Queue(int Queue_Size){
        this.Queue_Size = Queue_Size;
        this.Queue = new int[Queue_Size];
        this.front = 0;
        this.rear = 0;
    }

    void init() {
        front = 0;
        rear = 0;
    }

    void enQueue(int insertData) {
        if((rear+1)%Queue_Size == front){
            System.out.println("꽉찼습니다!");
            return;
        }
        rear = (rear+1)%Queue_Size;
        Queue[rear] = insertData;
    }

    void deQueue() {
        if(front == rear){
            System.out.println("지울 데이터가 없습니다");
            return;
        }
        front = (front+1)%Queue_Size;
        System.out.println(Queue[front] + " 삭제함");
    }

    void printAll() {
        if(front == rear){
            System.out.println("데이터가 없습니다");
            return;
        }
        for(int i = front; (i % Queue_Size) != rear; i++ ){
            System.out.print("[" + Queue[(i+1)%Queue_Size] + "]");
        }
        System.out.println();
    }
}