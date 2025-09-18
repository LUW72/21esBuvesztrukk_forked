package modell;

import modell.Lap;
import java.util.Scanner;

public class Pakli 
{
    
    public static final String PIROS = "\033[31;1m";
    public static final String ZOLD  = "\033[32;6m";
    public static final String TOK   = "\033[33;8m";
    public static final String MAKK  = "\033[39;1m";
    public static final String VEGE  = "\033[0m";
    
    static Scanner sc = new Scanner(System.in);
    
    private Lap[] pakli;
    
    public Pakli() 
    {
        pakli = new Lap[22];
    }
    
    public Lap getLap(int index) 
    {
        return pakli[index];
    }  

    public Lap[] getPakli() 
    {
        return pakli;
    }    
  
    public void feltolt() 
    {
        String[] ertekek = {"Asz", "Kir", "Fel", "X", "IX", "VIII"};
        String[] szinek = {"%sP".formatted(PIROS), "%sT".formatted(TOK), "%sZ".formatted(ZOLD), "%sM".formatted(MAKK)};
        pakli[0] = new Lap("");
        int index = 1;
        for (int j = 0; j < ertekek.length && index < pakli.length; j++) 
        {
            for (int k = 0; k < szinek.length && index < pakli.length; k++) 
            {
                pakli[index] = new Lap("%s_%s%s".formatted(szinek[k], ertekek[j], VEGE));
                index++;
            }
        }
    }    
    
    public void feltoltSzintelen() 
    {
        String[] ertekek = {"Asz", "Kir", "Fel", "X", "IX", "VIII"};
        String[] szinek = {"P", "T", "Z", "M"};
        pakli[0] = new Lap("");
        int index = 1;
        for (int j = 0; j < ertekek.length && index < pakli.length; j++) 
        {
            for (int k = 0; k < szinek.length && index < pakli.length; k++) 
            {
                pakli[index] = new Lap("%s_%s".formatted(szinek[k], ertekek[j]));
                index++;
            }
        }
    }      

    
    public void kever(int oszlopSzam) 
    {
        Lap[] ujPakli = new Lap[22];
        switch (oszlopSzam) 
        {
            case 1:
                for (int i = 1; i < 8; i++) 
                {
                    ujPakli[i] = pakli[20 - (i - 1) * 3];
                    ujPakli[i + 7] = pakli[19 - (i - 1) * 3];
                    ujPakli[i + 14] = pakli[21 - (i - 1) * 3];
                }
                break;
            case 2:
                for (int i = 1; i < 8; i++) 
                {
                    ujPakli[i] = pakli[19 - (i - 1) * 3];
                    ujPakli[i + 7] = pakli[20 - (i - 1) * 3];
                    ujPakli[i + 14] = pakli[21 - (i - 1) * 3];
                }
                break;
            case 3:
                for (int i = 1; i < 8; i++) 
                {
                    ujPakli[i] = pakli[19 - (i - 1) * 3];
                    ujPakli[i + 7] = pakli[21 - (i - 1) * 3];
                    ujPakli[i + 14] = pakli[20 - (i - 1) * 3];
                }
                break;
        }
        pakli = ujPakli;
    }

    public String kirak() 
    {
        String s = "";
        for (int i = 1; i < pakli.length; i++) 
        {
            s += "%-28s".formatted(pakli[i].getLeiras());
            if (i % 3 == 0) 
            {
                s += "\n";
            }
        }
        return s;
    }
}
