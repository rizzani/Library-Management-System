import java.io.*;

public class FileManagement {

    // Save PatronLinkList to a CSV file
    public static void savePatronLinkList(PatronLinkList list, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            PatronNode currentNode = list.getHead();

            // Write header for CSV file
            writer.write("First Name,Last Name,Card Number,Password,Is Admin,First Login\n");

            // Traverse the linked list and write each Patron's information as CSV
            while (currentNode != null) {
                Patron patron = currentNode.getPatron();
                writer.write(patron.getfName() + ",");
                writer.write(patron.getlName() + ",");
                writer.write(patron.getCardNumber() + ",");
                writer.write(patron.getPassword() + ",");
                writer.write(patron.isAdmin() + ",");
                writer.write(patron.isFirstLogin() + "\n");

                currentNode = currentNode.getNextNode();
            }


           // System.out.println("Patrons saved successfully to " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving patrons: " + e.getMessage());
        }
    }

    // Load PatronLinkList from a CSV file
    public static PatronLinkList loadPatronLinkList(String fileName) {
        PatronLinkList list = new PatronLinkList();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            // Skip the header line
            reader.readLine();

            // Read each line and convert it to a Patron object
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");

                if (values.length == 6) {
                    String fName = values[0];
                    String lName = values[1];
                    String cardNumber = values[2];
                    String password = values[3];
                    boolean isAdmin = Boolean.parseBoolean(values[4]);
                    boolean firstLogin = Boolean.parseBoolean(values[5]);

                    Patron patron = new Patron(fName, lName);
                    patron.setCardNumber(cardNumber);
                    patron.setPassword(password);
                    patron.setAdmin(isAdmin);
                    patron.setFirstLogin(firstLogin);


                    // Insert the new Patron into the list
                    list.insertAtBack(patron);
                }
            }

           // System.out.println("Patrons loaded successfully from " + fileName);
        } catch (IOException e) {
            System.out.println("Error loading patrons: " + e.getMessage());
        }

        return list;
    }

    // Save the linked list of books to a CSV file
    public static void saveBookLinkedList(BookLinkedList bookList, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            Book[] books = bookList.getAllBooks();
            // Write header
            writer.write("Title,Author,ISBN,Available\n");

            // Write each book's data
            for (Book book : books) {
                StringBuilder line = new StringBuilder();

                line.append(book.getTitle()).append(",")
                        .append(book.getAuthor()).append(",")
                        .append(book.getISBN()).append(",")
                        .append(book.isAvailable());

                if (book.getWaitList() != null) {
                    Patron[] patrons = book.getWaitList().getAll();
                    for (Patron patron : patrons) {
                        line.append(",").append(patron.getCardNumber());
                    }
                }

                line.append("\n"); // Add a new line at the end
                writer.write(line.toString());
            }
           // System.out.println("Books have been saved to " + fileName);
        } catch (IOException e) {
            System.err.println("Error saving file: " + e.getMessage());
        }
    }

    // Load the linked list of books from a CSV file
    public static BookLinkedList loadBookLinkedList(String fileName, PatronLinkList list) {
        BookLinkedList bookList = new BookLinkedList();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            reader.readLine(); // Skip the header line

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 4) { // Ensure there are at least four fields
                    String title = data[0];
                    String author = data[1];
                    String isbn = data[2];
                    boolean isAvailable = Boolean.parseBoolean(data[3]);

                    Book book = new Book(title, author, isbn);
                    book.setAvailable(isAvailable);

                    // Check if there are patrons in the waitlist
                    if (data.length > 4) {
                        Queue waitList = new Queue();
                        for (int i = 4; i < data.length; i++) {
                            Patron patron = list.findPatron(data[i]); // Assuming Patron constructor takes card number
                            if (patron != null) {
                                waitList.enqueue(patron);
                            }
                        }
                        book.setWaitList(waitList);
                    }

                    // Add the book to the list
                    bookList.InsertAtBack(book);
                }
            }
            // System.out.println("Books have been loaded from " + fileName);
        } catch (IOException e) {
            System.err.println("Error loading file: " + e.getMessage());
        }

        return bookList;
    }

    public static void saveBookTitle(Patron patron) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(patron.getCardNumber() + ".txt"))) {
            Book[] books = patron.getBooks().getAllBooks();
            if (books != null) {
                for (Book book : books) {
                    writer.write(book.getTitle() + "\n");
                }
            }
        } catch (IOException e) {
            System.out.println("Error saving books: " + e.getMessage());
        }
    }
    public static BookLinkedList loadBookTitle(Patron patron, BookBST bst) {
        BookLinkedList bookList = new BookLinkedList();
        String fileName = patron.getCardNumber() + ".txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                bookList.InsertAtBack(bst.searchByTitle(line));
            }
        } catch (IOException e) {
            System.out.println("Error loading books: " + e.getMessage());
        }
        return bookList;
    }
}

