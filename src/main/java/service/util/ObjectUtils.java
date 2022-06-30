package service.util;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import java.lang.reflect.Field;

public class ObjectUtils {
    /**
     * 把实体bean对象转换成dbobject
     * @param bean
     * @return
     */
    public static <t> DBObject beanToDBObject(t bean) {
        if (bean == null) {
            return null;
        }
        DBObject dbobject = new BasicDBObject();
        // 获取对象对应类中的所有属性域
        Field[] fields = bean.getClass().getDeclaredFields();
        for (Field field : fields) {
            // 获取属性名
            String varname = field.getName();
            // 修改访问控制权限
            boolean accessflag = field.isAccessible();
            if (!accessflag) {
                field.setAccessible(true);
            }
            Object param = null;
            try {
                param = field.get(bean);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if (param == null) {
                continue;
            } else if (param instanceof Integer) {//判断变量的类型
                int value = ((Integer) param).intValue();
                dbobject.put(varname, value);
            } else if (param instanceof String) {
                String value = (String) param;
                dbobject.put(varname, value);
            } else if (param instanceof Double) {
                Double value = ((Double) param).doubleValue();
                dbobject.put(varname, value);
            } else if (param instanceof Float) {
                Float value = ((Float) param).floatValue();
                dbobject.put(varname, value);
            } else if (param instanceof Long) {
                Long value = ((Long) param).longValue();
                dbobject.put(varname, value);
            } else if (param instanceof Boolean) {
                Boolean value = ((Boolean) param).booleanValue();
                dbobject.put(varname, value);
            } else if (param instanceof Boolean) {
                Boolean value = (Boolean) param;
                dbobject.put(varname, value);
            }
            // 恢复访问控制权限
            field.setAccessible(accessflag);
        }
        return dbobject;
    }
}
