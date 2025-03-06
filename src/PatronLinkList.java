public class PatronLinkList {

    private PatronNode head;

    //Default Constructor
    public PatronLinkList() {
        head = null;
    }

    public PatronNode getHead() {
        return head;
    }

    public void setHead(PatronNode head) {
        this.head = head;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public void insertAtBack(Patron dataToInsert) {
        PatronNode temp = new PatronNode(dataToInsert);

        if (isEmpty()) {
            head = temp;
        } else {
            PatronNode traverseTemp = head;

            while (traverseTemp.getNextNode() != null) {
                traverseTemp = traverseTemp.getNextNode();
            }

            traverseTemp.setNextNode(temp);
        }
    }
    public int countNodes()
    {
        int count = 0;

        PatronNode trav = head;
        while(trav !=null)
        {
            count ++;
            trav = trav.getNextNode();
        };
        return count;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("No patrons in the list.");
            return;
        }

        PatronNode current = head;
        while (current != null) {
            current.display();
            current = current.getNextNode();
        }
    }
}
