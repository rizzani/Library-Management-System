import java.util.List;
import java.util.Scanner;

public class LibraryManagementSystem {
   private BookLinkedList books;
   private BookBST bookBST;
   private PatronLinkList patronList;
   private static Scanner scanner;

   public LibraryManagementSystem() {
       this.books = new BookLinkedList();
       this.patronList = new PatronLinkList();
       this.bookBST = new BookBST();
       this.scanner = new Scanner(System.in);
       Add.patrons(patronList);
       Add.books(bookBST,books);
   }

    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printHeader(String title) {
        int width = 50;
        String border = "=".repeat(width); // Repeat '=' for the full width

        // Center the title
        int padding = (width - title.length()) / 2;
        String formattedTitle = " ".repeat(Math.max(0, padding)) + title;

        System.out.println(border);
        System.out.println(formattedTitle);
        System.out.println(border);
    }

    public static void printSubHeader(String subtitle) {
        int width = 50;
        String subBorder = "-".repeat(width);
        int subPadding = (width - subtitle.length()) / 2;
        String formattedSubtitle = " ".repeat(Math.max(0, subPadding)) + subtitle;

        System.out.println(formattedSubtitle);
        System.out.println(subBorder);
    }

    public void mainMenu() {
        while (true) {
            clearScreen();
            printHeader("🔐 Welcome to Library System");

            System.out.println("1️⃣ Login");
            System.out.println("2️⃣ Sign Up");
            System.out.println("3️⃣ Exit");

            System.out.print("\nEnter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1": login(); break;
                case "2": signUp(); break;
                case "3":
                    System.out.println("👋 Exiting... Goodbye!");
                    return;
                default:
                    System.out.println("⚠ Invalid choice! Please select 1-3.");
            }
            System.out.println("\nPress Enter to continue...");
            scanner.nextLine();
        }
    }
    //Method for Main Menu
    public void login() {
        clearScreen();
        printHeader("🔑 Login");

        System.out.print("📛 Enter Card Number: ");
        String cardNumber = scanner.nextLine().trim();

        System.out.print("🔐 Enter Password: ");
        String password = scanner.nextLine().trim();

        // Check if the card number and password match a patron's credentials
        Patron patron = patronList.findPatron(cardNumber);

        if (patron != null && patron.getPassword().equals(password)) {
            System.out.println("✅ Login successful!");
            System.out.println("Welcome, " + patron.getName() + "!");

            user(patron);
        } else {
            System.out.println("⚠ Invalid card number or password. Please try again.");
        }

       // System.out.println("\nPress Enter to continue...");
       // scanner.nextLine();
    }
    public void user(Patron patron) {
        if (patron.isFirstLogin()){
            changePassword(patron);
        }
        clearScreen();
        printHeader("👤 User Dashboard: " + patron.getName());
        if (patron.isAdmin()){
            adminDisplay();
        } else {
            patronDisplay(patron);
        }
    }
    private static void changePassword(Patron patron) {
        clearScreen();
        printHeader("🔑 Change Password");

        System.out.print("🆕 Enter New Password: ");
        String newPassword = scanner.nextLine();

        patron.setPassword(newPassword);

        System.out.println("\n✅ Password changed successfully!");
    }

    public void adminDisplay(){
       while (true) {
           clearScreen();
           printHeader("📚 Library Management System");
           System.out.println("1️⃣ Book Management");
           System.out.println("2️⃣ Patron Management");
           System.out.println("3️⃣ Checkout Process");
           System.out.println("4️⃣ Handling Waitlists");
           System.out.println("5️⃣ Returning Books");
           System.out.println("6️⃣ Search System");
           System.out.println("7️⃣ User Interface Settings");
           System.out.println("8️⃣ File System & Storage");
           System.out.println("9️⃣ Exit");

           System.out.print("\nEnter your choice: ");
           String choice = scanner.nextLine();

           switch (choice) {
               case "1": bookManagement(); break;
               case "2": patronManagement(); break;
               case "3": checkoutProcess(); break;
               case "4": handleWaitlists(); break;
               case "5": returningBooks(); break;
               case "6": searchSystem(false); break;
               case "7": userInterface(); break;
               case "8": fileSystem(); break;
               case "9":
                   System.out.println("Exiting... Goodbye!");
                   return;
               default:
                   System.out.println("Invalid choice! Please select a valid option.");
           }
           System.out.println("\nPress Enter to continue...");
           scanner.nextLine();
       }
   }

    public void bookManagement() {
        while (true) {
            clearScreen();
            printHeader("📖 Book Management");
            System.out.println("1. Add a Book");
            System.out.println("2. Remove a Book");
            System.out.println("3. Search a Book");
            System.out.println("4. View All Books");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine(); // Read user input

            switch (choice) {
                case "1":
                    addBook();
                    break;
                case "2":
                    removeBook();
                    break;
                case "3":
                    searchSystem(false);
                    break;
                case "4":
                    books.DisplayList(true);
                    break;
                case "5":
                    System.out.println("Returning to Main Menu...");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }
    // methods for Book Management
    public void addBook() {
        clearScreen();
        printHeader("📕 Adding a new book...");
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter Isbn: ");
        String isbn = scanner.nextLine();
        books.InsertAtBack(new Book(title,author,isbn));
        bookBST.insert(new Book(title,author,isbn));
        System.out.println("'" + title + "' by " + author + " added successfully!");
    }
    public void removeBook() {
        System.out.println("\n🗑️ Removing a book...");
        Book book = searchSystem(true);
        if (book == null) {
            System.out.println("Returning to menu...");
        } else {
            books.remove(book);
            bookBST.delete(book);
            System.out.println("✅ Book removed successfully.");
        }
    }

    public void patronManagement() {
        while (true) {
            clearScreen();
            printHeader("👥 Patron Management");
            System.out.println("1. Register a Patron");
            System.out.println("2. View Patron Details");
            System.out.println("3. Track Checked-out Books");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine(); // Read user input

            switch (choice) {
                case "1":
                    registerPatron();
                    break;
                case "2":
                    viewPatronDetails();
                    break;
                case "3":
                    viewAllPatron();
                    break;
                case "4":
                    System.out.println("Returning to Main Menu...");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }
    //Methods for Patron Management
    public void registerPatron() {
        clearScreen();
        printHeader("👤 Registering a Patron");
        System.out.print("Enter patron First Name: ");
        String fName = scanner.nextLine();
        System.out.print("Enter patron Last Name: ");
        String lName = scanner.nextLine();
        Patron patron = new Patron(fName, lName);
        patronList.insertAtBack(patron);
        System.out.println("✅ Patron '" + patron.getName() + "' registered successfully!");
    }
    public void viewPatronDetails() {
        clearScreen();
        printHeader("👤 View Patron Details");
        System.out.println("Enter Patron Card Number To Search:");
        String cardNumber = scanner.nextLine().trim();

        Patron foundPatron = patronList.findPatron(cardNumber);

        if (foundPatron != null) {
            System.out.println("\n✅ Patron details found:");
            foundPatron.display();
        } else {
            System.out.println("\n⚠️ Patron not found.");
        }
    }
    public void viewAllPatron() {
        clearScreen();
        printHeader("All Patrons");
        patronList.display();
    }

    public static void checkoutProcess() {
        clearScreen();
        printHeader("🛒 Checkout Process");
        System.out.println("1. Select Books");
        System.out.println("2. Finalize Checkout");
        System.out.println("3. Cancel Checkout");
        System.out.println("4. Back to Main Menu");
        scanner.nextLine();
    }

    public static void handleWaitlists() {
        clearScreen();
        printHeader("⏳ Handling Waitlists");
        System.out.println("1. Add to Waitlist");
        System.out.println("2. View Waitlist");
        System.out.println("3. Notify Next Patron");
        System.out.println("4. Back to Main Menu");
        scanner.nextLine();
    }

    public static void returningBooks() {
        clearScreen();
        printHeader("📦 Returning Books");
        System.out.println("1. Return a Book");
        System.out.println("2. Process Waitlist");
        System.out.println("3. Back to Main Menu");
        scanner.nextLine();
    }

    public Book searchSystem(boolean returnBook) {
        while (true) {
            clearScreen();
            printSubHeader("🔍 Search ");
            System.out.println("1. Search by Title");
            System.out.println("2. Search by Author");
            System.out.println("3. Search by ISBN");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    return searchByTitle(returnBook);
                case "2":
                    return searchByAuthor(returnBook);
                case "3":
                    return searchByISBN(returnBook);
                case "4":
                    return null;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }
    //Methods For Search System
    public Book searchByTitle(boolean returnBook) {
        clearScreen();
        printHeader("🔍 Search by Title");
        System.out.println("Type the book title to search.");
        System.out.println("Type '2' to cancel and return to menu.\n");

        while (true) {
            System.out.print("📖 Enter book title: ");
            String title = scanner.nextLine().trim();

            if (title.equals("2")) {
                System.out.println("\n❌ Search cancelled.");
                return null; // Return null if user cancels
            }

            Book foundBook = bookBST.searchByTitle(title);

            if (foundBook != null) {
                if (returnBook) {
                    System.out.println("\n✅ Book found: " + foundBook.getTitle());
                    return foundBook;
                } else {System.out.println("\n✅ Book found:" );
                    foundBook.display(true);
                    return null;
                }
            } else {
                System.out.println("\n⚠️ Book not found. Try again or type '2' to cancel.\n");
            }
        }
    }
    public Book searchByAuthor(boolean returnBook) {
        clearScreen();
        printHeader("🔍 Search by Author");
        System.out.println("Type the author's name to search.");
        System.out.println("Type '2' to cancel and return to menu.\n");

        while (true) {
            System.out.print("✍️ Enter author name: ");
            String author = scanner.nextLine().trim();

            if (author.equals("2")) {
                System.out.println("\n❌ Search cancelled. Returning to menu...");
                return null;
            }

            List<Book> foundBooks = bookBST.searchByAuthor(author);

            if (!foundBooks.isEmpty()) {
                System.out.println("\n✅ Books found by " + author + ":\n");
                for (int i = 0; i < foundBooks.size(); i++) {
                    System.out.println((i + 1) + ". 📖 " + foundBooks.get(i).getTitle() + " (ISBN: " + foundBooks.get(i).getISBN() + ")");
                }

                if (!returnBook) {
                    return null;
                }

                System.out.println((foundBooks.size() + 1) + ". ❌ Cancel\n");

                while (true) {
                    System.out.print("➡️ Choose a book number (1-" + foundBooks.size() + ") or " + (foundBooks.size() + 1) + " to cancel: ");
                    String choice = scanner.nextLine().trim();

                    try {
                        int index = Integer.parseInt(choice);
                        if (index >= 1 && index <= foundBooks.size()) {
                            Book selectedBook = foundBooks.get(index - 1);
                            System.out.println("\n✅ You selected: " + selectedBook.getTitle());
                            return selectedBook;
                        } else if (index == foundBooks.size() + 1) {
                            System.out.println("\n❌ Selection cancelled. Returning to menu...");
                            return null;
                        } else {
                            System.out.println("⚠️ Invalid choice. Please enter a valid number.\n");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("⚠️ Please enter a number.\n");
                    }
                }
            } else {
                System.out.println("\n⚠️ No books found by this author. Try again or type '2' to cancel.\n");
            }
        }
    }
    public Book searchByISBN(boolean returnBook) {
        clearScreen();
        printHeader("🔍 Search by ISBN");
        System.out.println("Type the ISBN number to search.");
        System.out.println("Type '2' to cancel and return to menu.\n");

        while (true) {
            System.out.print("🔢 Enter ISBN: ");
            String isbn = scanner.nextLine().trim();

            if (isbn.equals("2")) {
                System.out.println("\n❌ Search cancelled. Returning to menu...");
                return null;
            }

            Book foundBook = bookBST.searchByISBN(isbn);

            if (foundBook != null) {
                if (returnBook) {
                    System.out.println("\n✅ Book found: " + foundBook.getTitle() + " (ISBN: " + foundBook.getISBN() + ")");
                    return foundBook;
                } else {
                    System.out.println("\n✅ Book found: ");
                    foundBook.display(true);
                    return null;
                }
            } else {
                System.out.println("\n⚠️ No book found with this ISBN. Try again or type '2' to cancel.\n");
            }
        }
    }

    public void patronDisplay(Patron patron) {
        while (true) {
            clearScreen();
            printHeader("📖 Patron Library System");
            System.out.println("1️⃣ Search for a Book");
            System.out.println("2️⃣ Add Book to Checkout");
            System.out.println("3️⃣ Undo Last Book");
            System.out.println("4️⃣ Finalize Checkout");
            System.out.println("5️⃣ Return a Book");
            System.out.println("6️⃣ View My Borrowed Books");
            System.out.println("7️⃣ Exit");

            System.out.print("\nEnter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {

                case "1": searchSystem(false); break;
                case "2": softCheckOutBook(patron); break;
                case "3": undoLastBook(patron); break;
                case "4": finalizeCheckout(patron); break;
                case "5": returnBook(patron); break;
                case "6": viewBorrowedBooks(patron); break;
                case "7":
                    System.out.println("\n📚 Exiting... Goodbye!");
                    return;
                default:
                    System.out.println("⚠ Invalid choice! Please select 1-7.");
            }
            System.out.println("\nPress Enter to continue...");
            scanner.nextLine();
        }
    }
    public void softCheckOutBook(Patron patron) {
        clearScreen();
        printHeader("📖 Add Book to Checkout");
        Book book = searchSystem(true);
        if (book == null) {
            return;
        }
        if (book.IsAvailable()) {
            patron.getCheckout().push(book);
            System.out.println("\n✅ '" + book.getTitle() + "' added to pending checkout.");
        } else {
            System.out.println("\n⚠ Book is unavailable would you like to go on the waitlist?. (" + book.getWaitList().count() + ") on the waitlist");
            System.out.println("1. Join the Waitlist");
            System.out.println("2. Add Next Book to Checkout");
            System.out.println("3. Go Back");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    book.addWaitList(patron);
                    break;
                case "2":
                    softCheckOutBook(patron);
                    break;
                case "3":
                    System.out.println("👋 Exiting...");
                    return;
                default:
                    System.out.println("⚠ Invalid choice! Please select 1-3.");
            }
        }
    }
    public void undoLastBook(Patron patron) {
        if (!patron.getCheckout().isEmpty()) {
            Book removedBook = patron.getCheckout().pop();
            System.out.println("\n❌ '" + removedBook.getTitle() + "' removed from pending checkout.");
        } else {
            System.out.println("\n⚠ No books to undo.");
        }
    }
    private void finalizeCheckout(Patron patron) {
        clearScreen();
        printHeader("✅ Finalize or ❌ Undo Checkout");

        if (patron.getCheckout().isEmpty()) {
            System.out.println("\n⚠ No books in pending checkout.");
            return;
        }

        System.out.println("\n📚 Pending Books for Checkout:");
        Stack tempStack = new Stack();
        while (!patron.getCheckout().isEmpty()) {
            Book book = patron.getCheckout().pop();
            System.out.println("📖 " + book.getTitle());
            tempStack.push(book);
        }

        while (!tempStack.isEmpty()) {
            patron.getCheckout().push(tempStack.pop());
        }

        System.out.println("\n1️⃣ Finalize Checkout");
        System.out.println("2️⃣ Undo Last Added Book");
        System.out.println("3️⃣ Cancel & Return");

        System.out.print("\nChoose an option: ");
        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                checkOut(patron);
                break;
            case "2":
                undoLastBook(patron);
                break;
            case "3":
                System.out.println("\nReturning to menu...");
                break;
            default:
                System.out.println("⚠ Invalid choice! Please select 1-3.");
        }
    }
    public void checkOut(Patron patron) {
       clearScreen();
        while (!patron.getCheckout().isEmpty()) {
            Book book = patron.getCheckout().pop();
            patron.borrowBook(book);
            book.setAvailable(false);
            System.out.println("✅ '" + book.getTitle() + "' checked out successfully!");
        }
    }
    public void returnBook(Patron patron) {
        clearScreen();
        printHeader("📦 Return a Book");
        System.out.print("\nEnter Choose One to return: ");
        Book book = patron.getBooks().RemoveByNumber(scanner);
        if (book != null) {
            book.setAvailable(true);
            System.out.println("\n✅ '" + book.getTitle() + "' returned successfully!");
        } else {
            System.out.println("\n⚠ You haven't borrowed this book.");
        }
    }
    public void viewBorrowedBooks(Patron patron) {
        clearScreen();
        printHeader("📜 My Borrowed Books");
        patron.getBooks().DisplayList(false);
    }


    public static void userInterface() {
        clearScreen();
        printHeader("🎨 User Interface Settings");
        System.out.println("1. Change Theme");
        System.out.println("2. Adjust Text Size");
        System.out.println("3. Back to Main Menu");
        scanner.nextLine();
    }

    public static void fileSystem() {
        clearScreen();
        printHeader("💾 File System & Storage");
        System.out.println("1. Load Data from File");
        System.out.println("2. Save Data to File");
        System.out.println("3. Manage Passwords");
        System.out.println("4. Back to Main Menu");
        scanner.nextLine();
    }


}
