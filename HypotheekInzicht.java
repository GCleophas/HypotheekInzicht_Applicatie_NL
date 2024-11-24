package hypotheekinzicht;

/**
 *
 * @author GCleophas
 */
public class HypotheekInzicht {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            LineaireHypotheek hypotheek1 = new LineaireHypotheek(001, "Huis1", 4, 100000, 5);
            hypotheek1.getHypotheekInzicht();
        } catch (NegativeValueException e) {
            System.out.println(e.getMessage());
        }
    
        System.out.println("\n");
        
        try {
            SpaarHypotheek hypotheek2 = new SpaarHypotheek(002, "Huis2", 4, 100000, 5);
            hypotheek2.getHypotheekInzicht();
        } catch (NegativeValueException e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("\n");
        try {
            AnnuiteitenHypotheek hypotheek3 = new AnnuiteitenHypotheek(002, "Huis3", 4, 100000, 5);
            hypotheek3.getHypotheekInzicht();
        } catch (NegativeValueException e) {
            System.out.println(e.getMessage());
        }
    }    
}
