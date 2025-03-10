public class BookNode {
    private Book data;
    private BookNode nextNode;

    //default constructor
    public BookNode(){
        data = new Book();
        nextNode = null;
    }

    //primary constructor 1
    public BookNode(Book data, BookNode nextNode){
        this.data = new Book(data); //calls copy constructor in Book to initialise
        this.nextNode = nextNode;
    }

    //primary constructor 2 used 99% of the time
    public BookNode(Book data){
        this.data = new Book(data);
        nextNode = null;
    }

    //copy constructor
    public BookNode(BookNode oldNode){
        this.data = oldNode.data;
        this.nextNode = oldNode.nextNode;
    }

    //getters
    public Book GetData(){
        return data;
    }
    public BookNode GetNextNode(){
        return nextNode;
    }
    public void SetNextNode(BookNode nextNode) {
        this.nextNode = nextNode;
    }
    public void SetData(Book data) {
        this.data = data;
    }

    public void Display(){
        System.out.println("===========================================");
        data.Display();
        System.out.println("===========================================");
    }
}