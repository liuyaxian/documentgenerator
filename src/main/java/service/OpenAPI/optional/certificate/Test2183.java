package service.OpenAPI.optional.certificate;

import net.sf.json.JSONObject;
import service.DocumentGeneratorServiceImpl;

/***
 * 2183 发送资产证明邮件
 */
public class Test2183 extends DocumentGeneratorServiceImpl {

    private static final  String bizcode = "2183";
    private static final  String bizcodeDesc = "发送资产证明邮件";

    public static void main(String[] args) throws Exception {
        // 需要鉴权的接口 custNo 不为为空
        String custNo =  "1001883566";
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
        bodyJson.put("englishname", "brael");
        bodyJson.put("email","liu_yaxian@126.com");
        return bodyJson;
    }
}
