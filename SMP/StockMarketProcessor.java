package SMP;
import java.util.*;
import java.util.stream.*;
public class StockMarketProcessor {
	
	private List<StockRecord> records =  new ArrayList<>();
	public void loadData(String filePath)throws java.io.FileNotFoundException,StockDataException {
		records = FileUtils.readCSV(filePath);
		System.out.println("Loaded " + records.size()+" records. ");
		
	}
	
	public double calculateAverageClose() {
		return records.stream()
				.mapToDouble(r -> r.getClosePrice())
				.average()
				.orElse(0);
	}
	
	public StockRecord findHighestClose() {
		return records.stream()
				.max(Comparator.comparingDouble(r ->r.getClosePrice()))
				.orElse(null);
	}
	public StockRecord findLowestClose() {
		return records.stream()
		.min(Comparator.comparingDouble(r -> r.getClosePrice()))
		.orElse(null);
	}
	
	public List<StockRecord> topGainers(int n) {
	    return records.stream()
	            .sorted((a, b) -> Double.compare(
	                    b.getPercentageChange(), a.getPercentageChange()))
	            .limit(n)
	            .collect(Collectors.toList());
	}
	
	public List<StockRecord> topLosers(int n) {
	    return records.stream()
	            .sorted((a, b) -> Double.compare(
	                    a.getPercentageChange(), b.getPercentageChange()))
	            .limit(n)
	            .collect(Collectors.toList());
	}
	 public Map<String, Double> averageCloseBySymbol() {
	        return records.stream()
	                .collect(Collectors.groupingBy(
	                        r -> r.getSymbol(),
	                        Collectors.averagingDouble(r -> r.getClosePrice())
	                ));
	    }
	 public long calculateTotalVolume() {
	        return records.stream()
	                .mapToLong(r -> r.getVolume())
	                .sum();
	    }
	 
	 public String buildReport() {

	        StringBuilder sb = new StringBuilder();
	        String line = "=".repeat(50) + "\n";

	        sb.append(line);
	        sb.append("        STOCK MARKET REPORT\n");
	        sb.append(line);
	        sb.append(String.format("Total records   : %d%n",
	                records.size()));
	        sb.append(String.format("Total volume    : %,d%n",
	                calculateTotalVolume()));
	        sb.append(String.format("Average close   : $%.2f%n%n",
	                calculateAverageClose()));

	        StockRecord highest = findHighestClose();
	        StockRecord lowest  = findLowestClose();

	        if (highest != null)
	            sb.append("Highest close : " + highest + "\n");
	        if (lowest != null)
	            sb.append("Lowest close  : " + lowest  + "\n");

	        sb.append("\n--- Average close by symbol ---\n");
	        averageCloseBySymbol()
	                .forEach((symbol, avg) ->
	                        sb.append(String.format(
	                                "  %-6s $%.2f%n", symbol, avg)));

	        sb.append("\n--- Top 3 gainers ---\n");
	        topGainers(3).forEach(r ->
	                sb.append(String.format(
	                        "  %s  %+.2f%%%n", r, r.getPercentageChange())));

	        sb.append("\n--- Top 3 losers ---\n");
	        topLosers(3).forEach(r ->
	                sb.append(String.format(
	                        "  %s  %+.2f%%%n", r, r.getPercentageChange())));

	        sb.append("\n" + line);
	        return sb.toString();
	    }
}
