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
        String custNo =  "1001883450";
        // 需要数据交易密码的接口
        String tradeacco = "";
        // 交易密码 111111
        String passwd = "";
        JSONObject bodyJson =  setBody(bizcode, custNo);
        String isAuth = "1";
        // 1001546198	1001883763
        requestUrl(custNo, tradeacco, passwd, bizcode, bizcodeDesc, bodyJson, isAuth);
    }

    public static  JSONObject setBody(){
        JSONObject bodyJson = new JSONObject();
        bodyJson.put("fundid", "SCW165");
        bodyJson.put("startdate", "20180101");
        bodyJson.put("enddate", "20221230");

        return bodyJson;
    }
}
