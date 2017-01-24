package project5katiegrubbs;

import java.io.IOException;

/**
 * The Controller class is the middleman between the Main class and other classes.
 * @author Katie Grubbs
 */
public class Controller
{
    private Presidents[] array, updateArray;
    private FileInterface reader;
    private HashTable hashTable1, hashTable2;
    private HashTable_SeparateChaining chainTable;
    private int[] statsT1, statsT2;
//------------------------------------------------------------------------------    
    /**
     * Method to build an array of presidents.
     * @param fileName : String
     * @param size : integer
     * @return nothing
     * @throws java.io.IOException
     */
    public void buildArray(String fileName, int size) throws IOException
    {
        reader = new FileInterface();
        array = reader.readData(fileName, size);
    } // End buildArray()
//------------------------------------------------------------------------------
    /**
     * Method to update an array of presidents.
     * @param fileName : String
     * @param size : integer
     * @return nothing
     * @throws java.io.IOException
     */
    public void updateArray(String fileName, int size) throws IOException
    {
        updateArray = reader.readUpdateData(fileName, size);
        DataItem tempPres;
        int tempKey;
        
        statsT1 = new int[9];
        statsT2 = new int[9];
        
        for (int i = 0; i < updateArray.length; i++)
        {
            if (updateArray[i].getTransactionCode().compareTo("D") == 0)
            {
                statsT1[i] = hashTable1.delete(updateArray[i].getLastName());
                statsT2[i] = hashTable2.delete(updateArray[i].getLastName());
            }
            else
            {
                tempKey = hashTable1.hashFunc(updateArray[i].getLastName());
                tempPres = new DataItem(updateArray[i], tempKey);
                statsT1[i] = hashTable1.insert(tempPres);
                
                tempKey = hashTable2.hashFunc(updateArray[i].getLastName());
                tempPres = new DataItem(updateArray[i], tempKey);
                statsT2[i] = hashTable2.insert(tempPres);
            }
        }
    } // End updateArray()
//------------------------------------------------------------------------------
    /**
     * Method to update an array of presidents for separate chaining.
     * @param fileName : String
     * @param size : integer
     * @return nothing
     * @throws java.io.IOException
     */
    public void updateChainArray(String fileName, int size) throws IOException
    {
        updateArray = reader.readUpdateData(fileName, size);
        Link tempPres;
        int tempKey;
        
        for (int i = 0; i < updateArray.length; i++)
        {
            if (updateArray[i].getTransactionCode().compareTo("D") == 0)
                chainTable.delete(updateArray[i].getLastName());
            else
            {
                tempKey = chainTable.hashFunc(updateArray[i].getLastName());
                tempPres = new Link(updateArray[i], tempKey);
                chainTable.insert(tempPres);
            }
        }
    } // End updateChainArray()
//------------------------------------------------------------------------------
    /**
     * Method to build the first hash table.
     * @param size : integer
     * @return nothing
     */
    public void buildTable1(int size)
    {
        hashTable1 = new HashTable(size);
        DataItem tempPres;
        int tempKey;
        
        for (int i = 0; i < array.length; i++)
        {
            tempKey = hashTable1.hashFunc(array[i].getLastName());
            tempPres = new DataItem(array[i], tempKey);
            hashTable1.insert(tempPres);
        }
    } // End buildTable1()
//------------------------------------------------------------------------------
    /**
     * Method to build the second hash table.
     * @param size : integer
     * @return nothing
     */
    public void buildTable2(int size)
    {
        hashTable2 = new HashTable(size);
        DataItem tempPres;
        int tempKey;
        
        for (int i = 0; i < array.length; i++)
        {
            tempKey = hashTable2.hashFunc(array[i].getLastName());
            tempPres = new DataItem(array[i], tempKey);
            hashTable2.insert(tempPres);
        }
    } // End buildTable2()
//------------------------------------------------------------------------------
    /**
     * Method to build the separate chaining hash table.
     * @param size : integer
     * @return nothing
     */
    public void buildChainTable(int size)
    {
        chainTable = new HashTable_SeparateChaining(size);
        Link tempPres;
        int tempKey;
        
        for (int i = 0; i < array.length; i++)
        {
            tempKey = chainTable.hashFunc(array[i].getLastName());
            tempPres = new Link(array[i], tempKey);
            chainTable.insert(tempPres);
        }
    } // End buildChainTable()
//------------------------------------------------------------------------------
    /**
     * Method to display the hash tables.
     * @param none
     * @return nothing
     */
    public void displayTables()
    {
        System.out.println("Hash Table 1");
        System.out.printf("%-7s %-11s\n", "Index", "Value");
        System.out.println("------------------");
        hashTable1.displayTable();
        
        System.out.println("Hash Table 2");
        System.out.printf("%-7s %-11s\n", "Index", "Value");
        System.out.println("------------------");
        hashTable2.displayTable();
    } // End displayTables()
//------------------------------------------------------------------------------
    /**
     * Method to display the separate chaining hash table.
     * @param none
     * @return nothing
     */
    public void displayChainTable()
    {
        System.out.println("Separate Chaining Hash Table");
        System.out.printf("%-7s %-11s %-11s %-11s %-11s %-11s\n", "Index", "Value", "Value", "Value", "Value", "Value");
        System.out.println("------------------------------------------------------------------");
        chainTable.displayTable();
    } // End displayChainTable()
//------------------------------------------------------------------------------
    /**
     * Method to display the statistics.
     * @param none
     * @return nothing
     */
    public void displayStatistics()
    {
        System.out.printf("\n%39s\n", "Hash Table Performance Statistics");
        System.out.printf("%-15s %-8s %-11s %-11s\n", "Transaction", "Type", "Table 1", "Table 2");
        System.out.println("-------------------------------------------------");
        String type;
        
        for (int i = 0; i < statsT1.length; i++)
        {
            type = updateArray[i].getTransactionCode();
            
            if (type.compareTo("A") == 0)
            {
                type = "Add";
                System.out.printf("%-15s %-11s %-11s %-11s\n", updateArray[i].getLastName(), type, statsT1[i], statsT2[i]);
            }
            else if (type.compareTo("D") == 0)
            {
                type = "Delete";
                if (statsT1[i] == -1 && statsT2[i] == -1) 
                    System.out.printf("%-15s %-8s %-11s\n", updateArray[i].getLastName(), type, "not found");
                else
                    System.out.printf("%-15s %-11s %-11s %-11s\n", updateArray[i].getLastName(), type, statsT1[i], statsT2[i]);
            }
        }
    } // End displayStatistics()
//------------------------------------------------------------------------------
} // End Controller
