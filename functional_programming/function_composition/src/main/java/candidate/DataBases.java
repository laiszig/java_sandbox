package candidate;

public enum DataBases {

    MYSQL("MySQL"),
    POSTGRESQL("PostgreSQL"),
    MONGODB("MongoDB"),
    MARIADB("MariaDB"),
    ORACLE("Oracle"),
    CASSANDRA("Cassandra"),
    REDIS("Redis");

    private String dbName;

    DataBases(String dbName) {
        this.dbName = dbName;
    }

    public String getDbName() {
        return dbName;
    }
}
