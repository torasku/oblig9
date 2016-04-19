import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ord {

	private String [] ordlisteUsortert;
	private int antallOrd;

	public void lesInn(String filNavn){

		File fil = new File(filNavn);
		Scanner nyFil = null;
		try {
			nyFil = new Scanner(fil);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		// leser inn antall ord
		antallOrd = Integer.parseInt(nyFil.nextLine());
		ordlisteUsortert = new String[antallOrd];
		int teller = 0;
		while(nyFil.hasNextLine()){
			ordlisteUsortert[teller] = nyFil.nextLine();
			teller++;

			/*try{
				if(teller < antallOrd){
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}*/
		}
        System.out.println(teller);

	}

	public synchronized int hentAntallOrd(){
        return antallOrd;
	}
	public String[] hentListe(){
		return ordlisteUsortert;
	}
	public synchronized String hentOrdIndeks(int indeks){
        return ordlisteUsortert[indeks];
	}
	public void printListe(){
		for (int i=0; i<ordlisteUsortert.length; i++){
			System.out.println(ordlisteUsortert[i]);
		}
	}
    public synchronized void forandreIndeks(int indeks, String erstatning) {
        ordlisteUsortert[indeks] = erstatning;
    }

}
