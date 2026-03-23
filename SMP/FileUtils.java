package SMP;


import java.io.*;     // gives us File, FileWriter, IOException,
                      // FileNotFoundException, PrintWriter
import java.util.*; 
public class FileUtils {
	
	public static List<StockRecord> readCSV(String filePath) throws FileNotFoundException,StockDataException{
		List<StockRecord> records = new ArrayList<>();
		
		File file = new File(filePath);
		try(Scanner scanner = new Scanner(file)) {
			int lineNumber = 0;
			while(scanner.hasNextLine()) {
				String line= scanner.nextLine().trim();
				lineNumber ++;
				
				if(lineNumber == 1 || line.isEmpty()) {
					continue;
				}
				
				String[]parts = line.split(",");
				if(parts.length !=7) {
					throw new StockDataException("Line" + lineNumber+" has "+ parts.length+ "Column,expected 7 . Line was:"+ line);
					
				}
				try {
					String symbol = parts[0].trim();
					String date = parts[1].trim();
					
					double openPrice  = Double.parseDouble(parts[2].trim());
                    double closePrice = Double.parseDouble(parts[3].trim());
                    double highPrice  = Double.parseDouble(parts[4].trim());
                    double lowPrice   = Double.parseDouble(parts[5].trim());
					
                    
                    long volume = Long.parseLong(parts[6].trim());
                    
                    StockRecord record = new StockRecord(
                    		 symbol, date,
                             openPrice, closePrice,
                             highPrice, lowPrice,
                             volume);
                    records.add(record);
				}catch(NumberFormatException e) {
					throw new StockDataException(
							 "Could not read number on line " + lineNumber +
		                        ". Check your CSV file. Error: " + e.getMessage());	
				}
				
			}


		}
		return records;
	}
	
	public static void writeReport(String filePath,String content) throws IOException {
		try(PrintWriter writer= new PrintWriter(new FileWriter(filePath,false))){
			writer.print(content);
		}
		System.out.println("Report saved to "+filePath);
	}
	
	public static void appendLog(String logPath,String message)throws IOException {
		try(PrintWriter writer = new PrintWriter(new FileWriter(logPath,true))){
			writer.println("[" +new java.util.Date()+ "]" + message);
		}
		
	}

}
