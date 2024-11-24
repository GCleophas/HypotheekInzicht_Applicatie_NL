package hypotheekinzicht;

/**
 *
 * @author GCleophas
 */
public abstract class Hypotheek implements Product{
    private int hypotheekNummer;
    private String hypotheekBeschrijving;
    private double hypotheekRente;
    private double hypotheekSom;
    private int hypotheekLooptijd;
    
    //Constructors
    public Hypotheek(int hypotheekNummer, String hypotheekBeschrijving, double hypotheekRente, double hypotheekSom, int hypotheekLooptijd) throws NegativeValueException{
        if(hypotheekSom < 0) {
            throw new NegativeValueException("Hypotheeksom kan niet negatief zijn.");
        }
        if(hypotheekRente < 0) {
            throw new NegativeValueException("Rente percentage kan niet negatief zijn.");
        }
        if(hypotheekLooptijd < 0) {
            throw new NegativeValueException("Looptijd kan niet negatief zijn.");
        }
        this.hypotheekNummer = hypotheekNummer;
        this.hypotheekBeschrijving = hypotheekBeschrijving;
        this.hypotheekRente = hypotheekRente;
        this.hypotheekSom = hypotheekSom;
        this.hypotheekLooptijd = hypotheekLooptijd;
    }
    
    //Getters
    public abstract void getHypotheekInzicht();
    
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

    public void setHypotheekNummer(int hypotheekNummer) {
        this.hypotheekNummer = hypotheekNummer;
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
