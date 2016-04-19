import java.io.*;
import java.util.*;

public class OrdListe {
	
	private String [] ordliste;
	private int antallOrd;
	private String filNavn;
	
	public OrdListe(String filNavn){
		this.filNavn = filNavn;
	}
	
	public void lesInn(String filNavn){
		File fil = new File(filNavn);
		Scanner nyFil = null;
		
		try {
			nyFil = new Scanner(fil);
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		// leser inn antall ord
		antallOrd = Integer.parseInt(nyFil.nextLine());
		ordliste = new String[antallOrd];
		int teller = 0;
		
		// leser inn alle ordene og oppdaterer ordliste
		while(nyFil.hasNextLine()){
			ordliste[teller] = nyFil.nextLine();
			teller++;
		}
		
		// for testing
		/**System.out.println("Antall ord er: " + antallOrd);
		for(int i = 0; i < ordliste.length; i++){
			System.out.println(ordliste[i]);
		}*/
	}
	
	public int hentAntallOrd(){
        return antallOrd;
	}
	public String[] hentListe(){
		return ordliste;
	}
	public String hentOrdIndeks(int indeks){
        return ordliste[indeks];
	}
	public void printListe(){
		for (int i=0; i<ordliste.length; i++){
			System.out.println(ordliste[i]);
		}
	}
    public void fjernIndeks(int indeks) {
        ordliste[indeks] = "";
    }
	
}
