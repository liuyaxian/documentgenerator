package cacheservice.his_balance_calc_group;


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
    private double mktvalue;
    private double totalin;
    private String partnerno;
    private double netamt;

    private double fundincome;




    public double getFundincome() {
        return fundincome;
    }

    public void setFundincome(double fundincome) {
        this.fundincome = fundincome;
    }

    public double getMktvalue() {
        return mktvalue;
    }

    public void setMktvalue(double mktvalue) {
        this.mktvalue = mktvalue;
    }

    public double getTotalin() {
        return totalin;
    }

    public void setTotalin(double totalin) {
        this.totalin = totalin;
    }

    public String getPartnerno() {
        return partnerno;
    }

    public void setPartnerno(String partnerno) {
        this.partnerno = partnerno;
    }

    public double getNetamt() {
        return netamt;
    }

    public void setNetamt(double netamt) {
        this.netamt = netamt;
    }

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
