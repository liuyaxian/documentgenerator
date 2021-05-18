package service;

import com.zlfund.openapi.base.util.HttpHelper;
import net.sf.json.JSONObject;

public class JsonTest {

    public static void main(String[] args) {
        String str = "https://officew.jjmmw.com/api/simu/up/products/info/income_brief?code=%S";
                String url = String.format(str, "SCW165");
        String httpResp = HttpHelper.getStringResponse(url);
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
}
