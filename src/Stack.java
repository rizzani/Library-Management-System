public class Stack {
    private BookNode top;
    public Stack(BookNode top) {
        this.top = top;
    }
    public Book pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }
        Book book = top.getBook();
        top = top.getNextNode();
        return book;
    }
    public void push(Book book) {
        BookNode newNode = new BookNode(book);
        newNode.setNextNode(top);
        top = newNode;
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
