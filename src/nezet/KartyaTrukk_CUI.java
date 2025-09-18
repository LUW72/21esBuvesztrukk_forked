package nezet;

import modell.Pakli;
import java.util.Scanner;

public class KartyaTrukk_CUI 
{
    private static Scanner sc = new Scanner(System.in);
    private Pakli pakli;
    
    private static final String SEP = System.lineSeparator();
    
    public KartyaTrukk_CUI() 
    {
        pakli = new Pakli();
    }
    
    
    public void indit() 
    {
        this.pakli.feltolt();
        
        for (int i = 0; i < 3; i++) 
        {   
            String s = pakli.kirak();
            //oszlopok();
            
            konzolraIr(s+SEP);            
            int oszlop = melyik();
            this.pakli.kever(oszlop);
        }
        melyikVolt();
        
    }  

    private int melyik() 
    {
        int oszlopSzam;
        boolean jo;
        do 
        {
            System.out.printf("\nMelyik oszlopban (1-3) van? : ");
            oszlopSzam = sc.nextInt();
            jo = oszlopSzam >= 1 && oszlopSzam <= 3;
        } 
        while (!jo);
        return oszlopSzam;
    }

//    public void kirakPrint(Pakli pakli) 
//    {
//        for (int i = 1; i < pakli.getPakli().length; i++) 
//        {
//            System.out.print("%-28s".formatted(pakli.getLap(i).getLeiras()));
//            if (i % 3 == 0) 
//            {
//                System.out.println("");
//            }
//        }
//    }
    
    private void oszlopok()
    {
        String s = "";
        for (int i = 1; i <= 3; i++) 
        {
            s += String.format("%-28s", i+".");
        }
        konzolraIr(s + SEP);
    }
    
    private void konzolraIr(String s)
    {
        System.out.print(s);
    }
    

    private void melyikVolt() 
    {
        System.out.println("\nA választott kártya a(z) %s volt!".formatted(pakli.getLap(11).getLeiras()));
    }
}