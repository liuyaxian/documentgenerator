package service.util;

public class UnicodeUtils {



    /**
     * 将字符串转成ASCII
     */
    public static String stringToAscii(String value) {
        StringBuffer sbu = new StringBuffer("");
        char[] chars = value.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i != chars.length - 1) {
                sbu.append((int) chars[i]).append(",");
            } else {
                sbu.append((int) chars[i]);
            }
        }
        return sbu.toString();
    }

    /**
     * 将ASCII转成字符串
     */
    public static String asciiToString(String value) {
        StringBuffer sbu = new StringBuffer("");
        String[] chars = value.split(",");
        for (int i = 0; i < chars.length; i++) {
            sbu.append((char) Integer.parseInt(chars[i]));
        }
        return sbu.toString();
    }

    /**
     * 字符串转unicode
     */
    public static String stringToUnicode(String str) {
        StringBuffer sb = new StringBuffer("");
        char[] c = str.toCharArray();
        for (int i = 0; i < c.length; i++) {
            sb.append("\\u" + Integer.toHexString(c[i]));
        }
        return sb.toString();
    }

    /**
     * unicode转字符串
     */
    public static String unicodeToString(String unicode) {
        StringBuffer sb = new StringBuffer("");
        String[] hex = unicode.split("\\\\u");
        for (int i = 1; i < hex.length; i++) {
            int index = Integer.parseInt(hex[i], 16);
            sb.append((char) index);
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        String str = "{恶趣味我去恶趣味111111133333}";
        String asciiResult = stringToAscii(str);
        System.out.println(asciiResult);
        String stringResult = asciiToString(asciiResult);
        System.out.println(stringResult);

        String str2 = "汉语pinyin";
        String unicode = stringToUnicode(str2);
        System.out.println("字符串转unicode结果：" + unicode);
        String s = unicodeToString(unicode);
        System.out.println("unicode转字符串结果：" + s);
    }
}
