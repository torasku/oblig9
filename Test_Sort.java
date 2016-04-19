import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
public class Test_Sort {
	
	private static String [] ordliste;
	private static int antallOrd;
	private static String filNavn;

	public static void main(String[] args) {
		
		String[] array = {"Arne", "Charlie", "Devon"};
		String[] array2 = {"Butt", "Dog", "Oleg"};
		
		//lesInn("names.txt");
		//bobbleSortering(ordliste);
		bobbleSortering(array);
		bobbleSortering(array2);
		flett(array, array2);
	}
	
	public static void bobbleSortering(String[] array){
		
		for(int i = 0; i < array.length - 1; i++){
			for(int j = 1; j < array.length - i; j++){
				if(array[j - 1].compareTo((array[j])) > 0){
					String temp = array[j - 1];
					array[j-1] = array[j];
					array[j] = temp;
				}
			}
		}
		System.out.println("Tester sort");
		System.out.println(Arrays.toString(array));
	}
	
	public static void flett(String[] array1, String[] array2){
		
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
	
	public static void lesInn(String filNavn){
		File fil = new File(filNavn);
		Scanner nyFil = null;
		
		try {
			nyFil = new Scanner(fil);
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		// leser inn antall ord
		antallOrd = Integer.parseInt(nyFil.nextLine());
		ordliste = new String[antallOrd];
		int teller = 0;
		
		// leser inn alle ordene og oppdaterer ordliste
		while(nyFil.hasNextLine()){
			ordliste[teller] = nyFil.nextLine();
			teller++;
		}
		
		// for testing
		/**System.out.println("Antall ord er: " + antallOrd);
		for(int i = 0; i < ordliste.length; i++){
			System.out.println(ordliste[i]);
		}*/
	}

}
