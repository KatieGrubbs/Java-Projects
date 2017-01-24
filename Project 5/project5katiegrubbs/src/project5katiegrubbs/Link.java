package project5katiegrubbs;

/**
 * The Link class contains presidential data and a key.
 * @author Katie Grubbs
 */
public class Link
{
    public Presidents pres;
    public int presKey;
    public Link next;
//------------------------------------------------------------------------------
    /**
     * Constructor for Link.
     * @param pres : Presidents
     * @param presKey : integer
     * @return nothing
     */
    public Link(Presidents pres, int presKey)
    {
        this.pres = pres;
        this.presKey = presKey;
    } // End Link()
//------------------------------------------------------------------------------
    public int getKey()
    {
        return presKey;
    } // End getKey()
//------------------------------------------------------------------------------
    /**
     * Method to set the value of the data key.
     * @param none
     * @return nothing
     */
    public void deleteKey()
    {
        presKey = -1;
    } // End deleteKey()
//------------------------------------------------------------------------------
    /**
     * Method to display a link.
     * @param none
     * @return nothing
     */
    public void displayLink()
    {
        if (presKey == -1)
            System.out.printf("%-12s", "*" + pres.getLastName());
        else
            System.out.printf("%-12s", pres.getLastName());
    } // End displayLink()
//------------------------------------------------------------------------------
} // End Link