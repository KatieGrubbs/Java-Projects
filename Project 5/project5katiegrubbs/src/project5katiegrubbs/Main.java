package project5katiegrubbs;

import java.io.IOException;

/**
 * Assignment: Program 5
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
// BUILD & DISPLAY THE HASH TABLES
//------------------------------------------------------------------------------
        
        Controller controller = new Controller();
        controller.buildArray("HashHeap.txt", 16);
        controller.buildTable1(37);
        controller.buildTable2(23);
        controller.displayTables();
        
//------------------------------------------------------------------------------
// UPDATE & DISPLAY THE HASH TABLES
//------------------------------------------------------------------------------        
        
        controller.updateArray("HashHeapUpdate.txt", 9);
        System.out.println("\nUpdated Hash Tables\n");
        controller.displayTables();
        
//------------------------------------------------------------------------------
// UPDATE STATISTICS & DISPLAY
//------------------------------------------------------------------------------
        
        controller.displayStatistics();
        
//------------------------------------------------------------------------------
// BONUS: SEPARATE CHAINING
//------------------------------------------------------------------------------
        
        Controller controller2 = new Controller();
        controller2.buildArray("HashHeap.txt", 16);
        controller2.buildChainTable(17);
        System.out.println("\n");
        controller2.displayChainTable();
        
        controller2.updateChainArray("HashHeapUpdate.txt", 9);
        System.out.print("\n\nUpdated ");
        controller2.displayChainTable();
        
    } // End main()
    
} // End Main