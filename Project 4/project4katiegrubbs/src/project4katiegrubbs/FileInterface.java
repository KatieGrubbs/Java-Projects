package project4katiegrubbs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * The FileInterface class contains methods to read input files and parse data.
 * @author Katie
 */
public class FileInterface
{
    private FileReader fr;
    private BufferedReader br;
    private Stack stack;
    private int number, term;
    private String name, firstName, lastName, code, party, state, inputString;
//------------------------------------------------------------------------------
    /**
     * Constructor for FileInterface.
     * @param fileName
     * @return nothing
     * @throws IOException
     */
    public FileInterface(String fileName) throws IOException
    {
        fr = new FileReader(fileName);
        br = new BufferedReader(fr);
        stack = new Stack();
    } // End FileInterface()
//------------------------------------------------------------------------------
    /**
     * Method to read and parse data.
     * @param none
     * @return nothing
     * @throws IOException
     */
    public void readData() throws IOException
    {
        Presidents temp;
        inputString = br.readLine();
        
        // Parse the data and assign it to the variables
        while (inputString != null)
        {
            number = Integer.parseInt(inputString.substring(0, 2).trim());
//            System.out.println("Number read in was: " + number);
            name = inputString.substring(2, 25).trim();
//            System.out.println("Name read in was: " + name);
            firstName = name.substring(0, name.indexOf(' ')).trim();
//            System.out.println("First name read in was: " + firstName);
            lastName = name.substring(name.lastIndexOf(' ')).trim();
//            System.out.println("Last name read in was: " + lastName);
            code = inputString.substring(25, 27).trim();
//            System.out.println("Code read in was: " + code);
            term = Integer.parseInt(inputString.substring(27, 29).trim());
//            System.out.println("Term read in was: " + term);
            party = inputString.substring(29, 48).trim();
//            System.out.println("Party read in was: " + party);
            state = inputString.substring(49, inputString.length());
//            System.out.println("State read in was: " + state + "\n");

            temp = new Presidents(number, name, firstName, lastName, code, term, party, state);
            stack.push(temp);
            inputString = br.readLine();
        }
        br.close();
    } // End readData()
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
} // End FileInterface