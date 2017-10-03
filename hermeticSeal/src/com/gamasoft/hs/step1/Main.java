package com.gamasoft.hs.step1;

import java.util.List;

public class Main {

    private DataContextBuilder newModule;

    public Response execute(String client, String market, List<Integer> trades, ConnectionPool conns){
        Portfolio pf = new Portfolio(client, trades);

        DataContext dc = newModule.createDataContext(conns, market);

        CalcResult r = runCalculations(pf, dc.getConnection(), dc.getOptions(), dc.getContext());

        return new Response(dc.getContext(), r);

    }

    private CalcResult runCalculations(Portfolio portfolio, Connection conn, Options opts, Context context) {
        //some very complex calculations

        Portfolio newPortfolio = context.applyTranform(conn, portfolio);

        //others very complex calculations

        double x = opts.calculate(newPortfolio);

        return CalcResult.success(x);
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