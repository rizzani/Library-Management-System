import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        BookLinkedList list = new BookLinkedList();
        BookBST bookBST = new BookBST();
        PatronLinkList patronList = new PatronLinkList();
        Scanner scanner = new Scanner(System.in);
        new Add(bookBST,patronList);
        /*while (true) {
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
                    bookBST.Insert(new Book(title, author, isbn, true));
                    System.out.println("Book inserted successfully!");
                    break;
                case 2:
                    System.out.print("Enter title to search: ");
                    title = scanner.nextLine();
                    Book foundBook = bookBST.SearchByTitle(title);
                    if (foundBook != null) {
                        foundBook.Display();
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter author to search: ");
                    author = scanner.nextLine();
                    List<Book> booksByAuthor = bookBST.SearchByAuthor(author);
                    if (!booksByAuthor.IsEmpty()) {
                        booksByAuthor.forEach(Book::display);
                    } else {
                        System.out.println("No books found by this author.");
                    }
                    break;
                case 4:
                    System.out.print("Enter ISBN to search: ");
                    isbn = scanner.nextLine(); // Changed from int to String
                    foundBook = bookBST.SearchByISBN(isbn);
                    if (foundBook != null) {
                        foundBook.Display();
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 5:
                    bookBST.inorder();
                    break;
                case 6: // Add a Patron
                    System.out.print("Enter Patron First Name: ");
                    String fName = scanner.nextLine();
                    System.out.print("Enter Patron Last Name: ");
                    String lName = scanner.nextLine();
                    Patron newPatron = new Patron(fName,lName);
                    patronList.InsertAtBack(newPatron);
                    System.out.println("Patron added successfully");
                    System.out.println("Card Number: " + newPatron.GetCardNumber());
                    System.out.print("Assigned Password: " + newPatron.GetPassword());
                    break;

                case 7: // Display All Patrons
                    System.out.println("\n=== Registered Patrons ===");
                    patronList.Display();
                    break;

                case 8: // Borrow a Book
                    System.out.print("Enter Patron Card Number: ");
                    String patronCard = scanner.nextLine();
                    PatronNode patronNode = patronList.GetHead();
                    Patron borrower = null;

                    while (patronNode != null) {
                        if (patronNode.GetPerson().GetCardNumber().equals(patronCard)) {
                            borrower = patronNode.GetPerson();
                            break;
                        }
                        patronNode = patronNode.GetNextNode();
                    }

                    if (borrower == null) {
                        System.out.println("Patron not found.");
                        break;
                    }

                    System.out.print("Enter Book Title to Borrow: ");
                    title = scanner.nextLine();
                    foundBook = bookBST.SearchByTitle(title);

                    if (foundBook != null && foundBook.GetIsAvailable()) {
                        borrower.BorrowBook(foundBook);
                        foundBook.SetAvailable(false);
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
        }*/

    }
}
