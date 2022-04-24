package service.合格投资者认证;

import net.sf.json.JSONObject;
import service.DocumentGeneratorServiceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @desc:
 * @author: admin
 * @since: 2021/11/18 14:12
 * @history:
 */
public class Test5003高端私募申购 extends DocumentGeneratorServiceImpl {

    private static final  String bizcode = "5003";
    private static final  String bizcodeDesc = "高端私募申购";

    public static void main(String[] args) throws Exception {
        // 需要鉴权的接口 custNo 不为为空  15600084007  1001883406
        String custNo =  "1001883548";
        // 需要数据交易密码的接口
        String tradeacco = "1001546207";
        // 交易密码 111111 ecc4ff67a0ef8282
        String passwd = "111111";
        JSONObject bodyJson =  setBody(bizcode, custNo);
        // 1001546198	1001883763
        requestUrl(custNo, tradeacco, passwd, bizcode, bizcodeDesc, bodyJson);
    }

    public static  JSONObject setBody(String bizcode, String custNo){
        JSONObject bodyJson = new JSONObject();
//        bodyJson.put("fundid", "SCV893");

        bodyJson.put("agreerisk", "1");
        bodyJson.put("subamt", "404000");
        bodyJson.put("paymenttp", "1");
        bodyJson.put("zltype", "CFPZG");
        bodyJson.put("agreecontract", "1");
        bodyJson.put("serviceid", "SJE850");
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        return bodyJson;
    }


//2022-04-21 10:46:48,755 [http-bio-8080-exec-6] INFO com.zlfund.openapi.action.BaseAction.getRequestJson(BaseAction.java:73) - request data =
//            {"msg":{"head":{"devicetype":"iOS","mctcode":"1000","version":"4.0","idfa":"18a38d11f89d4da7894dcb82a8a813c9","sendtime":"104647","custip":"172.18.40.173",
//            "seqid":"D4AD95C263C94798BA7E683A119C0ABC","appversion":"4.5.2","bizcode":"5003","deviceid":"07ea20e30c284232495b79c6028320af9fd2",
//            "senddate":"20220423","zl-skip-cache":"1"},"auth":{"sessionkey":"e9bd356371c1f4aaa50d3628e2e8d9ed","authtype":"2","passwd":"ecc4ff67a0ef8282",
//            "mctcustno":"1001883548","tradeacco":"1001546207"},"body":{"serviceid":"SJE850",
//            "agreement":"合格投资者承诺书，盛达期货众禄资产配置FOF3号资管计划资产管理合同，盛达期货众禄资产配置FOF3号资管计划风险揭示书，盛达期货众禄资产配置FOF3号资管计划说明书",
//            "paymenttp":1,"agreecontract":"1","subamt":404000,"agreerisk":"1"}},"signtype":"m","sign":"a27c1ef778ff92fb78881d0f836822d5"}
//

}
