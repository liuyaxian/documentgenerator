package service.OpenAPI.optional;

import net.sf.json.JSONObject;
import service.DocumentGeneratorServiceImpl;

public class Test3199    extends DocumentGeneratorServiceImpl {

    private static final  String bizcode = "3199";
    private static final  String bizcodeDesc = "查询自选列表（含收益）";

    public static void main(String[] args) throws Exception {
        // 需要鉴权的接口 custNo 不为为空

        String custNo =  "1001883516";

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
        bodyJson.put("groupId", 5);

        //  万份收益 tenthou_unit_incm
        //     * 7日年化 year_yield_by7d
        //     * 14日年化 year_yield_by14d
        //     * 28日年化 year_yield_by28d
        //     * 35日年化 year_yield_by35d
        //     * 近1周 oneweek_income
        //     * 近1月 onemonth_income
        //     * 近3月 threemonth_income
        //     * 近6月 sixmonth_income
        //     * 近1年 oneyear_income
        //     * 近2年 twoyear_income
        //     * 近3年 threeyear_income
        //     * 近5年 fiveyear_income
        //     * 今年来 thisyear_income
        //     * 成立来  found_income
        //     * 成立来(年化） found_income_yearly
        //     * 估值02-04  estNav
        //     * 单位净值02-03  day_income
        //     * 添加以来收益率 addOptionYieldrate
        //     * 净值变动  unitNetChngPct



//        bodyJson.put("sortfield", "unitNetChngPct");
//
//
//        bodyJson.put("sortfield", "unitNetChngPct");
//
//        bodyJson.put("sortfield", "");


        // DESC  A
        bodyJson.put("sortmode","ASC");
        return bodyJson;
    }

}
