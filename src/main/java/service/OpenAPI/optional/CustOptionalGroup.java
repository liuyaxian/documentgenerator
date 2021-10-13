package service.OpenAPI.optional;

import java.io.Serializable;

public class CustOptionalGroup implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 主键id */
    private int id;
    /** 分组描述 */
    private String groupName;
    /**分组中产品个数 */
    private int countNum;
    /** 序号 */
    private int groupOrder;
    /** 固定分组 01 ，自定义分组 00 */
    private String fixed;
    /** 分组类型 */
    private String groupType;
    /** 客户号 */
    private String custNo;

    public String getCustNo() {
        return custNo;
    }

    public void setCustNo(String custNo) {
        this.custNo = custNo;
    }

    public String getGroupType() {
        return groupType;
    }

    public void setGroupType(String groupType) {
        this.groupType = groupType;
    }

    public String getFixed() {
        return fixed;
    }

    public void setFixed(String fixed) {
        this.fixed = fixed;
    }

    public int getCountNum() {
        return countNum;
    }

    public int getGroupOrder() {
        return groupOrder;
    }

    public void setGroupOrder(int groupOrder) {
//        Integer defaultGroupOrder =  MapUtils.getInteger(SysConstant.OPTIONAL_GROUP_ORDER_MAP, this.groupType,  0);
//        if (defaultGroupOrder != null && defaultGroupOrder != 0){
//            this.groupOrder = defaultGroupOrder;
//        } else {
//            this.groupOrder = groupOrder;
//        }
        this.groupOrder = groupOrder;

    }

    public void setCountNum(int countNum) {
        this.countNum = countNum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {

            this.groupName = groupName;

    }

}
