public class BookLinkedList {

    private BookNode head;

    //default constructor
    public BookLinkedList(){
        head = null;
    }

    //primary constructor
    public BookLinkedList(BookNode head){
        this.head = head; //head point to a node
    }

    //copy constructor
    public BookLinkedList(BookLinkedList list){
        this.head = list.head;
    }

    public BookNode GetHead() {
        return head;
    }

    public void SetHead(BookNode head) {
        this.head = head;
    }

    public void InsertAtFront(Book dataToInsert) {
        BookNode temp = new BookNode(dataToInsert);
        if (IsEmpty()) {
            head = temp;
        } else {
            temp.setNextNode(head);
            head = temp;
        }
    }

    public void InsertAtBack(Book dataToInsert) {
        BookNode temp = new BookNode(dataToInsert);

        if (IsEmpty()) {
            head = temp;
        } else {
            BookNode traverseTemp = head;

            while (traverseTemp.getNextNode() != null) {
                traverseTemp = traverseTemp.getNextNode();
            }

            traverseTemp.setNextNode(temp);
        }
    }

    public boolean IsEmpty() {
        return (head == null);
    }

    public void DisplayList()
    {
        if(IsEmpty())
        {
            System.err.println("The list is empty! Nothing to display.");
            return;
        }

        BookNode trav = head;
        while(trav !=null)
        {
            trav.display();
            trav = trav.getNextNode();
        }
    }

    public int CountNodes()
    {
        int count = 0;

        BookNode trav = head;
        while(trav !=null)
        {
            count ++;
            trav = trav.getNextNode();
        }
        return count;
    }

    public Book[] getAllBooks() {
        int size = CountNodes();
        Book[] books = new Book[size];
        BookNode trav = head;
        int index = 0;

        while (trav != null) {
            books[index++] = trav.getBook();
            trav = trav.getNextNode();
        }

        return books;
    }
}
