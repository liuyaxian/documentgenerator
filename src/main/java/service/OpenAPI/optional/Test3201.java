package service.OpenAPI.optional;


import net.sf.json.JSONObject;
import service.DocumentGeneratorServiceImpl;

import java.util.ArrayList;
import java.util.List;

/***
 * 3201 公募私募组合收益指定日收益
 *
 */
public class Test3201   extends DocumentGeneratorServiceImpl {

    private static final  String bizcode = "3201";
    private static final  String bizcodeDesc = "公募私募组合收益指定日收益";

    public static void main(String[] args) throws Exception {
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
        List<FundYield> yieldList = new ArrayList<>();

        FundYield fundYield = new FundYield();
        fundYield.setFundId("000771");
        fundYield.setYieldPeriod("RET_1W");
        yieldList.add(fundYield);


        FundYield fundYieldXZG = new FundYield();
        fundYieldXZG.setFundId("XZGF00");
        fundYieldXZG.setYieldPeriod("RET_1Y");
        yieldList.add(fundYieldXZG);


        FundYield fundYieldfp = new FundYield();
        fundYieldfp.setFundId("SCW165");
        fundYieldfp.setYieldPeriod("RET_1W");
        yieldList.add(fundYieldfp);


        bodyJson.put("fundarr", yieldList);
        return bodyJson;
    }
}
