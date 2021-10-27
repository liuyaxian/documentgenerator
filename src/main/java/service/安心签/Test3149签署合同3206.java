package service.安心签;

import cfca.sadk.util.Base64;
import net.sf.json.JSONObject;
import service.DocumentGeneratorServiceImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Test3149签署合同3206 extends DocumentGeneratorServiceImpl {

    private static final  String bizcode = "3149";
    private static final  String bizcodeDesc = "3149签署合同3206";

    public static void main(String[] args) throws Exception {
        // 需要鉴权的接口 custNo 不为为空
        String custNo =  "1001883516";
        // 需要数据交易密码的接口
        String tradeacco = "";
        // 交易密码 111111
        String passwd = "";
        JSONObject bodyJson =  setBody(bizcode, custNo);
        // 1001546198	1001883763
        requestUrl(custNo, tradeacco, passwd, bizcode, bizcodeDesc, bodyJson);
    }

    public static  JSONObject setBody(String bizcode, String custNo)   {
        JSONObject bodyJson = new JSONObject();
//        cfca.trustsign.common.vo.cs.SignInfoVO signInfoVO = new cfca.trustsign.common.vo.cs.SignInfoVO();
//        signInfoVO.setUserId("C54519845C277CF1E05312016B0A937F");
//        signInfoVO.setLocation("127.0.0.1");
//        signInfoVO.setIsCheckProjectCode(1);
//        signInfoVO.setProjectCode("MM_5466");
//        signInfoVO.setSignLocation("Signature1,Signature2,Signature3,Signature4,Signature5,Signature6,Signature7,Signature8");
//        signInfoVO.setAuthorizationTime("20211020");
//        // 传图片或传sealId的方式任选其一，传图片优先级高
//        try {
//            signInfoVO.setImageData(Base64.toBase64String(Files.readAllBytes(Paths.get("C:\\Users\\Administrator\\Desktop\\签名.png"))));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        SignContractVO signContractVO = new SignContractVO();
//        signContractVO.setContractNo("MM20211020000000279");
//        signContractVO.setSignInfo(signInfoVO);

        bodyJson.put("userId", "C54519845C277CF1E05312016B0A937F");
        bodyJson.put("projectCode", "1212121111111");
        bodyJson.put("contractTypeCode", "visit");
        bodyJson.put("fundid", "SCW165");
        bodyJson.put("tradeacco", "1001546061");

        try {
            bodyJson.put("imageData", Base64.toBase64String(Files.readAllBytes(Paths.get("C:\\Users\\Administrator\\Desktop\\签名.png"))));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bodyJson;
    }
}
class SignInfoVO {
    private String userId;
    private String authorizationTime;
    private String location;
    private String signLocation;
    private String projectCode;
    private Integer isCheckProjectCode;
    private Integer isProxySign;
    private Integer isCopy;
    private String signCert;
    private String sealId;
    private String imageData;
    private Integer certType;
    private Integer sealColor;

    public SignInfoVO() {
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAuthorizationTime() {
        return this.authorizationTime;
    }

    public void setAuthorizationTime(String authorizationTime) {
        this.authorizationTime = authorizationTime;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSignLocation() {
        return this.signLocation;
    }

    public void setSignLocation(String signLocation) {
        this.signLocation = signLocation;
    }

    public String getProjectCode() {
        return this.projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public Integer getIsCheckProjectCode() {
        return this.isCheckProjectCode;
    }

    public void setIsCheckProjectCode(Integer isCheckProjectCode) {
        this.isCheckProjectCode = isCheckProjectCode;
    }

    public Integer getIsProxySign() {
        return this.isProxySign;
    }

    public void setIsProxySign(Integer isProxySign) {
        this.isProxySign = isProxySign;
    }

    public Integer getIsCopy() {
        return this.isCopy;
    }

    public void setIsCopy(Integer isCopy) {
        this.isCopy = isCopy;
    }

    public String getSignCert() {
        return this.signCert;
    }

    public void setSignCert(String signCert) {
        this.signCert = signCert;
    }

    public String getSealId() {
        return this.sealId;
    }

    public void setSealId(String sealId) {
        this.sealId = sealId;
    }

    public String getImageData() {
        return this.imageData;
    }

    public void setImageData(String imageData) {
        this.imageData = imageData;
    }

    public Integer getCertType() {
        return this.certType;
    }

    public void setCertType(Integer certType) {
        this.certType = certType;
    }

    public Integer getSealColor() {
        return this.sealColor;
    }

    public void setSealColor(Integer sealColor) {
        this.sealColor = sealColor;
    }

}

 class SignContractVO {
    private String contractNo;
    private cfca.trustsign.common.vo.cs.SignInfoVO signInfo;
    private Integer isSendNotice;

    public SignContractVO() {
    }

    public String getContractNo() {
        return this.contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public cfca.trustsign.common.vo.cs.SignInfoVO getSignInfo() {
        return this.signInfo;
    }

    public void setSignInfo(cfca.trustsign.common.vo.cs.SignInfoVO signInfo) {
        this.signInfo = signInfo;
    }

    public Integer getIsSendNotice() {
        return this.isSendNotice;
    }

    public void setIsSendNotice(Integer isSendNotice) {
        this.isSendNotice = isSendNotice;
    }

}