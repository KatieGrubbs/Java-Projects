
/**
 * The PresidentsMDrvr class contains methods to be used by the Main class.
 * @author Katie
 */
public class PresidentsMDrvr
{
    private Presidents[] myPresidents; // Reference to myPresidents array
    private int numElems;
//------------------------------------------------------------------------------    
    /**
     * Constructor for PresidentsMDrvr.
     * @param maxSize : integer
     * @return nothing
     */
    public PresidentsMDrvr(int maxSize)
    {
        myPresidents = new Presidents[maxSize];
        numElems = 0;
    } // End PresidentsMDrvr()
//------------------------------------------------------------------------------
    /**
     * Method to insert elements into the myPresidents array.
     * @param number : integer
     * @param name : string
     * @param code : string
     * @param term : integer
     * @param party : string
     * @param state : string
     * @return nothing
     */
    public void insert(int number, String name, String code, int term, 
            String party, String state)
    {
        myPresidents[numElems] = new Presidents(number, name, code, term, 
                party, state);
        numElems++;
    } // End insert()
//------------------------------------------------------------------------------
    /**
     * Method to display the contents of the myPresidents array.
     * @param none
     * @return nothing
     */
    public void display()
    {
        System.out.printf("\n%2s %-19s %-20s\n", "#", "NAME", "PARTY");
        for (int i = 0; i < numElems; i++)          // For each element,
            System.out.println(myPresidents[i]);    // display the item
    } // End display()
//------------------------------------------------------------------------------
    /**
     * Method to sort the contents of the myPresidents array.
     * @param none
     * @return nothing
     */
    public void bubbleSortOnNumber()
    {
        int out, in;
        for (out = numElems-1; out > 1; out--)  // Outer loop (backward)
            for (in = 0; in < out; in++)        // Inner loop (forward)
                if (myPresidents[in].getNumber() > myPresidents[in+1].getNumber()) // Out of order?
                    swap(in, in+1);             // Swap them
    } // End bubbleSortOnNumber()
//------------------------------------------------------------------------------
    /**
     * Method to sort the contents of the myPresidents array.
     * @param none
     * @return nothing
     */
    public void bubbleSortOnName()
    {
        int out, in;
        for (out = numElems-1; out > 1; out--)  // Outer loop (backward)
            for (in = 0; in < out; in++)        // Inner loop (forward)
                if (myPresidents[in].getName().compareTo(myPresidents[in+1].getName()) > 0) // Out of order?
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
     * Method to search the contents of the myPresidents array for political
     * parties.
     * @param partySearchKey : string
     * @return nothing
     */
    public void sequentialSearch(String partySearchKey)
    {
        int count = 0;
        for (int i = 0; i < numElems; i++)
            if (myPresidents[i].getParty().compareTo(partySearchKey) == 0)  // Compare to key
                count++;                                                    // Increment counter
        System.out.printf("%-20s%-14s%1s\n", partySearchKey, (count > 0)? 
                "Found" : "Not found", (count > 0)? count + " occurences" : "");
    } // End sequentialSearch()
//------------------------------------------------------------------------------
    /**
     * Method to display the results of the sequential search.
     * @param none
     * @return nothing
     */
    public void sequentialSearchDisplay()
    {
        System.out.printf("\n\n%43s\n", "Results of Sequential Search on Party");
        System.out.printf("\n%-20s%-14s%1s\n", "SEARCH ARGUMENT", "RESULT", "NUMBER OF HITS");
    } // End sequentialSearchDisplay()
//------------------------------------------------------------------------------
    /**
     * Method to search the contents of the myPresidents array for president
     * names.
     * @param nameSearchKey : string
     * @return nothing
     */
    public void binarySearch(String nameSearchKey)
    {
        int numProbes = 0, lowerBound = 0, upperBound = numElems-1, currentIndex;
        String result = "";
        while (true)
        {
            numProbes++;                                    // Increment counter
            currentIndex = (lowerBound + upperBound) / 2;   // Set pointer to middle of range
            if (nameSearchKey.compareTo(myPresidents[currentIndex].getName()) == 0)
            {
                result = "Found";
                break;                                      // Found it
            }
            else
            {
                if (lowerBound > upperBound)
                {
                    result = "Not found";
                    numProbes--;
                    break;                                  // Can't find it
                }
                else                                        // Divide range
                {
                    if (myPresidents[currentIndex].getName().compareTo(nameSearchKey) < 0)
                        lowerBound = currentIndex + 1;      // It's in upper half
                    else
                        upperBound = currentIndex - 1;      // It's in lower half
                }
            }
        }
        System.out.printf("%-20s%-14s%1s\n", nameSearchKey, result, numProbes + " probes");
    } // End binarySearch()
//------------------------------------------------------------------------------
    /**
     * Method to display the results of the binary search.
     * @param none
     * @return nothing
     */
    public void binarySearchDisplay()
    {
        System.out.printf("\n\n%41s\n", "Results of Binary Search on Name");
        System.out.printf("\n%-20s%-14s%1s\n", "SEARCH ARGUMENT", "RESULT", "NUMBER OF PROBES");
    } // End binarySearchDisplay()
//------------------------------------------------------------------------------
} // End class PresidentsMDrvr