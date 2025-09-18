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
        this.pakli.feltoltSzintelen();
        
        for (int i = 0; i < 3; i++) 
        {              
            int oszlop = felugroraIrGombokkal(oszlopok()+ SEP + pakli.kirak()+SEP);            

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
        String input = JOptionPane.showInputDialog(null, "<html><pre>" + s + "\nMelyik oszlopban van? (1-3)</pre></html>");
        return Integer.parseInt(input.trim());
    }    
    
    private int felugroraIrGombokkal(String s) 
    {
        // thx Lord GPTron Prime
        String formatted = "<html><pre>" + s + "\nMelyik oszlopban van?</pre></html>";

        Object[] options = {"1", "2", "3"};

        int choice = JOptionPane.showOptionDialog( null, formatted, "Kártya választás", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        if (choice == JOptionPane.CLOSED_OPTION) 
        {
            JOptionPane.showMessageDialog(null, "A program leállt.", "Kilépés", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }

        return choice + 1;
    }


    private void melyikVolt() 
    {
        JOptionPane.showMessageDialog(null, "<html><h2>" + "A gondolt lap a(z):<br><br>" + "<center>"+ pakli.getLap(11).getLeiras() + "</center>" + "</h2></html>", "Eredmény", JOptionPane.INFORMATION_MESSAGE);
    }

}
