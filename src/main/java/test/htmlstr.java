package test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class htmlstr {

    public static void main(String[] args) {
        String trStr = "<tr> <td> $fundCode$ </td> <td> $fundUnits$ </td>  <td> $marketValue$ </td> </tr>";
        List<CustFundBalanceInfo> custFundBalanceInfos = new ArrayList<>();
        CustFundBalanceInfo custFundBalanceInfo = new CustFundBalanceInfo();
        custFundBalanceInfo.setBalance(BigDecimal.valueOf(223.33));
        custFundBalanceInfo.setFundId("000771");
        custFundBalanceInfo.setMktValue(BigDecimal.valueOf(22.333));
        custFundBalanceInfos.add(custFundBalanceInfo);

//        StringBuffer fundData  = new StringBuffer();
//        for (CustFundBalanceInfo custFundBalanceInfo1 : custFundBalanceInfos) {
//            trStr =   trStr.replace("$fundCode$", custFundBalanceInfo1.getFundId())
//                    .replace("$fundUnits$", custFundBalanceInfo1.getBalance().toString())
//                    .replace("$marketValue$", custFundBalanceInfo1.getMktValue().toString());
//            fundData.append(trStr);
//        }
//        System.out.println("fundData = " + fundData);


        String trStr1 = "<tr> <td> $fundCode$ </td> <td> $fundUnits$ </td>  <td> $marketValue$ </td> </tr>";
        trStr1 = trStr1.replace("$fundCode$", "22222");
        trStr1 = trStr1.replace("$fundUnits$", "qqq423423");
        trStr1 = trStr1.replace("$marketValue$", "1111");
        System.out.println("trStr1 = " + trStr1);


        String trStr3 = "<tr> <td> $fundCode$ </td> <td> $fundUnits$ </td>  <td> $marketValue$ </td> </tr>";
        trStr3 = trStr3.replace("$fundCode$", "22222");
        trStr3 = trStr3.replace("$fundUnits$", "qqq423423");
        trStr3 = trStr3.replace("$marketValue$", "1111");
        System.out.println("trStr3 = " + trStr3);



    }
}
