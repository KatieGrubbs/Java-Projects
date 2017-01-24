package project3katiegrubbs;

import java.io.IOException;

/**
 * Assignment: Program 3
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
// BUILD & SORT THE ARRAY
//------------------------------------------------------------------------------
        
        // Instantiate and initialize PresidentsDrvr with an array size of 44
        PresidentsMDrvr array;
        array = new PresidentsMDrvr(44);
        
        // Create a File object to read the first input file and store its data
        File reader = new File("Presidents.txt");
        reader.readData();
        
        // Take a president from reader and insert it into the array
        while (reader.hasNext())
            array.insert(reader.getNext());
        
        // Sort the array on last name
        array.bubbleSortOnLastName();
//        array.displayArray();
        
//------------------------------------------------------------------------------
// BUILD & DISPLAY THE DOUBLY-LINKED LISTS
//------------------------------------------------------------------------------
        
        // Create a DoublyLinkedList object
        DoublyLinkedList list;
        list = new DoublyLinkedList();
               
        // Move the Republican presidents from the array to the doubly-linked list
        array.movePresidents(list);
        
        // Display the contents of the doubly-linked list forwards and backwards
        list.displayList();
        
//------------------------------------------------------------------------------
// BUILD & DISPLAY THE STACK
//------------------------------------------------------------------------------
        
        // Create a File object to read the second input file and store its data
        File updateReader = new File("PresidentsUpdate.txt");
        updateReader.readUpdatedData();
        
        // Display the contents of the stack
        updateReader.displayStack();
        
        // Re-read the second input file and store its data to repopulate the stack
        File repopulateReader = new File("PresidentsUpdate.txt");
        repopulateReader.readUpdatedData();
        
//------------------------------------------------------------------------------
// UPDATE & DISPLAY THE DOUBLY-LINKED LISTS
//------------------------------------------------------------------------------
        
        // Display processing
        System.out.printf("\n\n%34s\n", "Input Stack Processing");
        System.out.printf("\n%-7s %-12s %24s\n", "CODE", "LAST NAME", "# OF PRECEDING NODES");
        
        // Take a president from the stack and insert it into the doubly-linked list if valid transaction type
        while (repopulateReader.hasNext())
            list.insertUpdate(repopulateReader.getNext());
        
        // Display the contents of the updated doubly-linked list forwards and backwards
        System.out.printf("\n\n%39s\n\n", "Updated Doubly-Linked List");
        list.displayList();
        
    } // End main()
    
} // End main