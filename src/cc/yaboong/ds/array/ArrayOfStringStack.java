package cc.yaboong.ds.array;

import java.util.Arrays;

/**
 * Created by yaboong on 2018. 1. 15..
 */
public class ArrayOfStringStack {
    private static final int DEFAULT_CAPACITY = 1;
    private String[] stack;
    private int N = 0;

    public ArrayOfStringStack(){
        stack = new String[DEFAULT_CAPACITY];
    }

    private boolean isFull(){
        return N == stack.length;
    }

    private boolean isEmpty() {
        return N == 0;
    }

    public void push(String item){
        if(isFull()) resize(2*stack.length);
        stack[N++] = item;
    }

    public String pop(){
        if (!isEmpty()) {
            String item = stack[--N];
            stack[N] = null;
            if (N > 0 && N == stack.length / 4) resize(stack.length / 2);
            return item;
        }
        return "";
    }

    private void resize(int newCapacity){
        stack = Arrays.copyOf(stack, newCapacity);
    }

    public void print(){
        if (isEmpty()) printEmpty();
        for(int i=0; i<N; i++){
            System.out.println(stack[i] + " ");
        }
    }

    private void printEmpty() {
        System.out.println("stack is empty");
    }

    public static void main(String[] args) {
        ArrayOfStringStack stack = new ArrayOfStringStack();

        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        stack.push("5");
        stack.push("6");
        stack.push("7");
        stack.push("8");
        stack.push("9");
        stack.push("10");
        stack.push("11");
        stack.push("12");
        stack.push("13");
        stack.push("14");

        System.out.println("After Push");
        stack.print();

        System.out.println("Popped item: " + stack.pop());
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.print();
    }
}
