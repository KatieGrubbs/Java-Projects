package project2katiegrubbs;

/**
 * The Presidents class contains a toString() method, in addition to getter
 * and setter methods to allow other classes to access private presidential
 * attributes.
 * @author Katie
 */
public class Presidents
{
    // Declare the attributes
    private int number;
    private String name, party;
//------------------------------------------------------------------------------
    /**
     * Constructor for Presidents.
     * @param number : integer
     * @param name : string
     * @param party : string
     * @return nothing
     */
    public Presidents(int number, String name, String party)
    {
        this.number = number;
        this.name = name;
        this.party = party;
    } // End Presidents()
//------------------------------------------------------------------------------
    /**
     * Method to print out a president's number, name, and party.
     * @param none
     * @return a formatted string
     */
    public String toString()
    {
        return String.format("%2s %-19s %-1s", number, name, party);
    } // End toString()
//------------------------------------------------------------------------------
    /**
     * Method to retrieve the value of a president's number.
     * @param none
     * @return an integer
     */
    public int getNumber()
    {
        return number;
    } // End getNumber()
//------------------------------------------------------------------------------
    /**
     * Method to set the value of a president's number.
     * @param number : integer
     * @return nothing
     */
    public void setNumber(int number)
    {
        this.number = number;
    } // End setNumber()
//------------------------------------------------------------------------------
    /**
     * Method to retrieve the value of a president's name.
     * @param none
     * @return a string
     */
    public String getName()
    {
        return name;
    } // End getName()
//------------------------------------------------------------------------------
    /**
     * Method to set the value of a president's name.
     * @param name : string
     * @return nothing
     */
    public void setName(String name)
    {
        this.name = name;
    } // End setName()
//------------------------------------------------------------------------------
    /**
     * Method to retrieve the value of a president's political party.
     * @param none
     * @return a string
     */
    public String getParty()
    {
        return party;
    } // End getParty()
//------------------------------------------------------------------------------
    /**
     * Method to set the value of a president's political party.
     * @param party : string
     * @return nothing
     */
    public void setParty(String party)
    {
        this.party = party;
    } // End setParty()
//------------------------------------------------------------------------------
} // End Presidents