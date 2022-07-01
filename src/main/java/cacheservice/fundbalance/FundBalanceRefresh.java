package cacheservice.fundbalance;

import cacheservice.his_balance_calc_group.MongoHelper;
import com.mongodb.*;
import org.apache.commons.lang.StringUtils;
import service.util.DbUtils2;
import service.util.ObjectUtils;

import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FundBalanceRefresh {
    private static String classname = "org.postgresql.Driver";
//    private static String url = "jdbc:postgresql://172.18.10.171:54320/trade";

    private static String url = "jdbc:postgresql://172.18.10.73:54320/trade";
    private static String user = "zlfund";
    private static String password = "zlfundzlfund";

    public static List<FundBalanceInfo> queryFundBalanceInfoList(String custno) {
        String sql = "{ call oqp_get_ebalanceandprofit_to_cache(?,?) }";
        return DbUtils2.queryCursorList(sql, (rs, row) ->{
            FundBalanceInfo fundBalanceInfo = new FundBalanceInfo();
            fundBalanceInfo.setFundid(rs.getString("fundid"));
            fundBalanceInfo.setAvaliable(rs.getDouble("avaliable"));
            fundBalanceInfo.setBalance(rs.getDouble("fundbalance"));
            fundBalanceInfo.setCustno(rs.getString("custno"));
            fundBalanceInfo.setDayprofit(rs.getDouble("dayprofit"));
            fundBalanceInfo.setClearst(rs.getString("clearst"));
            fundBalanceInfo.setNavdt(rs.getString("navdt"));
            fundBalanceInfo.setNav(rs.getDouble("nav"));
            fundBalanceInfo.setProfit(rs.getDouble("profit"));
            fundBalanceInfo.setProfitprop(rs.getDouble("profitprop"));
            fundBalanceInfo.setWorkdate(rs.getString("workdate"));
            fundBalanceInfo.setCompensate(rs.getDouble("compensate"));
            fundBalanceInfo.setUnprofit(rs.getDouble("unprofit"));
            fundBalanceInfo.setTransid(rs.getString("transid"));
            fundBalanceInfo.setSplitflag(rs.getString("splitflag"));
            fundBalanceInfo.setDivflag(rs.getString("divflag"));
            fundBalanceInfo.setRedackamt(rs.getDouble("redackamt"));
            fundBalanceInfo.setTradeacco(rs.getString("tradeacco"));
            fundBalanceInfo.setProducttype(rs.getString("producttype"));
            fundBalanceInfo.setNetamt(rs.getDouble("netmat"));
            fundBalanceInfo.setMelonmd(rs.getString("melonmd"));
            fundBalanceInfo.setIncomeamt(rs.getDouble("incomeamt"));
            fundBalanceInfo.setExpprofit(rs.getDouble("expprofit"));
            fundBalanceInfo.setTotalin(rs.getDouble("totalin"));
            fundBalanceInfo.setMktvalue(rs.getDouble("mktvalue"));
            fundBalanceInfo.setIncomeamt(rs.getDouble("incomeamt"));
            return fundBalanceInfo;
        }, custno);
    }


    public static List<FundBalanceInfo> queryFundBalanceInfoList2(String custNo) throws Exception {
        final String sql = "{call oqp_get_ebalanceandprofit_to_cache(?, ?)}";
        Class.forName(classname);

        Connection connection = DriverManager.getConnection(url , user, password);
        List<FundBalanceInfo> list = new ArrayList<>();
        connection.setAutoCommit(false);
                CallableStatement cs = connection.prepareCall(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
                cs.setString(1, custNo);
                cs.registerOutParameter(2, Types.OTHER);

                cs.execute();

                ResultSet rs = (ResultSet)cs.getObject(2);
                if (null != rs) {
                    Map<String, Object> temp = new HashMap<String, Object>();
                    while (rs.next()) {
                        FundBalanceInfo fundBalanceInfo = new FundBalanceInfo();
                        fundBalanceInfo.setFundid(rs.getString("fundid"));
                        fundBalanceInfo.setAvaliable(rs.getDouble("avaliable"));
                        fundBalanceInfo.setBalance(rs.getDouble("balance"));
                        fundBalanceInfo.setCustno(rs.getString("custno"));
                        fundBalanceInfo.setDayprofit(rs.getDouble("dayprofit"));
                        fundBalanceInfo.setClearst(rs.getString("clearst"));
                        fundBalanceInfo.setNavdt(rs.getString("navdt"));
                        fundBalanceInfo.setNav(rs.getDouble("nav"));
                        fundBalanceInfo.setProfit(rs.getDouble("profit"));
                        fundBalanceInfo.setProfitprop(rs.getDouble("profitprop"));
                        fundBalanceInfo.setWorkdate(rs.getString("workdate"));
                        fundBalanceInfo.setCompensate(rs.getDouble("compensate"));
                        fundBalanceInfo.setUnprofit(rs.getDouble("unprofit"));
                        fundBalanceInfo.setTransid(rs.getString("transid"));
                        fundBalanceInfo.setSplitflag(rs.getString("splitflag"));
                        fundBalanceInfo.setDivflag(rs.getString("divflag"));
                        fundBalanceInfo.setRedackamt(rs.getDouble("redackamt"));
                        fundBalanceInfo.setTradeacco(rs.getString("tradeacco"));
                        fundBalanceInfo.setProducttype(rs.getString("producttype"));
                        fundBalanceInfo.setNetamt(rs.getDouble("netamt"));
                        fundBalanceInfo.setMelonmd(rs.getString("melonmd"));
                        fundBalanceInfo.setIncomeamt(rs.getDouble("incomeamt"));
                        fundBalanceInfo.setExpprofit(rs.getDouble("expprofit"));
                        fundBalanceInfo.setTotalin(rs.getDouble("totalin"));
                        fundBalanceInfo.setMktvalue(rs.getDouble("mktvalue"));
                        fundBalanceInfo.setIncomeamt(rs.getDouble("incomeamt"));
                        list.add(fundBalanceInfo);
                    }
                }
        connection.commit();
                return list;
    }


    public static void deleteCollMongoDb(String collName, String custNo, String id) {
        DB db = MongoHelper.getDB("");
        DBCollection custOptionalFundColl = db.getCollection(collName);
        DBObject whereObj = new BasicDBObject();
        whereObj.put("custno", custNo);
        if (StringUtils.isNotBlank(id)){
            whereObj.put("_id", id);
        }

        custOptionalFundColl.remove(whereObj, WriteConcern.MAJORITY);
    }

    public static void pushCollMongoDb(String collName, List<FundBalanceInfo> fundBalanceInfos) {
        DB db = MongoHelper.getDB("");
        DBCollection custOptionalFundColl = db.getCollection(collName);
        for (FundBalanceInfo fundBalanceInfo : fundBalanceInfos){
            DBObject  object = ObjectUtils.beanToDBObject(fundBalanceInfo);
            object.put("_id", fundBalanceInfo.getTradeacco()+fundBalanceInfo.getFundid());
            custOptionalFundColl.save(object, WriteConcern.MAJORITY);
        }
    }

    public static void main(String[] args) throws Exception {
        String custno ="1001883979";
        String _id ="202207011524313377100007";
        String collName = "fundbalance";
        deleteCollMongoDb(collName, custno, "");
        deleteCollMongoDb("tradeapply", custno, _id);
        List<FundBalanceInfo> fundBalanceInfos = queryFundBalanceInfoList2(custno);
        System.out.println("fundbalance 客户号："+ custno + " 刷新总数："+ fundBalanceInfos.size());
        pushCollMongoDb("fundbalance", fundBalanceInfos);
    }

}
