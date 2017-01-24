package project3katiegrubbs;

/**
 * The DoublyLinkedList class contains methods to add links to and remove links
 * from a doubly-linked list.
 * @author Katie
 */
public class DoublyLinkedList
{
    private Link first;     // Reference to first item in list
    private Link last;      // Reference to last item in list
//------------------------------------------------------------------------------
    /**
     * Constructor for DoublyLinkedList.
     * @param none
     * @return nothing
     */
    public DoublyLinkedList()
    {
        first = null;
        last = null;
    } // End DoublyLinkedList()
//------------------------------------------------------------------------------
    /**
     * Method to check if the list is empty.
     * @param none
     * @return boolean value
     */
    public boolean isEmpty()
    {
        return first == null;
    } // End isEmpty()
//------------------------------------------------------------------------------
    /**
     * Method to update the linked list with add and delete transactions.
     * @param object
     * @return none
     */
    public void insertUpdate(Presidents object)
    {
        Link current = first;
        int numNodes = 0;
        
        switch (object.getTransactionCode())
        {
            case "A":
                while (true)
                {
                    if (isEmpty())                  // If list is empty
                    {
                        insertFirst(object);        // Insert at front of list
                        break;
                    }
                    else if (current.data.getLastName().compareTo(object.getLastName()) == 0)   // If object's last name is identical to current's last name
                    {
                        if (current.data.getName().compareTo(object.getName()) == 0)    // If item is duplicate
                        {
                            System.out.printf("%-7s %-12s %24s\n", object.getTransactionCode(), object.getLastName(), "Dupe Add Attempted");
                            break;
                        }
                        else if (current.data.getFirstName().compareTo(object.getFirstName()) > 0)  // If object's first name is alphabetically earlier than current's first name
                        {
                            Link newLink = new Link(object);
                        
                            if (current == last)    // If last link
                                insertLast(object);
                            else                    // Not last link
                            {
                                newLink.previous = current.previous;    // Make newLink point to old previous
                                current.previous.next = newLink;        // Make old previous point to newLink
                            }
                            newLink.next = current;                     // Make newLink point to old current
                            current.previous = newLink;                 // Make old current point to newLink
                            
                            System.out.printf("%-7s %-12s %24s\n", object.getTransactionCode(), object.getLastName(), numNodes);
                            break;
                        }
                    }
                    else if (current.data.getLastName().compareTo(object.getLastName()) > 0)    // If object's last name is alphabetically earlier than current's last name
                    {
                        Link newLink = new Link(object);
                        
                        if (current == last)        // If last link
                            insertLast(object);
                        else                        // Not last link
                        {
                            newLink.previous = current.previous;        // Make newLink point to old previous
                            current.previous.next = newLink;            // Make old previous point to newLink
                        }
                        newLink.next = current;                         // Make newLink point to old current
                        current.previous = newLink;                     // Make old current point to newLink
                        
                        System.out.printf("%-7s %-12s %24s\n", object.getTransactionCode(), object.getLastName(), numNodes);
                        break;
                    }
                    numNodes++;                     // Increment number of preceding nodes
                    current = current.next;         // Move to next link
                }
                break;
            case "D":
                while (true)
                {
                    if (current == null)            // If list was traversed and item wasn't found
                    {
                        System.out.printf("%-7s %-12s %24s\n", object.getTransactionCode(), object.getLastName(), "Transaction Not Found");
                        break;
                    }
                    else if (current.data.getName().compareTo(object.getName()) == 0)   // If item was found
                    {
                        if (current == first)       // If first link
                            first = current.next;
                        else                        // Not first link
                            current.previous.next = current.next;
                        
                        if (current == last)        // If last link
                            last = current.previous;
                        else                        // Not last link
                            current.next.previous = current.previous;
                        
                        System.out.printf("%-7s %-12s %24s\n", object.getTransactionCode(), object.getLastName(), numNodes);
                        break;
                    }
                    numNodes++;                     // Increment number of preceding nodes
                    current = current.next;         // Move to next link
                }
                break;
            default:
                System.out.printf("%-7s %-12s %24s\n", object.getTransactionCode(), "", "Invalid Transaction Type");
                break;
        }
    } // End insertUpdate()
//------------------------------------------------------------------------------
    /**
     * Method to insert a link at the front of a list.
     * @param object : Presidents
     * @return nothing
     */
    public void insertFirst(Presidents object)
    {
        Link newLink = new Link(object);
        if (isEmpty())                  // If list is empty
            last = newLink;             // Make last point to newLink
        else                            // List is not empty
            first.previous = newLink;   // Make old first point to newLink
        newLink.next = first;           // Make newLink point to old first
        first = newLink;                // Make first point to newLink
    } // End insertFirst()
//------------------------------------------------------------------------------
    /**
     * Method to insert a link at the end of a list.
     * @param object : Presidents
     * @return nothing
     */
    public void insertLast(Presidents object)
    {
        Link newLink = new Link(object);
        if (isEmpty())                  // If list is empty
            first = newLink;            // Make first point to newLink
        else                            // List is not empty
        {
            last.next = newLink;        // Make old last point to newLink
            newLink.previous = last;    // Make newLink point to old last
        }
        last = newLink;                 // Make last point to newLink
    } // End insertLast()
//------------------------------------------------------------------------------
    /**
     * Method to delete a link from the front of a list.
     * @param none
     * @return nothing
     */
    public Link deleteFirst()
    {
        Link temp = first;
        if (first.next == null)         // If only one item in list
            last = null;                // Make last point to null
        else                            // More than one item in list
            first.next.previous = null; // Make old next point to null
        first = first.next;             // Make first point to old next
        return temp;
    } // End deleteFirst()
//------------------------------------------------------------------------------
    /**
     * Method to delete a link from the end of a list.
     * @param none
     * @return nothing
     */
    public Link deleteLast()
    {
        Link temp = last;
        if (first.next == null)         // If only one item in list
            first = null;               // Make first point to null
        else                            // More than one item in list
            last.previous.next = null;  // Make old previous point to null
        last = last.previous;           // Make last point to old previous
        return temp;
    } // End deleteLast()
//------------------------------------------------------------------------------
    /**
     * Method to display the contents of the doubly-linked list.
     * @param none
     * @return nothing
     */
    public void displayList()
    {
        displayListForwards();
        displayListBackwards();
    } // End displayList()
//------------------------------------------------------------------------------
    /**
     * Method to display the contents of the doubly-linked list forwards.
     * @param none
     * @return nothing
     */
    private void displayListForwards()
    {
        System.out.println("Doubly-Linked List Displayed Using Forward Pointers");
        System.out.printf("\n%-12s %-13s %-13s\n", "LAST NAME", "FIRST NAME", "STATE");
        Link current = first;
        while (current != null)
        {
            current.displayLink();
            current = current.next;
        }
    } // End displayListForwards()
//------------------------------------------------------------------------------
    /**
     * Method to display the contents of the doubly-linked list backwards.
     * @param none
     * @return nothing
     */
    private void displayListBackwards()
    {
        System.out.println("\n\nDoubly-Linked List Displayed Using Backward Pointers");
        System.out.printf("\n%-12s %-13s %-13s\n", "LAST NAME", "FIRST NAME", "STATE");
        Link current = last;
        while (current != null)
        {
            current.displayLink();
            current = current.previous;
        }
    } // End displayListBackwards()
//------------------------------------------------------------------------------
} // End DoublyLinkedList