public class PatronLinkList {

    private PatronNode head;

    //Default Constructor
    public PatronLinkList() {
        head = null;
    }

    public PatronNode getHead() {
        return head;
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
    public int countNodes() {
        int count = 0;

        PatronNode trav = head;
        while(trav !=null)
        {
            count ++;
            trav = trav.getNextNode();
        }
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

    public Patron findPatron(String cardNumber) {
        if (isEmpty()) {
            System.out.println("No patrons in the list.");
            return null;
        }

        PatronNode current = head;

        while (current != null) {
            if (current.getPatron().getCardNumber().equals(cardNumber)) {
                return current.getPatron();
            }
            current = current.getNextNode();
        }

        System.out.println("Patron not found.");
        return null;

    }

    public boolean removePatron(String cardNumber) {
        if (isEmpty()) {
            System.out.println("No patrons in the list.");
            return false;
        }

        if (head.getPatron().getCardNumber().equals(cardNumber)) {
            head = head.getNextNode();
            return true;
        }

        PatronNode current = head;
        PatronNode previous = null;

        while (current != null && !current.getPatron().getCardNumber().equals(cardNumber)) {
            previous = current;
            current = current.getNextNode();
        }


        if (current == null) {
            System.out.println("Patron not found.");
            return false;
        }

        previous.setNextNode(current.getNextNode());
        return true;
    }
}
