package service.问卷调查;

import net.sf.json.JSONObject;
import service.DocumentGeneratorServiceImpl;

/**
 * @desc:
 * @author: admin
 * @since: 2021/10/28 15:14
 * @history:
 */
public class Test3213客户是否已经做过问卷调查  extends DocumentGeneratorServiceImpl {

    private static final  String bizcode = "3213";
    private static final  String bizcodeDesc = "客户是否已经做过问卷调查";

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
        bodyJson.put("question_id", 1);
        return bodyJson;
    }

}
