package core;

import connector.DatabaseConnector;
import mode.ProcessingMode;

public class DataProcessor {
    private ProcessingMode mode;
    private DatabaseConnector connector;

    public DataProcessor(ProcessingMode mode, DatabaseConnector connector) {
        this.mode = mode;
        this.connector = connector;
    }

    public void setMode(ProcessingMode mode) {
        this.mode = mode;
    }

    public void setConnector(DatabaseConnector connector) {
        this.connector = connector;
    }

    public void process(String data) {
        mode.process(data, connector);
    }
}
