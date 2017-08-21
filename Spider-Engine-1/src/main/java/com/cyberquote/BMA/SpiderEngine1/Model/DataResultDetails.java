package com.cyberquote.BMA.SpiderEngine1.Model;

public class DataResultDetails {

    private String compName;
    private String compAddress;

    public DataResultDetails(String compName, String compAddress) {
        this.compName = compName;
        this.compAddress = compAddress;
    }

    public String getCompName() {
        return compName;
    }

    public String getCompAddress() {
        return compAddress;
    }
}
