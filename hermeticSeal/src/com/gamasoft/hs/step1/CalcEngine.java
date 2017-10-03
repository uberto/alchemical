package com.gamasoft.hs.step1;

import java.util.List;

public class CalcEngine {

    private ConnectionHelper connectionHelper;
    private ConfigHelper configHelper;

    public OpResult execute(String clientId, String market, List<Integer> trades, ConnectionPool connections){

        Connection ds = connectionHelper.connectToDS(clientId, connections);

        Context context = ds.fetchContext(market);

        Portfolio cal = new Portfolio(clientId, trades);

        Options opts = configHelper.getOptions(cal, context);

        CalcResult result = runCalculations(cal, ds, opts, context);

        return new OpResult(market, result.result, result.errors);

    }

    private CalcResult runCalculations(Portfolio cal, Connection ds, Options opts, Context context) {
        //very complex calc...
        return new CalcResult(12.34);
    }
}
