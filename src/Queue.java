public class Queue{
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