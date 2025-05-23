package mode;

import connector.DatabaseConnector;

public class RealTimeProcessingMode implements ProcessingMode {
    public void process(String data, DatabaseConnector connector) {
        connector.connect();
        if (connector.validateData(data)) {
            connector.insertData(data);
        }
    }
}
