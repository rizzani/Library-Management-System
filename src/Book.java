public class Book {
    private String title_;
    private String author;
    private String isbn;
    private boolean isAvailable;
    private Queue waitList;

    // Default constructor
    public Book() {
        title_ = "Book Title";
        author = "Book Author";
        isbn = "1234"; // Default as string
        isAvailable = true;
        waitList = new Queue();
    }

    // Primary constructor
    public Book(String title_, String author, String isbn) {
        this.title_ = title_;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = true;
        this.waitList = new Queue();
    }

    // Copy constructor
    public Book(Book oldBook) {
        this.title_ = oldBook.title_;
        this.author = oldBook.author;
        this.isbn = oldBook.isbn;
        this.isAvailable = oldBook.isAvailable;
        this.waitList = new Queue();
    }

    // Getters
    public String getTitle() {
        return title_;
    }
    public String getAuthor() {
        return author;
    }
    public String getISBN() {  // Changed return type
        return isbn;
    }
    public boolean isAvailable() {
        return isAvailable;
    }
    public Queue getWaitList() {
        return waitList;
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
        this.isAvailable = available;
    }

    public void setWaitList(Queue waitList) {
        this.waitList = waitList;
    }

    public void display(boolean display) {
        System.out.println("Book Title: " + title_);
        System.out.println("Book Author: " + author);
        System.out.println("Book ISBN: " + isbn);
        if (display) {
            System.out.println(this.isAvailable ? "Book is available" : "Book is not available");
            System.out.println(waitList.isEmpty() ? "Waitlist is empty" : waitList.count() + " Patrons on the waitlist");
        }

    }

    public void addWaitList(Patron patron) {
        this.waitList.enqueue(patron);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;  // Check if both references point to the same object
        if (obj == null || getClass() != obj.getClass()) return false; // Ensure obj is not null and is the same class

        Book book = (Book) obj; // Cast obj to a Book object
        return title_.equals(book.title_) && author.equals(book.author) && isbn.equals(book.isbn);
    }

}
