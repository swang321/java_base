package test;

import stack.MyStack;

import java.util.Stack;

/**
 * @Date: 2019/1/8 14:21
 * @Description:
 * @Author admin
 */
public class StackMain {

    public static void main(String[] args) {

        Stack<Object> stack = new Stack<Object>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack.search(5));
        System.out.println("------------------------------------------");


        MyStack<Object> myStack = new MyStack<Object>();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);
        myStack.push(5);
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);
        myStack.push(5);
        System.out.println(myStack.search(null));

    }

}
