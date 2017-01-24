package project3katiegrubbs;

/**
 * The Link class contains a constructor to build a link, in addition to a
 * method to display a link.
 * @author Katie
 */
public class Link
{
    public Presidents data;
    public Link next;       // Points to next link in list
    public Link previous;   // Points to previous link in list
//------------------------------------------------------------------------------
    /**
     * Constructor for Link.
     * @param object : Presidents
     * @return nothing
     */
    public Link(Presidents object)
    {
        data = object;
    } // End Link()
//------------------------------------------------------------------------------
    /**
     * Method to display a link.
     * @param none
     * @return nothing
     */
    public void displayLink()
    {
        System.out.println(data);
    } // End displayLink()
//------------------------------------------------------------------------------
} // End Link