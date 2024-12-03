package hypotheekinzicht.GUI;

//imports
import hypotheekinzicht.AnnuiteitenHypotheek;
import hypotheekinzicht.LineaireHypotheek;
import hypotheekinzicht.NegativeValueException;
import hypotheekinzicht.SpaarHypotheek;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author GCleophas
 * logo kleurcode: 107,8,82
 * textfield leeg maken na berekenen
 */
public class HypotheekLauncher implements ActionListener {
    private static JFrame infoFrame;
    private static JFrame resultFrame;
    private static JPanel infoPanel;
    private static JPanel resultPanel;
    private static JButton homeButton;
    private static JLabel beschrijvingLabel;
    private static JTextField beschrijvingTextField;
    private static JLabel somLabel;
    private static JTextField somTextField;
    private static JLabel renteLabel;
    private static JTextField renteTextField;
    private static JLabel looptijdLabel;
    private static JTextField looptijdTextField;
    private static JButton berekenButton;
    private static JComboBox<String> typeComboBox;
    private static JLabel resultLabel;
    private static JScrollPane resultScrollPane;
    private double som;
    private String type;
    private String beschrijving;
    private double rente;
    private int looptijd;
    private String resultaten;
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Frame
        infoFrame = new JFrame();
        infoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        infoFrame.setSize(500,250);
        infoFrame.setTitle("Hypotheek inzicht");
        
        //Panel imput
        infoPanel = new JPanel();
        infoPanel.setLayout(null);
        infoFrame.add(infoPanel);
        
        //Home button
        homeButton = new JButton("Home");
        homeButton.setBounds(10, 10, 100, 25);
        //home.addActionListener(new HypotheekInzichtGUI()); knop moet het programma resetten
        infoPanel.add(homeButton);
        
        //Hypotheek type (JComboBox)
        String[] typeHypotheek = {"Lineaire hypotheek", "Annuiteiten hypotheek", "Spaar hypotheek"};
        typeComboBox = new JComboBox<>(typeHypotheek);
        typeComboBox.setBounds(250, 10, 200, 25);
        infoPanel.add(typeComboBox);
        
        //Hypotheek beschrijving
        beschrijvingLabel = new JLabel("Hypotheek beschrijving:");
        beschrijvingLabel.setBounds(50, 50, 200, 25);
        infoPanel.add(beschrijvingLabel);
        beschrijvingTextField = new JTextField();
        beschrijvingTextField.setBounds(250, 50, 200, 25);
        infoPanel.add(beschrijvingTextField);
        
        //Hypotheek som
        somLabel = new JLabel("Hypotheek som:");
        somLabel.setBounds(50, 75, 200, 25);
        infoPanel.add(somLabel);
        somTextField = new JTextField();
        somTextField.setBounds(250, 75, 200, 25);
        infoPanel.add(somTextField);
        
        //Hypotheek rente
        renteLabel = new JLabel("Hypotheek rente:");
        renteLabel.setBounds(50, 100, 200, 25);
        infoPanel.add(renteLabel);
        renteTextField = new JTextField();
        renteTextField.setBounds(250, 100, 200, 25);
        infoPanel.add(renteTextField);
        
        //Hypotheek looptijd
        looptijdLabel = new JLabel("Hypotheek looptijd:");
        looptijdLabel.setBounds(50, 125, 200, 25);
        infoPanel.add(looptijdLabel);
        looptijdTextField = new JTextField();
        looptijdTextField.setBounds(250, 125, 200, 25);
        infoPanel.add(looptijdTextField);
        
        //Bereken hypotheek knop
        berekenButton = new JButton("Bereken hypotheek");
        berekenButton.setBounds(150, 175, 200, 25);
        berekenButton.addActionListener(new HypotheekLauncher());
        infoPanel.add(berekenButton);
        
        infoFrame.setVisible(true);
    }
    
    @Override //Bereken hypotheek functie
    public void actionPerformed(ActionEvent h) {
        type = (String) typeComboBox.getSelectedItem();
        beschrijving = beschrijvingTextField.getText();
        rente = Double.parseDouble(renteTextField.getText());
        som = Double.parseDouble(somTextField.getText());
        looptijd = Integer.parseInt(looptijdTextField.getText());
        resultaten = "";
        
        try {
            if (type.equals("Lineaire hypotheek")) {
                LineaireHypotheek hypotheek = new LineaireHypotheek(beschrijving, rente, som, looptijd);
                resultaten = hypotheek.getHypotheekInzichtGUI();
            } else if (type.equals("Spaar hypotheek")) {
                SpaarHypotheek hypotheek = new SpaarHypotheek(beschrijving, rente, som, looptijd);
                resultaten = hypotheek.getHypotheekInzichtGUI();
            } else if (type.equals("Annuiteiten hypotheek")) {
                AnnuiteitenHypotheek hypotheek = new AnnuiteitenHypotheek(beschrijving, rente, som, looptijd);
                resultaten = hypotheek.getHypotheekInzichtGUI();
            }
        } catch (NegativeValueException ex) {
            resultaten = "Fout: " + ex.getMessage();
        }
        openResultaten(resultaten);
        
    }
    
    private void openResultaten(String resultaten) {
        //Resultaten frame
        resultFrame = new JFrame(type + ": " + beschrijving);
        resultFrame.setSize(500, 500);
        resultFrame.setLayout(new BorderLayout());

        //Resultaten panel
        resultPanel = new JPanel();
        resultPanel.setLayout(new BorderLayout());
        
        //Text label
        resultLabel = new JLabel(resultaten);
        resultLabel.setVerticalAlignment(SwingConstants.TOP);
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultLabel.setFont(new java.awt.Font("Monospaced", java.awt.Font.PLAIN, 15));
        
        //Scrollable venster
        resultScrollPane = new JScrollPane(resultLabel);
        resultScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        resultScrollPane.setPreferredSize(new Dimension(480, 480));
        
        resultPanel.add(resultScrollPane, BorderLayout.CENTER);
        resultFrame.add(resultPanel, BorderLayout.CENTER);
        
        resultFrame.setVisible(true);
    }
}
