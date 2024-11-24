package hypotheekinzicht;

/**
 *
 * @author GCleophas
 */
public class NegativeValueException extends Exception{
    //Constructor
    public NegativeValueException(String message) {
        super(message);
    }
    
    @Override
    public String toString() {
        return "Negative value exception: " + getMessage();
    }
}
