import connector.*;
import mode.*;
import core.DataProcessor;

public class Main {
    public static void main(String[] args) {
        DatabaseConnector pgConnector = new PostgresConnector();
        ProcessingMode batchMode = new BatchProcessingMode();

        DataProcessor processor = new DataProcessor(batchMode, pgConnector);
        processor.process("Walmart shipment data");

        System.out.println("----- Changing to RealTime + Redis -----");

        processor.setMode(new RealTimeProcessingMode());
        processor.setConnector(new RedisConnector());
        processor.process("Real-time inventory update");

        System.out.println("----- Switching to Analytics + Elasticsearch -----");

        processor.setMode(new AnalyticsProcessingMode());
        processor.setConnector(new ElasticConnector());
        processor.process("Product search analytics");
    }
}
