package endpoint;

public class Operation {

    private String query;
    private String description;

    public Operation(String query, String description) {
        this.query = query;
        this.description = description;
    }

    public String getQuery() {
        return this.query;
    }

    public String getDescription() {
        return this.description;
    }
}
