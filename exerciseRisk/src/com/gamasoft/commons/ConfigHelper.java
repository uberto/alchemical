package com.gamasoft.commons;

public class ConfigHelper {

    private ConfigHelper() {
        //use the static factory
    }

    public static ConfigHelper readFromResources(){
        return new ConfigHelper();
    }

    public ConfigManager getRiskConfig(String client, String stockExchange) {
        Utils.notBlank(client, "riskData");
        Utils.notBlank(stockExchange, "stockExchange");

        return new ConfigManager(client + "_ " + stockExchange + ".yaml");
    }
}
