package hypotheekinzicht.GUI;

import hypotheekinzicht.AnnuiteitenHypotheek;
import hypotheekinzicht.LineaireHypotheek;
import hypotheekinzicht.NegativeValueException;
import hypotheekinzicht.SpaarHypotheek;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 *
 * @author GCleophas
 */
public class LauncherV2 implements ActionListener {
    private double som;
    private String type;
    private String beschrijving;
    private double rente;
    private int looptijd;
    private String result1;
    private String result2;
    private String result3;
    private String result4;
    
    private static JFrame launcherFrame;
    
    private static JPanel menuPanel;
    private static JButton homeButton;
    
    private static JPanel inputPanel;
    private static JComboBox typeComboBox;
    private static JLabel beschrijvingLabel;
    private static JTextField beschrijvingTextField;
    private static JLabel somLabel;
    private static JTextField somTextField;
    private static JLabel renteLabel;
    private static JTextField renteTextField;
    private static JLabel looptijdLabel;
    private static JTextField looptijdTextField;
    private static JButton berekenButton;
    
    private static JScrollPane resultScrollPane;
    private static JPanel resultPanel;
    private static JLabel resultLabel1;
    private static JLabel resultLabel2;
    private static JLabel resultLabel3;
    private static JLabel resultLabel4;
    
    public static void main(String[] args) {
        //____________________LAUNCHER____________________
        
        //launcherFrame
        launcherFrame = new JFrame();
        launcherFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        launcherFrame.setLayout(new BorderLayout());
        launcherFrame.setSize(1280,720);
        launcherFrame.setBackground(new Color(107,8,82));
        launcherFrame.setResizable(false);
        launcherFrame.setLocationRelativeTo(null);
        launcherFrame.setTitle("Hypotheek inzicht");
        
        //____________________MENU____________________
        
        //menuPanel
        menuPanel = new JPanel();
        menuPanel.setLayout(new BorderLayout());
        menuPanel.setBackground(Color.WHITE);
        menuPanel.setPreferredSize(new Dimension(1, 100));
        
        //homeButton
        ImageIcon home = new ImageIcon("/Users/gijscleophas/Software Development/HypotheekInzicht/Afbeeldingen/huis.png");
        homeButton = new JButton("Hypotheek inzicht");
        homeButton.setHorizontalTextPosition(JLabel.RIGHT);
        homeButton.setFont(new Font("Sans-Serif", Font.BOLD, 50));
        homeButton.setForeground(new Color(107,8,82));
        homeButton.setIconTextGap(25);
        homeButton.setPreferredSize(new Dimension(75,75));
        homeButton.setHorizontalAlignment(SwingConstants.LEFT);
        homeButton.setIcon(home);
        homeButton.setFocusable(false);
        homeButton.setBorderPainted(false);
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                beschrijvingTextField.setText("");
                somTextField.setText("");
                renteTextField.setText("");
                looptijdTextField.setText("");
                resultLabel1.setText("");
                resultLabel2.setText("");
                resultLabel3.setText("");
                resultLabel4.setText("");
            }
        });
        
        //____________________INPUT____________________
        
        //inputPanel
        inputPanel = new JPanel();
        inputPanel.setLayout(null);
        inputPanel.setBackground(new Color(107,8,82));
        inputPanel.setPreferredSize(new Dimension(300, 1));
        
        //typeComboBox
        String[] typeHypotheek = {"Lineaire hypotheek", "Annuiteiten hypotheek", "Spaar hypotheek"};
        typeComboBox = new JComboBox<>(typeHypotheek);
        typeComboBox.setBounds(47, 50, 206, 30);
        typeComboBox.setFocusable(false);
        inputPanel.add(typeComboBox);
        
        //beschrijvingLabel
        beschrijvingLabel = new JLabel("Beschrijving");
        beschrijvingLabel.setBounds(50, 100, 200, 30);
        beschrijvingLabel.setHorizontalAlignment(SwingConstants.CENTER);
        beschrijvingLabel.setForeground(Color.WHITE);
        //beschrijvingLabel.setFont();
        inputPanel.add(beschrijvingLabel);
        
        //beschrijvingTextField
        beschrijvingTextField = new JTextField();
        beschrijvingTextField.setBounds(50, 125, 200, 30);
        beschrijvingTextField.setHorizontalAlignment(SwingConstants.CENTER);
        //beschrijvingTextField.setFont();
        inputPanel.add(beschrijvingTextField);
        
        //somLabel
        somLabel = new JLabel("Hypotheeksom");
        somLabel.setBounds(50, 200, 200, 30);
        somLabel.setHorizontalAlignment(SwingConstants.CENTER);
        somLabel.setForeground(Color.WHITE);
        //somLabel.setFont();
        inputPanel.add(somLabel);
        
        //somTextField
        somTextField = new JTextField();
        somTextField.setBounds(50, 225, 200, 30);
        somTextField.setHorizontalAlignment(SwingConstants.CENTER);
        //somTextField.setFont();
        inputPanel.add(somTextField);
        
        //renteLabel
        renteLabel = new JLabel("Rente percentage");
        renteLabel.setBounds(50, 300, 200, 30);
        renteLabel.setHorizontalAlignment(SwingConstants.CENTER);
        renteLabel.setForeground(Color.WHITE);
        //renteLabel.setFont();
        inputPanel.add(renteLabel);
        
        //renteTextField
        renteTextField = new JTextField();
        renteTextField.setBounds(50, 325, 200, 30);
        renteTextField.setHorizontalAlignment(SwingConstants.CENTER);
        //renteTextField.setFont();
        inputPanel.add(renteTextField);
        
        //looptijdLabel
        looptijdLabel = new JLabel("Looptijd");
        looptijdLabel.setBounds(50, 400, 200, 30);
        looptijdLabel.setHorizontalAlignment(SwingConstants.CENTER);
        looptijdLabel.setForeground(Color.WHITE);
        //looptijdLabel.setFont();
        inputPanel.add(looptijdLabel);
        
        //looptijdTextField
        looptijdTextField = new JTextField();
        looptijdTextField.setBounds(50, 425, 200, 30);
        looptijdTextField.setHorizontalAlignment(SwingConstants.CENTER);
        //looptijdTextField.setFont();
        inputPanel.add(looptijdTextField);
        
        //berekenButton
        ImageIcon bereken = new ImageIcon("/Users/gijscleophas/Software Development/HypotheekInzicht/Afbeeldingen/document.png");
        berekenButton = new JButton("Bereken mijn hypotheek");
        berekenButton.setForeground(new Color(107,8,82));
        homeButton.setFont(new Font("Sans-Serif", Font.BOLD, 50));
        homeButton.setIconTextGap(15);
        berekenButton.setIcon(bereken);
        berekenButton.setBounds(50, 500, 200, 50);
        berekenButton.setFocusable(false);
        berekenButton.setHorizontalTextPosition(JLabel.RIGHT);
        berekenButton.addActionListener(new LauncherV2());
        inputPanel.add(berekenButton);
        
        //____________________RESULT____________________
        
        //resultPanel
        resultPanel = new JPanel();
        resultPanel.setBackground(Color.LIGHT_GRAY);
        resultPanel.setBorder(new LineBorder(new Color(107,8,82),7));
        resultPanel.setLayout(new GridLayout(0, 4, 0, 0));
        
        //resultScrollPane (panel)
        resultScrollPane = new JScrollPane(resultPanel);
        resultScrollPane.setBackground(new Color(107,8,82));
        resultScrollPane.setBounds(300, 100, 980, 620);
        resultScrollPane.getVerticalScrollBar().setUnitIncrement(20);
        
        //resultLabel1
        resultLabel1 = new JLabel();
        resultLabel1.setVerticalAlignment(SwingConstants.TOP);
        resultLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        resultLabel1.setBorder(new EmptyBorder(0, 0, 0, 20));
        resultPanel.add(resultLabel1);
        
        //resultLabel2
        resultLabel2 = new JLabel();
        resultLabel2.setVerticalAlignment(SwingConstants.TOP);
        resultLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        resultLabel2.setBorder(new EmptyBorder(0, 0, 0, 20));
        resultPanel.add(resultLabel2);
        
        //resultLabel3
        resultLabel3 = new JLabel();
        resultLabel3.setVerticalAlignment(SwingConstants.TOP);
        resultLabel3.setHorizontalAlignment(SwingConstants.CENTER);
        resultLabel3.setBorder(new EmptyBorder(0, 0, 0, 20));
        resultPanel.add(resultLabel3);
        
        //resultLabel4
        resultLabel4 = new JLabel();
        resultLabel4.setVerticalAlignment(SwingConstants.TOP);
        resultLabel4.setHorizontalAlignment(SwingConstants.CENTER);
        resultLabel4.setBorder(new EmptyBorder(0, 0, 0, 20));
        resultPanel.add(resultLabel4);
        
        //____________________ADDS____________________
        
        //Frame adds
        menuPanel.add(homeButton);
        launcherFrame.add(resultScrollPane);
        launcherFrame.add(menuPanel, BorderLayout.NORTH);
        launcherFrame.add(inputPanel, BorderLayout.WEST);
        launcherFrame.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent h) {
        try {
            type = (String) typeComboBox.getSelectedItem();
            beschrijving = beschrijvingTextField.getText().trim();
        
            if (beschrijving.isEmpty() || renteTextField.getText().isEmpty() || somTextField.getText().isEmpty() || looptijdTextField.getText().isEmpty()) {
                throw new IllegalArgumentException("Alle velden moeten worden ingevuld.");
        }

        rente = Double.parseDouble(renteTextField.getText());
        som = Double.parseDouble(somTextField.getText());
        looptijd = Integer.parseInt(looptijdTextField.getText());

        if (rente < 0 || som < 0 || looptijd < 0) {
            throw new NegativeValueException("Negatieve waarden zijn niet toegestaan.");
        }

        switch (type) {
            case "Lineaire hypotheek" -> {
                LineaireHypotheek hypotheek = new LineaireHypotheek(beschrijving, rente, som, looptijd);
                hypotheek.berekenHypotheek();
                result1 = hypotheek.resultJaar.toString();
                result2 = hypotheek.resultRestSchuld.toString();
                result3 = hypotheek.resultAflossing.toString();
                result4 = hypotheek.resultRente.toString();
            }
            case "Spaar hypotheek" -> {
                SpaarHypotheek hypotheek = new SpaarHypotheek(beschrijving, rente, som, looptijd);
                hypotheek.berekenHypotheek();
                result1 = hypotheek.resultJaar.toString();
                result2 = hypotheek.resultInleg.toString();
                result3 = hypotheek.resultGespaardBedrag.toString();
                result4 = hypotheek.resultRente.toString();
            }
            case "Annuiteiten hypotheek" -> {
                AnnuiteitenHypotheek hypotheek = new AnnuiteitenHypotheek(beschrijving, rente, som, looptijd);
                hypotheek.berekenHypotheek();
                result1 = hypotheek.resultJaar.toString();
                result2 = hypotheek.resultRestSchuld.toString();
                result3 = hypotheek.resultAflossing.toString();
                result4 = hypotheek.resultRente.toString();
            }
        }
    } 
    catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(null, "Geen geldige numerieke waarde ingevuld. Gebruik alleen cijfers.", "Warning: Ongeldige invoer", JOptionPane.WARNING_MESSAGE);
    } 
    catch (NegativeValueException ex) {
        JOptionPane.showMessageDialog(null, ex.getMessage(), "Warning: Negatief getal", JOptionPane.WARNING_MESSAGE);
    } 
    catch (IllegalArgumentException ex) {
        JOptionPane.showMessageDialog(null, ex.getMessage(), "Error: Ongeldige invoer", JOptionPane.WARNING_MESSAGE);
    } 
    catch (HeadlessException ex) {
        JOptionPane.showMessageDialog(null, "Er is een onverwachte fout opgetreden: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } 
        resultLabel1.setText(result1);
        resultLabel2.setText(result2);
        resultLabel3.setText(result3);
        resultLabel4.setText(result4);  
    }
}
