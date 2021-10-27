package service.安心签;

import cfca.sadk.util.Base64;
import net.sf.json.JSONObject;
import service.DocumentGeneratorServiceImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @desc:
 * @author: admin
 * @since: 2021/10/27 11:24
 * @history:
 */
public class Test3155创建本地签署3401  extends DocumentGeneratorServiceImpl {

    private static final  String bizcode = "3155";
    private static final  String bizcodeDesc = "3155创建本地签署3401 ";

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
        bodyJson.put("userId", "C54519845C277CF1E05312016B0A937F");
        bodyJson.put("fundid", "SCW165");
        bodyJson.put("projectCode", "1212121111111");
        bodyJson.put("contractTypeCode", "riskbook");
        bodyJson.put("tradeacco", "1001883516");
        try {
            bodyJson.put("imageData", Base64.toBase64String(Files.readAllBytes(Paths.get("C:\\Users\\Administrator\\Desktop\\签名.png"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bodyJson;
    }
}
