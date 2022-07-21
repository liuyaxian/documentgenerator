package service.客户信息相关接口;

import net.sf.json.JSONObject;
import service.DocumentGeneratorServiceImpl;

public class Test3111 extends DocumentGeneratorServiceImpl {

    private static final  String bizcode = "3111";
    private static final  String bizcodeDesc = "持仓数据";

    public static void main(String[] args) throws Exception {
        // 需要鉴权的接口 custNo 不为为空
        String custNo =  "1001883806";
        // 需要数据交易密码的接口
        String tradeacco = "";
        // 交易密码 111111
        String passwd = "";
        JSONObject  bodyJson =  setBody(bizcode, custNo);
        String isAuth ="1";
        // 1001546198	1001883763
        requestUrl(custNo, tradeacco, passwd, bizcode, bizcodeDesc, bodyJson, isAuth);

    }

    public static  JSONObject setBody(String bizcode, String custNo){
        JSONObject bodyJson = new JSONObject();
        bodyJson.put("mctcustno", "1001881527");
        return bodyJson;
    }
}
