package service;


import service.util.DESEncHelper;
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
//    private static final  String url = "https://officeapi.zlfund.cn/OpenAPI.do";

    // 测试环境
//    private static final  String url = "https://officeapi.zlfund.cn/OpenAPIXZG/OpenAPI.do";
//    private static final  String url = "https://officeapi.zlfund.cn/OpenAPIBHJR/OpenAPI.do";
    // 开发环境
    private static final  String url = "http://localhost:8080/OpenAPI/OpenAPI.do";
//
    // uat
//    private static final  String url = "https://appapitest.zlfund.cn/OpenAPI.do";


//            private static final  String url = "https://officeapi.zlfund.cn/OpenAPI.do";
    private static final  String mctcode = "1000";
    // ef2c0ef8385db0effdda73fad2cf32b0   1000
    // 167eef0c6c834b5b94322ecbf87ab108 1003
    // c46b9b4dabae425a9daabbe16c8994df  00
    // 3c05f9e358214fc78cb8a1a0020540f6  0040
    private static final  String sign = "ef2c0ef8385db0effdda73fad2cf32b0";
    private static final  String version = "4.0";
    private static final  String appversion = "4.5.4";
    private static final  String appversionCode = "";

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
        return bodyJson;
    }



    public static String requestUrl(String custno, String tradeacco, String passwd, String bizcode, String bizcodeDesc,JSONObject requestBodyJson) throws IOException {
        JSONObject reqJson = createReqJson(bizcode, custno, tradeacco, passwd, requestBodyJson);


//        String data2 = "ewef{f\"msg\":{\"head\":{\"version\":\"4.0\",\"appversion\":\"4.5.3\",\"appversionCode\":\"4053\",\"bizcode\":\"3291\",\"devicetype\":\"Android\",\"senddate\":\"20220613\",\"sendtime\":\"103226\",\"seqid\":\"dfc38a2c73b54e71b523625c9377aea4\",\"mctcode\":\"1000\"},\"body\":{\"domain\":\"appapi.zlfund.cn\"}},\"signtype\":\"m\",\"sign\":\"8de8dbb0922aa1ab4909376b649b4b52\"}ffd";
        System.out.println("请求json:" + reqJson.toString());
        NameValuePair[] param = {new NameValuePair("data", reqJson.toString())};
//        NameValuePair[] param = {new NameValuePair("data", data2)};

        if ("3291".equals(bizcode)){
            // 解密字符串
            DESEncHelper des = DESEncHelper.getInstance();
            try {
                String domain =  des.encrypt(reqJson.toString());
//                String domain = "";
                param = new NameValuePair[]{new NameValuePair("message", domain.toString())};
            } catch(Exception e) {

            }
        }

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
        sb.append("**相关表**" + "\n");
        sb.append("```sql"+ "\n");
        sb.append("```"+ "\n\n");
        sb.append("**restful请求URL**" + "\n");
        sb.append("```xml"+ "\n");
        sb.append("```"+ "\n");
        sb.append("**请求方向**" + "\n\n");
        sb.append("商户->众禄" + "\n\n\n\n");
        sb.append("接口参数" + "\n\n");
        sb.append("**请求参数**" + "\n\n");
        sb.append("bizcode:"+ bizcode + "\n\n");
        sb.append("请求报文："+ "\n\n");
        sb.append("```json"+ "\n\n");
        String reqJsonStr = formatJson(reqJson.toString());
        sb.append(reqJsonStr + "\n");
        sb.append("```" + "\n\n\n");
        sb.append("| **字段名称** | **Json path**   | **格式** | **必填** | **备注**   |" + "\n");
        sb.append("| ------------ | --------------- | -------- | -------- | ---------- | " + "\n");
        JSONObject msg = (JSONObject) reqJson.get("msg");
        JSONObject bodyJson = (JSONObject) msg.get("body");
        setRequestValue(bodyJson,  sb, " body/");
        sb.append("\n\n\n"+"**响应参数**" + "\n\n\n");
        int code = Integer.parseInt(bizcode) + 1;
        sb.append("bizcode:" +  code + "\n\n\n");
        sb.append("响应报文："+ "\n\n");
        sb.append("```json" + "\n\n");
        sb.append(formatJson(method.getResponseBodyAsString())+ "\n\n\n");
        sb.append("```" + "\n\n\n");
        sb.append("| **字段名称**   | **Json path** | **格式** | **必填** | **备注**  |" + "\n");
        sb.append("| -------------- | ------------------------------ | -------- | -------- | ------- |" + "\n");
        String responseStr = method.getResponseBodyAsString();
        if (StringUtils.isBlank(responseStr)){
            System.out.println("为空！");
            return "" ;
        }
        if ("3291".equals(bizcode)){
            try{
                JSONObject jsonObj = JSONObject.fromObject(responseStr);
                String data = (String) jsonObj.get("data");
                service.util.DESEncHelper des = service.util.DESEncHelper.getInstance();
                responseStr = des.decrypt(data);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        JSONObject jsonObj = JSONObject.fromObject(responseStr);
        JSONObject msg1 = (JSONObject) jsonObj.get("msg");
        JSONObject bodyJson1 = (JSONObject) msg1.get("body");
        setResponsValue(bodyJson1, sb);
       // FileWriter(sb.toString(),bizcode , bizcodeDesc);
        System.out.println(sb.toString());
        return reqJsonStr;
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
            if (list == null || list.size() ==0){
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
        } else if (bodyJson.containsKey("data")){
//                JSONObject object = bodyJson.getJSONObject("data");
//                if (object == null){
//                    return;
//                }
//                setTableValue(object, sb,  " body/data/");
        }  else {
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
        // 167eef0c6c834b5b94322ecbf87ab108 1003
        // ef2c0ef8385db0effdda73fad2cf32b0 1000
        // c46b9b4dabae425a9daabbe16c8994df  00
        // ef2c0ef8385db0effdda73fad2cf32b0   1000
        reqJson.put("sign", DigestUtils.md5Hex((msgJson.toString() + sign)));
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



//        // 其余客户端均采用DES加密算法对密码进行加密
//        service.util.DESEncHelper des = service.util.DESEncHelper.getInstance();
//        try {
//            System.out.println("encrypt: " + des.encrypt("aaa111"));
//            System.out.println("decrypt: "+ des.decrypt("7f2e8cbdd934e553"));
//
//        } catch(Exception e) {
//            e.printStackTrace();
//        }

        try {
//            authJson.put("passwd", des.encrypt(passwd));
            // ecc4ff67a0ef8282    111111
            // 其余客户端均采用DES加密算法对密码进行加密
            DESEncHelper des = DESEncHelper.getInstance();
            try {
                passwd = des.encrypt(passwd);
            } catch(Exception e) {
               e.printStackTrace();
            }
            authJson.put("passwd", passwd);
        }catch (Exception e){
            e.printStackTrace();
        }
        return authJson;
    }


    public static String encryptPasswd(String passwd){
//         其余客户端均采用DES加密算法对密码进行加密
        service.util.DESEncHelper des = service.util.DESEncHelper.getInstance();
        try {
            return  des.encrypt(passwd);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return "";
    }
    public static String decryptPasswd(String passwd){
//         其余客户端均采用DES加密算法对密码进行加密
        service.util.DESEncHelper des = service.util.DESEncHelper.getInstance();
        try {
         return  des.decrypt("7f2e8cbdd934e553");

        } catch(Exception e) {
            e.printStackTrace();
        }
        return  "";
    }
    // head 组装
    public static JSONObject setHeadJson(String  bizcode){
        JSONObject headJson = new JSONObject();
        headJson.put("version", version);
        headJson.put("appversion", appversion);
        headJson.put("appversionCode", appversionCode);
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
