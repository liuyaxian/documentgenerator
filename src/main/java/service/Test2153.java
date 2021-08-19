package service;

import com.alibaba.fastjson.JSON;
import net.sf.json.JSONObject;
import service.io.vo.FundInfo;

/***
 * 2153 组合购买
 */
public class Test2153  extends DocumentGeneratorServiceImpl {

    private static final  String bizcode = "2153";
    private static final  String bizcodeDesc = "组合购买";

    public static void main(String[] args) throws Exception {
        // 需要鉴权的接口 custNo 不为为空
        String custNo =  "1001881673";
        // 需要数据交易密码的接口
        String tradeacco = "1001544496";
        // 交易密码 111111
        String passwd = "111111";
        JSONObject bodyJson =  setBody(bizcode, custNo);
        // 1001546198	1001883763
        requestUrl(custNo, tradeacco, passwd, bizcode, bizcodeDesc, bodyJson);
    }

    public static JSONObject setBody(String bizcode, String custNo){

        JSONObject bodyJson = new JSONObject();

        String str = "[{'fundid':'000771','subamt':100},{'fundid':'164906','subamt':100},{'fundid':'519772','subamt':100}]";

        bodyJson.put("forcedeal", "1");
        bodyJson.put("agreerisk", "1");
        bodyJson.put("portfoliofundid", "XJB001");
//        JSONArray jsonArray = JSON.parseArray(str);
        bodyJson.put("fundidarr", JSON.parseArray(str, FundInfo.class));
        bodyJson.put("totalsubamt", 300);
        bodyJson.put("bankcmd", "1");
        bodyJson.put("paymentmethod", "X");
        bodyJson.put("postponeflag", "1");
        return bodyJson;
    }

}
