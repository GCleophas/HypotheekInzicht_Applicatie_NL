package hypotheekinzicht;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author GCleophas
 * logo kleurcode: 107,8,82
 */
public class HypotheekInzichtGUI {
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Image import
        ImageIcon image1 = new ImageIcon("/Users/gijscleophas/Software Development/HypotheekInzicht/Afbeeldingen/huis.png");
        ImageIcon image2 = new ImageIcon("/Users/gijscleophas/Software Development/HypotheekInzicht/Afbeeldingen/document.png");
        Image scaledHome = image1.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon imageHome = new ImageIcon(scaledHome);
        Image scaledResult = image2.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon imageResult = new ImageIcon(scaledResult);
        
        //Frame settings
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setSize(1280,720);
        frame.setTitle("Hypotheek inzicht");
        
        //Panel menu
        JPanel panelMenu = new JPanel();
        panelMenu.setBackground(Color.WHITE);
        panelMenu.setPreferredSize(new Dimension(100,75));
        panelMenu.setLayout(new FlowLayout(FlowLayout.LEFT));
        frame.add(panelMenu,BorderLayout.NORTH);
        
        //Button home
        JButton buttonHome = new JButton();
        buttonHome.setIcon(imageHome);
        panelMenu.add(buttonHome);
        
        //Panel info
        JPanel panelInfo = new JPanel();
        panelInfo.setBackground(Color.DARK_GRAY);
        panelInfo.setPreferredSize(new Dimension(300,75));
        frame.add(panelInfo,BorderLayout.WEST);
        
        //Button result
        JButton buttonResult = new JButton();
        buttonResult.setIcon(imageResult);
        buttonResult.setText("Bereken hypotheek");
        buttonResult.setForeground(new Color(107,8,82));
        buttonResult.setHorizontalTextPosition(JButton.RIGHT);
        panelInfo.add(buttonResult, BorderLayout.SOUTH);
        
        //Panel result
        JPanel panelResult = new JPanel();
        panelResult.setBackground(Color.LIGHT_GRAY);
        panelResult.setPreferredSize(new Dimension(980,75));
        frame.add(panelResult,BorderLayout.EAST);
    }
    
}
