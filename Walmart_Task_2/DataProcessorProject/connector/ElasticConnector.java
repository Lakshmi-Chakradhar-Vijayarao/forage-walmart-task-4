package connector;

public class ElasticConnector implements DatabaseConnector {
    public void connect() {
        System.out.println("Connected to Elasticsearch.");
    }

    public void insertData(String data) {
        System.out.println("Inserted data into Elasticsearch: " + data);
    }

    public boolean validateData(String data) {
        System.out.println("Validated data in Elasticsearch: " + data);
        return true;
    }
}
