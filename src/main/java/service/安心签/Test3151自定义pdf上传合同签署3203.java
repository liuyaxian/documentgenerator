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
 * @since: 2021/10/28 13:14
 * @history:
 */
public class Test3151自定义pdf上传合同签署3203 extends DocumentGeneratorServiceImpl {

    private static final  String bizcode = "3151";
    private static final  String bizcodeDesc = "3151自定义pdf上传合同签署3203";

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
        bodyJson.put("subamt","123456789.222");
        bodyJson.put("contractName","SCW165 合同");


        try {
            bodyJson.put("imageData", Base64.toBase64String(Files.readAllBytes(Paths.get("C:\\Users\\Administrator\\Desktop\\签名.png"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bodyJson;
    }

}
