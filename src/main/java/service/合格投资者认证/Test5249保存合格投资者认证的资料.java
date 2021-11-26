package service.合格投资者认证;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import service.DocumentGeneratorServiceImpl;

/**
 * @desc:
 * @author: admin
 * @since: 2021/11/26 18:22
 * @history:
 */
public class Test5249保存合格投资者认证的资料 extends DocumentGeneratorServiceImpl {

    private static final  String bizcode = "5249";
    private static final  String bizcodeDesc = "保存合格投资者认证的资料";

    public static void main(String[] args) throws Exception {
        // 需要鉴权的接口 custNo 不为为空  15600084007
        String custNo =  "1001883406";
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
        bodyJson.put("authType", "2");

        JSONArray  filepatharr = new JSONArray();
        filepatharr.add("sdfsdfsdf");
        filepatharr.add("121");
        filepatharr.add("123123123");
        JSONObject  object1  = new JSONObject();
        object1.put("filepatharr", filepatharr);
        object1.put("filetype", "property");

        JSONObject object2  = new JSONObject();
        object2.put("filepatharr", filepatharr);
        object2.put("filetype", "investorexperience");

        JSONArray qualifiedInvestorList  = new JSONArray();
        qualifiedInvestorList.add(object1);
        qualifiedInvestorList.add(object2);
        bodyJson.put("qualifiedInvestorList",  qualifiedInvestorList);


//        String strt = " {'filetype':'property','filepatharr':['sdfsdfsdf','ssssss','234234']}";
//        String strt1 = " {'filetype':'property','filepatharr':['sdfsdfsdf','ssssss','234234']}";
//        String str2 =  "["+ strt + ',' +strt1 + "]";
        return bodyJson;
    }
}
