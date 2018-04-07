package com.gamasoft;

public class ConfigHelper {
    private String fileName;

    public ConfigHelper(String fileName) {

        this.fileName = fileName;
    }

    public ConfigManager getRiskConfig(String client, String market) {
        return new ConfigManager(client + "_ " + market + ".yaml");
    }
}
