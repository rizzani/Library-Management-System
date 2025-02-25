public class Main {

    public static void main(String[] args){

        LinkedList list = new LinkedList();//create empty list
        Book book1 = new Book("Red Riding Hood", "Mary Brown", 12350, true);
        Book book2 = new Book("Blue Berry", "Mary Poppin", 12351, true);
        Book book3 = new Book("Tall Van", "Cher Scott", 12352, false);
        Book book4 = new Book("Big Hill", "Doe Brown", 12353, true);
        Book book5 = new Book("Yellow Car", "John Doe", 12354, false);

        list.DisplayList();//display list before adding any books/nodes
        System.out.println("Number of elements in list: " + list.CountNodes());


        list.InsertAtFront(book1);
        list.InsertAtBack(book2);
        list.InsertAtFront(book3);
        list.InsertAtBack(book4);
        list.InsertAtFront(book5);


        //Display format: 5 -> 3 -> 1 -> 2 -> 4
        list.DisplayList();

        System.out.println();
        System.out.println("Number of elements in list: " + list.CountNodes());
    }
}
