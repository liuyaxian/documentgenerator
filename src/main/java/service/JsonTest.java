package service;

import net.sf.json.JSONObject;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpConnectionManager;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.methods.GetMethod;
import org.springframework.beans.factory.annotation.Autowired;;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

public class JsonTest {

    @Autowired
    RestTemplate restTemplate;

    public static void main(String[] args) {
        String str = "https://officew.jjmmw.com/api/simu/up/products/info/income_brief?code=%S";
                String url = String.format(str, "SCW165");


        HttpClient httpClient = multiThreadedHttpConnectionManager();

        GetMethod method = new GetMethod(url);
        try {
            httpClient.executeMethod(method);
        } catch (IOException e) {
            e.printStackTrace();
        }


        String httpResp = null;
        try {
            httpResp = method.getResponseBodyAsString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        JSONObject incomeObject = JSONObject.fromObject(httpResp);
        if (incomeObject.containsKey("result")){
            JSONObject resultObj = JSONObject.fromObject(incomeObject.get("result"));
            if (resultObj.containsKey("income_index")){
                JSONObject income_index = JSONObject.fromObject(resultObj.get("income_index"));
                JSONObject  m1 = JSONObject.fromObject(income_index.get("ret_1m"));
                System.out.printf(m1.get("income").toString());
            }
        }
    }
    private static  HttpClient multiThreadedHttpConnectionManager(){
        HttpConnectionManager hcm = new MultiThreadedHttpConnectionManager();
        hcm.getParams().setConnectionTimeout(300000);
        hcm.getParams().setSoTimeout(300000);
        // 每个host支持多少个并发
        hcm.getParams().setDefaultMaxConnectionsPerHost(512);
        // 总共支持多少个链接， host个数*DefaultMaxConnectionsPerHost
        hcm.getParams().setMaxTotalConnections(5 * 256);
        return  new HttpClient(hcm);
    }
}
