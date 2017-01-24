package project5katiegrubbs;

/**
 * The DataItem class contains presidential data and a key.
 * @author Katie Grubbs
 */
public class DataItem
{
    public Presidents pres;
    public int presKey;
//------------------------------------------------------------------------------
    /**
     * Constructor for DataItem.
     * @param pres : Presidents
     * @param presKey : integer
     * @return nothing
     */
    public DataItem(Presidents pres, int presKey)
    {
        this.pres = pres;
        this.presKey = presKey;
    } // End DataItem()
//------------------------------------------------------------------------------
    /**
     * Method to retrieve the value of the data key.
     * @param none
     * @return an integer
     */
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
} // End DataItem