package service;

import net.sf.json.JSONObject;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ZLappHomeDateAuto {


    @Autowired
    private  DocumentGeneratorServiceImpl documentGeneratorServiceImpl;
    //    private static final  String url = "https://officeapi.zlfund.cn/OpenAPIXZG/OpenAPI.do";
    private static final  String url = "http://localhost:8080/OpenAPI/OpenAPI.do";
    //        private static final  String url = "https://officeapi.zlfund.cn/OpenAPI.do";


    public void baseService(String bizCode, String custNo, String tradeacco, String passwd, JSONObject requestBodyJson) throws IOException {
        JSONObject reqJson = documentGeneratorServiceImpl.createReqJson(bizCode, custNo, tradeacco, passwd, requestBodyJson, "");
        NameValuePair[] param = {new NameValuePair("data", reqJson.toString())};
        PostMethod method = new PostMethod(url);
        method.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
        method.setRequestBody(param);
        method.setParameter("bizcode", "1000");
        method.setDoAuthentication(true);
        HttpClient client = new HttpClient();
        client.executeMethod(method);
        String resStr = method.getResponseBodyAsString();
        JSONObject bodyJson  = (JSONObject) JSONObject.fromObject(resStr).get("body");
        Iterator<String> keys = bodyJson.keys();
        while (keys.hasNext()) {
            String key = keys.next();
            Object object = bodyJson.get(key);
        }
    }
    public void baseService(String bizCode, String custNo, String tradeacco, String passwd, JSONObject requestBodyJson, String isAuth) throws IOException {
        JSONObject reqJson = documentGeneratorServiceImpl.createReqJson(bizCode, custNo, tradeacco, passwd, requestBodyJson, isAuth);
        NameValuePair[] param = {new NameValuePair("data", reqJson.toString())};
        PostMethod method = new PostMethod(url);
        method.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
        method.setRequestBody(param);
        method.setParameter("bizcode", "1000");
        method.setDoAuthentication(true);
        HttpClient client = new HttpClient();
        client.executeMethod(method);
        String resStr = method.getResponseBodyAsString();
        JSONObject bodyJson  = (JSONObject) JSONObject.fromObject(resStr).get("body");
        Iterator<String> keys = bodyJson.keys();
        while (keys.hasNext()) {
            String key = keys.next();
            Object object = bodyJson.get(key);
        }
    }

    public static void main(String[] args) throws IOException, IllegalAccessException {
        String[] titles = new String[]{"ID","姓名"};
        String[] propertys = new String[]{"id","name"};
        List<User> list = new ArrayList<>();
        User user;
        user = new User();
        user.setId(1L);
        user.setName("张三");
        list.add(user);
        user = new User();
        user.setId(2L);
        user.setName("李四");
        list.add(user);
        exportCsv("1111", titles,propertys, list);
    }

    static class User {
        private long id;
        private String name;
        public void setId(long id) {
            this.id = id;
        }
        public long getId() {
            return  this.id;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getName() {
            return  this.name;
        }
    }



    public static void exportCsv(String bizcode, String[] titles, String[] propertys, List<User> list) throws IOException, IllegalAccessException {
        // 创建文件
        File file = new File("D:\\liuyaxian\\" + bizcode + ".csv");
        FileOutputStream fos = new FileOutputStream(file);
        //构建输出流，同时指定编码
        OutputStreamWriter ow = new OutputStreamWriter(fos, "UTF-8");
        //csv文件是逗号分隔，除第一个外，每次写入一个单元格数据后需要输入逗号
        for(String title : titles){
            ow.write(title);
            ow.write(",");
        }
        //写完文件头后换行
        ow.write("\r\n");
        //写内容
        for(Object obj : list){
            //利用反射获取所有字段
            Field[] fields = obj.getClass().getDeclaredFields();
            for(String property : propertys){
                for(Field field : fields){
                    //设置字段可见性
                    field.setAccessible(true);
                    if(property.equals(field.getName())){
                        ow.write(field.get(obj).toString());
                        ow.write(",");
                        continue;
                    }
                }
            }
            //写完一行换行
            ow.write("\r\n");
        }
        ow.flush();
        ow.close();
    }

    /***
     * 字符串写入文件
     * @param pathName
     * @param buff
     * @throws IOException
     */
    public static void FileWriter(String pathName, String buff) throws IOException {
        File file = new File(pathName);
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

}
