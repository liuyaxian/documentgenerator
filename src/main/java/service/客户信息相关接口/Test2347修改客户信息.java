package service.客户信息相关接口;

import net.sf.json.JSONObject;
import service.DocumentGeneratorServiceImpl;

/**
 * @desc:
 * @author: admin
 * @since: 2022/1/5 10:53
 * @history:
 */
public class Test2347修改客户信息 extends DocumentGeneratorServiceImpl {

    private static final  String bizcode = "2347";
    private static final  String bizcodeDesc = "2347修改客户信息";

    public static void main(String[] args) throws Exception {
        // 需要鉴权的接口 custNo 不为为空
        String custNo =  "1001883882";
        // 需要数据交易密码的接口
        String tradeacco = "";
        // 交易密码 111111
        String passwd = "aaa111";
        JSONObject bodyJson =  setBody(bizcode, custNo);
        // 1001546198	1001883763
        requestUrl(custNo, tradeacco, passwd, bizcode, bizcodeDesc, bodyJson);

    }

    public static  JSONObject setBody(String bizcode, String custNo){
        JSONObject bodyJson = new JSONObject();
        bodyJson.put("citycode", "110000");
        bodyJson.put("areacode", "110101");
        bodyJson.put("provincecode", "110000");
        bodyJson.put("mctcustno", "1001881741");
        bodyJson.put("detailedaddr", "点解点解tu");
        return bodyJson;
    }




}