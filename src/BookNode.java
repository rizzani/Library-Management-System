public class BookNode {
    private Book book;
    private BookNode nextNode;

    //default constructor
    public BookNode(){
        book = new Book();
        nextNode = null;
    }

    //primary constructor 1
    public BookNode(Book data, BookNode nextNode){
        this.book = new Book(data); //calls copy constructor in Book to initialise
        this.nextNode = nextNode;
    }

    //primary constructor 2 used 99% of the time
    public BookNode(Book data){
        this.book = new Book(data);
        nextNode = null;
    }

    //copy constructor
    public BookNode(BookNode oldNode){
        this.book = oldNode.book;
        this.nextNode = oldNode.nextNode;
    }

    //getters
    public Book getBook(){
        return book;
    }
    public BookNode getNextNode(){
        return nextNode;
    }
    public void setNextNode(BookNode nextNode) {
        this.nextNode = nextNode;
    }
    public void setBook(Book book) {
        this.book = book;
    }

    public void display(){
        System.out.println("===========================================");
        book.display();
        System.out.println("===========================================");
    }
}