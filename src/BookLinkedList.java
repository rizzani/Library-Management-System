import java.util.Scanner;

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

    public void remove(Book bookToRemove) {
        if (IsEmpty()) {
            System.out.println("⚠️ List is empty. No book to remove..");
            return;
        }


        if (head.getBook().equals(bookToRemove)) {
            head = head.getNextNode();
            return;
        }

        BookNode prev = head;
        BookNode current = head.getNextNode();

        while (current != null) {
            if (current.getBook().equals(bookToRemove)) {
                prev.setNextNode(current.getNextNode());
                return;
            }
            prev = current;
            current = current.getNextNode();
        }

        System.out.println("⚠️ Book not found in the list.");
    }

    public boolean IsEmpty() {
        return (head == null);
    }

    public void displayList() {
        if(IsEmpty())
        {
            System.out.println("The list is empty!.");
            return;
        }

        BookNode trav = head;
        while(trav !=null)
        {
            trav.display(false);
            trav = trav.getNextNode();
        }
    }

    public int CountNodes() {
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
    public void DisplayListWithNumbers() {
        if (IsEmpty()) {
            System.out.println("The list is empty!");
            return;
        }

        BookNode trav = head;
        int index = 1;
        while (trav != null) {
            System.out.println(index + ". " + trav.getBook().getTitle());
            trav = trav.getNextNode();
            index++;
        }
    }

    public Book RemoveByNumber(Scanner scanner) {
        if (IsEmpty()) {
            System.out.println("The list is empty!");
            return null;
        }

        DisplayListWithNumbers();
        System.out.print("Enter the number of the book to remove: ");
        scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        if (choice < 1 || choice > CountNodes()) {
            System.out.println("Invalid choice!");
            return null;
        }

        if (choice == 1) {
            Book temp = head.getBook();
            head = head.getNextNode();
            System.out.println("Book removed successfully.");
            return temp;
        }

        BookNode prev = head;
        BookNode current = head.getNextNode();
        int index = 2;

        while (current != null) {
            if (index == choice) {
                Book temp = current.getBook();
                prev.setNextNode(current.getNextNode());
                return temp;
            }
            prev = current;
            current = current.getNextNode();
            index++;
        }
        return null;
    }

    public BookBST getBookBST() {
        BookBST bst = new BookBST();
        BookNode trav = head;
        while(trav !=null)
        {
            bst.insert(trav.getBook());
            trav = trav.getNextNode();
        }
        return bst;
    }

    public Book getbook(Book bookToGet) {
        if (IsEmpty()) {
            System.out.println("⚠️ List is empty. No book to remove..");
            return null;
        }


        if (head.getBook().equals(bookToGet)) {
            return head.getBook();
        }

        BookNode prev = head;
        BookNode current = head.getNextNode();

        while (current != null) {
            if (current.getBook().equals(bookToGet)) {
                return current.getBook();
            }
            prev = current;
            current = current.getNextNode();
        }

        System.out.println("⚠️ Book not found in the list.");
        return null;
    }

    public int getCheckOut(){
        Book[] books = getAllBooks();
        int count = 0;
        for (Book book : books) {
            if (!book.isAvailable()){
                count++;
            }
        }
        return count;
    }
}
