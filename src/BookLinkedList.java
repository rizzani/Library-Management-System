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
            temp.SetNextNode(head);
            head = temp;
        }
    }

    public void InsertAtBack(Book dataToInsert) {
        BookNode temp = new BookNode(dataToInsert);

        if (IsEmpty()) {
            head = temp;
        } else {
            BookNode traverseTemp = head;

            while (traverseTemp.GetNextNode() != null) {
                traverseTemp = traverseTemp.GetNextNode();
            }

            traverseTemp.SetNextNode(temp);
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
            trav = trav.GetNextNode();
        }
    }

    public int CountNodes()
    {
        int count = 0;

        BookNode trav = head;
        while(trav != null)
        {
            count ++;
            trav = trav.GetNextNode();
        }
        return count;
    }

    public Book[] GetAllBooks() {
        int size = CountNodes();
        Book[] books = new Book[size];
        BookNode trav = head;
        int index = 0;

        while (trav != null) {
            books[index++] = trav.GetData();
            trav = trav.GetNextNode();
        }

        return books;
    }

    public int TotalBooksAvailable()//total books in the library
    {
        int count = 0;

        BookNode trav = head;
        while(trav != null)
        {
            Book currentBook = trav.GetData();
            if(currentBook.GetIsAvailable())
            {
                count++;
            }
            trav = trav.GetNextNode();
        }

        return count;
    }

    public int TotalBooksUnavailable()//total books are checked out by patrons
    {
        int count = 0;

        BookNode trav = head;
        while(trav != null)
        {
            Book currentBook = trav.GetData();
            if(!currentBook.GetIsAvailable())
            {
                count++;
            }
            trav = trav.GetNextNode();
        }

        return count;
    }
}
