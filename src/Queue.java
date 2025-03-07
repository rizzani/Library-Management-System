public class Queue {
    private PatronNode firstNode;
    private PatronNode lastNode;

    public Queue() {
        this.firstNode = this.lastNode = null;
    }
    public void enqueue(PatronNode node) {
        if (this.firstNode == null) {
            firstNode = lastNode = node;
        }
        else {
            this.lastNode.setNextNode(node);
        }
    }
    public Patron dequeue() {
        if (this.firstNode == null) {
            System.out.println("Queue is empty");
            return null;
        }
        Patron patron = firstNode.getPatron();
        firstNode = firstNode.getNextNode();
        if (firstNode == null) {
            lastNode = null;
        }
        return patron;
    }
    public boolean isEmpty() {
        return this.firstNode == null;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        PatronNode currentNode = this.firstNode;
        while (currentNode != null) {
            currentNode.display();
            currentNode = currentNode.getNextNode();
        }

    }
    public PatronNode peek(){
        if (isEmpty()) {
            System.out.println("Queue is empty");
        }
        return this.firstNode;
    }
}
