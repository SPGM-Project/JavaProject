public class Stack{
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

    int peek() {
        System.out.println("가장 위의 값 : " + Stack[topIdx]); 
        return Stack[topIdx-1];
    }
}