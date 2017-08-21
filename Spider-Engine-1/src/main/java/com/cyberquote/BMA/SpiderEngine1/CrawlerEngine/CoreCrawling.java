package com.cyberquote.BMA.SpiderEngine1.CrawlerEngine;


import com.cyberquote.BMA.SpiderEngine1.Model.DataResult;
import com.cyberquote.BMA.SpiderEngine1.Model.DataResultDetails;
import com.cyberquote.BMA.SpiderEngine1.Model.MessageSpider;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class CoreCrawling {

    public static String processCrawling(final MessageSpider companyObj){

        ObjectMapper mapper = new ObjectMapper();
        List<DataResultDetails> listDataResultDetails = new ArrayList <>();
        String companyName = "";
        String companyAddress = "";
        Boolean renderOK = false;
        String result = "";
        DataResult dataResult = new DataResult();
        int paging = 0;
        int retry = 0;
        while (!renderOK)
        {
            try {
                String strName = companyObj.getCompanyName().replace(" ", "+");
                String link = "https://ahu.go.id/pencarian/bakum/cari/tipe/perseroan?nama="+strName;
                Document doc = Jsoup.connect(link).get();
                Elements contentPaging = doc.select("section#paging");
                Elements linksPaging = contentPaging.select("a[href]");
                for (Element pagingData : linksPaging) {

                    paging = Integer.parseInt(pagingData.text().replace(".", ""));
                }

                if(paging > 0)
                {
                    String link_paging = "https://ahu.go.id/pencarian/bakum/cari/tipe/perseroan?nama="+strName+"&page="+companyObj.getPage();

                    Document doc_content = Jsoup.connect(link_paging).get();
                    String [] listDiv = {"div.cl0" , "div.cl1"};
                    for (int i = 0; i < listDiv.length; i++) {
                        Elements DivAllData = doc_content.select(listDiv[i]);

                        for (Element allData : DivAllData) {

                            Elements companyNameElm = allData.select("strong");
                            Elements alamatElm = allData.select("div.alamat");
                            companyName = companyNameElm.text();
                            companyAddress = alamatElm.text();
                            System.out.println("Still "+strName+""+companyName+ ": "+companyAddress);
                            listDataResultDetails.add(new DataResultDetails(companyName,companyAddress));
                            }

                        }
                    }
                    renderOK = true;
                }catch (Exception e) {
                    renderOK = false;
                    retry++;
                    if (retry > 10)
                    {
                        System.out.println(e.getMessage() + "Error From Company Name : "+companyObj.getCompanyName());
                        dataResult.setUserId("zedde");
                        dataResult.setLinkName(companyObj.getCompanyName());
                        dataResult.setTotalPages(0);
                        dataResult.setStatus(0);

                        try {

                            result = mapper.writeValueAsString(dataResult);
                        } catch (JsonProcessingException exResult) {
                            // TODO Auto-generated catch block
                            exResult.printStackTrace();
                        }
                    }
                }
            }
            System.out.println("Finished collected from Company Name: "+companyObj.getCompanyName());
            dataResult.setUserId("zedde");
            dataResult.setLinkName(companyObj.getCompanyName());
            dataResult.setTotalPages(paging);

            dataResult.setResultDetails(listDataResultDetails);
            dataResult.setStatus(1);

            try {

                result =  mapper.writeValueAsString(dataResult);
            } catch (JsonProcessingException exResult) {
                // TODO Auto-generated catch block
                exResult.printStackTrace();
            }

            return result;

        }

}