package com.cyberquote.BMA.SpiderEngine1.Model;

public class MessageSpider {

    private String companyName;
    private int page;

    public MessageSpider() {
    }

    public MessageSpider(String companyName, int page) {
        this.companyName = companyName;
        this.page = page;
    }

    public String getCompanyName() {
        return companyName;
    }

    public int getPage() {
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
