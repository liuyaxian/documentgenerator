package service;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.lang.StringUtils;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.*;

public class DocumentGeneratorServiceImpl {

    // 测试环境
//    private static final  String url = "https://officeapi.zlfund.cn/OpenAPIXZG/OpenAPI.do";
    // 开发环境
    private static final  String url = "http://localhost:8080/OpenAPI/OpenAPI.do";

    //        private static final  String url = "https://officeapi.zlfund.cn/OpenAPI.do";
    private static final  String mctcode = "1000";
    private static final  String version = "4.0";
    private static final  String appversion = "4.4.5";

//    public static void main(String[] args) throws IOException, Exception {
//        // 需要鉴权的接口 custNo 不为为空
//        String custNo =  "1001883763";
//        // 需要数据交易密码的接口
//        String tradeacco = "";
//        // 交易密码 111111
//        String passwd = "";
//        // 1001546198	1001883763
//        requestUrl(custNo, tradeacco, passwd, bizcode, bizcodeDesc);
//    }


    // body 组装
    public static JSONObject setBody(String bizcode, String custNo){
        JSONObject bodyJson = new JSONObject();
        // 个人开户3001
        if ("3137".equals(bizcode)){
            bodyJson.put("personName", "刘思");
            bodyJson.put("identNo", "1234567890");
            bodyJson.put("mobilePhone", "17666100076");
            bodyJson.put("authenticationMode", "公安部");
        }
        // 发送验证码3101
        if ("3141".equals(bizcode)){
            bodyJson.put("userId", "C31FD569690C4718E05311016B0AF1FB");
            bodyJson.put("userId", "XZGF00");
            bodyJson.put("projectCode", "10000001");
        }
        // 确认验证码3102
        if ("3143".equals(bizcode)){
            bodyJson.put("userId", "C31FD569690C4718E05311016B0AF1FB");
            bodyJson.put("projectCode", "10000001");
            bodyJson.put("checkCode", "411026");
        }

        if ("3135".equals(bizcode)){
            bodyJson.put("fundids", "XZGF00");
        }
        if ("5235".equals(bizcode)){
            bodyJson.put("sortfield", "period");
            bodyJson.put("fundid", "");
            bodyJson.put("sortmode", "DESC");
        }
        if ("2307".equals(bizcode)){
//            "mctcustno": "1001883548",
//                    "orderbyfield": "perlimitamt",
//                    "tradeType": "ZL"
            bodyJson.put("mctcustno", "1001883548");
            bodyJson.put("orderbyfield", "perlimitamt");
            bodyJson.put("tradeType", "ZL");
        }
        if ("2401".equals(bizcode)){
            bodyJson.put("inner_code", 1000009983);
            bodyJson.put("fundid", "003009");
            bodyJson.put("balancedetailtype", "INC");
            bodyJson.put("fundtype", "0");
            bodyJson.put("period", "1M");
            bodyJson.put("mctcustno", "1001881549");
            bodyJson.put("tradeacco", "1001544877");
        }



        if ("3123".equals(bizcode)){
            bodyJson.put("code", "CLXJ_JNJ");
        }
        if ("3133".equals(bizcode)){
            List<Map> mapList = new ArrayList<>();
            Map map = new HashMap<>();
            map.put("fundId","161725");
            map.put("yieldPeriod","RET_1Y");
            map.put("fundId","XZGF00");
            map.put("yieldPeriod","RET_1M");
            mapList.add(map);
//            Map map2 = new HashMap<>();
//            map2.put("fundId","002143");
//            map2.put("yieldPeriod","RET_5Y");
//            mapList.add(map2);
//            Map map3 = new HashMap<>();
//            map3.put("fundId","XZGF00");
//            map3.put("yieldPeriod","RET_5Y");
//            mapList.add(map3);
//
//            Map map4 = new HashMap<>();
//            map4.put("fundId","SCW165");
//            map4.put("yieldPeriod","RET_5Y");
//            mapList.add(map4);

            bodyJson.put("fundarr", mapList);
        }
        if ("2309".equals(bizcode)){
            bodyJson.put("mctcustno", custNo);
        }
        //  3131 众禄严选
        if ("3131".equals(bizcode)){
            bodyJson.put("mctcustno", custNo);
        }
        // 2103认申购接口
        if ("2103".equals(bizcode)){
            bodyJson.put("mctcustno", custNo);
            bodyJson.put("fundid", "000217");
            bodyJson.put("subamt", 1235);
            bodyJson.put("bankcmd", "1");
            bodyJson.put("capbal", "1");
            bodyJson.put("postponeflag", "1");
            bodyJson.put("forcedeal", "1");
            bodyJson.put("agreement", "风险揭示,电子签名协议");
            bodyJson.put("serialnoex", "");
            bodyJson.put("agreerisk", "1");
            bodyJson.put("paymentmethod", "B");
            bodyJson.put("opertime", "20210301084435");
        }
        if ("3117".equals(bizcode)){
            // XFJJ XFJJ_SY
            bodyJson.put("code", "XFJJSY");
        }
        return bodyJson;
    }



    public static void requestUrl(String custno, String tradeacco, String passwd, String bizcode, String bizcodeDesc,JSONObject requestBodyJson) throws IOException {
        JSONObject reqJson = createReqJson(bizcode, custno, tradeacco, passwd, requestBodyJson);

        System.out.println("请求json:" + reqJson.toString());
        NameValuePair[] param = { new NameValuePair("data", reqJson.toString()) };
        PostMethod method = new PostMethod(url);
        method.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
        method.setRequestBody(param);
        method.setParameter("bizcode","1000");
        method.setDoAuthentication(true);
        HttpClient client = new HttpClient();
        client.executeMethod(method);
        StringBuffer sb = new StringBuffer();
        sb.append("### ").append(bizcode + " " + bizcodeDesc + "\n\n");
        sb.append("**功能描述**" + "\n\n");
        sb.append(bizcodeDesc + "\n\n");
        sb.append("**接口类型**" + "\n\n");
        sb.append("POST请求，后台调用，传输数据格式为Json。" + "\n\n\n\n");
        sb.append("不需要身份鉴权。" + "\n\n\n\n");
        sb.append("**请求方向**" + "\n\n");
        sb.append("商户->众禄" + "\n\n\n\n");
        sb.append("接口参数" + "\n\n");
        sb.append("**请求参数**" + "\n\n");
        sb.append("bizcode:"+ bizcode + "\n\n");
        sb.append("```JSON"+ "\n\n");
        sb.append("请求json:"+ "\n\n");
        sb.append(formatJson(reqJson.toString()) + "\n");
        sb.append("```" + "\n\n\n");
        sb.append("| **字段名称** | **Json path**   | **格式** | **必填** | **备注**   |" + "\n");
        sb.append("| ------------ | --------------- | -------- | -------- | ---------- | " + "\n");
        JSONObject msg = (JSONObject) reqJson.get("msg");
        JSONObject bodyJson = (JSONObject) msg.get("body");
        setRequestValue(bodyJson,  sb, " body/");
        sb.append("\n\n\n"+"**响应参数**" + "\n\n\n");
        int code = Integer.parseInt(bizcode) + 1;
        sb.append("bizcode:" +  code + "\n\n\n");
        sb.append("```JSON" + "\n\n");
        sb.append("响应Json:" + "\n");
        sb.append(formatJson(method.getResponseBodyAsString())+ "\n\n\n");
        sb.append("```" + "\n\n\n");
        sb.append("| **字段名称**   | **Json path** | **格式** | **必填** | **备注**  |" + "\n");
        sb.append("| -------------- | ------------------------------ | -------- | -------- | ------- |" + "\n");
        String responseStr = method.getResponseBodyAsString();
        if (StringUtils.isBlank(responseStr)){
            System.out.println("为空！");
            return ;
        }
        JSONObject jsonObj = JSONObject.fromObject(responseStr);
        JSONObject msg1 = (JSONObject) jsonObj.get("msg");
//        JSONObject bodyJson1 = (JSONObject) msg1.get("body");
//        setResponsValue(bodyJson1, sb);
//        FileWriter(sb.toString(),bizcode , bizcodeDesc);
        System.out.println(sb.toString());
    }


    /***
     * 字符串处理
     * @param buff
     * @throws IOException
     */
    public static void FileWriter(String buff, String bizcode, String bizcodeDesc) throws IOException {
        File file = new File("E:\\apidocs\\" + bizcode +bizcodeDesc+".md");
        if (!file.exists()) {
            // 1，先得到文件的上级目录，并创建上级目录
            file.getParentFile().mkdirs();
            try {
                // 2，再创建文件
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileWriter writer = new FileWriter(file,true);
        writer.write(buff);
        writer.close();
    }
    /**
     * 流处理
     * @param buff
     * @throws IOException
     */
    public static void inputStream(byte[] buff,String bizcode, String bizcodeDesc) throws IOException {
        // 创建文件
        File file = new File("E:\\apidocs\\" + bizcode + bizcodeDesc+".txt");
        if (!file.exists()){
            //1，先得到文件的上级目录，并创建上级目录
            file.getParentFile().mkdirs();
            // 2，再创建文件
            file.createNewFile();
        }
        FileOutputStream out = new FileOutputStream(file);
        InputStream is = new ByteArrayInputStream(buff);
        int len = 0;
        while((len=is.read(buff))!=-1){
            out.write(buff, 0, len);
        }
        is.close();
        out.close();
    }


    /**
     * 请求tab
     * @param bodyJson
     * @param sb
     * @param dataStr
     */

    public static void setRequestValue(JSONObject bodyJson, StringBuffer sb,  String dataStr){
        if (bodyJson == null || bodyJson.size() ==0){
            return;
        }
        Iterator<String> keys = bodyJson.keys();
        while (keys.hasNext()) {

            String key = keys.next();
            Object object = bodyJson.get(key);
            String filedType = "varchar";
            if (object instanceof Number) {
                filedType = "number";
            } else if (object instanceof Boolean) {
                filedType = "Boolean";
            } else if (object instanceof Date) {
                filedType = "Date";
            }
            Object  objectValue  = null;
            if (object != null && object.toString().length()< 50){
                objectValue = object;
            }
            sb.append("| " + key + " |  " + dataStr + key + " | " + filedType + " | " + "  Y " + " | " + " " + objectValue + " | " + "\n");
        }
    }




    /***
     * 写响应tab
     * @param bodyJson
     * @param sb
     */
    public static void setResponsValue(JSONObject bodyJson, StringBuffer sb){
        if (bodyJson == null || bodyJson.size() ==0){
            return;
        }
        if (bodyJson.containsKey("datalist")){
            JSONArray list = bodyJson.getJSONArray("datalist");
            if (list == null){
                 return;
            }
            JSONObject bodyJson1 =  list.getJSONObject(0);

            setTableValue(bodyJson1, sb,  " body/datalist/");

//            JSONObject bodyJson1 =  list.getJSONObject(0);
//            setTableValue(bodyJson1, sb,  " body/datalist/");
//            JSONArray list2 = bodyJson1.getJSONArray("tabInfos");
//            JSONObject bodyJson2 =  list2.getJSONObject(0);
//            setTableValue(bodyJson2, sb,  " body/datalist/tabInfos/");
//            JSONArray list3 = bodyJson2.getJSONArray("fundInfos");
//            JSONObject bodyJson3 =  list3.getJSONObject(0);
//            setTableValue(bodyJson3, sb,  " body/datalist/tabInfos/fundInfos/");
        } else {
            setTableValue(bodyJson, sb,  " body/");
        }
    }

    /**
     * 写对象表格值
     * @param bodyJson
     * @param sb
     * @param dataStr
     */
    public static void setTableValue(JSONObject bodyJson, StringBuffer sb, String dataStr){
        if (bodyJson == null || bodyJson.size() ==0){
            return;
        }
        Iterator<String> keys = bodyJson.keys();
        while (keys.hasNext()) {

            String key = keys.next();
            Object object = bodyJson.get(key);
            String filedType = "varchar";
            if (object instanceof Number) {
                filedType = "number";
            } else if (object instanceof Boolean) {
                filedType = "Boolean";
            } else if (object instanceof Date) {
                filedType = "Date";
            }
            Object  objectValue  = null;
            if (object != null && object.toString().length()< 50){
                objectValue = object;
            }
            sb.append("| " + key + " |  " + dataStr + key + " | " + filedType + " | " + "  Y " + " | " + " " + objectValue + " | " + "\n");
        }
    }



    /**
     * 获取客户的sessionkey
     * @param custNo
     * @return
     */
    public static String getSessionkey(String custNo){
        if (StringUtils.isBlank(custNo)){
            return "";
        }
        String className = "org.postgresql.Driver";
        Connection con = null;
        Statement stmt = null;
        try {
            Class.forName(className);
            con = DriverManager.getConnection("jdbc:postgresql://172.18.10.73:54320/trade",
                    "zlfund", "zlfundzlfund");
            stmt = con.createStatement();
            String sql = "   select sessionkey from custinfo a " +
                    "    inner join custinfoex b using(custno) " +
                    "   where a.custno= '" + custNo + "' limit 1 ";
            ResultSet rs = stmt.executeQuery(sql);
            while ( rs.next() ) {
                return rs.getString("sessionkey");
            }
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        return "";
    }


    public static JSONObject createReqJson(String bizCode, String custNo, String tradeacco, String passwd, JSONObject bodyJson) {
        JSONObject msgJson = new JSONObject();
        msgJson.put("head", setHeadJson(bizCode));
        msgJson.put("body", bodyJson);
        msgJson.put("auth", setAuthJson(custNo, tradeacco, passwd));
        JSONObject reqJson = new JSONObject();
        reqJson.put("msg", msgJson);
        // 签名
        reqJson.put("signtype", "m");
        //  ef2c0ef8385db0effdda73fad2cf32b0
        reqJson.put("sign", DigestUtils.md5Hex((msgJson.toString() + "ef2c0ef8385db0effdda73fad2cf32b0")));
        return reqJson;
    }

    /**
     * auth 鉴权json组装
     * @param custNo
     * @param tradeacco
     * @param passwd
     * @return
     */
    public static JSONObject setAuthJson(String custNo, String tradeacco, String passwd){
        JSONObject authJson = new JSONObject();
        if(StringUtils.isBlank(custNo)){
            return new JSONObject();
        }
        authJson.put("authtype", "2");
        authJson.put("mctcustno", custNo);
        authJson.put("sessionkey", getSessionkey(custNo));
        authJson.put("tradeacco", tradeacco);
//        DESEncHelper des = DESEncHelper.getInstance();
        try {
//            authJson.put("passwd", des.encrypt(passwd));
            // ecc4ff67a0ef8282    111111
            authJson.put("passwd", "ecc4ff67a0ef8282");
        }catch (Exception e){
            e.printStackTrace();
        }
        return authJson;
    }

    // head 组装
    public static JSONObject setHeadJson(String  bizcode){
        JSONObject headJson = new JSONObject();
        headJson.put("version", version);
        headJson.put("appversion", appversion);
        headJson.put("bizcode", bizcode);
        headJson.put("senddate", formatDate(new Date(), "yyyyMMdd"));
        headJson.put("sendtime", formatDate(new Date(), "HHmmss"));
        headJson.put("seqid", UUID.randomUUID().toString().replaceAll("-","").toUpperCase());
        headJson.put("mctcode", mctcode);
        return headJson;
    }

    public static String formatDate(Date date, String pattern) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.format(date);
    }



    public static String formatJson(String jsonStr){
        if (null == jsonStr || "".equals(jsonStr)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        char last = '\0';
        char current = '\0';
        int indent = 0;
        boolean isInQuotationMarks = false;
        for (int i = 0; i < jsonStr.length(); i++) {
            last = current;
            current = jsonStr.charAt(i);
            switch (current) {
                case '"':
                    if (last != '\\'){
                        isInQuotationMarks = !isInQuotationMarks;
                    }
                    sb.append(current);
                    break;
                case '{':
                case '[':
                    sb.append(current);
                    if (!isInQuotationMarks) {
                        sb.append('\n');
                        indent++;
                        addIndentBlank(sb, indent);
                    }
                    break;
                case '}':
                case ']':
                    if (!isInQuotationMarks) {
                        sb.append('\n');
                        indent--;
                        addIndentBlank(sb, indent);
                    }
                    sb.append(current);
                    break;
                case ',':
                    sb.append(current);
                    if (last != '\\' && !isInQuotationMarks) {
                        sb.append('\n');
                        addIndentBlank(sb, indent);
                    }
                    break;
                default:
                    sb.append(current);
            }
        }
        return sb.toString();
    }

    private static void addIndentBlank(StringBuilder sb, int indent) {
        for (int i = 0; i < indent; i++) {
            sb.append("    ");
        }
    }



}
