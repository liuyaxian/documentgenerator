package cacheservice.his_balance_calc_group;

import com.mongodb.*;
import service.util.DbUtils2;
import service.util.ObjectUtils;

import java.util.List;

public class HisBalanceCalcGroup {



    public static List<HisBalanceCalcGroupInfo> querHisBalanceCalcGroupList(String custno) {

        String sql1 = " select custno,\n" +
                "                                           fundid,\n" +
                "                                           nav,\n" +
                "                                       '20220629'    navdt,\n" +
                "                                       '20220630'    workdate,\n" +
                "          sum(mktvalue) mktvalue,  \n" +
                "            sum(totalin) totalin,\n" +
                "            '1000' partnerno,\n" +
                "            1.1 netamt,\n" +
                "            1.12 fundincome,\n" +

                "                                        '20220630'  announcedate,\n" +
                "                                           sum(balance) balance,\n" +
                "                                           sum(profit) profit,\n" +
                "                                           sum(dayprofit) dayprofit,\n" +
                "                                           (case when sum(totalin) > 0 then round(sum(profit)/sum(totalin),3) else 0 end) as profitprop\n" +
                "                                 from fundbalanceprofit\n" +
                "                                where balance > 0\n" +
                "                                  and custno =  ? \n" +
                "                                group by custno,fundid,navdt,nav,workdate,announcedate  ";

        return DbUtils2.queryList(sql1, (rs, row) ->{
            HisBalanceCalcGroupInfo hisBalanceCalcGroup = new HisBalanceCalcGroupInfo();
            hisBalanceCalcGroup.setBalance(rs.getDouble("balance"));
            hisBalanceCalcGroup.setAnnouncedate(rs.getString("workdate"));
            hisBalanceCalcGroup.setDayprofit(rs.getDouble("dayprofit"));
            hisBalanceCalcGroup.setFundid(rs.getString("fundid"));
            hisBalanceCalcGroup.setNav(rs.getDouble("nav"));
            hisBalanceCalcGroup.setNavdt(rs.getString("navdt"));
            hisBalanceCalcGroup.setWorkdate(rs.getString("workdate"));
            hisBalanceCalcGroup.setProfit(rs.getDouble("profit"));
            hisBalanceCalcGroup.setProfitprop(rs.getDouble("profitprop"));
            hisBalanceCalcGroup.setCustno(rs.getString("custno"));
            hisBalanceCalcGroup.setMktvalue(rs.getDouble("mktvalue"));
            hisBalanceCalcGroup.setTotalin(rs.getDouble("totalin"));
            hisBalanceCalcGroup.setPartnerno(rs.getString("partnerno"));
            hisBalanceCalcGroup.setNetamt(rs.getDouble("netamt"));
            hisBalanceCalcGroup.setFundincome(rs.getDouble("fundincome"));
            return hisBalanceCalcGroup;
        }, custno);
    }


    public static void deleteCollMongoDb(String collName, String custNo) {
        DB db = MongoHelper.getDB("");
        DBCollection custOptionalFundColl = db.getCollection(collName);
        DBObject whereObj = new BasicDBObject();
        whereObj.put("custno", custNo);
        custOptionalFundColl.remove(whereObj, WriteConcern.MAJORITY);
    }

    public static void pushCollMongoDb(String collName, List<HisBalanceCalcGroupInfo> hisBalanceCalcGroupInfos) {
        DB db = MongoHelper.getDB("");
        DBCollection custOptionalFundColl = db.getCollection(collName);
        for (HisBalanceCalcGroupInfo hisBalanceCalcGroupInfo : hisBalanceCalcGroupInfos){
            DBObject  object = ObjectUtils.beanToDBObject(hisBalanceCalcGroupInfo);
            object.put("_id", hisBalanceCalcGroupInfo.getCustno()+hisBalanceCalcGroupInfo.getFundid() + hisBalanceCalcGroupInfo.getNavdt());
            custOptionalFundColl.save(object, WriteConcern.MAJORITY);
        }
    }

    public static void main(String[] args) {
        String custno ="1001883450";
        String collName = "his_balance_calc_group";
        deleteCollMongoDb(collName, custno);
        List<HisBalanceCalcGroupInfo> hisBalanceCalcGroupInfos = querHisBalanceCalcGroupList(custno);
        System.out.printf("his_balance_calc_group 客户号："+ custno + " 刷新总数："+ hisBalanceCalcGroupInfos.size());
        pushCollMongoDb("his_balance_calc_group", hisBalanceCalcGroupInfos);
    }


}





