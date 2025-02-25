public class Node {
    private Book data;
    private Node nextNode;

    //default constructor
    public Node(){
        data = new Book();
        nextNode = null;
    }

    //primary constructor 1
    public Node(Book data, Node nextNode){
        this.data = new Book(data); //calls copy constructor in Book to initialise
        this.nextNode = nextNode;
    }

    //primary constructor 2 used 99% of the time
    public Node(Book data){
        this.data = new Book(data);
        nextNode = null;
    }

    //copy constructor
    public Node(Node oldNode){
        this.data = oldNode.data;
        this.nextNode = oldNode.nextNode;
    }

    //getters
    public Book GetData(){
        return data;
    }

    public Node GetNextNode() {
        return nextNode;
    }

    public void SetData(Book data) {
        this.data = data;
    }

    public void SetNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public void Display(){
        System.out.print("[ ");
        data.Display();
        System.out.print(" | * ]->");
    }
}
