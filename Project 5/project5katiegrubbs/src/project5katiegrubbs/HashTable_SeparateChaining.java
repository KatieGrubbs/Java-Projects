package project5katiegrubbs;

/**
 * The HashTable_SeparateChaining class uses separate chaining instead of open 
 * addressing.
 * @author Katie
 */
public class HashTable_SeparateChaining
{
    private SortedList[] hashArray;
    private int arraySize;
//------------------------------------------------------------------------------
    /**
     * Constructor for HashTable_SeparateChaining.
     * @param size : integer
     * @return none
     */
    public HashTable_SeparateChaining(int size)
    {
        arraySize = size;
        hashArray = new SortedList[arraySize];
        
        for (int j = 0; j < arraySize; j++)
            hashArray[j] = new SortedList();
    } // End HashTable_SeparateChaining()
//------------------------------------------------------------------------------
    /**
     * Method to insert a link into the separate chaining hash table.
     * @param newLink : Link
     * @return nothing
     */
    public void insert(Link newLink)
    {
        String key = newLink.pres.getLastName();
        int hashVal = hashFunc(key);
        hashArray[hashVal].insert(newLink);
    } // End insert()
//------------------------------------------------------------------------------
    /**
     * Method to delete a link from the separate chaining hash table.
     * @param key : integer
     * @return nothing
     */
    public void delete(String key)
    {
        int hashVal = hashFunc(key);
        hashArray[hashVal].delete(key);
    } // End delete()
//------------------------------------------------------------------------------
    /**
     * Method to return a hash value.
     * @param key : String
     * @return an integer
     */
    public int hashFunc(String key)
    {
        key = key.toLowerCase();
        int hashVal = 0;
        
        for (int j = 0; j < key.length(); j++)
        {
            int letter;
            if (key.charAt(j) == '_')
                letter = 0;
            else
                letter = key.charAt(j) - 96;
            hashVal = (hashVal + letter) % arraySize;
        }
        return hashVal;
    } // End hashFunc()
//------------------------------------------------------------------------------
    /**
     * Method to display the first hash table.
     * @param none
     * @return nothing
     */
    public void displayTable()
    {
        for (int j = 0; j < arraySize; j++)
        {
            System.out.printf("%-8s", j);
            hashArray[j].displayList();
        }
    } // End display()
//------------------------------------------------------------------------------
} // End HashTable_SeparateChaining