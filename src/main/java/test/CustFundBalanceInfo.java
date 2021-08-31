package test;

import java.math.BigDecimal;


public class CustFundBalanceInfo {

    /**  基金代码 */
    private String fundId;
    /** 份额 */
    private BigDecimal balance = BigDecimal.ZERO;
    /** 市值 */
    private BigDecimal mktValue = BigDecimal.ZERO;

    public String getFundId() {
        return fundId;
    }

    public void setFundId(String fundId) {
        this.fundId = fundId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getMktValue() {
        return mktValue;
    }

    public void setMktValue(BigDecimal mktValue) {
        this.mktValue = mktValue;
    }
}
