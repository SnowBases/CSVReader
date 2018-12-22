import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.stream.Stream;

import org.apache.commons.io.FilenameUtils;
import static java.lang.System.out;

public class CSVReader {
	final static String CSV_FILE_PATH = "C:\\C2ImportFamRelSample.csv"; 

	public static void main(String[] args) throws SQLException, IOException {
		// Please ensure lower_case_table_names = 2 is set in my.ini
		ClassDB mysql = new ClassDB("mysql");
		mysql.createDB("CSVReader");
		
    	ClassDB db = new ClassDB("CSVReader");
    	db.createTables("CSVReader", paramTableSQL(readCSVContent(0) ) );
    	
		for(int n=1; n < getCSVLines() ; n++) db.insertRecords("CSVReader", paramRecordSQL(readCSVContent(n) , n));
		
    }
	
	public static void printCSV() throws FileNotFoundException {
		// Print the whole content of CSV files in clear format
		Scanner scanner = new Scanner(new File( CSV_FILE_PATH ));
        scanner.useDelimiter(",");
        while(scanner.hasNext()){
            System.out.print(scanner.next()+" | ");
        }
        scanner.close();
	}
	
	public static String[] readCSVContent(int n) throws IOException {
		// Read the CSV content, after the Column Header
		String line;
		try (Stream<String> lines = Files.lines(Paths.get( CSV_FILE_PATH ))) {
		    line = lines.skip(n).findFirst().get(); // n is specific line
		}
		String[] lines = line.split(",");
		
		return lines;
	}
	
	public static int getCSVLines() throws IOException {
		// Get number of lines in the file
		BufferedReader bufferReader = new BufferedReader(new FileReader( CSV_FILE_PATH ));	
		String line = bufferReader.readLine(); 
		int size = 0;
		while(line != null) {
			size += 1;
			line = bufferReader.readLine();
		}
		bufferReader.close();
		
		return size;
	}
	
	public static String paramTableSQL(String[] strings) {
		// Create SQL table parameter
		StringBuilder str = new StringBuilder();
		
		for(String x : strings ) {
			str.append(" `" + x + "` VARCHAR(255)");
			if( !x.equals( strings[strings.length - 1] )) str.append(",");
		}
		return str.toString();
	}
	
	public static String paramRecordSQL(String[] strings, int n) {
		// Create SQL record parameter
		StringBuilder str = new StringBuilder();
		//VALUES (100, 'Zara', 'Ali', 18)
		for(String x : strings ) {
			str.append("'" + x + "'");
			if( !x.equals( strings[strings.length - 1] )) str.append(",");
		}
		return str.toString();
	}
		
	public static String getCSVFilename() {
		// Get CSV the filename
		String name = FilenameUtils.getName( CSV_FILE_PATH );
		return name;
	}

}
