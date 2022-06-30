package service.util;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DbUtils2 {
    private static String classname = "org.postgresql.Driver";
    private static String url = "jdbc:postgresql://172.18.10.171:54320/trade";
    private static String user = "zlfund";
    private static String password = "zlfundzlfund";


    static {
        // 关闭流
        try(InputStream resourceAsStream = DbUtils.class.getClassLoader().getResourceAsStream("/jdbc.properities");) {
            Properties properties = new Properties();
            properties.load(resourceAsStream);
            classname = properties.getProperty("jdbc.driverClass");
            url = properties.getProperty("jdbc.url");
            user = properties.getProperty("jdbc.user");
            password = properties.getProperty("jdbc.password");
        } catch (Exception e) {
            e.getMessage();
        }
    }

    /**
     * 执行 DDL  DML 语句
     * 可变参数。。。。
     * @return
     */
    public static int update(String sql,  Object ...args){

        try {
            Class.forName(classname);
            try(Connection connection = DriverManager.getConnection(url , user, password);
                PreparedStatement preparedStatement = connection.prepareStatement(sql);){
                for (int i = 0; i < args.length; i++) {
                    preparedStatement.setObject(i+1,  args[i]);
                }

                return preparedStatement.executeUpdate();
            }
        } catch (Exception e){
            System.out.println("e.getMessage() = " + e.getMessage());
        }
        return 0;
    }


    public static <T> List<T> queryList(String sql, DbUtils.RowMapper<T> mapper, Object ...args ){

        if (mapper == null){
            return  null;
        }
        try {
            Class.forName(classname);
            try(Connection connection = DriverManager.getConnection(url , user, password);
                PreparedStatement preparedStatement = connection.prepareStatement(sql);){
                for (int i = 0; i < args.length; i++) {
                    preparedStatement.setObject(i+1, args[i]);
                }
                ResultSet resultSet = preparedStatement.executeQuery();

                List<T>  result = new ArrayList<>();
                int row = 0;
                // 让游标指向下一行记录
                while (resultSet.next()){
                    result.add(mapper.map(resultSet, row++));
                }
                resultSet.close();
                return result;
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("e.getMessage() = " + e.getMessage());
        }
        return  null;
    }

    public   interface  RowMapper<T> {
        T map(ResultSet rs, int row) throws SQLException;
    }
}
