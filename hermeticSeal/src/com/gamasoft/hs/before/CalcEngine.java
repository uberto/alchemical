package com.gamasoft.hs.before;

import java.util.List;

public class CalcEngine {

    private ConnectionHelper connectionHelper;
    private ConfigHelper configHelper;

    public CalcResults execute(String clientId, String market, List<Integer> trades, ConnectionPool connections){

        Connection ds = connectionHelper.connectToDS(clientId, connections);

        Context context = ds.fetchContext(market);

        Calcable cal = new Calcable(clientId, trades);

        Options opts = configHelper.getOptions(cal, context);

        CalcResult result = runCalculations(cal, ds, opts, context);

        return new CalcResults(market, result.result, result.errors);

    }

    private CalcResult runCalculations(Calcable cal, Connection ds, Options opts, Context context) {
        //very complex calc...
        return new CalcResult(12.34);
    }
}
