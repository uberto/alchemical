package com.gamasoft.hs.after;

public class CalcResult {
    public final double result;
    public final String errors;
    public final boolean isSuccess;

    private CalcResult(double res, String errors, boolean isSuccess) {

        this.result = res;
        this.errors = errors;
        this.isSuccess = isSuccess;
    }

    public static CalcResult success(double res) {
        return new CalcResult(res, "", true);
    }

    public static CalcResult failure(String errors) {
        return new CalcResult(-1, errors, false);
    }
}
