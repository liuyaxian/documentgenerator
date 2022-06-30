package cacheservice;


public class HisBalanceCalcGroupInfo {
    private String fundid;
    private String custno;
    private double nav;
    private String navdt;
    private String workdate;
    private String announcedate;
    private double balance;
    private double profit;
    private double dayprofit;
    private double  profitprop;


    public String getFundid() {
        return fundid;
    }

    public void setFundid(String fundid) {
        this.fundid = fundid;
    }

    public String getCustno() {
        return custno;
    }

    public void setCustno(String custno) {
        this.custno = custno;
    }

    public double getNav() {
        return nav;
    }

    public void setNav(double nav) {
        this.nav = nav;
    }

    public String getNavdt() {
        return navdt;
    }

    public void setNavdt(String navdt) {
        this.navdt = navdt;
    }

    public String getWorkdate() {
        return workdate;
    }

    public void setWorkdate(String workdate) {
        this.workdate = workdate;
    }

    public String getAnnouncedate() {
        return announcedate;
    }

    public void setAnnouncedate(String announcedate) {
        this.announcedate = announcedate;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public double getDayprofit() {
        return dayprofit;
    }

    public void setDayprofit(double dayprofit) {
        this.dayprofit = dayprofit;
    }

    public double getProfitprop() {
        return profitprop;
    }

    public void setProfitprop(double profitprop) {
        this.profitprop = profitprop;
    }
}
