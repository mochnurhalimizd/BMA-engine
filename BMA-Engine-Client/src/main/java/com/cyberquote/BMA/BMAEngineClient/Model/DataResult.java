package com.cyberquote.BMA.BMAEngineClient.Model;

import java.util.List;

public class DataResult {

    private String userId;
    private String linkName;
    private int totalPages;
    private int status;
    private List<DataResultDetails> resultDetails;


    public List <DataResultDetails> getResultDetails() {
        return resultDetails;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "DataResult{" +
                "userId='" + userId + '\'' +
                ", linkName='" + linkName + '\'' +
                ", totalPages=" + totalPages +
                '}';
    }
}

