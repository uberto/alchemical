package com.gamasoft.hs.after;

public class Response {

    public final Context context;
    public final CalcResult result;

    public Response(Context context, CalcResult result) {

        this.context = context;
        this.result = result;
    }
}