class MinStack {
    class Node{
        int val;
        int min;
        Node next;
        public Node(int val, int min){
            this.val = val;
            this.min = min;
        }
    }
    private Node head;
    public MinStack(){
        this.head = null;
    }
    public void push(int x) {
        if(this.head == null){
            this.head = new Node(x,x);
        }else{
            Node newNode = new Node(x, Math.min(this.head.min, x));
            newNode.next = this.head;
            this.head = newNode;
        }
    }

    public void pop() {
        if(this.head != null){
            this.head = this.head.next;
        }
    }

    public int top() {
        if(this.head != null){
            return this.head.val;
        }else{
            return -1;
        }
    }

    public int getMin() {
        return this.head.min;
    }
}
