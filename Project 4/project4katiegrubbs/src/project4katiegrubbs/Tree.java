package project4katiegrubbs;

/**
 * The Tree class contains methods to add nodes to and remove nodes from a tree.
 * @author Katie
 */
public class Tree
{
    private Node root;
//------------------------------------------------------------------------------
    /**
     * Constructor for Tree.
     * @param none
     * @return nothing
     */
    public Tree()
    {
        root = null;
    } // End Tree()
//------------------------------------------------------------------------------
    /**
     * Method to insert a node into the tree.
     * @param presData : String
     * @return nothing
     */
    public void insertNode(String presData)
    {
        Node newNode = new Node();
        newNode.data = presData;
        
        if (root == null)   // No node in root
            root = newNode;
        else                // Node in root
        {
            Node current = root;
            Node parent;
            
            while (true)
            {
                parent = current;
                if (presData.compareTo(current.data) < 0)   // If less than current node
                {
                    current = current.leftChild;            // Go left
                    if (current == null)                    // If left child has no children
                    {
                        parent.leftChild = newNode;         // Insert node to left of parent
                        return;
                    }
                } // End if less than current node
                else                                        // Greater than current node
                {
                    current = current.rightChild;           // Go right
                    if (current == null)                    // If right child has no children
                    {
                        parent.rightChild = newNode;        // Insert node to right of parent
                        return;
                    }
                } // End else greater than current node
            } // End while
        } // End else node in root
    } // End insertNode()
//------------------------------------------------------------------------------
    /**
     * Method to delete a node from the tree.
     * @param key : String
     * @return a boolean
     */
    public boolean deleteNode(String key)
    {
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;
        
        // Search for node 
        while (!current.data.contains(key))
        {
            parent = current;

            if (key.compareTo(current.data) < 0)    // If less than current node
            {
                isLeftChild = true;                 // Left child
                current = current.leftChild;        // Go left
            } // End if less than current node
            else                                    // Greater than current node
            {
                isLeftChild = false;                // Right child
                current = current.rightChild;       // Go right
            }
            
            if (current == null)                    // Didn't find it
                return false;
        } // End while
        
        // If node has no children, delete it
        if (current.leftChild == null && current.rightChild == null)
        {
            if (current == root)
                root = null;
            else if (isLeftChild)
                parent.leftChild = null;
            else
                parent.rightChild = null;
        }
        
        // If node has no left child, replace it with its right subtree
        else if (current.leftChild == null)
        {
            if (current == root)
                root = current.rightChild;
            else if (isLeftChild)
                parent.leftChild = current.rightChild;
            else
                parent.rightChild = current.rightChild;
        }

        // If node has no right child, replace it with its left subtree
        else if (current.rightChild == null)
        {
            if (current == root)
                root = current.leftChild;
            else if (isLeftChild)
                parent.leftChild = current.leftChild;
            else
                parent.rightChild = current.leftChild;
        }
        
        // Node has two children; replace it with inorder successor
        else
        {
            Node successor = getSuccessor(current);
            
            if (current == root)
                root = successor;
            else if (isLeftChild)
                parent.leftChild = successor;
            else
                parent.rightChild = successor;
            
            successor.leftChild = current.leftChild;
        }
        return true;
    } // End deleteNode()
//------------------------------------------------------------------------------
    /**
     * Method to retrieve the node with the next-highest value after the node 
     * to be deleted. Goes to right child, then right child's left descendents.
     * @param deleteNode : Node
     * @return successor : Node
     */
    private Node getSuccessor(Node deleteNode)
    {
        Node successorParent = deleteNode;
        Node successor = deleteNode;
        Node current = deleteNode.rightChild;
        
        while (current != null)
        {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }

        if (successor != deleteNode.rightChild)
        {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = deleteNode.rightChild;
        }
        return successor;
    } // End getSuccessor()
//------------------------------------------------------------------------------
    /**
     * Method to display the tree iteratively in pre-order.
     * @param localRoot : Node
     * @return nothing
     */
    private void iterativePreOrder(Node localRoot)
    {
        // Base case
        if (localRoot == null)
            return;
        
        // Create an empty stack and push root onto it
        NodeStack nodeStack = new NodeStack();
        nodeStack.push(root);
        
        // Print the contents of the tree
        while (!nodeStack.isEmpty())
        {
            Node n = nodeStack.pop();
            n.displayNode();
            
            if (n.rightChild != null)
                nodeStack.push(n.rightChild);
            
            if (n.leftChild != null)
                nodeStack.push(n.leftChild);
        }
    } // End iterativePreOrder()
//------------------------------------------------------------------------------
    /**
     * Method to display the tree iteratively in in-order.
     * @param localRoot : Node
     * @return nothing
     */
    private void iterativeInOrder(Node localRoot)
    {
        if (localRoot == null)
            return;
        
        NodeStack nodeStack = new NodeStack();
        Node current = root;
        
        while (!nodeStack.isEmpty() || current != null)
        {
            if (current != null)
            {
                nodeStack.push(current);
                current = current.leftChild;
            }
            else
            {
                Node n = nodeStack.pop();
                n.displayNode();
                current = n.rightChild;
            }
        }
    } // End iterativeInOrder()
//------------------------------------------------------------------------------
    /**
     * Method to display the tree iteratively in post-order.
     * @param localRoot : Node
     * @return nothing
     */
    private void iterativePostOrder(Node localRoot)
    {
        if (localRoot == null)
            return;
        
        NodeStack nodeStack = new NodeStack();
        Node current = root;
        
        while (true)
        {
            if (current != null)
            {
                if (current.rightChild != null)
                    nodeStack.push(current.rightChild);
                nodeStack.push(current);
                current = current.leftChild;
                continue;
            }
            
            if(nodeStack.isEmpty())
                return;
            
            current = nodeStack.pop();
            
            if(current.rightChild != null && !nodeStack.isEmpty() && current.rightChild == nodeStack.peek())
            {  
                nodeStack.pop();
                nodeStack.push(current);
                current = current.rightChild;
            }
            else
            {
                current.displayNode();
                current = null;  
            }
        }
    } // End iterativePostOrder()
//------------------------------------------------------------------------------
    /**
     * Method to display the tree recursively in pre-order.
     * @param localRoot : Node
     * @return nothing
     */
    private void recursivePreOrder(Node localRoot)
    {
        if (localRoot != null)
        {
            localRoot.displayNode();
            recursivePreOrder(localRoot.leftChild);
            recursivePreOrder(localRoot.rightChild);
        }
    } // End recursivePreOrder()
//------------------------------------------------------------------------------
    /**
     * Method to display the tree recursively in in-order.
     * @param localRoot : Node
     * @return nothing
     */
    private void recursiveInOrder(Node localRoot)
    {
        if (localRoot != null)
        {
            recursiveInOrder(localRoot.leftChild);
            localRoot.displayNode();
            recursiveInOrder(localRoot.rightChild);
        }
    } // End recursiveInOrder()
//------------------------------------------------------------------------------
    /**
     * Method to display the tree recursively in post-order.
     * @param localRoot : Node
     * @return nothing
     */
    private void recursivePostOrder(Node localRoot)
    {
        if (localRoot != null)
        {
            recursivePostOrder(localRoot.leftChild);
            recursivePostOrder(localRoot.rightChild);
            localRoot.displayNode();
        }
    } // End recursivePostOrder()
//------------------------------------------------------------------------------
    /**
     * Method to display the tree iteratively.
     * @param none
     * @return nothing
     */
    public void displayIteratively()
    {
        System.out.println("\nTask 3: Iterative NLR Scan");
        displayHeader();
        iterativePreOrder(root);
        System.out.println("\nTask 4: Iterative LNR Scan");
        displayHeader();
        iterativeInOrder(root);
        System.out.println("\nTask 5: Iterative LRN Scan");
        displayHeader();
        iterativePostOrder(root);
    } // End displayIteratively()
//------------------------------------------------------------------------------
    /**
     * Method to display the tree recursively.
     * @param none
     * @return nothing
     */
    public void displayRecursively()
    {
        System.out.println("\nTask 6: Recursive NLR Scan");
        displayHeader();
        recursivePreOrder(root);
        System.out.println("\nTask 7: Recursive LNR Scan");
        displayHeader();
        recursiveInOrder(root);
        System.out.println("\nTask 8: Recursive LRN Scan");
        displayHeader();
        recursivePostOrder(root);
    } // End displayRecursively()
//------------------------------------------------------------------------------
    /**
     * Method to display the tree recursively in in-order after nodes 
     * have been deleted from it.
     * @param none
     * @return nothing
     */
    public void displayAfterDelete()
    {
        displayHeader();
        recursiveInOrder(root);
    } // End displayAfterDelete()
//------------------------------------------------------------------------------
    /**
     * Method to display a header.
     * @param none
     * @return nothing
     */
    private void displayHeader()
    {
        System.out.printf("%-12s %-13s %15s\n", "LAST NAME", "PARTY", "YEARS IN OFFICE");
    } // End displayHeader()
//------------------------------------------------------------------------------
} // End Tree