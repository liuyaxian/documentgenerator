package service.安心签;

import net.sf.json.JSONObject;
import service.DocumentGeneratorServiceImpl;

/**
 * @desc:
 * @author: admin
 * @since: 2021/10/28 14:31
 * @history:
 */
public class Test3159查询已签署合同信息   extends DocumentGeneratorServiceImpl {

    private static final String bizcode = "3159";
    private static final String bizcodeDesc = "3159查询已签署合同信息";

    public static void main(String[] args) throws Exception {
        // 需要鉴权的接口 custNo 不为为空
        String custNo = "1001883566";
        // 需要数据交易密码的接口
        String tradeacco = "";
        // 交易密码 111111
        String passwd = "";
        JSONObject bodyJson = setBody(bizcode, custNo);
        // 1001546198	1001883763
        requestUrl(custNo, tradeacco, passwd, bizcode, bizcodeDesc, bodyJson);
    }

    public static JSONObject setBody(String bizcode, String custNo) {
        JSONObject bodyJson = new JSONObject();
        bodyJson.put("fundid", "SQW359");
        bodyJson.put("projectCode", "202110281421520257004807");
        bodyJson.put("contractTypeCode", "visit");

        bodyJson.put("serialno", "202109101137409392004807");

        return bodyJson;
    }
}
