package hypotheekinzicht;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author GCleophas
 * logo kleurcode: 107,8,82
 */
public class HypotheekInzichtGUI implements ActionListener {
    private static JFrame frame;
    private static JPanel panel;
    private static JButton home;
    private static JLabel textBeschrijving;
    private static JTextField inputBeschrijving;
    private static JLabel textSom;
    private static JTextField inputSom;
    private static JLabel textRente;
    private static JTextField inputRente;
    private static JLabel textLooptijd;
    private static JTextField inputLooptijd;
    private static JButton bereken;
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Frame
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,250);
        frame.setTitle("Hypotheek inzicht");
        
        //Panel
        panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);
        
        //Home button
        home = new JButton("Home");
        home.setBounds(10, 10, 100, 25);
        //home.addActionListener(new HypotheekInzichtGUI());
        panel.add(home);
        
        //Hypotheek type (JComboBox)
        
        //Hypotheek beschrijving
        textBeschrijving = new JLabel("Hypotheek beschrijving:");
        textBeschrijving.setBounds(50, 50, 200, 25);
        panel.add(textBeschrijving);
        inputBeschrijving = new JTextField();
        inputBeschrijving.setBounds(250, 50, 200, 25);
        panel.add(inputBeschrijving);
        
        //Hypotheek som
        textSom = new JLabel("Hypotheek som:");
        textSom.setBounds(50, 75, 200, 25);
        panel.add(textSom);
        inputSom = new JTextField();
        inputSom.setBounds(250, 75, 200, 25);
        panel.add(inputSom);
        
        //Hypotheek rente
        textRente = new JLabel("Hypotheek rente:");
        textRente.setBounds(50, 100, 200, 25);
        panel.add(textRente);
        inputRente = new JTextField();
        inputRente.setBounds(250, 100, 200, 25);
        panel.add(inputRente);
        
        //Hypotheek looptijd
        textLooptijd = new JLabel("Hypotheek looptijd:");
        textLooptijd.setBounds(50, 125, 200, 25);
        panel.add(textLooptijd);
        inputLooptijd = new JTextField();
        inputLooptijd.setBounds(250, 125, 200, 25);
        panel.add(inputLooptijd);
        
        //Bereken button
        bereken = new JButton("Bereken hypotheek");
        bereken.setBounds(150, 175, 200, 25);
        bereken.addActionListener(new HypotheekInzichtGUI());
        panel.add(bereken);
        
        frame.setVisible(true);
    }

    //Momenteel nog maar type hypotheek
    @Override //Bereken button
    public void actionPerformed(ActionEvent h) {
        try {
            String beschrijving = inputBeschrijving.getText();
            double rente = Double.parseDouble(inputRente.getText());
            double som = Double.parseDouble(inputSom.getText());
            int looptijd = Integer.parseInt(inputLooptijd.getText());
            
            LineaireHypotheek hypotheek1 = new LineaireHypotheek(001, beschrijving, rente, som, looptijd);
            hypotheek1.getHypotheekInzicht();
        } catch (NegativeValueException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
}
