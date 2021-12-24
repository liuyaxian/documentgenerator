package service;

import net.sf.json.JSONObject;

/**
 * @desc:
 * @author: admin
 * @since: 2021/12/16 18:08
 * @history:
 */
public class Test3215获取客户的买入卖出点 extends DocumentGeneratorServiceImpl {

    private static final  String bizcode = "3215";
    private static final  String bizcodeDesc = "获取客户的买入卖出点";

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
        bodyJson.put("fundid", "000928");
        bodyJson.put("startdate", "20180101");
        bodyJson.put("enddate", "20181230");

        return bodyJson;
    }
}
