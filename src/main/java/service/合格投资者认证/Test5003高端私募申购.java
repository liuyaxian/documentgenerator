package service.合格投资者认证;

import net.sf.json.JSONObject;
import service.DocumentGeneratorServiceImpl;

/**
 * @desc:
 * @author: admin
 * @since: 2021/11/18 14:12
 * @history:
 */
public class Test5003高端私募申购 extends DocumentGeneratorServiceImpl {

    private static final  String bizcode = "5003";
    private static final  String bizcodeDesc = "高端私募申购";

    public static void main(String[] args) throws Exception {
        // 需要鉴权的接口 custNo 不为为空  15600084007  1001883406
        String custNo =  "1001883516";
        // 需要数据交易密码的接口
        String tradeacco = "";
        // 交易密码 111111
        String passwd = "111111";
        JSONObject bodyJson =  setBody(bizcode, custNo);
        // 1001546198	1001883763
        requestUrl(custNo, tradeacco, passwd, bizcode, bizcodeDesc, bodyJson);
    }

    public static  JSONObject setBody(String bizcode, String custNo){
        JSONObject bodyJson = new JSONObject();
//        bodyJson.put("fundid", "SCV893");

        bodyJson.put("agreerisk", "1");
        bodyJson.put("subamt", "5000000");
        bodyJson.put("paymenttp", "1");
        bodyJson.put("zltype", "CFPZG");
        bodyJson.put("agreecontract", "1");
        bodyJson.put("serviceid", "D30034");

        return bodyJson;
    }
}
