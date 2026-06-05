package org.laiszig;

public class Stack {

        private int[] arr; // stores elements
        private int top; // stores the index of the current top element
        private int capacity; // max number of elements the stack can hold

        Stack(int size) {
            arr = new int[size];
            capacity = size;
            top = -1; // empty stack - no valid index yet
        }

        void push(int x) {
            if(top == capacity -1) { // if top == capacity -1 it means the stack is full
                return;
            }
            arr[++top] = x; // add item to stack - increment index
        }

        int pop() {
            if(top == -1) { // if top == -1 it means the stack is empty
                return -1;
            }
            return arr[top--]; // remove item from stack - decrement index
        }

        int peek() {
            if(top == -1) {
                return -1;
            }
            return arr[top]; // returns top element without removing it
        }

        boolean isEmpty() {
            return top ==-1;
        }

}
