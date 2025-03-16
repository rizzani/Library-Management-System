public class Stack {
    private BookNode top;

    // Primary Constructor
    public Stack() {
        this.top = null;
    }

    public void push(Book book) {
        BookNode newNode = new BookNode(book);
        newNode.setNextNode(top);
        top = newNode;
    }
    public Book pop() {
        if (isEmpty()) {
            return null;
        }
        Book book = top.getBook();
        top = top.getNextNode();
        return book;
    }

    public boolean isEmpty() {
        return top == null;
    }
    public BookNode peek(){
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }
        return top;
    }
}
