package project3katiegrubbs;

/**
 * The PresidentsMDrvr class contains methods to be used by the Main class.
 * @author Katie
 */
public class PresidentsMDrvr
{
    private Presidents[] myPresidents; // Reference to myPresidents array
    private int nElems;
//------------------------------------------------------------------------------    
    /**
     * Constructor for PresidentsMDrvr.
     * @param maxSize : integer
     * @return nothing
     */
    public PresidentsMDrvr(int maxSize)
    {
        myPresidents = new Presidents[maxSize];
        nElems = 0;
    } // End PresidentsMDrvr()
//------------------------------------------------------------------------------
    /**
     * Method to insert elements into the myPresidents array.
     * @param object : Presidents
     * @return nothing
     */
    public void insert(Presidents object)
    {
        myPresidents[nElems] = object;
        nElems++;
    } // End insert()
//------------------------------------------------------------------------------

    /**
     * Method to sort the contents of the myPresidents array on last name.
     * @param none
     * @return nothing
     */
    public void bubbleSortOnLastName()
    {
        int out, in;
        for (out = nElems-1; out > 1; out--)    // Outer loop (backward)
            for (in = 0; in < out; in++)        // Inner loop (forward)
                if (myPresidents[in].getLastName().compareTo(myPresidents[in+1].getLastName()) > 0) // Out of order?
                    swap(in, in+1);             // Swap them
                else if (myPresidents[in].getLastName().compareTo(myPresidents[in+1].getLastName()) == 0    // Same last name and out of order?
                        && myPresidents[in].getFirstName().compareTo(myPresidents[in+1].getFirstName()) > 0)
                    swap(in, in+1);             // Swap them
    } // End bubbleSortOnName()
//------------------------------------------------------------------------------
    /**
     * Method to swap two elements within the myPresidents array.
     * @param one : integer
     * @param two : integer
     * @return nothing
     */
    private void swap(int one, int two)
    {
        Presidents temp = myPresidents[one];
        myPresidents[one] = myPresidents[two];
        myPresidents[two] = temp;
    } // End swap()
//------------------------------------------------------------------------------
    /**
     * Method to display the contents of the myPresidents array.
     * @param none
     * @return nothing
     */
    public void displayArray()
    {
        System.out.println("Presidents Array");
        System.out.printf("\n%-12s %-13s %-13s\n", "LAST NAME", "FIRST NAME", "STATE");
        for (int i = 0; i < nElems; i++)
            System.out.println(myPresidents[i]);
        System.out.printf("\n\n");
    } // End displayArray()
//------------------------------------------------------------------------------
    /**
     * Method to move the objects from the myPresidents array to a doubly-linked list.
     * @param list
     * @return nothing
     */
    public void movePresidents(DoublyLinkedList list)
    {
        for (int i = 0; i < nElems; i++)
        {
            if (myPresidents[i].getParty().compareTo("Republican") == 0)
                list.insertLast(myPresidents[i]);
        }
    } // End movePresidents()
//------------------------------------------------------------------------------
} // End PresidentsMDrvr