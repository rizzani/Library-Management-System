public class PatronNode {
    private Patron patron;
    private PatronNode nextNode;

    public PatronNode(Patron person) {
        this.patron = person;
        this.nextNode = null;
    }
    public Patron getPatron() {
        return patron;
    }
    public void setPatron(Patron patron) {
        this.patron = patron;
    }
    public PatronNode getNextNode() {
        return nextNode;
    }
    public void setNextNode(PatronNode nextNode) {
        this.nextNode = nextNode;
    }
    public void display(){
        System.out.println("===========================================");
        patron.display();
        System.out.println("===========================================");
    }

}
