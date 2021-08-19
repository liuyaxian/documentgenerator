package service.OpenAPI.optional;

import java.io.Serializable;

public class CustOptionalFund implements Serializable {

        private static final long serialVersionUID = 1L;

        /** 主键id */
        private int id;
        /** 序号 */
        private int groupOrder;
        /** 基金代码 */
        private String fundId;
        /** 基金代码 */
        private String fundName;
        /** 分组id */
        private int groupId;
        /** 客户号 */
        private String custNo;
        /** 基金排序 */
        private int fundOrder;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getGroupOrder() {
            return groupOrder;
        }

        public void setGroupOrder(int groupOrder) {
            this.groupOrder = groupOrder;
        }

        public String getFundId() {
            return fundId;
        }

        public void setFundId(String fundId) {
            this.fundId = fundId;
        }


        public int getGroupId() {
            return groupId;
        }

        public void setGroupId(int groupId) {
            this.groupId = groupId;
        }

        public String getCustNo() {
            return custNo;
        }

        public void setCustNo(String custNo) {
            this.custNo = custNo;
        }

        public int getFundOrder() {
            return fundOrder;
        }

        public void setFundOrder(int fundOrder) {
            this.fundOrder = fundOrder;
        }

}
