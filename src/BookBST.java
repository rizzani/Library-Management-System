import java.util.ArrayList;
import java.util.List;

public class BookBST {
    private BooKBSTNode root;

    public void insert(Book book) {
        root = insertRec(root, book);
    }

    private BooKBSTNode insertRec(BooKBSTNode root, Book book) {
        if (root == null) {
            return new BooKBSTNode(book);
        }
        if (book.getTitle().toLowerCase().compareTo(root.getTitle().toLowerCase()) < 0) {
            root.setLeft(insertRec(root.getLeft(), book));
        } else {
            root.setRight(insertRec(root.getRight(), book));
        }
        return root;
    }

    public void inorder() {
        inorderRec(root);
    }

    private void inorderRec(BooKBSTNode root) {
        if (root != null) {
            inorderRec(root.getLeft());
            System.out.println("------------------------------------------------");
            root.getBook().display(true);
            System.out.println("------------------------------------------------");
            inorderRec(root.getRight());
        }
    }

    public Book searchByTitle(String title) {
        return searchTitleRec(root, title);
    }

    private Book searchTitleRec(BooKBSTNode root, String title) {
        if (root == null) {
            return null;
        }
        int comparison = title.toLowerCase().compareTo(root.getTitle().toLowerCase());
        if (comparison == 0) {
            return root.getBook();
        } else if (comparison < 0) {
            return searchTitleRec(root.getLeft(), title);
        } else {
            return searchTitleRec(root.getRight(), title);
        }
    }

    public List<Book> searchByAuthor(String author) {
        List<Book> books = new ArrayList<>();
        searchAuthorRec(root, author.toLowerCase(), books);
        return books;
    }

    private void searchAuthorRec(BooKBSTNode root, String author, List<Book> books) {
        if (root != null) {
            searchAuthorRec(root.getLeft(), author, books);
            if (root.getBook().getAuthor().toLowerCase().contains(author)) {
                books.add(root.getBook());
            }
            searchAuthorRec(root.getRight(), author, books);
        }
    }

    public Book searchByISBN(String isbn) { // Changed int to String
        return searchISBNRec(root, isbn);
    }

    private Book searchISBNRec(BooKBSTNode root, String isbn) { // Changed int to String
        if (root == null) {
            return null;
        }
        if (root.getBook().getISBN().equals(isbn)) { // Changed from == to .equals()
            return root.getBook();
        }
        Book leftResult = searchISBNRec(root.getLeft(), isbn);
        if (leftResult != null) return leftResult;
        return searchISBNRec(root.getRight(), isbn);
    }

    public void delete(Book book) {
        root = deleteRec(root, book);
    }

    private BooKBSTNode deleteRec(BooKBSTNode root, Book book) {
        if (root == null) return null;

        int comparison = book.getTitle().toLowerCase().compareTo(root.getTitle().toLowerCase());

        if (comparison < 0) {
            root.setLeft(deleteRec(root.getLeft(), book));
        } else if (comparison > 0) {
            root.setRight(deleteRec(root.getRight(), book));
        } else {
            if (book.equals(root.getBook())) {
                if (root.getLeft() == null && root.getRight() == null) {
                    return null;
                }
                if (root.getLeft() == null) {
                    return root.getRight();
                } else if (root.getRight() == null) {
                    return root.getLeft();
                }
                BooKBSTNode successor = minValueNode(root.getRight());
                root.setBook(successor.getBook());
                root.setRight(deleteRec(root.getRight(), successor.getBook()));
            }
        }
        return root;
    }

    private BooKBSTNode minValueNode(BooKBSTNode node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }
}
