package service;

import net.sf.json.JSONObject;

/**
 * @desc:
 * @author: admin
 * @since: 2021/12/28 18:24
 * @history:
 */
public class Test2215五要素开户申请  extends DocumentGeneratorServiceImpl {

    private static final  String bizcode = "2215";
    private static final  String bizcodeDesc = "五要素开户申请";

    public static void main(String[] args) throws Exception {
        // 需要鉴权的接口 custNo 不为为空
        String custNo =  "1001883882";
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

        bodyJson.put("custname", "21");
        bodyJson.put("bankid", "ICBC");
        bodyJson.put("idtype", "0");
        bodyJson.put("bankacco", "6666666688888888");
        bodyJson.put("mobileno", "13068149322");
        bodyJson.put("idno", "44142619951028092X");
        bodyJson.put("mctcustno", "1001883882");

//        String messsage  ="";
//        JSONObject.fromObject(messsage);

        return bodyJson;
    }
}

