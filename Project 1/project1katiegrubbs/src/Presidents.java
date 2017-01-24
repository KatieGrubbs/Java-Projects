
/**
 * The Presidents class contains a toString() method, in addition to getter
 * and setter methods to allow the PresidentsMDrvr class to access private
 * presidential attributes.
 * @author Katie
 */
public class Presidents
{
    // Declare the attributes
    private int number, term;
    private String name, code, party, state;
//------------------------------------------------------------------------------
    /**
     * Constructor for Presidents.
     * @param number : integer
     * @param name : string
     * @param code : string
     * @param term : integer
     * @param party : string
     * @param state : string
     * @return nothing
     */
    public Presidents(int number, String name, String code, int term, 
            String party, String state)
    {
        this.number = number;
        this.name = name;
        this.code = code;
        this.term = term;
        this.party = party;
        this.state = state;
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
     * Method to retrieve the value of a president's code.
     * @param none
     * @return a string
     */
    public String getCode()
    {
        return code;
    } // End getCode()
//------------------------------------------------------------------------------
    /**
     * Method to set the value of a president's code.
     * @param code : string
     * @return nothing
     */
    public void setCode(String code)
    {
        this.code = code;
    } // End setCode()
//------------------------------------------------------------------------------
    /**
     * Method to retrieve the value of a president's term.
     * @param none
     * @return an integer
     */
    public int getTerm()
    {
        return term;
    } // End getTerm()
//------------------------------------------------------------------------------
    /**
     * Method to set the value of a president's term.
     * @param term : string
     * @return nothing
     */
    public void setTerm(int term)
    {
        this.term = term;
    } // End setTerm()
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
    /**
     * Method to retrieve the value of a president's home state.
     * @param none
     * @return a string
     */
    public String getState()
    {
        return state;
    } // End getState()
//------------------------------------------------------------------------------
    /**
     * Method to set the value of a president's home state.
     * @param state : string
     * @return nothing
     */
    public void setState(String state)
    {
        this.state = state;
    } // End setState()
//------------------------------------------------------------------------------
} // End class Presidents