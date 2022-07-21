package service.客户信息相关接口;

import net.sf.json.JSONObject;
import service.DocumentGeneratorServiceImpl;

public class Test3099 extends DocumentGeneratorServiceImpl {

    private static final  String bizcode = "3099";
    private static final  String bizcodeDesc = "组合购买";

    public static void main(String[] args) throws Exception {
        // 需要鉴权的接口 custNo 不为为空
        String custNo =  "1001881673";
        // 需要数据交易密码的接口
        String tradeacco = "1001544496";
        // 交易密码 111111
        String passwd = "111111";
        JSONObject bodyJson =  setBody(bizcode, custNo);
        // 1001546198	1001883763
        requestUrl(custNo, tradeacco, passwd, bizcode, bizcodeDesc, bodyJson);
    }
}
