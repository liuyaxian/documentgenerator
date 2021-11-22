package service.问卷调查;

import net.sf.json.JSONObject;
import service.DocumentGeneratorServiceImpl;

/**
 * @desc:
 * @author: admin
 * @since: 2021/10/27 9:33
 * @history:
 */
public class Test3211保存客户调查问卷的答案 extends DocumentGeneratorServiceImpl {

    private static final  String bizcode = "3211";
    private static final  String bizcodeDesc = "保存客户调查问卷的答案";

    public static void main(String[] args) throws Exception {
        // 需要鉴权的接口 custNo 不为为空
        String custNo =  "1001883763";
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
        bodyJson.put("question_list", "[\n" +
                "            {\n" +
                "                \"index\": 1,\n" +
                "                \"answer\": \"A\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"index\": 1,\n" +
                "                \"answer\": \"A\"\n" +
                "            }\n" +
                "        ]");

        return bodyJson;
    }
}