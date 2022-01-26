package service.基金投顾;

import net.sf.json.JSONObject;
import service.DocumentGeneratorServiceImpl;

/**
 * @desc:
 * @author: admin
 * @since: 2022/1/20 14:46
 * @history:
 */
public class Test3231持仓风险匹配情况  extends DocumentGeneratorServiceImpl {

    private static final  String bizcode = "3231";
    private static final  String bizcodeDesc = "持仓风险匹配情况";

    public static void main(String[] args) throws Exception {
        // 需要鉴权的接口 custNo 不为为空
        String custNo =  "1001883882";
        // 需要数据交易密码的接口
        String tradeacco = "";
        // 交易密码 111111
        String passwd = "111111";
        JSONObject bodyJson =  setBody(bizcode, custNo);
        // 1001546198	1001883763
        requestUrl(custNo, tradeacco, passwd, bizcode, bizcodeDesc, bodyJson);
    }

    public static JSONObject setBody(String bizcode, String custNo){

        JSONObject bodyJson = new JSONObject();

        return bodyJson;
    }
}
