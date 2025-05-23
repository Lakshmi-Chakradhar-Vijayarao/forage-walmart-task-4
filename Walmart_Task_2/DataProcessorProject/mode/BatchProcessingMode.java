package mode;

import connector.DatabaseConnector;

public class BatchProcessingMode implements ProcessingMode {
    public void process(String data, DatabaseConnector connector) {
        connector.connect();
        connector.insertData(data);
    }
}
