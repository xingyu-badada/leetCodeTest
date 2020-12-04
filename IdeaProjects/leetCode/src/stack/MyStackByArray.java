package stack;

public class MyStackByArray {
    //存储数据
    int[] array;
    //最大容量
    int maxSize;
    //实际存储容量发小
    int top;

    public MyStackByArray(int size) {
        maxSize = size;
        array = new int[size];
        top = -1;
    }

    public void push(int value) {
        //最上方如果小于最大容量-1；
        if (top < maxSize - 1) {
            top++;
            array[top] = value;
        }
    }

    public int pop() {
        int result = array[top];
        top--;
        return result;
    }

    public int peek() {
        return array[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == (maxSize - 1);
    }

    public static void main(String[] args) {
        MyStackByArray myStack = new MyStackByArray(3);
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println(myStack.isFull());
        System.out.println(myStack.peek());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.isEmpty());
    }
}
