public class Book {
    private String title_;
    private String author;
    private int isbn;
    private boolean isAvailable;

    //default constructor
    public Book(){
        title_ = "Book Title";
        author = "Book Author";
        isbn = 1234;
        isAvailable = true;
    }

    //primary constructor
    public Book(String title_, String author, int isbn, boolean isAvailable){
        this.title_ = title_;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = isAvailable;
    }

    //copy constructor
    public Book(Book oldBook){
        this.title_ = oldBook.title_;
        this.author = oldBook.author;
        this.isbn = oldBook.isbn;
        this.isAvailable = oldBook.isAvailable;
    }


    //getters
    public String GetTitle(){
        return title_;
    }

    public String GetAuthor(){
        return author;
    }

    public int GetIsbn(){
        return isbn;
    }

    public boolean GetIsAvailable(){
        return isAvailable;
    }

    //setters
    public void SetTitle(String title_){
        this.title_ = title_;
    }

    public void SetAuthor(String author){
        this.author = author;
    }

    public void SetIsbn(int isbn){
        this.isbn = isbn;
    }

    public void SetAvailable(boolean available) {
        isAvailable = available;
    }

    public void Display(){
        System.out.print("Book Title: " + title_ + ", ");
        System.out.print("Book Author: " + author + ", ");
        System.out.print("Book ISBN: " + isbn + ", ");
        if(isAvailable) {
            System.out.print("Book is available");
        }
        else{
            System.out.print("Book is not available");
        }
    }
}
