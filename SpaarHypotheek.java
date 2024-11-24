package hypotheekinzicht;

/**
 *
 * @author GCleophas
 */
public class SpaarHypotheek extends Hypotheek {
    private double inleg;
    private double gespaardBedrag;
    
    //Constructors
    public SpaarHypotheek(int hypotheekNummer, String hypotheekBeschrijving, double hypotheekRente, double hypotheekSom, int hypotheekLooptijd) throws NegativeValueException{
        super(hypotheekNummer, hypotheekBeschrijving, hypotheekRente, hypotheekSom, hypotheekLooptijd);
        this.inleg = berekenInleg();
        this.gespaardBedrag = 0;
    }
    
    //Getters
    @Override
    public double getHypotheekSom() {
        return super.getHypotheekSom();
    }
    
    public double berekenInleg() {
        double p = 1 + (getHypotheekRente() / 100);
        double som = 0;
        for (int i = 0; i < getHypotheekLooptijd(); i++) {
            som += Math.pow(p, i);
        }
        return getHypotheekSom() / som;
    }
    
    @Override
    public void getHypotheekInzicht() {
        System.out.printf("Spaarhypotheek: Hoofdsom = %.2f, Rente = %.2f%%, Looptijd = %d jaar%n", getHypotheekSom(), getHypotheekRente(), getHypotheekLooptijd());
        System.out.println("Jaar\tInleg\tGespaard\tRente");
        
        double rente = getHypotheekSom() * (getHypotheekRente() / 100);
        
        for(int jaar = 1; jaar <= getHypotheekLooptijd(); jaar++) {
            double renteGespaardBedrag = gespaardBedrag * (getHypotheekRente() / 100);
            gespaardBedrag += inleg + renteGespaardBedrag;
            System.out.printf("%d\t%.2f\t%.2f\t%.2f%n", jaar, inleg, gespaardBedrag, rente);
        }
    }
}
