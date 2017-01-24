import java.io.*;

/**
 * Assignment: Program 1
 * Course: COP 3538
 * Instructor: Roggio
 * @author Katie
 */
public class Main
{
    /**
     * The main method builds, accesses, and processes an array of Presidents
     * objects.
     * @param args
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException
    {
        // Instantiate and initialize PresidentsDrvr with an array size of 44
        PresidentsMDrvr PresidentsDrvr;
        PresidentsDrvr = new PresidentsMDrvr(44);
        
//------------------------------------------------------------------------------
// PARSING, SORTING, & DISPLAYING
//------------------------------------------------------------------------------
        
        // Declare the variables needed for parsing
        int number, term;
        String name, code, party, state;
        String inputString;
        
        // Create objects to read the first input file
        FileReader fr = new FileReader("Presidents.txt");
        BufferedReader br = new BufferedReader(fr);
        
        // Read a record from the input file
        inputString = br.readLine();
        
        // Parse the data and assign it to the variables
        while (inputString != null)
        {
            number = Integer.parseInt(inputString.substring(0, 2).trim());
//            System.out.println("Number read in was: " + number);
            name = inputString.substring(2, 25).trim();
//            System.out.println("Name read in was: " + name);
            code = inputString.substring(25, 27).trim();
//            System.out.println("Code read in was: " + code);
            term = Integer.parseInt(inputString.substring(27, 29).trim());
//            System.out.println("Term read in was: " + term);
            party = inputString.substring(29, 49).trim();
//            System.out.println("Party read in was: " + party);
            state = inputString.substring(49, inputString.length());
//            System.out.println("State read in was: " + state + "\n");
            PresidentsDrvr.insert(number, name, code, term, party, state);
            inputString = br.readLine();
        }
        br.close();
        
        // Display the contents of the myPresidents array
        System.out.printf("%34s\n", "Unsorted Presidents Array");
        PresidentsDrvr.display();
        
        // Sort the contents of the myPresidents array on number
        PresidentsDrvr.bubbleSortOnNumber();
        
        // Display the sorted contents of the myPresidents array on number
        System.out.printf("\n\n%33s\n", "Sorted Presidents Array");
        PresidentsDrvr.display();
        
//------------------------------------------------------------------------------
// SEQUENTIAL SEARCH & DISPLAY
//------------------------------------------------------------------------------
        
        // Declare the variables needed for the sequential search
        String partySearchKey;
        
        // Create objects to read the second input file
        FileReader fr2 = new FileReader("PresidentsSearch.txt");
        BufferedReader br2 = new BufferedReader(fr2);
        
        // Read a record from the input file
        inputString = br2.readLine();
        
        // Conduct the sequential search and display the results
        PresidentsDrvr.sequentialSearchDisplay();
        
        while (inputString != null)
        {
            partySearchKey = inputString.substring(0, inputString.length());
            PresidentsDrvr.sequentialSearch(partySearchKey);
            inputString = br2.readLine();
        }
        br2.close();
        
//------------------------------------------------------------------------------
// BINARY SEARCH & DISPLAY
//------------------------------------------------------------------------------
        
        // Initialize the array needed for the binary search
        String[] nameSearchKey = {"Andrew Jackson", "Abraham Lincoln", 
        "Billy Bob", "George Patton", "Harry Truman", "XXX"};
        
        // Sort the contents of the myPresidents array on name
        PresidentsDrvr.bubbleSortOnName();
        
        // Conduct the binary search and display the results
        PresidentsDrvr.binarySearchDisplay();
        for (String key : nameSearchKey)        // For each key in nameSearchKey,
            PresidentsDrvr.binarySearch(key);   // search for it
        
    } // End main()
    
} // End class Main