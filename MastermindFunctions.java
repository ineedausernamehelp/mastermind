package mastermind;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MastermindFunctions
{
    Scanner input = new Scanner(System.in);
    public int beurten = 10;
    public boolean win = false;
    private int[] raden = new int[4];
    private int[] code = new int[4];
    private int[] hulpCode = new int[4];
    private int witCode = 0;
    private int zwartCode = 0;
    private boolean hogerAlsZes = false;

    public void random()
    {
	// genereert een random code
	Random random = new Random();
	for (int i = 0; i < code.length; i++)
	{
	    code[i] = random.nextInt(6) + 1;
	    System.out.print(code[i]);// voor testen
	    hulpCode[i] = code[i];
	}
	System.out.println();// ook voor testen

    }

    public void spelRegels()
    {
	// legt spelregels uit
	System.out.println("Welcome to Mastermind.");
	System.out.println("vul een getal in tussen de 1 en 6.");
	System.out.println("je krijgt er een witte of zwarte pin voor.");
	System.out.println("een zwarte pin krijg je door een getal van de code goed te raden.");
	System.out.println(
		"Een witte pin krijg je door een getal van de code goed raden alleen op de verkeerd plaats zetten.");
    }

    public int beurtenBerekening()
    {
	// het de beurten te berekenen
	System.out.println("je hebt nog " + beurten + " beurten");
	return beurten--;
    }

    public void raden()
    {
	// voor het raden

	// leest een getal tussen de 1 en 6
	for (int i = 0; i < raden.length; i++)
	{
	    System.out.println("vul getal " + (i + 1) + " in: ");

	    raden[i] = input.nextInt();
	    input.nextLine();
	}
    }

    public void pinnenBerekenen()
    {
	boolean[] witPinHulp = new boolean[4];
	Arrays.fill(witPinHulp, Boolean.FALSE);

	for (int i = 0; i < raden.length; i++)
	{
	    if (raden[i] > 6)
	    {
		hogerAlsZes = true;

	    }
	    // black pins
	    else if (raden[i] == code[i] && !hogerAlsZes)
	    {

		witPinHulp[i] = true;
		zwartCode++;

	    }
	    for (int j = 0; j < raden.length; j++)
	    {
		if (raden[i] == code[j] && !witPinHulp[i] && !hogerAlsZes)
		{

		    witCode++;

		}
	    }

	}
	if (witCode == 6)
	{
	    witCode = witCode - 2;
	}
	// voor de witte pinnen uitrekenen

	// reset de code terug naar het originele
	for (int i = 0; i < code.length; i++)
	{
	    code[i] = hulpCode[i];
	    witPinHulp[i] = false;
	}

    }

    public boolean teHoogGetal()
    {
	if (hogerAlsZes == true)
	{
	    System.out.println("ongeldig getal");
	}
	return hogerAlsZes = false;
    }

    public int zwartePinnen()
    {
	// kijkt hoeveel zwarte pinnen je hebt
	if (zwartCode == 4)
	{
	    System.out.println("you win");
	    win = true;
	} else if (zwartCode > 0)
	{
	    System.out.println("je hebt " + zwartCode + " zwarte pinnen");
	} else
	{
	    System.out.println("je hebt geen zwarte pinnen");
	}
	// zet de zwarte code weer op nul
	return zwartCode = 0;
    }

    public int wittePinnen()
    {
	// kijkt hoeveel witte pinnen je hebt
	if (witCode > 0)
	{
	    System.out.println("je hebt " + witCode + " witte pinnen");
	} else
	{
	    System.out.println("je hebt geen witte pinnen");
	}
	// reset de witte pinnen naar nul
	return witCode = 0;
    }

    public int[] beurtenOp()
    {
	// geeft de code aan en sluit de scanner
	System.out.print("de code was ");
	for (int i = 0; i < code.length; i++)
	{
	    System.out.print(code[i]);
	}
	input.close();

	return code;
    }

}
