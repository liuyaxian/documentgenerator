package service.util;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

public class DbJdbcUtils {

    private static String classname = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://172.18.10.74:3306/mytest?useUnicode=true&useSSL=false&characterEncoding=utf-8&serverTimezone=Asia/Shanghai&useAffectedRows=true&allowMultiQueries=true";
    private static String user = "emsel";
    private static String password = "emselemsel";



    private static JdbcTemplate jdbcTemplate;
    static {
        // 关闭流
        try(InputStream  InputStream = DbJdbcUtils.class.getClassLoader().getResourceAsStream("/druid.properities");) {
            Properties properties = new Properties();
            properties.load(InputStream);
            DataSource dataSource =  null;
//                    DruidDataSourceFactory.createDataSource(properties);
            jdbcTemplate = new JdbcTemplate(dataSource);
        } catch (Exception e) {
            e.getMessage();
        }
    }
    public static JdbcTemplate getJdbcTemplate(){
        return  jdbcTemplate;
    }
}

