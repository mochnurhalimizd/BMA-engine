package com.cyberquote.BMA.BMAEngineClient.Model;

public class MessageSpider {

    private String companyName;
    private String page;

    public MessageSpider() {
    }

    public MessageSpider(String companyName, String page) {
        this.companyName = companyName;
        this.page = page;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getPage() {
        return page;
    }

    @Override
    public String toString() {
        return "MessageSpider{" +
                "companyName='" + companyName + '\'' +
                ", page=" + page +
                '}';
    }
}
