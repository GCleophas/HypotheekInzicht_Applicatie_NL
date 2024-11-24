package hypotheekinzicht;

/**
 *
 * @author GCleophas
 */
public class AnnuiteitenHypotheek extends Hypotheek {
    //Constructors
    public AnnuiteitenHypotheek(int hypotheekNummer, String hypotheekBeschrijving, double hypotheekRente, double hypotheekSom, int hypotheekLooptijd) throws NegativeValueException{
        super(hypotheekNummer, hypotheekBeschrijving, hypotheekRente, hypotheekSom, hypotheekLooptijd);
    }
    
    //Getters
    @Override
    public void getHypotheekInzicht() {
        double rente = getHypotheekRente() / 100;
        double looptijd = getHypotheekLooptijd();
        double som = getHypotheekSom();
        
        double annuiteiten = (som * rente) / (1 - Math.pow(1 + rente, -looptijd));
        double restschuld = som;
        
        System.out.printf("Annuïteitenhypotheek: Hoofdsom = %.2f, Rente = %.2f%%, Looptijd = %d jaar%n", getHypotheekSom(), getHypotheekRente(), getHypotheekLooptijd());
        System.out.println("Jaar\tRestschuld\tAflossing\tRente");
        for(int jaar = 1; jaar <= getHypotheekLooptijd(); jaar++)
        {
            double hypotheekRente = restschuld * (getHypotheekRente() / 100);
            double aflossing = annuiteiten - hypotheekRente;
            restschuld -= aflossing;
            
            System.out.printf("%d\t%.2f\t%.2f\t%.2f%n", jaar, restschuld, aflossing, hypotheekRente);
        }
    }
}
