import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        LinkedList list = new LinkedList();
        BookBST bookBST = new BookBST();
        Scanner scanner = new Scanner(System.in);
        new Add(bookBST);
        while (true) {
            System.out.println("\nBook Management System");
            System.out.println("1. Insert a book");
            System.out.println("2. Search by Title");
            System.out.println("3. Search by Author");
            System.out.println("4. Search by ISBN");
            System.out.println("5. Display all books");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine(); // Changed from int to String
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
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
