import java.util.concurrent.CountDownLatch;

public class Traader {

	int antallOrdPerTraad, start, slutt = 0;
	private int antallTraader = 0;
	TraadMonitor monitor;

	public Traader (int antallTraader, OrdListe ordliste) throws Exception {
		antallOrdPerTraad = (int) Math.ceil(ordliste.hentAntallOrd() / antallTraader);
		this.antallTraader = antallTraader;
		monitor = new TraadMonitor(ordliste.hentAntallOrd(), antallOrdPerTraad);
		
		while(antallTraader > 0) {
            slutt += antallOrdPerTraad;
			EnkelTraad nyTraad = new EnkelTraad(ordliste, start, slutt, monitor);
			nyTraad.start();
			antallTraader--;
			start += antallOrdPerTraad;
			
		}
        start = 0;
        slutt = 0;
	}
	
	public int hentAntallTraader(){
		return antallTraader;
	}
}

	