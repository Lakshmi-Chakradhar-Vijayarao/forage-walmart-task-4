package mode;

import connector.DatabaseConnector;

public class AnalyticsProcessingMode implements ProcessingMode {
    public void process(String data, DatabaseConnector connector) {
        connector.connect();
        System.out.println("Analyzing data: " + data);
    }
}
