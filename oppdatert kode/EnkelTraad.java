import java.util.concurrent.CountDownLatch;

public class EnkelTraad extends Thread {

	private Ord peker;
	private int start, slutt = 0;
	private String temp, minsteOrd = "";
	//CountDownLatch barriere;
	TraadMonitor mon;
	String[] sortert;

	public EnkelTraad (Ord peker, int start, int slutt, TraadMonitor mon) throws Exception {
		this.slutt = slutt;
		this.peker = peker;
		this.start = start;
		this.mon = mon;
	}
	public void run() {
		/*sortert = new String[slutt-start];
		for(int i = start; i < slutt - start; i++){
			for(int j = start+1; j < slutt-start; j++){
				if((peker.hentOrdIndeks(j-1)).compareTo(peker.hentOrdIndeks(j)) > 0){
					temp = peker.hentOrdIndeks(j-1);
					peker.forandreIndeks((j-1), peker.hentOrdIndeks(j));
					peker.forandreIndeks(j, temp);
				}
			}

		}*/
		mon.leggTilArray(sortert, start, slutt);
		mon.printArray();
	}
	/*public synchronized void printArray(){
		for (int g = 0; g < sortert.length; g++){
            if (sortert[g] != null) {
                System.out.println(sortert[g]);
            }
		}
	}*/
}
