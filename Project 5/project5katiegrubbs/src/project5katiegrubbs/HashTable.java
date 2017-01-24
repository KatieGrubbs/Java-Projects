package project5katiegrubbs;

/**
 * The HashTable class contains methods to insert into or to delete from a hash 
 * table, as well as a hashing function.
 * @author Katie Grubbs
 */
public class HashTable
{
    private DataItem[] hashArray;
    private int arraySize;
    private int probeCount;
//------------------------------------------------------------------------------
    /**
     * Constructor for HashTable.
     * @param size : integer
     * @return none
     */
    public HashTable(int size)
    {
        arraySize = size;
        hashArray = new DataItem[arraySize];
    } // End HashTable()
//------------------------------------------------------------------------------
    /**
     * Method to insert a data item into the hash table.
     * @param item : Presidents
     * @return nothing
     */
    public int insert(DataItem item)
    {
        probeCount = 1;
        
        String key = item.pres.getLastName();
        int hashVal = hashFunc(key);
        
        while (hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1)
        {
            probeCount++;
            ++hashVal;
            hashVal %= arraySize;
        }
        hashArray[hashVal] = item;
        return probeCount;
    } // End insert()
//------------------------------------------------------------------------------
    /**
     * Method to delete a data item from the hash table.
     * @param key : integer
     * @return a DataItem
     */
    public int delete(String key)
    {
        probeCount = 1;
        
        int hashVal = hashFunc(key);
        
        while (hashArray[hashVal] != null)
        {
            if (hashArray[hashVal].pres.getLastName().compareTo(key) == 0 && hashArray[hashVal].getKey() != -1)
            {
                hashArray[hashVal].deleteKey();
                return probeCount;
            }
            probeCount++;
            ++hashVal;
            hashVal %= arraySize;
        }
        return -1;
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
     * Method to display the hash table.
     * @param none
     * @return nothing
     */
    public void displayTable()
    {
        for (int j = 0; j < arraySize; j++)
        {
            if (hashArray[j] != null)
            {
                if (hashArray[j].getKey() == -1)
                    System.out.printf("%-7s %-11s\n", j, "*" + hashArray[j].pres.getLastName());
                else
                    System.out.printf("%-7s %-11s\n", j, hashArray[j].pres.getLastName());
            }
            else
                System.out.printf("%-7s\n", j);
        }
        System.out.println("");
    } // End displayTable()
//------------------------------------------------------------------------------
} // End HashTable