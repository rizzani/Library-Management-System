import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        LibraryManagementSystem lms = new LibraryManagementSystem();
        lms.mainMenu();

//        Book book1 = new Book("The Catcher in the Rye", "J.D. Salinger", "9780316769488");
//        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", "9780061120084");
//        Book book3 = new Book("1984", "George Orwell", "9780451524935");
//        Book book4 = new Book("Moby Dick", "Herman Melville", "9781503280786");
//        Book book5 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565");
//
//        Patron person1 = new Patron("John1", "Doe1");
//        Patron person2 = new Patron("John2", "Doe2");
//        Patron person3 = new Patron("John3", "Doe3");
//        Patron person4 = new Patron("John4", "Doe4");
//
//        BookLinkedList books = new BookLinkedList();
//
//        books.InsertAtBack(book1);
//        books.InsertAtBack(book2);
//        books.InsertAtBack(book3);
//        books.InsertAtBack(book4);
//        books.InsertAtBack(book5);
//
//        book1.addWaitList(person1);
//        book1.addWaitList(person2);
//
//        book3.addWaitList(person3);
//
//        Book book9 = books.getbook(book1);
//        book9.setAvailable(false);
//       // book1.display(true);
//
//        Patron[] patrons = book1.getWaitList().getAll();
//        BookBST bst = books.getBookBST();
//        books.getbook(book1).addWaitList(person1);
//        System.out.println(books.getbook(book1));
//        System.out.println(bst.searchByTitle("The Catcher in the Rye"));
//        System.out.println(book9);
//        System.out.println(book9.getWaitList());
//        System.out.println(books.getbook(book1).getWaitList());
//
//
//
//        FileManagement.saveBookLinkedList(books,"test.txt");
    }
}
