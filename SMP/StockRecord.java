package SMP;

public class StockRecord {
	String symbol;
	String date;
	double openPrice;
	double closePrice;
	double highPrice;
	double lowPrice;
	long volume;
	public StockRecord(String symbol, String date, double openPrice, double closePrice, double highPrice,
			double lowPrice, long volume) {
		super();
		this.symbol = symbol;
		this.date = date;
		this.openPrice = openPrice;
		this.closePrice = closePrice;
		this.highPrice = highPrice;
		this.lowPrice = lowPrice;
		this.volume = volume;
	}
	  public String getSymbol()     { return symbol; }
	    public String getDate()       { return date; }
	    public double getOpenPrice()  { return openPrice; }
	    public double getClosePrice() { return closePrice; }
	    public double getHighPrice()  { return highPrice; }
	    public double getLowPrice()   { return lowPrice; }
	    public long   getVolume()     { return volume; }
 public double getDailyChange() {
	 return closePrice - openPrice;
 }
 public double getPercentageChange() {
	 if(openPrice==0)return 0;
	return ((closePrice-openPrice)/openPrice) * 100;
	 
 }
 @Override
 public String toString() {
	return "StockRecord [symbol=" + symbol + ", date=" + date + ", openPrice=" + openPrice + ", closePrice="
			+ closePrice + ", highPrice=" + highPrice + ", lowPrice=" + lowPrice + ", volumn=" + volume + "]";
 }
 
 
 
	
	
}
