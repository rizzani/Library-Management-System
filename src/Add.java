import java.util.Random;

//update
public class Add {
    public Add(BookBST bookBST, PatronLinkList patronLinkList,BookLinkedList bookLinkedList) {
        books(bookBST,bookLinkedList);
        patrons(patronLinkList);
    }

    public static void books(BookBST bookBST,BookLinkedList bookLinkedList) {
        Book[] books = {
                new Book("The Catcher in the Rye", "J.D. Salinger", "9780316769488"),
                new Book("To Kill a Mockingbird", "Harper Lee", "9780061120084"),
                new Book("1984", "George Orwell", "9780451524935"),
                new Book("Moby Dick", "Herman Melville", "9781503280786"),
                new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565"),
                new Book("War and Peace", "Leo Tolstoy", "9781400079988"),
                new Book("Pride and Prejudice", "Jane Austen", "9781503290563"),
                new Book("The Hobbit", "J.R.R. Tolkien", "9780547928227"),
                new Book("Crime and Punishment", "Fyodor Dostoevsky", "9780486415871"),
                new Book("Brave New World", "Aldous Huxley", "9780060850524"),
                new Book("Fahrenheit 451", "Ray Bradbury", "9781451673319"),
                new Book("The Alchemist", "Paulo Coelho", "9780062315007"),
                new Book("Les Misérables", "Victor Hugo", "9780451419439"),
                new Book("Dracula", "Bram Stoker", "9780486411095"),
                new Book("Frankenstein", "Mary Shelley", "9780486282114"),
                new Book("The Picture of Dorian Gray", "Oscar Wilde", "9780141442464"),
                new Book("Wuthering Heights", "Emily Brontë", "9780141439556"),
                new Book("Jane Eyre", "Charlotte Brontë", "9780141441146"),
                new Book("Anna Karenina", "Leo Tolstoy", "9780143035008"),
                new Book("The Brothers Karamazov", "Fyodor Dostoevsky", "9780374528379"),
                new Book("The Count of Monte Cristo", "Alexandre Dumas", "9780140449266"),
                new Book("Don Quixote", "Miguel de Cervantes", "9780060934347"),
                new Book("Ulysses", "James Joyce", "9781840226355"),
                new Book("One Hundred Years of Solitude", "Gabriel Garcia Marquez", "9780060883287"),
                new Book("The Stranger", "Albert Camus", "9780679720201"),
                new Book("The Road", "Cormac McCarthy", "9780307387899"),
                new Book("Beloved", "Toni Morrison", "9781400033416"),
                new Book("Slaughterhouse-Five", "Kurt Vonnegut", "9780440180296"),
                new Book("Catch-22", "Joseph Heller", "9781451626650"),
                new Book("Lord of the Flies", "William Golding", "9780399501487"),
                new Book("The Book Thief", "Markus Zusak", "9780375842207"),
                new Book("A Tale of Two Cities", "Charles Dickens", "9781853262647"),
                new Book("Gone with the Wind", "Margaret Mitchell", "9781416548942"),
                new Book("The Secret Garden", "Frances Hodgson Burnett", "9780192835963"),
                new Book("Great Expectations", "Charles Dickens", "9780141439563"),
                new Book("The Sun Also Rises", "Ernest Hemingway", "9780743297332"),
                new Book("The Old Man and The Sea", "Ernest Hemingway", "9780684801223"),
                new Book("Mansfield Park", "Jane Austen", "9780141439808"),
                new Book("The Scarlet Letter", "Nathaniel Hawthorne", "9780486280486"),
                new Book("A Farewell to Arms", "Ernest Hemingway", "9780684801469"),
                new Book("Middlemarch", "George Eliot", "9780141439549"),
                new Book("Persuasion", "Jane Austen", "9780141439686"),
                new Book("The Odyssey", "Homer", "9780140268867"),
                new Book("Dune", "Frank Herbert", "9780441013593"),
                new Book("The Shining", "Stephen King", "9780307743657"),
                new Book("It", "Stephen King", "9781501142970"),
                new Book("The Stand", "Stephen King", "9780307743688"),
                new Book("The Silence of the Lambs", "Thomas Harris", "9780312924584"),
                new Book("Red Dragon", "Thomas Harris", "9780425228227")
        };

        for (Book book : books) {
            bookBST.insert(book);
            bookLinkedList.InsertAtBack(book);
        }
    }


    public static void patrons(PatronLinkList patronLinkList) {
        String[] firstNames = {"John", "Jane", "Alex", "Emily", "Michael", "Sarah", "David", "Sophia", "Daniel", "Olivia"};
        String[] lastNames = {"Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia", "Martinez", "Hernandez", "Davis", "Lopez"};

        Random rand = new Random();

        for (int i = 0; i < 20; i++) {
            String fName = firstNames[rand.nextInt(firstNames.length)];
            String lName = lastNames[rand.nextInt(lastNames.length)];
            Patron patron = new Patron(fName, lName);
            patronLinkList.insertAtBack(patron);
        }
    }
}
