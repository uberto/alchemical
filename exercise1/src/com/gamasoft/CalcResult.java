package com.gamasoft;

public class CalcResult {
    public final double risk;
    public final String errors;
    public final boolean isSuccess;

    private CalcResult(double risk, String errors, boolean isSuccess) {

        this.risk = risk;
        this.errors = errors;
        this.isSuccess = isSuccess;
    }

    @Override
    public String toString() {
        return "CalcResult{" +
                "risk=" + risk +
                ", errors='" + errors + '\'' +
                ", isSuccess=" + isSuccess +
                '}';
    }

    public static CalcResult success(double risk) {
        return new CalcResult(risk, "", true);
    }

    public static CalcResult failure(String errors) {
        return new CalcResult(-1, errors, false);
    }


}
