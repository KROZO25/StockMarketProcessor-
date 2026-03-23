# Stock Market Processor

A Java-based data analytics processor that reads stock market 
data from a CSV file, performs calculations, and generates reports.

## Features
- Reads stock data from CSV file
- Calculates average closing price
- Finds highest and lowest performing stocks
- Identifies top 3 gainers and top 3 losers by % change
- Calculates total volume traded
- Groups average price by company symbol
- Saves full report to report.txt
- Logs every run to app.log

## Technologies Used
- Java
- File I/O (Scanner, PrintWriter, FileWriter)
- Stream API
- Object Oriented Programming
- Custom Exception Handling

## Project Structure
- StockRecord.java — data model for one stock entry
- FileUtils.java — handles all file reading and writing
- StockMarketProcessor.java — performs all calculations
- StockDataException.java — custom exception for bad data
- Main.java — entry point
- stocks.csv — sample stock data input

## How to Run
1. Clone the repository
2. Open in Eclipse or any Java IDE
3. Place stocks.csv in the project root folder
4. Run Main.java
