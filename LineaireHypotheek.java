package hypotheekinzicht;

/**
 *
 * @author GCleophas
 */
public class LineaireHypotheek extends Hypotheek{
    
    
    //Constructors
    public LineaireHypotheek(String hypotheekBeschrijving, double hypotheekRente, double hypotheekSom, int hypotheekLooptijd) throws NegativeValueException {
        super(hypotheekBeschrijving, hypotheekRente, hypotheekSom, hypotheekLooptijd);
    }
    
    //Getters
    @Override
    public double getHypotheekSom() {
        return super.getHypotheekSom();
    }
    
    @Override //HypotheekInzicht
    public void getHypotheekInzicht() {
        double restSchuld = getHypotheekSom();
        double aflossing = getHypotheekSom() / getHypotheekLooptijd();
        
        System.out.println(getHypotheekNummer() + " " + getHypotheekBeschrijving());
        System.out.printf("Lineaire hypotheek: Hoofdsom = %.2f, rente = %.2f%%, looptijd = %d jaar%n", getHypotheekSom(), getHypotheekRente(), getHypotheekLooptijd());
        System.out.println("Jaar\tRestschuld\tAflossing\tRente");
        for(int jaar = 1; jaar <= getHypotheekLooptijd(); jaar++)
        {
            double rente = restSchuld * (getHypotheekRente() / 100);
            restSchuld -= aflossing;
            System.out.printf("%-5d\t%-12.2f\t%-12.2f\t%-10.2f%n", jaar, restSchuld, aflossing, rente);
        }
    }
    
    @Override //LauncherV1
    public String getHypotheekInzichtGUI() {
        double restSchuld = getHypotheekSom();
        double aflossing = getHypotheekSom() / getHypotheekLooptijd();
        StringBuilder result = new StringBuilder();
        
        result.append("<html>");
        result.append(String.format("<p>Jaar&nbsp;&nbsp;Restschuld&nbsp;&nbsp;&nbsp;Aflossing&nbsp;&nbsp;&nbsp;Rente</p>"));
        for(int jaar = 1; jaar <= getHypotheekLooptijd(); jaar++)
        {
            double rente = restSchuld * (getHypotheekRente() / 100);
            restSchuld -= aflossing;
            result.append(String.format("<p>%d&nbsp;&nbsp;%.2f&nbsp;&nbsp;&nbsp;%.2f&nbsp;&nbsp;&nbsp;%.2f</p>", jaar, restSchuld, aflossing, rente));
        }
        
        result.append("</html>");
        return result.toString();
    }
    
    @Override //LauncherV2
    public void berekenHypotheek() {
        double restSchuld = getHypotheekSom();
        double aflossing = getHypotheekSom() / getHypotheekLooptijd();
        
        for (int jaar = 1; jaar <= getHypotheekLooptijd(); jaar++) {
            double rente = restSchuld * (getHypotheekRente() / 100);
        
            resultJaar.append(jaar).append("<br>");
            resultRestSchuld.append((String.format("%.2f", (double) restSchuld))).append("<br>");
            resultAflossing.append((String.format("%.2f", (double) aflossing))).append("<br>");
            resultRente.append((String.format("%.2f", (double) rente))).append("<br>");

            restSchuld -= aflossing;
        }
        
        resultJaar.append("</div></html>");
        resultRestSchuld.append("</div></html>");
        resultAflossing.append("</div></html>");
        resultRente.append("</div></html>");
    }
}
