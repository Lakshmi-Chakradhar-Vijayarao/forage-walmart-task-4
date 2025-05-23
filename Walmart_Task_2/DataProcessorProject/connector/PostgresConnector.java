package connector;

public class PostgresConnector implements DatabaseConnector {
    public void connect() {
        System.out.println("Connected to PostgreSQL.");
    }

    public void insertData(String data) {
        System.out.println("Inserted data into PostgreSQL: " + data);
    }

    public boolean validateData(String data) {
        System.out.println("Validated data in PostgreSQL: " + data);
        return true;
    }
}
