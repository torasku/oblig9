public class Traader {

	int antallOrdPerTraad, start, slutt = 0;

	public Traader (int antallTraader, Ord peker, TraadMonitor mon) throws Exception {
		antallOrdPerTraad = (int) Math.ceil(peker.hentAntallOrd() / antallTraader);
		mon.opprettArray(peker.hentAntallOrd());
		while(antallTraader > 0) {
            slutt += antallOrdPerTraad;
			EnkelTraad nyTraad = new EnkelTraad(peker, start, slutt, mon);
			nyTraad.start();
			antallTraader--;
			start += antallOrdPerTraad;
		}
        start = 0;
        slutt = 0;
	}



}
