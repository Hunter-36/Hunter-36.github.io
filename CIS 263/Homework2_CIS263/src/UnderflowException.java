/**
 * Exception class for access in empty containers
 * such as stacks, queues, and priority queues.
 * @author Mark Allen Weiss
 */
public class UnderflowException extends RuntimeException
{
    /**
     * Construct this exception object.
     * // @param message the error message.
     */
    public UnderflowException() { // removed the string because it caused problems in BinarySearchTree.java
    }
}
