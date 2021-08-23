package service.OpenAPI.optional;

public class FundYield {
    private String  fundId;
    private String yieldPeriod;


    public String getFundId() {
        return fundId;
    }

    public void setFundId(String fundId) {
        this.fundId = fundId;
    }

    public String getYieldPeriod() {
        return yieldPeriod;
    }

    public void setYieldPeriod(String yieldPeriod) {
        this.yieldPeriod = yieldPeriod;
    }
}
