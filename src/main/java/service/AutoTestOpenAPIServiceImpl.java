package service;

import net.sf.json.JSONObject;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AutoTestOpenAPIServiceImpl extends  DocumentGeneratorServiceImpl{

    /***
     * 1、编写在excel中测试用例
     * 1.1、 根据不同的测试案例设置对应的请求参数，
     * 2、系统读取excel 中案例 ，
     * 2、1 获取请求参数， 调用接口， 并将执行结果回入excel 执行结果，
     * 3、 判断期望值是否与输入结果一直，生成对应的执行结果。
     * 4、循环遍历所有测试案例。
     */
    //    private static final  String url = "https://officeapi.zlfund.cn/OpenAPIXZG/OpenAPI.do";
    private static final  String url = "http://localhost:8080/OpenAPI/OpenAPI.do";
    //        private static final  String url = "https://officeapi.zlfund.cn/OpenAPI.do";
    private static final  String bizcode = "5235";
    private static final  String bizcodeDesc = "523552355235";
    // 需要鉴权的接口 custNo 不为为空
    private static String custNo =  "50000011428";
    // 需要数据交易密码的接口
    private static String tradeacco = "1001545863";
    // 交易密码 111111
    private static String passwd = "123456";
    public static void main(String[] args) throws Exception {
      List<String>  params =  getTestFild();
    }

    public static List<String>  getTestFild() throws Exception {
        String pathName = "E:\\apidocs\\5235接口测试用例.xlsx";
        File xlsFile = new File(pathName);
        // 工作表
        Workbook workbook = WorkbookFactory.create(xlsFile);
        // 表个数。
        int numberOfSheets = workbook.getNumberOfSheets();
        // 保存所有请求参数
        List<String>  paramsList = new ArrayList<>();
        FileOutputStream out=null;

        // 遍历表。
        for (int i = 0; i < numberOfSheets; i++) {
            Sheet sheet = workbook.getSheetAt(i);
            // 行数。
            int rowNumbers = sheet.getLastRowNum() + 1;
            // Excel第一行。
            Row temp = sheet.getRow(0);
            if (temp == null) {
                continue;
            }
            int cells = temp.getPhysicalNumberOfCells();
            // 读取数据
            for (int row = 0; row < rowNumbers; row++) {
                if (row == 0) {
                    continue;
                }
                Row r = sheet.getRow(row);
                paramsList.add(r.getCell(2).toString());
                System.out.println(r.getCell(4));
                r.getCell(4).setCellValue(requestUrls(custNo,  tradeacco,  passwd,  r.getCell(2).toString(), bizcode).toString());

                //获取输出流
                out=new FileOutputStream(xlsFile);
                String pathName2 = "E:\\apidocs\\5235接口测试用例111.xlsx";

                FileInputStream  in = new FileInputStream(new File(pathName2));
                Workbook   workbook1 = new XSSFWorkbook(in);
                //向out写入数据
                workbook1.write(out);
                //刷新
                out.flush();
                //关闭流和工作簿
                out.close();
            }
        }
        return paramsList;
    }


    public static JSONObject  requestUrls(String custno, String tradeacco, String passwd, String params, String bizcode) throws IOException {
        JSONObject reqJson = createReqJson(custno, tradeacco, passwd, params, bizcode);
//        System.out.println("请求json:" + reqJson.toString());
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
        sb.append(DocumentGeneratorServiceImpl.formatJson(method.getResponseBodyAsString())+ "\n\n\n");
        sb.append("```" + "\n\n\n");
        sb.append("| **字段名称**   | **Json path** | **格式** | **必填** | **备注**  |" + "\n");
        sb.append("| -------------- | ------------------------------ | -------- | -------- | ------- |" + "\n");
        String responseStr = method.getResponseBodyAsString();
        JSONObject jsonObj = JSONObject.fromObject(responseStr);
        JSONObject msg1 = (JSONObject) jsonObj.get("msg");
        JSONObject bodyJson1 = (JSONObject) msg1.get("body");
        setResponsValue(bodyJson1, sb);
//        FileWriter(sb.toString());
//        System.out.println(sb.toString());
        return bodyJson1;
    }

    // body 组装
    public static JSONObject setBody(String params){
        JSONObject bodyJson = new JSONObject();
       return JSONObject.fromObject(params);
    }

    public static JSONObject createReqJson(String custNo, String tradeacco, String passwd, String params, String bizcode) {
        JSONObject msgJson = new JSONObject();
        msgJson.put("head", setHeadJson(bizcode));
        msgJson.put("body", setBody(params));
        msgJson.put("auth", setAuthJson(custNo, tradeacco, passwd));
        JSONObject reqJson = new JSONObject();
        reqJson.put("msg", msgJson);
        // 签名
        reqJson.put("signtype", "m");
        reqJson.put("sign", DigestUtils.md5Hex((msgJson.toString() + "c46b9b4dabae425a9daabbe16c8994df")));
        return reqJson;
    }
}
