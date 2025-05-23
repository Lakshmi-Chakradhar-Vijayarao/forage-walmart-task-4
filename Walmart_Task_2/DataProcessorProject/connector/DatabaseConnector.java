package connector;

public interface DatabaseConnector {
    void connect();
    void insertData(String data);
    boolean validateData(String data);
}
