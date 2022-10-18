package oct172022;

public class Stack {
    private static class Node {
        int val;
        Node next;
        Node(int v) {
            val = v;
            next = null;
        }
    }

    private Node top;
    private int size = 0;

    public boolean isEmpty(){
        return top==null;
    }

    public int peek(){
        return top.val;
    }

    public void push(int val){
        Node node = new Node(val);
        node.next = top;
        top = node;
        size++;
    }

    public int pop() {
        if(isEmpty()) throw new RuntimeException("Attempt to pop an empty Stack");

        int val = top.val;
        top = top.next;
        size--;
        return val;
    }

    public int max() {
        if(isEmpty()) throw new RuntimeException("Invalid operation max() on empty stack");

        Node cur = top;
        int max = 0;

        while(cur!=null){
            if(cur.val > max) max = cur.val;
            cur = cur.next;
        }

        return max;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
//        stack.pop(); // Checking Exception
//        stack.max(); // Checking Exception

        stack.push(5);
        stack.push(4);
        stack.push(7);
        stack.push(3);
        stack.push(1);
        stack.push(9);
        stack.push(0);

        System.out.println(stack.peek());
        System.out.println(stack.max());
    }
}
