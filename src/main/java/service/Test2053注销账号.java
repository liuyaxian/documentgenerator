package service;

import net.sf.json.JSONObject;

/**
 * @desc:
 * @author: admin
 * @since: 2021/12/24 9:47
 * @history:
 */
public class Test2053注销账号 extends DocumentGeneratorServiceImpl {

    private static final  String bizcode = "2053";
    private static final  String bizcodeDesc = "注销账号";

    public static void main(String[] args) throws Exception {
        // 需要鉴权的接口 custNo 不为为空
        String custNo =  "1001883551";
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

        return bodyJson;
    }
}
