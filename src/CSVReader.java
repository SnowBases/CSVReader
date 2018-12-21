import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CSVReader {

	public static void main(String[] args) throws FileNotFoundException {
        readCSV();
    }
	
	public static void readCSV() throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("C:\\C2ImportFamRelSample.csv"));
        scanner.useDelimiter(",");
        while(scanner.hasNext()){
            System.out.print(scanner.next()+"|");
        }
        scanner.close();
	}

}
