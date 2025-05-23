package mode;

import connector.DatabaseConnector;

public interface ProcessingMode {
    void process(String data, DatabaseConnector connector);
}
