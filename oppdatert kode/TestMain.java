
import java.util.*;
import java.io.*;

public class TestMain {

	public static void main(String[] args) throws Exception {
		Ord fil1 = new Ord();
		fil1.lesInn("names.txt");
        //fil1.printListe();
		Traader nyeTraader = new Traader(3, fil1);
		
	}

}
