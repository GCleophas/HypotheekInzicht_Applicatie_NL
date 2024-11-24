package hypotheekinzicht;

/**
 *
 * @author GCleophas
 */
public class LineaireHypotheek extends Hypotheek{
    //Constructors
    public LineaireHypotheek(int hypotheekNummer, String hypotheekBeschrijving, double hypotheekRente, double hypotheekSom, int hypotheekLooptijd) throws NegativeValueException {
        super(hypotheekNummer, hypotheekBeschrijving, hypotheekRente, hypotheekSom, hypotheekLooptijd);
    }
    
    //Getters
    @Override
    public double getHypotheekSom() {
        return super.getHypotheekSom();
    }
    
    @Override
    public void getHypotheekInzicht() {
        double restSchuld = getHypotheekSom();
        double aflossing = getHypotheekSom() / getHypotheekLooptijd();
        
        System.out.printf("Lineaire hypotheek: Hoofdsom = %.2f, rente = %.2f%%, looptijd = %d jaar%n", getHypotheekSom(), getHypotheekRente(), getHypotheekLooptijd());
        System.out.println("Jaar\tRestschuld\tAflossing\tRente");
        for(int jaar = 1; jaar <= getHypotheekLooptijd(); jaar++)
        {
            double rente = restSchuld * (getHypotheekRente() / 100);
            restSchuld -= aflossing;
            System.out.printf("%-5d\t%-12.2f\t%-12.2f\t%-10.2f%n", jaar, restSchuld, aflossing, rente);
        }
    }
}
