public class PatronNode {
    private Patron person;
    private PatronNode nextNode;

    public PatronNode(Patron person) {
        this.person = person;
        this.nextNode = null;
    }
    public Patron getPerson() {
        return person;
    }
    public void setPerson(Patron person) {
        this.person = person;
    }
    public PatronNode getNextNode() {
        return nextNode;
    }
    public void setNextNode(PatronNode nextNode) {
        this.nextNode = nextNode;
    }
    public void display(){
        System.out.println("===========================================");
        person.display();
        System.out.println("===========================================");
    }

}
