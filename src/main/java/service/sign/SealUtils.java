package service.sign;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SealUtils {
    private static final String KEY_MAC = "HmacMD5";

    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println(computeSHA1("dddd".getBytes(StandardCharsets.UTF_8)));
    }

    /**
     * MD5算法
     * @param content
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static final byte[] computeMD5(byte[] content) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        return  md5.digest(content);
    }
    public static byte[] computeSHA1(byte[] content) {
        try {
            MessageDigest sha1 = MessageDigest.getInstance("SHA1");
            return sha1.digest(content);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * HMAC算法
     * HMAC 是密钥相关的 哈希运算消息认证码（Hash-based Message Authentication Code），
     * HMAC 运算利用 哈希算法 (MD5、SHA1 等)，以 一个密钥 和 一个消息 为输入，
     * 生成一个 消息摘要 作为 输出。
     *
     * HMAC 发送方 和 接收方 都有的 key 进行计算，而没有这把 key 的第三方，
     * 则是 无法计算 出正确的 散列值的，这样就可以 防止数据被篡改。
     */
    public  void HMacHelper(){

    }
}

