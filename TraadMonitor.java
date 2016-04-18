class TraadMonitor {
    private String[] finalArray;
    private String[] array1;
    private String[] array2;

    public synchronized void sorterArray1(String[] array, int start, int slutt){
        array1 = array;
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
        //mon.sorterArray(sortert, start, slutt);
		teller = 0;
    }
    public synchronized void sorterArray2(String[] array, int start, int slutt){
        array2 = array;
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
        //mon.sorterArray(sortert, start, slutt);
		teller = 0;
    }
    public void opprettArray(int antOrd) {
        finalArray = new String[antOrd];
    }
}
