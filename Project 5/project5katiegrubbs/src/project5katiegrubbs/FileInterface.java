package project5katiegrubbs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * The FileInterface class contains methods to read input files and parse data.
 * @author Katie Grubbs
 */
public class FileInterface
{
    private FileReader fr;
    private BufferedReader br;
    private Presidents[] array, updateArray;
    private int number, term, arrayCount, updateArrayCount;
    private String lastName, party, state, transactionCode, inputString;
//------------------------------------------------------------------------------
    /**
     * Method to read and parse data from the first file.
     * @param fileName : String
     * @param size : integer
     * @return nothing
     * @throws IOException
     */
    public Presidents[] readData(String fileName, int size) throws IOException
    {
        fr = new FileReader(fileName);
        br = new BufferedReader(fr);
        array = new Presidents[size];
        arrayCount = 0;
        inputString = br.readLine();
        Presidents temp;
        
        while (inputString != null)
        {
            String[] splitIt = inputString.split(",");
            
            number = Integer.parseInt(splitIt[0]);
//            System.out.println("Number read in was: " + number);
            lastName = splitIt[1];
//            System.out.println("Last name read in was: " + lastName);
            term = Integer.parseInt(splitIt[2]);
//            System.out.println("Term read in was: " + term);
            party = splitIt[3];
//            System.out.println("Party read in was: " + party);
            state = splitIt[4];
//            System.out.println("State read in was: " + state + "\n");
            
            temp = new Presidents(number, lastName, term, party, state);
            array[arrayCount++] = temp;
            
            inputString = br.readLine();
        }
        return array;
    } // End readData()
//------------------------------------------------------------------------------
    /**
     * Method to read and parse data from the update file.
     * @param fileName : String
     * @param size : integer
     * @return a Presidents[] array
     * @throws IOException
     */
    public Presidents[] readUpdateData(String fileName, int size) throws IOException
    {
        fr = new FileReader(fileName);
        br = new BufferedReader(fr);
        updateArray = new Presidents[size];
        updateArrayCount = 0;
        inputString = br.readLine();
        Presidents temp;
        
        while (inputString != null)
        {
            String[] splitIt = inputString.split(",");
            
            if (inputString.startsWith("D"))    // String begins with transaction code "D"
            {
                transactionCode = splitIt[0];
//                System.out.println("Transaction code read in was: " + transactionCode);
                lastName = splitIt[1];
//                System.out.println("Last name read in was: " + lastName + "\n");
                
                temp = new Presidents(transactionCode, lastName);
                updateArray[updateArrayCount++] = temp;
            }
            else                                // String begins with transaction code "A"
            {
                transactionCode = splitIt[0];
//                System.out.println("Transaction code read in was: " + transactionCode);
                number = Integer.parseInt(splitIt[1]);
//                System.out.println("Number read in was: " + number);
                lastName = splitIt[2];
//                System.out.println("Last name read in was: " + lastName);
                term = Integer.parseInt(splitIt[3]);
//                System.out.println("Term read in was: " + term);
                party = splitIt[4];
//                System.out.println("Party read in was: " + party);
                state = splitIt[5];
//                System.out.println("State read in was: " + state + "\n");
                
                temp = new Presidents(transactionCode, number, lastName, term, party, state);
                updateArray[updateArrayCount++] = temp;
            }
            
            inputString = br.readLine();
        }
        return updateArray;
    } // End readUpdateData()
//------------------------------------------------------------------------------
} // End FileInterface