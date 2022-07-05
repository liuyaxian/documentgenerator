package test;

import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import java.util.ArrayList;
import java.util.List;

public class TestListNull {

    public static void main(String[] args) {
        List<String> result = new ArrayList<>();
        List<String> tradeApply = null;
        DBCursor cur = null;
   
        List<DBObject> tradeHistoryList  = cur.toArray();

        result.addAll(tradeApply);
        //按照申请日期降序
        if (result != null && result.size() >0) {
            System.out.println("1111111111111");

        }
        if ( result.size() >0) {
            System.out.println("222222222222222");

        }
        if ( result == null) {
            System.out.println("3333333333333");
        }
    }
}
