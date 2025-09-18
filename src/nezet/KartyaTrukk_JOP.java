package nezet;

import modell.Pakli;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.plaf.RootPaneUI;

public class KartyaTrukk_JOP 
{
    private static Scanner sc = new Scanner(System.in);
    private Pakli pakli;
    
    private static final String SEP = System.lineSeparator();
    
    public KartyaTrukk_JOP() 
    {
        pakli = new Pakli();
    }
    
    public void indit() 
    {
        //this.pakli.feltolt();
        this.pakli.feltolt();
        
        for (int i = 0; i < 3; i++) 
        {   
            //String s = pakli.kirak();
            
            int oszlop = felugroraIr(oszlopok()+SEP+pakli.kirak()+SEP);            

            this.pakli.kever(oszlop);
        }
        melyikVolt();
    }  
    
    private String oszlopok()
    {
        String s = "";
        for (int i = 1; i <= 3; i++) 
        {
            s += String.format("%-28s", i+".");
        }
        return s;
    }    
    
    private int felugroraIr(String s)
    {
        String formatted = "<html><pre>" + s + "\nMelyik oszlopban van? (1-3)</pre></html>";
        String input = JOptionPane.showInputDialog(null, formatted);
        return Integer.parseInt(input.trim());
    }
   
    

    private void melyikVolt() 
    {
        JOptionPane.showConfirmDialog(null, "A választott kártya a(z) %s volt!".formatted(pakli.getLap(11).getLeiras()));
    }
}
