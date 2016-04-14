
public class Traader {
	
	int antallOrd;
	int antallOrdPerTraad = 0;
	int teller;
	
	public Traader (int antallTraader, Ord peker){
		antallOrdPerTraad = peker.hentAntallOrd() / antallTraader;
		while(antallTraader > 0){
			teller = 0;
			EnkelTraad nyTraad = new EnkelTraad(peker, teller, teller+antallOrd-1, antallOrdPerTraad);
			nyTraad.start();
			antallTraader--;
			teller += antallOrdPerTraad;
		}
	}
	
	

}
