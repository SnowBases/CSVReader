import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.io.FilenameUtils;


public class CSVReader {
	final static String CSV_FILE_PATH = "C:\\C2ImportFamRelSample.csv"; 

	public static void main(String[] args) throws SQLException, IOException {
		// Please ensure lower_case_table_names = 2 is set in my.ini
		ClassDB mysql = new ClassDB("mysql");
		mysql.createDB("CSVReader");
        //readCSV();
    	ClassDB db = new ClassDB("CSVReader");
    	db.createTables("CSVReader", createTableSQL(readCSVFirstColumn()) );
    }
	
	public static void readCSV() throws FileNotFoundException {
		Scanner scanner = new Scanner(new File( CSV_FILE_PATH ));
        scanner.useDelimiter(",");
        while(scanner.hasNext()){
            System.out.print(scanner.next()+" | ");
        }
        scanner.close();
	}
	
	public static List<String> readCSVFirstColumn() throws IOException {
		List<String> columnName = new ArrayList<String>();
		BufferedReader br = new BufferedReader(new FileReader( CSV_FILE_PATH )); 
	    String line = br.readLine(); 
	    br.close();
	    
		Scanner scanner = new Scanner( line );
        scanner.useDelimiter(",");

        while(scanner.hasNext()){
            columnName.add( scanner.next() );
        }
        scanner.close();
        
        return columnName;
	}
	
	public static String createTableSQL(List<String> column) {
		StringBuilder str = new StringBuilder();
			      
		for(String x : column ) {
			str.append(" `" + x + "` VARCHAR(255)");
			if( !x.equals( column.get(column.size() - 1) )) str.append(",");
		}
		return str.toString();
	}
	
	public static String getCSVFilename() {
		String name = FilenameUtils.getName( CSV_FILE_PATH );
		return name;
	}

}
