package service.合格投资者认证;

import net.sf.json.JSONObject;
import service.DocumentGeneratorServiceImpl;

/**
 * @desc:
 * @author: admin
 * @since: 2021/11/18 11:05
 * @history:
 */
public class Test5247合格投资者验证列表页 extends DocumentGeneratorServiceImpl {

    private static final  String bizcode = "5247";
    private static final  String bizcodeDesc = "合格投资者验证列表页";

    public static void main(String[] args) throws Exception {
        // 需要鉴权的接口 custNo 不为为空  15600084007
        String custNo =  "1001883406";
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
        bodyJson.put("fundid", "SCV893");

        return bodyJson;
    }
}
