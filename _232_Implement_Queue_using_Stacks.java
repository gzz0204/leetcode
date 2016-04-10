class MyQueue {
    // Push element x to the back of queue.
    // push 1 -> 1
    // push 2 -> 2 1 -> 1 2
    // push 3 -> 3 1 2 -> 1 2 3
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> auxStack = new Stack<>();
    public void push(int x) {
        while(!stack.isEmpty()){
            auxStack.push(stack.pop());
        }
        stack.push(x);
        while(!auxStack.isEmpty()){
            stack.push(auxStack.pop());
        }
    }

    // Removes the element from in front of queue.
    public void pop() {
        stack.pop();
    }

    // Get the front element.
    public int peek() {
        return stack.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack.isEmpty();
    }
}
