package service.OpenAPI.optional;

import com.alibaba.fastjson.JSON;
import net.sf.json.JSONObject;
import service.DocumentGeneratorServiceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * *3173批量更新分组管理
 */
public class Test3173批量更新分组管理 extends DocumentGeneratorServiceImpl {

    private static final  String bizcode = "3173";
    private static final  String bizcodeDesc = "批量更新分组管理";

    public static void main(String[] args) throws IOException, Exception {
        // 需要鉴权的接口 custNo 不为为空
        String custNo =  "1001883545";
        // 需要数据交易密码的接口
        String tradeacco = "";
        // 交易密码 111111
        String passwd = "";
        JSONObject  bodyJson =  setBody(bizcode, custNo);
        // 1001546198	1001883763
        requestUrl(custNo, tradeacco, passwd, bizcode, bizcodeDesc, bodyJson);
    }

    public static JSONObject setBody(String bizcode, String custNo){
        JSONObject bodyJson = new JSONObject();

        String str = "{'fixed':'00','groupName':'44','groupOrder':1,'groupType':'','id': 118}";

        List<Object> list = new ArrayList<>();
        list.add(JSON.toJSON(str));
        bodyJson.put("custOptionalGroup", list);
        bodyJson.put("deleteGroupIds", "184258");

        return bodyJson;
    }
}
