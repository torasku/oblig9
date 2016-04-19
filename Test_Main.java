import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test_Main {

	public static void main(String[] args) throws Exception {
	
		//OrdListe nyOrdListe = new OrdListe("names.txt");
		
		//nyOrdListe.lesInn("names.txt");
		
		// tester traadene
		
		OrdListe fil1 = new OrdListe("names.txt");
		fil1.lesInn("names.txt");
        //fil1.printListe();
		Traader nyeTraader = new Traader(1, fil1);
		
		// ved kjoring av 2 traader, saa printes samme verdi paa nytt i traad 2
		

	}


	
}
