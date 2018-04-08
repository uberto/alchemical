package com.gamasoft.commons;

import java.util.HashMap;
import java.util.Map;

public class ConfigManager {
    public ConfigManager(String fileName) {
        //fetch config from the filename
        Utils.notBlank(fileName, "fileName");

    }

    public Map<String, Double> get(String riskName) {
        Utils.notBlank(riskName, "riskName");

        HashMap<String, Double> map = new HashMap<>();
        map.put("vol", 1.1);
        map.put("bump", 0.1);
        return map;
    }
}
