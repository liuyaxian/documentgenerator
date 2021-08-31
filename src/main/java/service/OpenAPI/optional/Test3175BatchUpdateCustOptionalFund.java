package service.OpenAPI.optional;

import net.sf.json.JSONObject;
import service.DocumentGeneratorServiceImpl;

import java.io.IOException;
import java.util.ArrayList;

/***
 * 3175 批量更新自选管理
 */
public class Test3175BatchUpdateCustOptionalFund extends DocumentGeneratorServiceImpl {

    private static final  String bizcode = "3175";
    private static final  String bizcodeDesc = "批量更新自选管理";

    public static void main(String[] args) throws IOException, Exception {
        // 需要鉴权的接口 custNo 不为为空
        String custNo =  "1001883545";
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
        custOptionalFund.setCustNo("1001883545");
        custOptionalFund.setFundId("163415");
        custOptionalFund.setFundOrder(1);
        custOptionalFund.setGroupId(109);
        objectArrayList.add(custOptionalFund);

        CustOptionalFund custOptionalFund2 = new CustOptionalFund();
        custOptionalFund2.setCustNo("1001883545");
        custOptionalFund2.setFundId("001938");
        custOptionalFund2.setFundOrder(2);
        custOptionalFund2.setGroupId(109);
        objectArrayList.add(custOptionalFund2);


        CustOptionalFund custOptionalFund4 = new CustOptionalFund();
        custOptionalFund4.setCustNo("1001883545");
        custOptionalFund4.setFundId("110022");
        custOptionalFund4.setFundOrder(3);
        custOptionalFund4.setGroupId(109);
        objectArrayList.add(custOptionalFund2);

        bodyJson.put("custOptionalFund", objectArrayList);

        return bodyJson;
    }

}
