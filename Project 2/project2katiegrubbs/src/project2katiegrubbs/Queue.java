package project2katiegrubbs;

import java.util.ArrayList;

/**
 * The Queue class contains methods to insert objects into queues, sort objects,
 * and display queues.
 * @author Katie
 */
public class Queue
{
    private ArrayList<Presidents> queueDem;
    private ArrayList<Presidents> queueRepub;
    private ArrayList<Presidents> queueWhig;
    private int frontDem, frontRepub, frontWhig;    // Front pointers
    private int rearDem, rearRepub, rearWhig;       // Rear pointers
    private int nItemsDem, nItemsRepub, nItemsWhig; // Number of items in queue
//------------------------------------------------------------------------------
    /**
     * Constructor for Queue.
     * @param none
     * @return nothing
     */
    public Queue()
    {
        queueDem = new ArrayList<>();
        queueRepub = new ArrayList<>();
        queueWhig = new ArrayList<>();
        frontDem = 0;
        frontRepub = 0;
        frontWhig = 0;
        rearDem = -1;
        rearRepub = -1; 
        rearWhig = -1;
        nItemsDem = 0;
        nItemsRepub = 0;
        nItemsWhig = 0;
    } // End Queue()
//------------------------------------------------------------------------------
    /**
     * Method to insert an item at the rear of a queue.
     * @param object : Presidents
     * @return nothing
     */
    public void insert(Presidents object)
    {
        switch(object.getParty())
        {
            case "Democrat":
                queueDem.add(++rearDem, object);        // Add president to Democrat queue
                nItemsDem++;                            // Increment number of items in Democrat queue
                break;
            case "Republican":
                queueRepub.add(++rearRepub, object);    // Add president to Republican queue
                nItemsRepub++;                          // Increment number of items in Republican queue
                break;
            case "Whig":
                queueWhig.add(++rearWhig, object);      // Add president to Whig queue
                nItemsWhig++;                           // Increment number of items in Whig queue
                break;
        }
    } // End insert()
//------------------------------------------------------------------------------
    /**
     * Method to insert an item at the correct position in a priority queue.
     * @param object
     * @return nothing
     */
    public void priorityInsert(Presidents object)
    {
        int j;
        switch(object.getParty())
        {
            case "Democrat":
                if (nItemsDem == 0)                         // If no items in queue
                    queueDem.add(nItemsDem++, object);      // Insert item at 0
                else                                        // If items in queue
                {
                    for (j = nItemsDem-1; j >= 0; j--)      // Start at end
                    {
                        if (object.getNumber() <= queueDem.get(j).getNumber())  // If new item smaller
                        {
                            queueDem.add(j+1, queueDem.get(j));                 // Shift upward
                            queueDem.remove(j);
                        }
                        else                                // If new item larger
                            break;                          // Done shifting
                    }
                    queueDem.add(j+1, object);              // Insert item
                    nItemsDem++;
                }
                break;
            case "Republican":
                if (nItemsRepub == 0)
                    queueRepub.add(nItemsRepub++, object);
                else
                {
                    for (j = nItemsRepub-1; j >= 0; j--)
                    {
                        if (object.getNumber() <= queueRepub.get(j).getNumber())
                        {
                            queueRepub.add(j+1, queueRepub.get(j));
                            queueRepub.remove(j);
                        }
                        else
                            break;
                    }
                    queueRepub.add(j+1, object);
                    nItemsRepub++;
                }
                break;
            case "Whig":
                if (nItemsWhig == 0)
                    queueWhig.add(nItemsWhig++, object);
                else
                {
                    for (j = nItemsWhig-1; j >= 0; j--)
                    {
                        if (object.getNumber() <= queueWhig.get(j).getNumber())
                        {
                            queueWhig.add(j+1, queueWhig.get(j));
                            queueWhig.remove(j);
                        }
                        else
                            break;
                    }
                    queueWhig.add(j+1, object);
                    nItemsWhig++;
                }
                break;
        }
    } // End priorityInsert()
//------------------------------------------------------------------------------
    /**
     * Method to sort the items in the Democrat queue by number.
     * @param none
     * @return nothing
     */
    private void selectionSortDem()
    {
        int out, in, min;
        for (out = 0; out < queueDem.size()-1; out++)
        {
            min = out;
            for (in = out+1; in < queueDem.size(); in++)
                if (queueDem.get(min).getNumber() > queueDem.get(in).getNumber())
                    min = in;
            swapDem(out, min);
        }
    } // End selectionSortDem()
//------------------------------------------------------------------------------
    /**
     * Method to sort the items in the Republican queue by number.
     * @param none
     * @return nothing
     */
    private void selectionSortRepub()
    {
        int out, in, min;
        for (out = 0; out < queueRepub.size()-1; out++)
        {
            min = out;
            for (in = out+1; in < queueRepub.size(); in++)
                if (queueRepub.get(min).getNumber() > queueRepub.get(in).getNumber())
                    min = in;
            swapRepub(out, min);
        }
    } // End selectionSortRepub()
//------------------------------------------------------------------------------
    /**
     * Method to sort the items in the Whig queue by number.
     * @param none
     * @return nothing
     */
    private void selectionSortWhig()
    {
        int out, in, min;
        for (out = 0; out < queueWhig.size()-1; out++)
        {
            min = out;
            for (in = out+1; in < queueWhig.size(); in++)
                if (queueWhig.get(min).getNumber() > queueWhig.get(in).getNumber())
                    min = in;
            swapWhig(out, min);
        }
    } // End selectionSortWhig()
//------------------------------------------------------------------------------
    /**
     * Method to sort all of the items in each of the queues by number.
     * @param none
     * @return nothing
     */
    public void selectionSortAll()
    {
        selectionSortDem();
        selectionSortRepub();
        selectionSortWhig();
    } // End selectionSortAll()
//------------------------------------------------------------------------------
    /**
     * Method to swap two items within the Democrat queue.
     * @param one : integer
     * @param two : integer
     * @return nothing
     */
    private void swapDem(int one, int two)
    {
        Presidents temp = queueDem.get(one);
        queueDem.set(one, queueDem.get(two));
        queueDem.set(two, temp);
    } // End swapDem()
//------------------------------------------------------------------------------
    /**
     * Method to swap two items within the Republican queue.
     * @param one : integer
     * @param two : integer
     * @return nothing
     */
    private void swapRepub(int one, int two)
    {
        Presidents temp = queueRepub.get(one);
        queueRepub.set(one, queueRepub.get(two));
        queueRepub.set(two, temp);
    } // End swapRepub()
//------------------------------------------------------------------------------
    /**
     * Method to swap two items within the Whig queue.
     * @param one : integer
     * @param two : integer
     * @return nothing
     */
    private void swapWhig(int one, int two)
    {
        Presidents temp = queueWhig.get(one);
        queueWhig.set(one, queueWhig.get(two));
        queueWhig.set(two, temp);
    } // End swapWhig()
//------------------------------------------------------------------------------
    /**
     * Method to display the Democrat queue.
     * @param none
     * @return nothing
     */
    private void displayQueueDem()
    {
        System.out.println("Queue 1: Democrats");
        System.out.printf("\n%2s %-19s %-20s\n", "#", "NAME", "PARTY");
        for (int i = 0; i < queueDem.size(); i++)               // For each item in the queue
            System.out.println(queueDem.get(i).toString());     // Display it
    } // End displayDem()
//------------------------------------------------------------------------------
    /**
     * Method to display the Republican queue.
     * @param none
     * @return nothing
     */
    private void displayQueueRepub()
    {
        System.out.println("\n\nQueue 2: Republicans");
        System.out.printf("\n%2s %-19s %-20s\n", "#", "NAME", "PARTY");
        for (int i = 0; i < queueRepub.size(); i++)             // For each item in the queue
            System.out.println(queueRepub.get(i).toString());   // Display it
    } // End displayRepub()
//------------------------------------------------------------------------------
    /**
     * Method to display the Whig queue.
     * @param none
     * @return nothing
     */
    private void displayQueueWhig()
    {
        System.out.println("\n\nQueue 3: Whigs");
        System.out.printf("\n%2s %-19s %-20s\n", "#", "NAME", "PARTY");
        for (int i = 0; i < queueWhig.size(); i++)              // For each item in the queue
            System.out.println(queueWhig.get(i).toString());    // Display it
    } // End displayWhig()
//------------------------------------------------------------------------------
    /**
     * Method to display all of the queues.
     * @param none
     * @return nothing
     */
    public void displayAllQueues()
    {
        displayQueueDem();
        displayQueueRepub();
        displayQueueWhig();
    } // End displayAllQueues()
//------------------------------------------------------------------------------
    /**
     * Method to display a decorative border.
     * @param none
     * @return nothing
     */
    public void displayBorder()
    {
        System.out.println("\n\n----------------------------------------");
        System.out.println("----------------------------------------\n\n");
    } // End displayBorder()
//------------------------------------------------------------------------------
} // End Queue