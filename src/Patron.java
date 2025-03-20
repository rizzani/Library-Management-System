import java.util.Random;

public class Patron {
    private String fName;
    private String lName;
    private String cardNumber;
    private BookLinkedList books;
    private Stack checkout;
    private String password;
    private boolean isAdmin;
    private boolean firstLogin;

    public Patron(String fName, String lName) {
        this.fName = fName;
        this.lName = lName;
        this.cardNumber = generateCardNumber();
        this.books = new BookLinkedList();
        this.password = generatePassword();
        this.isAdmin = false;
        this.firstLogin = true;
        this.checkout = new Stack();
    }

    //getters
    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getName() {
        return fName + " " + lName;
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

    public Stack getCheckout() {
        return checkout;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public boolean isFirstLogin() {
        return firstLogin;
    }

    //settters
    public void setPassword(String password) {
        this.password = password;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public void setBooks(BookLinkedList books) {
        this.books = books;
    }

    public void setFirstLogin(boolean firstLogin) {
        this.firstLogin = firstLogin;
    }

    public void borrowBook(Book book) {
        this.books.InsertAtBack(book);
        book.setAvailable(false);
    }

    public void display() {
        System.out.println("Name: " + this.getName());
        System.out.println("Card Number: " + cardNumber);
        if (this.books != null) {
            System.out.println("Books: ");
            Book[] allBooks = books.getAllBooks();
            for (int i = 0; i < allBooks.length; i++) {
                System.out.println(allBooks[i].getTitle());
            }
        } else {
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
        firstLogin = true;
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;  // Check if both references point to the same object
        if (obj == null || getClass() != obj.getClass()) return false; // Ensure obj is not null and is the same class

        Patron patron = (Patron) obj; // Cast obj to a Book object
        return cardNumber.equals(patron.cardNumber) && fName.equals(patron.fName) && lName.equals(patron.lName);
    }


}