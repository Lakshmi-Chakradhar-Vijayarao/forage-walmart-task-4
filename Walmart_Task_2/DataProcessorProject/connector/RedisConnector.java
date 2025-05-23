package connector;

public class RedisConnector implements DatabaseConnector {
    public void connect() {
        System.out.println("Connected to Redis.");
    }

    public void insertData(String data) {
        System.out.println("Inserted data into Redis: " + data);
    }

    public boolean validateData(String data) {
        System.out.println("Validated data in Redis: " + data);
        return true;
    }
}
