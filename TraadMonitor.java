import java.util.Arrays;


public class TraadMonitor {

	private String[] finalArray;
	private int antOrdPrTraad, teller, teller2 = 0;
    
    
    public TraadMonitor(int finStr, int antOrdPrTraad) {
        this.antOrdPrTraad = antOrdPrTraad;
        finalArray = new String[finStr];

    }
   
    // invariant metode
    /*public synchronized boolean invariant (String [] array1, String [] array2){
    	return array1 != array2;
    }*/
	
    public synchronized void flettSammen(String [] array1, String [] array2){

    	String[] res = new String[array1.length + array2.length];
		
			int indeks1 = 0;
			int indeks2 = 0;
		
			for(int i = 0; i < res.length; i++){
				if(indeks2 >= array2.length || (indeks1 < array1.length && array1[indeks1].compareTo(array2[indeks2]) < 0)){
					res[i] = array1[indeks1];
					indeks1++;
				}
				else{
					res[i] = array2[indeks2];
					indeks2++;
				}
			}
			System.out.println(Arrays.toString(res));	
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
