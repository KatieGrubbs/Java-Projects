package project3katiegrubbs;

/**
 * The Presidents class contains toString() methods and getter/setter methods
 * to allow other classes to access private presidential attributes.
 * @author Katie
 */
public class Presidents
{
    // Declare the attributes
    private int number, term;
    private String name, firstName, lastName, code, party, state, transactionCode;
//------------------------------------------------------------------------------
    /**
     * Constructor for Presidents.
     * @param number : integer
     * @param name : string
     * @param firstName : string
     * @param lastName : string
     * @param code : string
     * @param term : integer
     * @param party : string
     * @param state : string
     * @return nothing
     */
    public Presidents(int number, String name, String firstName, 
            String lastName, String code, int term, String party, String state)
    {
        this.number = number;
        this.name = name;
        this.firstName = firstName;
        this.lastName = lastName;
        this.code = code;
        this.term = term;
        this.party = party;
        this.state = state;
    } // End Presidents()
//------------------------------------------------------------------------------
    /**
     * Secondary constructor for Presidents.
     * @param transactionCode
     * @param name
     * @param firstName
     * @param lastName
     * @param party
     * @param state
     */
    public Presidents(String transactionCode, String name, String firstName, 
            String lastName, String party, String state)
    {
        this.transactionCode = transactionCode;
        this.name = name;
        this.firstName = firstName;
        this.lastName = lastName;
        this.party = party;
        this.state = state;
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
        return String.format("%-12s %-13s %-13s", lastName, firstName, state);
    } // End toString()
//------------------------------------------------------------------------------
    /**
     * Method to print out a president's transaction code, last name,
     * first name, and state.
     * @param none
     * @return a formatted string
     */
    public String toStringUpdated()
    {
        return String.format("%-7s %-13s %-12s %-13s %-13s", transactionCode, firstName, lastName, party, state);
    } // End toStringUpdated()
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
     * Method to retrieve the value of a president's first name.
     * @param none
     * @return a string
     */
    public String getFirstName()
    {
        return firstName;
    } // End getName()
//------------------------------------------------------------------------------
    /**
     * Method to set the value of a president's first name.
     * @param firstName : string
     * @return nothing
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    } // End setName()
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