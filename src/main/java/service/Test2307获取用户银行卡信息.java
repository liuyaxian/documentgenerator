package service;

import net.sf.json.JSONObject;

/**
 * @desc:
 * @author: admin
 * @since: 2022/3/1 13:31
 * @history:
 */
public class Test2307获取用户银行卡信息 extends DocumentGeneratorServiceImpl {

    private static final  String bizcode = "2307";
    private static final  String bizcodeDesc = "Test2307获取用户银行卡信息";

    public static void main(String[] args) throws Exception {
        // 需要鉴权的接口 custNo 不为为空
        String custNo =  "1001883516";
        // 需要数据交易密码的接口
        String tradeacco = "";
        // 交易密码 111111
        String passwd = "aaa111";
        JSONObject bodyJson =  setBody(bizcode, custNo);
        // 1001546198	1001883763
        requestUrl(custNo, tradeacco, passwd, bizcode, bizcodeDesc, bodyJson);

    }

    public static  JSONObject setBody(String bizcode, String custNo){
        JSONObject bodyJson = new JSONObject();
        bodyJson.put("accounttype", 1);
        bodyJson.put("mctcustno", "1001883516");

        return bodyJson;
    }
}
