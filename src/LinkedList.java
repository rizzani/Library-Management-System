public class LinkedList {

    private BookNode head;

    //default constructor
    public LinkedList(){
        head = null;
    }

    //primary constructor
    public LinkedList(BookNode head){
        this.head = head; //head point to a node
    }

    //copy constructor
    public LinkedList(LinkedList list){
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
        System.out.println("===========================================");
    }

    public int CountNodes()
    {
        int count = 0;

        BookNode trav = head;
        while(trav !=null)
        {
            count ++;
            trav = trav.GetNextNode();
        }
        return count;
    }

}
