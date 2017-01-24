package project2katiegrubbs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * The File class contains methods to read input files and parse data.
 * @author Katie
 */
public class File
{
    private FileReader fr;
    private BufferedReader br;
    private Stack stack;
    private int number;
    private String name, party, inputString;
//------------------------------------------------------------------------------
    /**
     * Constructor for File.
     * @param fileName
     * @return nothing
     * @throws IOException
     */
    public File(String fileName) throws IOException
    {
        fr = new FileReader(fileName);
        br = new BufferedReader(fr);
        stack = new Stack();
    } // End File()
//------------------------------------------------------------------------------
    /**
     * Method to read and parse data.
     * @param none
     * @return nothing
     * @throws IOException
     */
    public void readPresidentData() throws IOException
    {
        // Read a record from the input file
        inputString = br.readLine();
        
        // Declare a temporary Presidents object
        Presidents temp;
        
        // Parse the data and assign it to the variables
        while (inputString != null)
        {
            number = Integer.parseInt(inputString.substring(0, 2).trim());
//            System.out.println("Number read in was: " + number);
            name = inputString.substring(2, 25).trim();
//            System.out.println("Name read in was: " + name);
            party = inputString.substring(29, 48).trim();
//            System.out.println("Party read in was: " + party + "\n");
            temp = new Presidents(number, name, party);
            stack.push(temp);
            inputString = br.readLine();
        }
        br.close();
    } // End loadData()
//------------------------------------------------------------------------------
    /**
     * Method to check for remaining presidents in the input stack.
     * @param none
     * @return a boolean
     */
    public boolean hasNext()
    {
        return !stack.isEmpty();
    } // End hasNext()
//------------------------------------------------------------------------------
    /**
     * Method to get the next president in the input stack.
     * @param none
     * @return an object of type Presidents
     */
    public Presidents getNext()
    {
        return stack.pop();
    } // End getNext()
//------------------------------------------------------------------------------
    /**
     * Method to display the current stack.
     * @param none
     * @return nothing
     */
    public void displayStack()
    {
        stack.displayStack(stack);
    } // End displayInputStack()
//------------------------------------------------------------------------------
} // End File