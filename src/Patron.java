import java.util.Random;

public class Patron {
    private String fName;
    private String lName;
    private String cardNumber;
    private BookLinkedList books;
    private String password;

    public Patron(String fName, String lName) {
        this.fName = fName;
        this.lName = lName;
        this.cardNumber = GenerateCardNumber();
        this.books = new BookLinkedList();
        this.password = GeneratePassword();
    }
    //getters
    public String GetName() {
        return fName+" "+lName;
    }
    public String GetCardNumber() {
        return cardNumber;
    }
    public String GetPassword() {
        return password;
    }
    public BookLinkedList GetBooks() {
        return books;
    }

    //settters

    public void BorrowBook(Book book) {
        this.books.InsertAtBack(book);
    }
    public String GetPasswordHash() {
        return GeneratePassword();
    }

    public void Display(){
        System.out.println("Name: " + this.GetName());
        System.out.println("Card Number: " + cardNumber);
        if (this.books != null) {
            System.out.println("Books: ");
            Book[] allBooks = books.GetAllBooks();
            for (int i = 0; i < allBooks.length; i++) {
                System.out.println(allBooks[i].GetTitle());
            }
        }else {
            System.out.println("No books on Loan");
        }
    }

    public String GeneratePassword() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder password = new StringBuilder(8);

        for (int i = 0; i < 8; i++) {
            int index = random.nextInt(characters.length());
            password.append(characters.charAt(index));
        }

        return password.toString();
    }

    public String GenerateCardNumber() {
        String characters = "0123456789";
        Random random = new Random();
        StringBuilder number = new StringBuilder(5);

        // Generate a 5-digit card number
        for (int i = 0; i < 5; i++) {
            int index = random.nextInt(characters.length());
            number.append(characters.charAt(index));
        }
        return number.toString();
    }
}
