package com.gamasoft.hs.before;

public class Main {
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

        Calcable cal = new Calcable(clientId, trades);

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

        Calcable cal = new Calcable(clientId, trades);

        ResultHolder resultsHolder = Calc.runCalculations(cal, facade);

        return new ExplainResults(market, resultsHolder.result, resultsHolder.errors);

        }

        */