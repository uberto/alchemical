package com.gamasoft.hs.before;

import java.util.List;

public class Main {

    private ConnectionHelper connHelper;
    private ConfigHelper configHelper;

    public Response execute(String client, String market, List<Integer> trades, ConnectionPool conns){

        Connection conn = connHelper.connect(client, conns);

        Context context = conn.fetchContext(market);

        Portfolio pf = new Portfolio(client, trades);

        Options opts = configHelper.getOptions(pf, context);

        CalcResult res = runCalculations(pf, conn, opts, context);

        return new Response(context, res);

    }

    private CalcResult runCalculations(Portfolio portfolio, Connection conn, Options opts, Context context) {
        //very complex calculation

        Portfolio newportfolio = context.applyTranform(conn, portfolio);

        return CalcResult.success(123.45);
    }

    public static void main(String[] args){
        //... calling execute..
    }
}


/*
interface Facade(){
        Connection getDs();
        Options getOptions();
        Context getContext();
        }



private newModule;

public ExplainResults execute(clientId, market, trades, connections){

        Facade facade = otherModule.createFacade(cal, context, market);

        Portfolio cal = new Portfolio(clientId, trades);

        ResultHolder resultsHolder = Calc.runCalculations(cal, facade.getDs(), facade.getOptions(), facade.getContext());

        return new ExplainResults(market, resultsHolder.result, resultsHolder.errors);

        }


        looking inside Calc.runCalculations:

        ...
        newPortfolio = context.applyTranform(ds, portfolio);
        ...


        let's modify the interface

interface Facade(){
        Options getOptions();
        Portfolio applyTranform(portfolio);
        }



        new code:

private newModule;

public ExplainResults execute(clientId, market, trades, connections){

        DataFacade facade = otherModule.createFacade(cal, context, market);

        Portfolio cal = new Portfolio(clientId, trades);

        ResultHolder resultsHolder = Calc.runCalculations(cal, facade);

        return new ExplainResults(market, resultsHolder.result, resultsHolder.errors);

        }

        */