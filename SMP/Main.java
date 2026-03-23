package SMP;

import java.io.*;

public class Main {

    public static void main(String[] args) {

        StockMarketProcessor processor = new StockMarketProcessor();

        try {
            // Step 2 — load CSV file
            processor.loadData("stocks.csv");

            // Step 3 — run all calculations and build report
            String report = processor.buildReport();

            // print to console
            System.out.println(report);

            // Step 4 — save report to file
            FileUtils.writeReport("report.txt", report);

            // log the run
            FileUtils.appendLog("app.log",
                    "Program ran successfully.");

        } catch (FileNotFoundException e) {
            System.out.println("ERROR: stocks.csv not found! "
                    + e.getMessage());
        } catch (StockDataException e) {
            System.out.println("ERROR: Bad data in CSV! "
                    + e.getMessage());
        } catch (IOException e) {
            System.out.println("ERROR: Could not write file! "
                    + e.getMessage());
        }
    }
}