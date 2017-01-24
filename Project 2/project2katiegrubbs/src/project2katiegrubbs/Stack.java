package project2katiegrubbs;

import java.util.ArrayList;

/**
 * The Stack class contains methods for various stack operations.
 * @author Katie
 */
public class Stack
{
    private ArrayList<Presidents> stack;
    private int top;
//------------------------------------------------------------------------------
    /**
     * Constructor for Stack.
     * @param none
     * @return nothing
     */
    public Stack()
    {
        stack = new ArrayList<>();
        top = -1;
    } // End Stack ()
//------------------------------------------------------------------------------
    /**
     * Method to put an item on the top of the stack.
     * @param object : Presidents
     * @return nothing
     */
    public void push(Presidents object)
    {
        stack.add(++top, object);
    } // End push()
//------------------------------------------------------------------------------
    /**
     * Method to take an item from the top of the stack.
     * @param none
     * @return an object of type Presidents
     */
    public Presidents pop()
    {
        return stack.remove(top--);
    } // End pop()
//------------------------------------------------------------------------------
    /**
     * Method to peek at the top of the stack.
     * @param none
     * @return an object of type Presidents
     */
    public Presidents peek()
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
    /**
     * Method to display the stack.
     * @param stack : Stack
     * @return nothing
     */
    public void displayStack(Stack stack)
    {
        System.out.printf("\n%2s %-19s %-20s\n", "#", "NAME", "PARTY");
        System.out.println("~ TOP OF STACK ~");
        while (!stack.isEmpty())
        {
            System.out.println(stack.peek());
            stack.pop();
        }
        System.out.println("~ BOTTOM OF STACK ~");
    } // End displayStack()
//------------------------------------------------------------------------------
} // End Stack