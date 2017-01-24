package project2katiegrubbs;

import java.io.IOException;

/**
 * Assignment: Program 2
 * Course: COP 3538
 * Instructor: Roggio
 * @author Katie Grubbs
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
// BUILD & DISPLAY THE REGULAR QUEUES
//------------------------------------------------------------------------------
        
        // Create a Queue object
        Queue queue = new Queue();
        
        // Create File objects to read the input files
        File presidentsReader = new File("Presidents.txt");
        File presidentsUpdateReader = new File("PresidentsUpdate.txt");
        File presidentsUpdateReader2 = new File("PresidentsUpdate.txt");
        
        // Read the first input file and store the data
        presidentsReader.readPresidentData();
        
        // Take a president from presidentsReader and insert it into a queue
        while (presidentsReader.hasNext())
            queue.insert(presidentsReader.getNext());
        
        // Display the contents of the queues
        System.out.printf("%32s\n", "Unsorted Regular Queues\n");
        queue.displayAllQueues();
        
//------------------------------------------------------------------------------
// SORT & DISPLAY THE PRIORITY QUEUES
//------------------------------------------------------------------------------
        
        // Sort the contents of the queues by number
        queue.selectionSortAll();
        
        // Display the sorted contents of the queues by number
        queue.displayBorder();
        System.out.printf("%32s\n", "Sorted Priority Queues\n");
        queue.displayAllQueues();
        
//------------------------------------------------------------------------------
// DISPLAY THE STACK
//------------------------------------------------------------------------------
        
        // Read the second input file and store the data
        presidentsUpdateReader.readPresidentData();
        
        // Display the contents of the stack
        queue.displayBorder();
        System.out.printf("%32s", "Input Stack for Updating Priority Queues\n");
        presidentsUpdateReader.displayStack();
        
//------------------------------------------------------------------------------
// UPDATE & DISPLAY THE PRIORITY QUEUES
//------------------------------------------------------------------------------
        
        // Re-read the second input file and store the data to repopulate the stack
        presidentsUpdateReader2.readPresidentData();
        
        // Take a president from presidentsUpdateReader and insert it into a priority queue
        while (presidentsUpdateReader2.hasNext())
            queue.priorityInsert(presidentsUpdateReader2.getNext());
        
        // Display the updated contents of the queues by number
        queue.displayBorder();
        System.out.printf("%32s\n", "Updated Priority Queues\n");
        queue.displayAllQueues();
        
    } // End main()
    
} // End Main