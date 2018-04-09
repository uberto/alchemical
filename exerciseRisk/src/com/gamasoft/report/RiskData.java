package com.gamasoft.report;

import com.gamasoft.risk.RiskResponse;

//clent
public class RiskData {
    public ClientData clientData;
    public RiskResponse riskResponse;
    public double pv;

    public RiskData(ClientData clientData, RiskResponse riskResponse, double pv) {

        this.riskResponse = riskResponse;
        this.pv = pv;
        this.clientData = clientData;
        this.clientData.riskData = this;
    }
}
