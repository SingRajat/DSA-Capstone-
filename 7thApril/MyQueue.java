import java.util.Stack;

class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public MyQueue() {
         stack1 = new Stack<>();
         stack2 = new Stack<>();
    }

    public void push(int x) {
        while(!stack1.isEmpty()){
            int item = stack1.pop();
            stack2.push(item);
        }
        stack1.push(x);
        while(!stack2.isEmpty()){
            int item = stack2.pop();
            stack1.push(item);
        }
    }

    public int pop() {
        return stack1.pop();
    }

    public int peek() {
        return stack1.peek();
    }

    public boolean empty() {
        return stack1.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        System.out.println("Pushing 1 and 2 to queue...");
        System.out.println("Peek: " + obj.peek());
        System.out.println("Pop: " + obj.pop());
        System.out.println("Empty: " + obj.empty());
    }
}