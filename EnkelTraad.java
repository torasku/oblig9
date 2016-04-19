import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

public class EnkelTraad extends Thread {

	private OrdListe ordliste;
	private String [] sortert;
	private int start, slutt, teller, teller2 = 0;
	private String minsteOrd, sammenlign = "";
	CountDownLatch minBarriere;
	TraadMonitor monitor;
	
	
	public EnkelTraad (OrdListe ordliste, int start, int slutt, TraadMonitor monitor) throws Exception {
		this.slutt = slutt;
		this.ordliste = ordliste;
		this.start = start;
		this.monitor = monitor;
	
	}
	 
	public void run() {
		minBarriere = new CountDownLatch(2);
		sortert = new String[slutt - start];
		int ordTeller = 0;
		for(int i = 0; i < slutt - start; i++){
			for(int j = 1; j < ordliste.hentAntallOrd(); j++){
				if(ordliste.hentListe()[j - 1].compareTo((ordliste.hentListe()[j])) > 0){
					String temp = ordliste.hentListe()[j - 1];
					ordliste.hentListe()[j-1] = ordliste.hentListe()[j];
					ordliste.hentListe()[j] = temp;	
				}
			}
			ordTeller++;
			minBarriere.countDown();
			monitor.leggTilArray(sortert, start, slutt);
			monitor.printArray();
		}
		System.out.println("Tester sort");
		System.out.println("Antall ord: " + ordTeller);
		System.out.println(Arrays.toString(ordliste.hentListe()));
		
	}
	
	public int sorterLigningen(String anotherString) {
        return sammenlign.compareTo(anotherString);
	}
	
	public void printArray(){
		for (int g = 0; g < sortert.length; g++){
            if (sortert[g] != null) {
                System.out.println(sortert[g]);
            }
		}
	}
   
}
