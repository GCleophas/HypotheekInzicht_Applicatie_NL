package hypotheekinzicht;

/**
 *
 * @author GCleophas
 */
public class SpaarHypotheek extends Hypotheek {
    private double inleg;
    private double gespaardBedrag;
    
    //Constructors
    public SpaarHypotheek(String hypotheekBeschrijving, double hypotheekRente, double hypotheekSom, int hypotheekLooptijd) throws NegativeValueException{
        super(hypotheekBeschrijving, hypotheekRente, hypotheekSom, hypotheekLooptijd);
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
    
    @Override //HypotheekInzicht
    public void getHypotheekInzicht() {
        System.out.println(getHypotheekNummer() + " " + getHypotheekBeschrijving());
        System.out.printf("Spaarhypotheek: Hoofdsom = %.2f, Rente = %.2f%%, Looptijd = %d jaar%n", getHypotheekSom(), getHypotheekRente(), getHypotheekLooptijd());
        System.out.println("Jaar\tInleg\tGespaard\tRente");
        
        double rente = getHypotheekSom() * (getHypotheekRente() / 100);
        
        for(int jaar = 1; jaar <= getHypotheekLooptijd(); jaar++) {
            double renteGespaardBedrag = gespaardBedrag * (getHypotheekRente() / 100);
            gespaardBedrag += inleg + renteGespaardBedrag;
            System.out.printf("%d\t%.2f\t%.2f\t%.2f%n", jaar, inleg, gespaardBedrag, rente);
        }
    }
    
    @Override //LauncherV1
    public String getHypotheekInzichtGUI() {
        StringBuilder result = new StringBuilder();
        
        result.append("<html>");
        result.append(String.format("<p>Jaar&nbsp;&nbsp;Inleg&nbsp;&nbsp;&nbsp;Gespaard&nbsp;&nbsp;&nbsp;Rente</p>"));
        
        double rente = getHypotheekSom() * (getHypotheekRente() / 100);
        
        for(int jaar = 1; jaar <= getHypotheekLooptijd(); jaar++) {
            double renteGespaardBedrag = gespaardBedrag * (getHypotheekRente() / 100);
            gespaardBedrag += inleg + renteGespaardBedrag;
            result.append(String.format("<p>%d&nbsp;&nbsp;%.2f&nbsp;&nbsp;&nbsp;%.2f&nbsp;&nbsp;&nbsp;%.2f</p>", jaar, inleg, gespaardBedrag, rente));
        }
        result.append("<html>");
        return result.toString();
    }
    
    @Override //LauncherV2
    public void berekenHypotheek() {
        
        double rente = getHypotheekSom() * (getHypotheekRente() / 100);
        
        for (int jaar = 1; jaar <= getHypotheekLooptijd(); jaar++) {
            double renteGespaardBedrag = gespaardBedrag * (getHypotheekRente() / 100);
            gespaardBedrag += inleg + renteGespaardBedrag;
            
            resultJaar.append(jaar).append("<br>");
            resultInleg.append((String.format("%.2f", (double) inleg))).append("<br>");
            resultGespaardBedrag.append((String.format("%.2f", (double) gespaardBedrag))).append("<br>");
            resultRente.append((String.format("%.2f", (double) rente))).append("<br>");
        }
        
        resultJaar.append("</div></html>");
        resultInleg.append("</div></html>");
        resultGespaardBedrag.append("</div></html>");
        resultRente.append("</div></html>");
    }
}
