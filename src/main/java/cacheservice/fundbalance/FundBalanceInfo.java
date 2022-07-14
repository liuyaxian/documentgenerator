package cacheservice.fundbalance;

public class FundBalanceInfo {

    private String custno;
    private String tradeacco;
    private String fundid;
    private double balance;
    private double totalin;
    private double avaliable;
    private double incomeamt;

    private String melonmd;
    private double netamt;
    private double profit;
    private double profitprop;

    private String producttype;
    private double unprofit;
    private double expprofit;
    private double compensate;
    private double dayprofit;


    //市值
    private double mktvalue;
    //最新净值日
    private String navdt;
    //最新净值
    private double nav;
    // 万份收益
    private double fundincome;
    // 清算状态
    private String clearst;
    // 分拆标识
    private String splitflag;
    //分拆标识
    private String divflag;
    // 清算工作日
    private String workdate;
    private String transid;
    private double redackamt;
    private String zlbalancetype;
    private String partnerno;

    public String getPartnerno() {
        return partnerno;
    }

    public void setPartnerno(String partnerno) {
        this.partnerno = partnerno;
    }

    public double getTotalin() {
        return totalin;
    }

    public String getZlbalancetype() {
        return zlbalancetype;
    }

    public void setZlbalancetype(String zlbalancetype) {
        this.zlbalancetype = zlbalancetype;
    }

    public void setTotalin(double totalin) {
        this.totalin = totalin;
    }

    public String getCustno() {
        return custno;
    }

    public void setCustno(String custno) {
        this.custno = custno;
    }

    public String getTradeacco() {
        return tradeacco;
    }

    public void setTradeacco(String tradeacco) {
        this.tradeacco = tradeacco;
    }

    public String getFundid() {
        return fundid;
    }

    public void setFundid(String fundid) {
        this.fundid = fundid;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAvaliable() {
        return avaliable;
    }

    public void setAvaliable(double avaliable) {
        this.avaliable = avaliable;
    }

    public double getIncomeamt() {
        return incomeamt;
    }

    public void setIncomeamt(double incomeamt) {
        this.incomeamt = incomeamt;
    }

    public String getMelonmd() {
        return melonmd;
    }

    public void setMelonmd(String melonmd) {
        this.melonmd = melonmd;
    }

    public double getNetamt() {
        return netamt;
    }

    public void setNetamt(double netamt) {
        this.netamt = netamt;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public double getProfitprop() {
        return profitprop;
    }

    public void setProfitprop(double profitprop) {
        this.profitprop = profitprop;
    }

    public String getProducttype() {
        return producttype;
    }

    public void setProducttype(String producttype) {
        this.producttype = producttype;
    }

    public double getUnprofit() {
        return unprofit;
    }

    public void setUnprofit(double unprofit) {
        this.unprofit = unprofit;
    }

    public double getExpprofit() {
        return expprofit;
    }

    public void setExpprofit(double expprofit) {
        this.expprofit = expprofit;
    }

    public double getCompensate() {
        return compensate;
    }

    public void setCompensate(double compensate) {
        this.compensate = compensate;
    }

    public double getDayprofit() {
        return dayprofit;
    }

    public void setDayprofit(double dayprofit) {
        this.dayprofit = dayprofit;
    }

    public double getMktvalue() {
        return mktvalue;
    }

    public void setMktvalue(double mktvalue) {
        this.mktvalue = mktvalue;
    }

    public String getNavdt() {
        return navdt;
    }

    public void setNavdt(String navdt) {
        this.navdt = navdt;
    }

    public double getNav() {
        return nav;
    }

    public void setNav(double nav) {
        this.nav = nav;
    }

    public double getFundincome() {
        return fundincome;
    }

    public void setFundincome(double fundincome) {
        this.fundincome = fundincome;
    }

    public String getClearst() {
        return clearst;
    }

    public void setClearst(String clearst) {
        this.clearst = clearst;
    }

    public String getSplitflag() {
        return splitflag;
    }

    public void setSplitflag(String splitflag) {
        this.splitflag = splitflag;
    }

    public String getDivflag() {
        return divflag;
    }

    public void setDivflag(String divflag) {
        this.divflag = divflag;
    }

    public String getWorkdate() {
        return workdate;
    }

    public void setWorkdate(String workdate) {
        this.workdate = workdate;
    }

    public String getTransid() {
        return transid;
    }

    public void setTransid(String transid) {
        this.transid = transid;
    }

    public double getRedackamt() {
        return redackamt;
    }

    public void setRedackamt(double redackamt) {
        this.redackamt = redackamt;
    }
}


