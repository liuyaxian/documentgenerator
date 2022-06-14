package service.私募改版;

import net.sf.json.JSONObject;
import service.DocumentGeneratorServiceImpl;

public class Test3197根据产品类型获取自选数据 extends DocumentGeneratorServiceImpl {

    private static final  String bizcode = "3197";
    private static final  String bizcodeDesc = "3197根据产品类型获取自选数据";

    public static void main(String[] args) throws Exception {
        // 需要鉴权的接口 custNo 不为为空
        String custNo =  "1001883516";
        // 需要数据交易密码的接口
        String tradeacco = "";
        // 交易密码 111111
        String passwd = "";
        JSONObject bodyJson =  setBody(bizcode, custNo);
        // 1001546198	1001883763
        requestUrl(custNo, tradeacco, passwd, bizcode, bizcodeDesc, bodyJson);
    }

    public static  JSONObject setBody(String bizcode, String custNo){
        JSONObject bodyJson = new JSONObject();

        bodyJson.put("mctcustno","1001883516");
        // PF : 私募 ，   FUND： 公募
        bodyJson.put("fundtype","PF");
        bodyJson.put("pagesize", 1);
        bodyJson.put("pageindex",1);

        return bodyJson;
    }
}
