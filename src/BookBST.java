import java.util.ArrayList;
import java.util.List;

public class BookBST {
    private BooKBSTNode root;

    public void Insert(Book book) {
        root = InsertRec(root, book);
    }

    private BooKBSTNode InsertRec(BooKBSTNode root, Book book) {
        if (root == null) {
            return new BooKBSTNode(book);
        }
        if (book.GetTitle().toLowerCase().compareTo(root.GetTitle().toLowerCase()) < 0) {
            root.SetLeft(InsertRec(root.GetLeft(), book));
        } else {
            root.SetRight(InsertRec(root.GetRight(), book));
        }
        return root;
    }

    public void Inorder() {
        InorderRec(root);
    }

    private void InorderRec(BooKBSTNode root) {
        if (root != null) {
            InorderRec(root.GetLeft());
            System.out.println("------------------------------------------------");
            root.GetBook().Display();
            System.out.println("------------------------------------------------");
            inorderRec(root.GetRight());
        }
    }

    public Book SearchByTitle(String title) {
        return SearchTitleRec(root, title);
    }

    private Book SearchTitleRec(BooKBSTNode root, String title) {
        if (root == null) {
            return null;
        }
        int comparison = title.toLowerCase().compareTo(root.GetTitle().toLowerCase());
        if (comparison == 0) {
            return root.GetBook();
        } else if (comparison < 0) {
            return searchTitleRec(root.GetLeft(), title);
        } else {
            return searchTitleRec(root.GetRight(), title);
        }
    }

    public List<Book> SearchByAuthor(String author) {
        List<Book> books = new ArrayList<>();
        SearchAuthorRec(root, author.toLowerCase(), books);
        return books;
    }

    private void SearchAuthorRec(BooKBSTNode root, String author, List<Book> books) {
        if (root != null) {
            SearchAuthorRec(root.GetLeft(), author, books);
            if (root.GetBook().GetAuthor().toLowerCase().contains(author)) {
                books.Add(root.GetBook());
            }
            SearchAuthorRec(root.GetRight(), author, books);
        }
    }

    public Book SearchByISBN(String isbn) { // Changed int to String
        return SearchISBNRec(root, isbn);
    }

    private Book SearchISBNRec(BooKBSTNode root, String isbn) { // Changed int to String
        if (root == null) {
            return null;
        }
        if (root.GetBook().GetIsbn().equals(isbn)) { // Changed from == to .equals()
            return root.GetBook();
        }
        Book leftResult = SearchISBNRec(root.GetLeft(), isbn);
        if (leftResult != null) return leftResult;
        return SearchISBNRec(root.GetRight(), isbn);
    }
}
