package service;

import net.sf.json.JSONObject;

/**
 * @desc:
 * @author: admin
 * @since: 2022/1/12 13:51
 * @history:
 */
public class Test2013静默登录  extends DocumentGeneratorServiceImpl {

    private static final  String bizcode = "2013";
    private static final  String bizcodeDesc = "静默登录";

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

        bodyJson.put("ciphertext","duYdCpHms5CMNobTkIveR3izHL0df0LILXqZJ/GWmWjrGwKFaWwFuT2jZPv1mwOXIgNjbM6IhIAiXaKIQWTAGn/rhxEsgZ8ltkD128a/F7Y93wB89n5HuwmGf8mrUA1u");



        return bodyJson;
    }
}

