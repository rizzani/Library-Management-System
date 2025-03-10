public class BooKBSTNode {
    private String title;
    private Book book;
    private BooKBSTNode left, right;

    public BooKBSTNode(Book book) {
        this.title = book.GetTitle();
        this.book = book;
        this.left = null;
        this.right = null;
    }
    //getters
    public String GetTitle() {
        return title;
    }

    public Book GetBook() {
        return book;
    }

    public BooKBSTNode GetLeft() {
        return left;
    }

    public BooKBSTNode GetRight() {
        return right;
    }

    //setters
    public void SetLeft(BooKBSTNode left) {
        this.left = left;
    }

    public void SetRight(BooKBSTNode right) {
        this.right = right;
    }
}

