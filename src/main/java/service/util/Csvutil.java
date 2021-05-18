package service.util;

import org.apache.poi.ss.formula.functions.T;

import java.io.*;
import java.lang.reflect.Field;
import java.util.List;

public class Csvutil {
    public static void exportCsv(String pathName, String[] titles, String[] propertys, List<T> list) throws IOException, IllegalAccessException {
        // 创建文件
        File file = new File(pathName + ".csv");
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

    public static void exportCsv2(String pathName, String[] titles, List<User> list) throws IOException, IllegalAccessException {

        File file = null;
        FileOutputStream fos = null;
        OutputStreamWriter ow = null;
        BufferedWriter csvWriter = null;

        // 创建文件
        try {
             file = new File(pathName + ".csv");
             fos = new FileOutputStream(file);
            //构建输出流，同时指定编码
             ow = new OutputStreamWriter(fos, "UTF-8");
             csvWriter = new BufferedWriter(ow);
            //csv文件是逗号分隔，除第一个外，每次写入一个单元格数据后需要输入逗号
            csvWriter.write(String.join(",", titles));
            csvWriter.newLine();
            // 写入文件内容
            for (User user : list) {
                csvWriter.write(user.toRow());
                csvWriter.newLine();
            }
            csvWriter.flush();
        }catch (Exception e){
            e.getMessage();
    } finally {
        try {
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

    static class User {
        private long id;
        private String name;

        public void setId(long id) {
            this.id = id;
        }

        public long getId() {
            return this.id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }
        public String toRow(){
            return String.format("%s,%s",this.id,this.name);
        }
    }
}
