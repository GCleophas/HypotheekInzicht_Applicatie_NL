package hypotheekinzicht;

/**
 *
 * @author GCleophas
 */
public abstract class Hypotheek implements Product{
    private static int hypotheekNummer;
    private String hypotheekBeschrijving;
    private double hypotheekRente;
    private double hypotheekSom;
    private int hypotheekLooptijd;
    
    //LauncherV2
    public StringBuilder resultJaar = new StringBuilder("<html><div style='text-align: right; font-size: 18px;'><b>Jaar</b><br>");
    public StringBuilder resultRestSchuld = new StringBuilder("<html><div style='text-align: right; font-size: 18px;'><b>Rest schuld</b><br>");
    public StringBuilder resultAflossing = new StringBuilder("<html><div style='text-align: right; font-size: 18px;'><b>Aflossing</b><br>");
    public StringBuilder resultRente = new StringBuilder("<html><div style='text-align: right; font-size: 18px;'><b>Rente</b><br>");
    public StringBuilder resultInleg = new StringBuilder("<html><div style='text-align: right; font-size: 18px;'><b>Inleg</b><br>");
    public StringBuilder resultGespaardBedrag = new StringBuilder("<html><div style='text-align: right; font-size: 18px;'><b>Gespaard bedrag</b><br>");
    
    //Constructors
    public Hypotheek(String hypotheekBeschrijving, double hypotheekRente, double hypotheekSom, int hypotheekLooptijd) throws NegativeValueException{
        if(hypotheekSom < 0) {
            throw new NegativeValueException("Hypotheeksom kan niet negatief zijn.");
        }
        if(hypotheekRente < 0) {
            throw new NegativeValueException("Rente percentage kan niet negatief zijn.");
        }
        if(hypotheekLooptijd < 0) {
            throw new NegativeValueException("Looptijd kan niet negatief zijn.");
        }
        this.hypotheekBeschrijving = hypotheekBeschrijving;
        this.hypotheekRente = hypotheekRente;
        this.hypotheekSom = hypotheekSom;
        this.hypotheekLooptijd = hypotheekLooptijd;
        hypotheekNummer++;
    }
    
    //Getters
    public abstract void getHypotheekInzicht();
    
    public abstract String getHypotheekInzichtGUI();
    
    public abstract void berekenHypotheek();
    
    @Override
    public int getHypotheekNummer() {
        return hypotheekNummer;
    }
    
    @Override
    public String getHypotheekBeschrijving() {
        return hypotheekBeschrijving;
    }
    
    @Override
    public double getHypotheekRente() {
        return hypotheekRente;
    }
    
    @Override
    public double getHypotheekSom() {
        return hypotheekSom;
    }
    
    @Override
    public int getHypotheekLooptijd() {
        return hypotheekLooptijd;
    }
    
    //Setters

    public void setHypotheekNummer() {
        Hypotheek.hypotheekNummer = hypotheekNummer++;
    }

    public void setHypotheekBeschrijving(String hypotheekBeschrijving) {
        this.hypotheekBeschrijving = hypotheekBeschrijving;
    }

    public void setHypotheekRente(double hypotheekRente) {
        this.hypotheekRente = hypotheekRente;
    }

    public void setHypotheekSom(double hypotheekSom) {
        this.hypotheekSom = hypotheekSom;
    }

    public void setHypotheekLooptijd(int hypotheekLooptijd) {
        this.hypotheekLooptijd = hypotheekLooptijd;
    }
}
