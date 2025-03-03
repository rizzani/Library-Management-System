public class BooKBSTNode {
    private String title;
    private Book book;
    private BooKBSTNode left, right;

    public BooKBSTNode(Book book) {
        this.title = book.getTitle();
        this.book = book;
        this.left = null;
        this.right = null;
    }
    //getters
    public String getTitle() {
        return title;
    }

    public Book getBook() {
        return book;
    }

    public BooKBSTNode getLeft() {
        return left;
    }

    public BooKBSTNode getRight() {
        return right;
    }

    //setters
    public void setLeft(BooKBSTNode left) {
        this.left = left;
    }

    public void setRight(BooKBSTNode right) {
        this.right = right;
    }
}

