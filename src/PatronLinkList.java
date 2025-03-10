public class PatronLinkList {

    private PatronNode head;

    //Default Constructor
    public PatronLinkList() {
        head = null;
    }

    public PatronNode GetHead() {
        return head;
    }

    public void SetHead(PatronNode head) {
        this.head = head;
    }

    public boolean IsEmpty() {
        return (head == null);
    }

    public void InsertAtBack(Patron dataToInsert) {
        PatronNode temp = new PatronNode(dataToInsert);

        if (IsEmpty()) {
            head = temp;
        } else {
            PatronNode traverseTemp = head;

            while (traverseTemp.GetNextNode() != null) {
                traverseTemp = traverseTemp.GetNextNode();
            }

            traverseTemp.SetNextNode(temp);
        }
    }
    public int CountNodes()
    {
        int count = 0;

        PatronNode trav = head;
        while(trav !=null)
        {
            count ++;
            trav = trav.GetNextNode();
        };
        return count;
    }

    public void Display() {
        if (IsEmpty()) {
            System.out.println("No patrons in the list.");
            return;
        }

        PatronNode current = head;
        while (current != null) {
            current.Display();
            current = current.GetNextNode();
        }
    }
}
