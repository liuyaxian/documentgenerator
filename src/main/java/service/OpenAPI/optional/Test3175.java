package service.OpenAPI.optional;

import net.sf.json.JSONObject;
import service.DocumentGeneratorServiceImpl;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

/***
 * 3175 批量更新自选管理
 */
public class Test3175  extends DocumentGeneratorServiceImpl {

    private static final  String bizcode = "3175";
    private static final  String bizcodeDesc = "批量更新自选管理";

    public static void main(String[] args) throws IOException, Exception {
        // 需要鉴权的接口 custNo 不为为空
        String custNo =  "1001881673";
        // 需要数据交易密码的接口
        String tradeacco = "";
        // 交易密码 111111
        String passwd = "";
        JSONObject bodyJson =  setBody(bizcode, custNo);
        // 1001546198	1001883763
        requestUrl(custNo, tradeacco, passwd, bizcode, bizcodeDesc, bodyJson);
    }

    public static JSONObject setBody(String bizcode, String custNo){
        JSONObject bodyJson = new JSONObject();
        ArrayList<CustOptionalFund> objectArrayList = new ArrayList<>();

        CustOptionalFund custOptionalFund = new CustOptionalFund();
        custOptionalFund.setCustNo("1001881673");
        custOptionalFund.setFundId("000771");
        custOptionalFund.setFundOrder(2);
        custOptionalFund.setId(22);
        custOptionalFund.setGroupId(2);

        objectArrayList.add(custOptionalFund);
        bodyJson.put("custOptionalFund", objectArrayList);
        bodyJson.put("groupId", 2);

        return bodyJson;
    }

}
