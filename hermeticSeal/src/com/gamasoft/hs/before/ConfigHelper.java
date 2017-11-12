package com.gamasoft.hs.before;

public class ConfigHelper {
    public ConfigManager getRiskConfig(String client, String market) {
        return new ConfigManager(client + "_ " + market + ".yaml");
    }
}
