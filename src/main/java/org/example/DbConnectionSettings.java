package org.example;

class DbConnectionSettings {
    private final String DB_URL;
    private final String DB_USER;
    private final String DB_PASSWORD;

    public DbConnectionSettings(String URL, String USER, String PASSWORD) {
        this.DB_URL = URL;
        this.DB_USER = USER;
        this.DB_PASSWORD = PASSWORD;
    }

    public String getDB_URL() {
        return DB_URL;
    }

    public String getDB_USER() {
        return DB_USER;
    }

    public String getDB_PASSWORD() {
        return DB_PASSWORD;
    }

    @Override
    public String toString() {
        return "BdConnectionSettings{" +
                "DB_URL='" + DB_URL + '\'' +
                ", DB_USER='" + DB_USER + '\'' +
                ", DB_PASSWORD='" + DB_PASSWORD + '\'' +
                '}';
    }
}