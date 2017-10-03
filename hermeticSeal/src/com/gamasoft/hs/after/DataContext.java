package com.gamasoft.hs.after;

public interface DataContext {

    Portfolio applyTranform(Portfolio portfolio);

    double calculate(Portfolio portfolio);
    Context getContext();

}
