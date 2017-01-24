package project4katiegrubbs;

import java.io.IOException;

/**
 * Assignment: Program 4
 * Course: COP 3538
 * Instructor: Roggio
 * @author Katie
 */
public class Main
{
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException
    {
//------------------------------------------------------------------------------
// BUILD THE ARRAY
//------------------------------------------------------------------------------
        
        // Instantiate and initialize the array with a size of 44
        President_Controller array;
        array = new President_Controller(44);
        
        // Insert presidents into the array
        array.insert();
        
//        array.displayArray();
        
//------------------------------------------------------------------------------
// BUILD & DISPLAY THE BINARY TREE
//------------------------------------------------------------------------------
        
        // Build the tree from the array
        array.buildTree();
        
        // Display the tree using recursive and iterative scans
        array.displayTree();
        
//------------------------------------------------------------------------------
// DELETE FROM & RE-DISPLAY THE BINARY TREE
//------------------------------------------------------------------------------
        
        // Delete Nixon from the tree
        array.deleteFromTree("Nixon");
        System.out.println("\nAfter deleting nodes with zero children:");
        array.displayTreeAfterDelete();
        array.buildTree();
        
        // Delete Grant and Taylor from the original tree
        array.deleteFromTree("Grant");
        array.deleteFromTree("Taylor");
        System.out.println("\nAfter deleting nodes with one child:");
        array.displayTreeAfterDelete();
        array.buildTree();
        
        // Delete Van_Buren and Clinton from the original tree
        array.deleteFromTree("Van_Buren");
        array.deleteFromTree("Clinton");
        System.out.println("\nAfter deleting nodes with two children:");
        array.displayTreeAfterDelete();
        
    } // End main()
    
} // End Main