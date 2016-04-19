import java.util.concurrent.*;

public class Traader {

	int antallOrdPerTraad, start, slutt = 0;
	TraadMonitor monitor;

	public Traader (int antallTraader, Ord peker) throws Exception {
		antallOrdPerTraad = (int) Math.ceil(peker.hentAntallOrd() / antallTraader);
		monitor = new TraadMonitor(peker.hentAntallOrd(), antallOrdPerTraad);

		while(antallTraader > 0) {
            slutt += antallOrdPerTraad;
			EnkelTraad nyTraad = new EnkelTraad(peker, start, slutt, monitor);
			nyTraad.start();
			antallTraader--;
			start += antallOrdPerTraad;
		}
        start = 0;
        slutt = 0;
		//monitor.printArray();
	}
}
