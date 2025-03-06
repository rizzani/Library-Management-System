import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        BookLinkedList list = new BookLinkedList();
        BookBST bookBST = new BookBST();
        PatronLinkList patronList = new PatronLinkList();
        Scanner scanner = new Scanner(System.in);
        new Add(bookBST);
        while (true) {
            System.out.println("\n=== Book & Patron Management System ===");
            System.out.println("1. Insert a book");
            System.out.println("2. Search book by Title");
            System.out.println("3. Search book by Author");
            System.out.println("4. Search book by ISBN");
            System.out.println("5. Display all books");
            System.out.println("6. Add a Patron");
            System.out.println("7. Display all Patrons");
            System.out.println("8. Borrow a Book");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine();
                    bookBST.insert(new Book(title, author, isbn, true));
                    System.out.println("Book inserted successfully!");
                    break;
                case 2:
                    System.out.print("Enter title to search: ");
                    title = scanner.nextLine();
                    Book foundBook = bookBST.searchByTitle(title);
                    if (foundBook != null) {
                        foundBook.display();
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter author to search: ");
                    author = scanner.nextLine();
                    List<Book> booksByAuthor = bookBST.searchByAuthor(author);
                    if (!booksByAuthor.isEmpty()) {
                        booksByAuthor.forEach(Book::display);
                    } else {
                        System.out.println("No books found by this author.");
                    }
                    break;
                case 4:
                    System.out.print("Enter ISBN to search: ");
                    isbn = scanner.nextLine(); // Changed from int to String
                    foundBook = bookBST.searchByISBN(isbn);
                    if (foundBook != null) {
                        foundBook.display();
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 5:
                    bookBST.inorder();
                    break;
                case 6: // Add a Patron
                    System.out.print("Enter Patron Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Card Number: ");
                    String cardNumber = scanner.nextLine();
                    Patron newPatron = new Patron(name, cardNumber);
                    patronList.insertAtBack(newPatron);
                    System.out.println("Patron added successfully! Assigned Password: " + newPatron.getPassword());
                    break;

                case 7: // Display All Patrons
                    System.out.println("\n=== Registered Patrons ===");
                    patronList.display();
                    break;

                case 8: // Borrow a Book
                    System.out.print("Enter Patron Card Number: ");
                    String patronCard = scanner.nextLine();
                    PatronNode patronNode = patronList.getHead();
                    Patron borrower = null;

                    while (patronNode != null) {
                        if (patronNode.getPerson().getCardNumber().equals(patronCard)) {
                            borrower = patronNode.getPerson();
                            break;
                        }
                        patronNode = patronNode.getNextNode();
                    }

                    if (borrower == null) {
                        System.out.println("Patron not found.");
                        break;
                    }

                    System.out.print("Enter Book Title to Borrow: ");
                    title = scanner.nextLine();
                    foundBook = bookBST.searchByTitle(title);

                    if (foundBook != null && foundBook.getIsAvailable()) {
                        borrower.borrowBook(foundBook);
                        foundBook.setAvailable(false);
                        System.out.println("Book borrowed successfully!");
                    } else {
                        System.out.println("Book is not available or does not exist.");
                    }
                    break;

                case 9:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
