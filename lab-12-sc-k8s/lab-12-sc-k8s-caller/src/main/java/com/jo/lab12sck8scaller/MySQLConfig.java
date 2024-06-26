package com.jo.lab12sck8scaller;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("mysql-config")
public class MySQLConfig {

    private String username;

    private String password;

    private String database;

    public MySQLConfig(String username, String password, String database) {
        this.username = username;
        this.password = password;
        this.database = database;
    }

    public MySQLConfig() {
    }

    @Override
    public String toString() {
        return "MySQLConfig{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", database='" + database + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }
}
