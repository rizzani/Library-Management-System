public class PatronNode {
    private Patron person;
    private PatronNode nextNode;

    public PatronNode(Patron person) {
        this.person = person;
        this.nextNode = null;
    }
    public Patron GetPerson() {
        return person;
    }
    public void SetPerson(Patron person) {
        this.person = person;
    }
    public PatronNode GetNextNode() {
        return nextNode;
    }
    public void SetNextNode(PatronNode nextNode) {
        this.nextNode = nextNode;
    }
    public void Display(){
        System.out.println("===========================================");
        person.Display();
        System.out.println("===========================================");
    }

}
