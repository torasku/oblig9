import java.util.concurrent.CountDownLatch;

public class EnkelTraad extends Thread {

	private Ord peker;
	private String [] sortert;
	private int start, slutt, teller, teller2 = 0;
	private String minsteOrd, sammenlign = "";
    private boolean sjekkRun = false;
	private TraadMonitor mon;

	public EnkelTraad (Ord peker, int start, int slutt, TraadMonitor mon) throws Exception {
		this.slutt = slutt;
		this.peker = peker;
		this.start = start;
		this.mon = mon;
	}
	public void run() {
        //sjekkRun = true;
		sortert = new String[slutt-start];
		for (int i = 0; i < slutt-start; i++) {
            if (!peker.hentOrdIndeks(i).equals("")) {
                sammenlign = peker.hentOrdIndeks(i);
                for (int j = 1; j < slutt-start; j++ ) {
                    if (sorterLigningen(peker.hentOrdIndeks(j)) > 0 && !peker.hentOrdIndeks(j).equals("")) {
                        teller2 = j;
                        minsteOrd = peker.hentOrdIndeks(j);
                        sammenlign = minsteOrd;
                    }
                }
                peker.removeIndeks(teller2);
                sortert[teller] = minsteOrd;
                teller2 = 0;
                teller++;
            }
		}
        mon.sorterArray(sortert, start, slutt);
		teller = 0;
	}
	public synchronized int sorterLigningen(String anotherString) {
        return sammenlign.compareTo(anotherString);
	}
	public synchronized void printArray(){
		for (int g = 0; g < sortert.length; g++){
            if (sortert[g] != null) {
                System.out.println(sortert[g]);
            }
		}
	}
    /*public boolean lagNyTraad() {
        return sjekkRun;
    }*/
}
