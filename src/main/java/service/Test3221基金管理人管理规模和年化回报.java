package service;

import net.sf.json.JSONObject;

/**
 * @desc:
 * @author: admin
 * @since: 2021/12/21 15:43
 * @history:
 */
public class Test3221基金管理人管理规模和年化回报 extends DocumentGeneratorServiceImpl {

    private static final  String bizcode = "3221";
    private static final  String bizcodeDesc = "基金管理人管理规模和年化回报";

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
        bodyJson.put("managerid", 20376719);

        return bodyJson;
    }
}
