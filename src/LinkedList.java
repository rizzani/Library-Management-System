public class LinkedList {

    private Node head;

    //default constructor
    public LinkedList(){
        head = null;//head to poin to null
    }

    //primary constructor
    public LinkedList(Node head){
        this.head = head; //head point to a node
    }

    //copy constructor
    public LinkedList(LinkedList list){
        this.head = list.head;//initialize head to point to the head of an existing list
    }

    public Node GetHead() {
        return head;
    }

    public void SetHead(Node head) {
        this.head = head;
    }

    public void InsertAtFront(Book dataToInsert){
        Node temp = new Node(dataToInsert);//create node to be inserted
        if(temp != null) //if created successfully
        {
            if(IsEmpty())//if it is empty
            {
                head = temp;//set head to new node
            }
            else
            {
                temp.SetNextNode(head);//set next node as what head was pointing to before
                head = temp;
            }
        }
        else//if not successful in reserving space that means list is full
        {
            System.err.println("Error! The list is full! Cannot insert new node");
        }
    }

    public void InsertAtBack(Book dataToInsert){
        Node temp = new Node(dataToInsert);//create node to be inserted
        if(temp != null)
        {
            if(IsEmpty())//if it is empty
            {
                head = temp;//set head to new node
            }
            else//if list is not empty
            {
                Node traverseTemp = head;//create a node to aid in list traversal and point ot to start of list
                while(traverseTemp.GetNextNode() != null)//traverse until we get to last node, node with link portion pointing to null
                {
                    traverseTemp = traverseTemp.GetNextNode();//let traverseTemp point to next element in the list
                }//ends when traverseTemp next node is pointing to null
                traverseTemp.SetNextNode(temp);//sets temp as next node in list(back of list)
            }
        }
        else
        {
            System.err.println("Error! The list is full!");
        }
    }

    public boolean IsEmpty()
    {
        return (head == null);//return result of check if head is equal to null
    }

    public void DisplayList()
    {
        if(IsEmpty())
        {
            System.err.println("The list is empty! Nothing to display.");
            return;
        }

        Node trav = head; //create node to aid in list traversal
        while(trav !=null)//while trav is pointing to valid node
        {
            trav.Display();
            trav = trav.GetNextNode();
        }
        System.out.print("null");
    }

    public int CountNodes()
    {
        int count = 0;

        Node trav = head; //create node to aid in list traversal
        while(trav !=null)//while trav is pointing to valid node
        {
            count ++;
            trav = trav.GetNextNode();
        }
        return count;
    }

}
