public class Book {
    private String title_;
    private String author;
    private String isbn;  // Changed from int to String
    private boolean isAvailable;

    // Default constructor
    public Book() {
        title_ = "Book Title";
        author = "Book Author";
        isbn = "1234"; // Default as string
        isAvailable = true;
    }

    // Primary constructor
    public Book(String title_, String author, String isbn, boolean isAvailable) {
        this.title_ = title_;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = isAvailable;
    }

    // Copy constructor
    public Book(Book oldBook) {
        this.title_ = oldBook.title_;
        this.author = oldBook.author;
        this.isbn = oldBook.isbn;
        this.isAvailable = oldBook.isAvailable;
    }

    // Getters
    public String GetTitle() {
        return title_;
    }

    public String GetAuthor() {
        return author;
    }

    public String GetIsbn() {  // Changed return type
        return isbn;
    }

    public boolean GetIsAvailable() {
        return isAvailable;
    }

    // Setters
    public void SetTitle(String title_) {
        this.title_ = title_;
    }

    public void SetAuthor(String author) {
        this.author = author;
    }

    public void SetIsbn(String isbn) { // Changed parameter type
        this.isbn = isbn;
    }

    public void SetAvailable(boolean available) {
        isAvailable = available;
    }

    public void Display() {
        System.out.println("Book Title: " + title_);
        System.out.println("Book Author: " + author);
        System.out.println("Book ISBN: " + isbn);
        System.out.println(isAvailable ? "Book is available" : "Book is not available");
    }
}
