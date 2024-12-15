package hypotheekinzicht;

/**
 *
 * @author GCleophas
 */
public class AnnuiteitenHypotheek extends Hypotheek {
    //Constructors
    public AnnuiteitenHypotheek(String hypotheekBeschrijving, double hypotheekRente, double hypotheekSom, int hypotheekLooptijd) throws NegativeValueException{
        super(hypotheekBeschrijving, hypotheekRente, hypotheekSom, hypotheekLooptijd);
    }
    
    //Getters
    @Override //HypotheekInzicht
    public void getHypotheekInzicht() {
        double rente = getHypotheekRente() / 100;
        double looptijd = getHypotheekLooptijd();
        double som = getHypotheekSom();
        
        double annuiteiten = (som * rente) / (1 - Math.pow(1 + rente, -looptijd));
        double restschuld = som;
        
        System.out.println(getHypotheekNummer() + " " + getHypotheekBeschrijving());
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
    
    @Override //LauncherV1
    public String getHypotheekInzichtGUI() {
        double rente = getHypotheekRente() / 100;
        double looptijd = getHypotheekLooptijd();
        double som = getHypotheekSom();
        StringBuilder result = new StringBuilder();
        
        double annuiteiten = (som * rente) / (1 - Math.pow(1 + rente, -looptijd));
        double restschuld = som;
        
        result.append("<html>");
        result.append(String.format("<p>Jaar&nbsp;&nbsp;Restschuld&nbsp;&nbsp;&nbsp;Aflossing&nbsp;&nbsp;&nbsp;Rente</p>"));
        for(int jaar = 1; jaar <= getHypotheekLooptijd(); jaar++)
        {
            double hypotheekRente = restschuld * (getHypotheekRente() / 100);
            double aflossing = annuiteiten - hypotheekRente;
            restschuld -= aflossing;
            
            result.append(String.format("<p>%d&nbsp;&nbsp;%.2f&nbsp;&nbsp;&nbsp;%.2f&nbsp;&nbsp;&nbsp;%.2f</p>", jaar, restschuld, aflossing, rente));
        }
        result.append("</html>");
        return result.toString();
    }
    
    @Override //LauncherV2
    public void berekenHypotheek() {
        double restSchuld = getHypotheekSom();
        double rente = getHypotheekRente() / 100;
        double looptijd = getHypotheekLooptijd();
        double som = getHypotheekSom();
        
        double annuiteiten = (som * rente) / (1 - Math.pow(1 + rente, -looptijd));
        
        for(int jaar = 1; jaar <= looptijd; jaar++)
        {
            double hypotheekRente = restSchuld * rente;
            double aflossing = annuiteiten - hypotheekRente;
            restSchuld -= aflossing;
            
            if (jaar == looptijd && restSchuld < 0) {
                restSchuld = 0;
            }
            
            resultJaar.append(jaar).append("<br>");
            resultRestSchuld.append((String.format("%.2f", (double) restSchuld))).append("<br>");
            resultAflossing.append((String.format("%.2f", (double) aflossing))).append("<br>");
            resultRente.append((String.format("%.2f", (double) hypotheekRente))).append("<br>");
        }
        
        resultJaar.append("</div></html>");
        resultRestSchuld.append("</div></html>");
        resultAflossing.append("</div></html>");
        resultRente.append("</div></html>");
    }
}
