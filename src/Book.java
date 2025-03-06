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
    public String getTitle() {
        return title_;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {  // Changed return type
        return isbn;
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

    // Setters
    public void setTitle(String title_) {
        this.title_ = title_;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setIsbn(String isbn) { // Changed parameter type
        this.isbn = isbn;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void display() {
        System.out.println("Book Title: " + title_);
        System.out.println("Book Author: " + author);
        System.out.println("Book ISBN: " + isbn);
        System.out.println(isAvailable ? "Book is available" : "Book is not available");
    }
}
