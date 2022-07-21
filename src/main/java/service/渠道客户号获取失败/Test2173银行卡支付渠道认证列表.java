package service.渠道客户号获取失败;

import net.sf.json.JSONObject;
import service.DocumentGeneratorServiceImpl;

public class Test2173银行卡支付渠道认证列表   extends DocumentGeneratorServiceImpl {

    private static final  String bizcode = "2173";
    private static final  String bizcodeDesc = "银行卡支付渠道认证列表";

    public static void main(String[] args) throws Exception {
        // 需要鉴权的接口 custNo 不为为空
        String custNo =  "1001883935";
        // 需要数据交易密码的接口
        String tradeacco = "";
        // 交易密码 111111
        String passwd = "aaa111";
        JSONObject bodyJson =  setBody(bizcode, custNo);
        String isAuth = "1";
        requestUrl(custNo, tradeacco, passwd, bizcode, bizcodeDesc, bodyJson, isAuth);

    }

    public static  JSONObject setBody(String bizcode, String custNo){
        JSONObject bodyJson = new JSONObject();
        bodyJson.put("tradeacco", "1001546430");
        bodyJson.put("bankid", "CCB");


        return bodyJson;
    }
}
