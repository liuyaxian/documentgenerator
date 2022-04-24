package controller.h5;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

import java.io.IOException;

public class Testh5 {

    private static final  String url = "http://localhost:8080/OpenAPI/certificate/certificate";


    public static void main(String[] args) throws IOException {
        get();
    }
    public static void get() throws IOException {
        PostMethod method = new PostMethod(url);
        method.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

        NameValuePair[] param = { new NameValuePair("url", "www.zlfund.com") };

        method.setRequestBody(param);
        method.setParameter("bizcode","1000");
        method.setDoAuthentication(true);
        HttpClient client = new HttpClient();
        client.executeMethod(method);
        method.getResponseBodyAsString();

    }
}

