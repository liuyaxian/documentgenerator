package service.ssl证书;

import net.sf.json.JSONObject;
import service.DocumentGeneratorServiceImpl;

import java.io.OutputStream;
import java.util.Base64;

public class Test3291获取指定域名下的证书文件  extends DocumentGeneratorServiceImpl {

    private static final  String bizcode = "3291";
    private static final  String bizcodeDesc = "获取指定域名下的证书文件";

    public static void main(String[] args) throws Exception {
        // 需要鉴权的接口 custNo 不为为空
        String custNo = "1001883551";
        // 需要数据交易密码的接口
        String tradeacco = "";
        // 交易密码 111111
        String passwd = "";
        JSONObject bodyJson = setBody(bizcode, custNo);
        // 1001546198	1001883763
        String responeStr = requestUrl(custNo, tradeacco, passwd, bizcode, bizcodeDesc, bodyJson);
        JSONObject jsonObject = JSONObject.fromObject(responeStr);
        JSONObject msg = (JSONObject) jsonObject.get("msg");
        JSONObject bodyJson1 = (JSONObject) msg.get("body");
        String data = String.valueOf(bodyJson1.get("data"));
//
//        Base64.Decoder(data);
//
//        OutputStream outputStream = new

    }
    public static  JSONObject setBody(String bizcode, String custNo){
        JSONObject bodyJson = new JSONObject();
//        bodyJson.put("domain", "fcef2a94a8f9d1175641b5f9dc0a2874e7933ad99549385d");
        bodyJson.put("domain", "officeapi.zlfund.cn");

        return bodyJson;
    }
}
