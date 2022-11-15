class LinkedList {
    Node head;
    Node tail;

    LinkedList() {
        head = null;
        tail = null;
    }

    void insert(int data) {
        if(head == null) {
            Node newNode = new Node(data);
            head = newNode;
            tail = newNode;
        } else {
            Node newNode = new Node(data);
            tail.next = newNode;
            tail = newNode;
        }
    }

    void printAll() {
        Node printNode = head;
        while(printNode != null) {
            System.out.print("[" + printNode.data + "]");
            printNode = printNode.next;
        }
        System.out.println();
    }

    void find(int findData) {
        Node curNode = head;
        while (curNode != null) {
            if (curNode.data == findData) {
                System.out.print("[" + curNode.data + "]");
            }
            curNode = curNode.next;
        }
        System.out.println();
    }

    void update(int targetData, int updateData) {
        Node curNode = head;
        while (curNode != null) {
            if (curNode.data == targetData) {
                curNode.data = updateData;
            }
            curNode = curNode.next;
        }
        return;
    }

    void delete(int deleteData) {
        Node curNode = head;
        Node delNode = null;
        Node prev = null;

        if (curNode.data == deleteData && head == tail) {
            delNode = curNode;
            head = null;
            tail = null;
            return;
        }

        while (curNode != null) {
            if (curNode.data == deleteData) {
                delNode = curNode;
                if (curNode == head) {
                    head = curNode.next;
                    curNode = curNode.next;
                }
                else {
                    curNode = curNode.next;
                    prev.next = curNode;
                    if (delNode == tail) {
                        tail = prev;
                    }
                }
            }
            else {
                prev = curNode;
                curNode = curNode.next;
            }
        }
    }
}

class Node {
    int data;
    Node next;       // .hashCode(); 를 사용해 주소값을 가져옴

    Node(int data) {
        this.data = data;
        next = null;
    }
}