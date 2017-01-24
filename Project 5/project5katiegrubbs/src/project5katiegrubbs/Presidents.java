package project5katiegrubbs;

/**
 * The Presidents class contains toString() methods and getter/setter methods
 * to allow other classes to access private presidential attributes.
 * @author Katie Grubbs
 */
public class Presidents
{
    private int number, term;
    private String lastName, party, state, transactionCode;
//------------------------------------------------------------------------------
    /**
     * Constructor for Presidents.
     * @param number : integer
     * @param lastName : string
     * @param term : integer
     * @param party : string
     * @param state : string
     * @return nothing
     */
    public Presidents(int number, String lastName, int term, String party, 
            String state)
    {
        this.number = number;
        this.lastName = lastName;
        this.term = term;
        this.party = party;
        this.state = state;
    } // End Presidents()
//------------------------------------------------------------------------------
    /**
     * Secondary constructor for Presidents.
     * @param transactionCode : String
     * @param number : integer
     * @param lastName : String
     * @param term : integer
     * @param party : String
     * @param state : String
     */
    public Presidents(String transactionCode, int number, String lastName, 
            int term, String party, String state)
    {
        this.transactionCode = transactionCode;
        this.number = number;
        this.lastName = lastName;
        this.party = party;
        this.state = state;
    } // End Presidents()
//------------------------------------------------------------------------------
    /**
     * Tertiary constructor for Presidents.
     * @param transactionCode : String
     * @param lastName : String
     */
    public Presidents(String transactionCode, String lastName)
    {
        this.transactionCode = transactionCode;
        this.lastName = lastName;
    } // End Presidents()
//------------------------------------------------------------------------------
    /**
     * Method to print out a president's number, last name, first name, and
     * state.
     * @param none
     * @return a formatted string
     */
    public String toString()
    {
        return String.format("%-12s", lastName);
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
     * Method to retrieve the value of a president's last name.
     * @param none
     * @return a string
     */
    public String getLastName()
    {
        return lastName;
    } // End getName()
//------------------------------------------------------------------------------
    /**
     * Method to set the value of a president's last name.
     * @param lastName : string
     * @return nothing
     */
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    } // End setName()
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
    /**
     * Method to retrieve the value of a president's transaction code.
     * @param none
     * @return a string
     */
    public String getTransactionCode()
    {
        return transactionCode;
    } // End getCode()
//------------------------------------------------------------------------------
    /**
     * Method to set the value of a president's transaction code.
     * @param transactionCode : string
     * @return nothing
     */
    public void setTransactionCode(String transactionCode)
    {
        this.transactionCode = transactionCode;
    } // End setCode()
//------------------------------------------------------------------------------
} // End Presidents