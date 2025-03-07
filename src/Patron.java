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
        this.cardNumber = generateCardNumber();
        this.books = new BookLinkedList();
        this.password = generatePassword();
    }
    //getters
    public String getName() {
        return fName+" "+lName;
    }
    public String getCardNumber() {
        return cardNumber;
    }
    public String getPassword() {
        return password;
    }
    public BookLinkedList getBooks() {
        return books;
    }

    //settters

    public void borrowBook(Book book) {
        this.books.InsertAtBack(book);
    }
    public String getPasswordHash() {
        return generatePassword();
    }

    public void display(){
        System.out.println("Name: " + this.getName());
        System.out.println("Card Number: " + cardNumber);
        if (this.books != null) {
            System.out.println("Books: ");
            Book[] allBooks = books.getAllBooks();
            for (int i = 0; i < allBooks.length; i++) {
                System.out.println(allBooks[i].getTitle());
            }
        }else {
            System.out.println("No books on Loan");
        }
    }

    public String generatePassword() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder password = new StringBuilder(8);

        for (int i = 0; i < 8; i++) {
            int index = random.nextInt(characters.length());
            password.append(characters.charAt(index));
        }

        return password.toString();
    }

    public String generateCardNumber() {
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
