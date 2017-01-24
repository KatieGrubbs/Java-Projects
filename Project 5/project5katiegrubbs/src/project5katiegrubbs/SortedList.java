package project5katiegrubbs;

/**
 * The SortedList class is used for separate chaining.
 * @author Katie
 */
public class SortedList
{
    private Link first;
//------------------------------------------------------------------------------
    /**
     * Constructor for SortedList.
     * @param none
     * @return nothing
     */
    public SortedList()
    {
        first = null;
    } // End SortedList()
//------------------------------------------------------------------------------
    /**
     * Method to insert a link into the sorted list.
     * @param newLink : Link
     */
    public void insert(Link newLink)
    {
        String key = newLink.pres.getLastName();
        Link previous = null;           // Start at first link
        Link current = first;
        
        while(current != null && key.compareTo(current.pres.getLastName()) > 0)    // Until end of list or until current > key
        {
            previous = current;
            current = current.next;     // Go to next item
        }
        
        if(previous == null)            // If at beginning of list
            first = newLink;            // Make first point to newLink
        else                            // Not at beginning of list
            previous.next = newLink;    // Make previous point to newLink
        
        newLink.next = current;         // Make newLink point to current
    } // End insert()
//------------------------------------------------------------------------------
    /**
     * Method to delete a link from the sorted list.
     * @param key : String
     * @return nothing
     */
    public void delete(String key)
    {
        Link current = first;
        
        while(current != null && key.compareTo(current.pres.getLastName()) != 0)   // Until end of list or until key is equal to current
        {
            if (current.next == null)
                return;
            else
                current = current.next; // Go to next link
        }
        current.deleteKey();
    } // End delete()
//------------------------------------------------------------------------------
    /**
     * Method to display the sorted list.
     * @param none
     * @return nothing
     */
    public void displayList()
    {
        Link current = first;           // Start at the beginning of list
        
        while (current != null)         // Until end of list
        {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    } // End displayList()
//------------------------------------------------------------------------------
} // End SortedList