class TraadMonitor {
    private String[] finalArray;
    private int antOrdPrTraad, teller, teller2 = 0;

    public TraadMonitor(int finStr, int antOrdPrTraad) {
        this.antOrdPrTraad = antOrdPrTraad;
        finalArray = new String[finStr];

    }
    public synchronized void leggTilArray(String[] a, int start, int slutt) {
        String[] temp = new String[antOrdPrTraad];
        teller++;
        teller2++;
        for (int i = 0; i < temp.length; i++) {
            temp[i] = a[i];
            finalArray[i] = a[i];

        }
        sorterArray();
    }
    public synchronized void sorterArray() {
		for(int p = 0; p < (antOrdPrTraad*teller2); p++){
			for(int l = 1; l < (antOrdPrTraad*teller2); l++) {
				if(finalArray[l-1].compareTo((finalArray[l])) > 0){
					String temp = finalArray[l-1];
                    finalArray[l-1] = finalArray[l];
					finalArray[l] = temp;
				}
			}
		}
    }
    public void printArray(){
		for (int g = 0; g < finalArray.length; g++){
            if (finalArray[g] != null) {
                System.out.println(finalArray[g]);
            }
		}
	}
}
