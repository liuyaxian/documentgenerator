package service.基金投顾;

import net.sf.json.JSONObject;
import service.DocumentGeneratorServiceImpl;

/**
 * @desc:
 * @author: admin
 * @since: 2022/2/22 17:58
 * @history:
 */
public class Test3289组合升级  extends DocumentGeneratorServiceImpl {

    private static final  String bizcode = "3289";
    private static final  String bizcodeDesc = "3289组合升级";

    public static void main(String[] args) throws Exception {
        // 需要鉴权的接口 custNo 不为为空
        String custNo =  "1001883911";
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

        String body = " [{'custno':'1001883548','tradeacco':'1001546170','productid':'XZGF0T','targetserviceid':'C21003',\n" +
                "                    'serialno':'202204251658212470100507'},{'custno':'1001883548','tradeacco':'1001546165',\n" +
                "                    'productid':'XZGF0T','targetserviceid':'C21003','serialno':'202204251658212471100507'},\n" +
                "            {'custno':'1001883548','tradeacco':'1001546164','productid':'XZGF0S','targetserviceid':\n" +
                "                'C21003','serialno':'202204251658212472100507'}],\n" +
                "            'agreement':'华宝薛掌柜新中产进取型组合策略说明书,基金投资顾问服务协议,基金投顾服务风险揭示书','sourceip':'172.18.50.113',\n" +
                "                    'user':{'custno':'1001883548','tradeacco':'','bankacco':'','bankno':'','risklevel':'5','xzgrisklevel':'5',\n" +
                "                    'mobileno':'17603035566'}}";
        JSONObject.fromObject(body);
        bodyJson.put("datalist",  JSONObject.fromObject(body));
        return bodyJson;
    }

}

