package project4katiegrubbs;

import java.io.IOException;

/**
 * The President_Controller class contains methods to be used by the Main class.
 * @author Katie
 */
public class President_Controller
{
    private Presidents[] myPresidents;  // Reference to myPresidents array
    private int nElems;
    private Tree tree;
    private FileInterface reader;
//------------------------------------------------------------------------------    
    /**
     * Constructor for President_Controller.
     * @param maxSize : integer
     * @return nothing
     */
    public President_Controller(int maxSize)
    {
        myPresidents = new Presidents[maxSize];
        nElems = 0;
    } // End President_Controller()
//------------------------------------------------------------------------------
    /**
     * Method to insert elements into the myPresidents array.
     * @param none
     * @return nothing
     */
    public void insert() throws IOException
    {
        // Create a File object to read the input file and store its data
        reader = new FileInterface("TreePres.txt");
        reader.readData();
        
        // Take a president from the reader and insert it into the array
        while (reader.hasNext())
        {
            myPresidents[nElems] = reader.getNext();
            nElems++;
        }
    } // End insert()
//------------------------------------------------------------------------------
    /**
     * Method to display the contents of the myPresidents array.
     * @param none
     * @return nothing
     */
    public void displayArray()
    {
        System.out.println("Presidents Array");
        System.out.printf("%-12s %-13s %15s %9s\n", "LAST NAME", "PARTY", "YEARS IN OFFICE", "NUMBER");
        for (int i = 0; i < nElems; i++)
            System.out.println(myPresidents[i]);
    } // End displayArray()
//------------------------------------------------------------------------------
    /**
     * Method to move the objects from the myPresidents array to a tree.
     * @param none
     * @return nothing
     */
    public void buildTree()
    {
        tree = new Tree();
        String presData;
        
        for (int i = nElems - 1; i >= 0; i--)
        {
            presData = (myPresidents[i].getLastName() 
                    + "," + myPresidents[i].getParty() 
                    + "," + myPresidents[i].getNumber() 
                    + "," + myPresidents[i].getTerm());
            tree.insertNode(presData);
        }
    } // End buildTree()
//------------------------------------------------------------------------------
    /**
     * Method to delete a node from the tree.
     * @param deleteKey : String
     * @return nothing
     */
    public void deleteFromTree(String deleteKey)
    {
        tree.deleteNode(deleteKey);
    } // End deleteFromTree
//------------------------------------------------------------------------------
    /**
     * Method to display the tree.
     * @param none
     * @return nothing
     */
    public void displayTree()
    {
        tree.displayIteratively();
        tree.displayRecursively();
    } // End displayTree()
//------------------------------------------------------------------------------
    /**
     * Method to display the tree after a node has been deleted from it.
     * @param none
     * @return nothing
     */
    public void displayTreeAfterDelete()
    {
        tree.displayAfterDelete();
    } // End displayTreeAfterDelete()
//------------------------------------------------------------------------------
} // End President_Controller