package project4katiegrubbs;

/**
 * The Node class contains data and a method to display a node.
 * @author Katie
 */
public class Node
{
    public String data;
    public Node leftChild;
    public Node rightChild;
//------------------------------------------------------------------------------
    /**
     * Method to display a node.
     * @param none
     * @return nothing
     */
    public void displayNode()
    {
        String[] splitIt = data.split(",");
        System.out.printf("%-12s %-13s %15s\n", splitIt[0], splitIt[1], splitIt[3]);
    } // End displayNode()
//------------------------------------------------------------------------------
} // End Node