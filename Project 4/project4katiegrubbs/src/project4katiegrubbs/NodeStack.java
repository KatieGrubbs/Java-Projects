package project4katiegrubbs;

import java.util.ArrayList;

/**
 * The NodeStack class contains methods for various stack operations.
 * @author Katie
 */
public class NodeStack
{
    private ArrayList<Node> stack;
    private int top;
//------------------------------------------------------------------------------
    /**
     * Constructor for Stack.
     * @param none
     * @return nothing
     */
    public NodeStack()
    {
        stack = new ArrayList<>();
        top = -1;
    } // End NodeStack ()
//------------------------------------------------------------------------------
    /**
     * Method to put an item on the top of the stack.
     * @param node : Node
     * @return nothing
     */
    public void push(Node node)
    {
        stack.add(++top, node);
    } // End push()
//------------------------------------------------------------------------------
    /**
     * Method to take an item from the top of the stack.
     * @param none
     * @return an object of type Presidents
     */
    public Node pop()
    {
        return stack.remove(top--);
    } // End pop()
//------------------------------------------------------------------------------
    /**
     * Method to peek at the top of the stack.
     * @param none
     * @return an object of type Presidents
     */
    public Node peek()
    {
        return stack.get(top);
    } // End peek()
//------------------------------------------------------------------------------
    /**
     * Method to check if the stack is empty.
     * @param none
     * @return a boolean value
     */
    public boolean isEmpty()
    {
        return (top == -1);
    } // End isEmpty()
//------------------------------------------------------------------------------
    /**
     * Method to check if the stack is full.
     * @param none
     * @return a boolean value
     */
    public boolean isFull()
    {
        return (top == stack.size()-1);
    } // End isFull()
//------------------------------------------------------------------------------
} // End NodeStack