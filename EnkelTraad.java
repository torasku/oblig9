import java.util.concurrent.CountDownLatch;


public class EnkelTraad extends Thread implements Comparable<Ord> {

	private String [] ordliste;
	private Ord peker;
	private String [] sortert;
	private int start;
	private int slutt;
	private int antallOrd;
	private String minsteOrd;
	private String sammenlign;
	private int teller = 0;
	private int teller2 = 0;
	
	public EnkelTraad (Ord peker, int start, int slutt, int antallOrd){
		this.antallOrd = antallOrd;
		this.peker=peker;
		this.peker = peker;
		this.start = start;
		this.slutt = slutt;
	}
	public void run(){
		ordliste = peker.hentListe();
		sortert = new String[antallOrd];
		for (int i = start; i <= slutt; i++){
			sammenlign = ordliste[i];
			for (int j = i+1; j <=slutt; j++ ){
				teller2 = j;
				if (compareTo(peker) > 0){
					minsteOrd = ordliste[j];
					sammenlign = minsteOrd;
				}
				if (teller2 == slutt){
					sortert[teller] = minsteOrd;
					teller++;
				}
			}
		}
		printArray();
		teller = 0;
	}
	public int compareTo(Ord a) {
		return sammenlign.compareTo(a.hentOrdIndeks(teller2));
	}
	public void printArray(){
		for (int g = 0; g < sortert.length; g++){
			System.out.println(sortert[g]);
		}
	}
	public void settInn(String a){
		sortert[0] = a;
	}
}
