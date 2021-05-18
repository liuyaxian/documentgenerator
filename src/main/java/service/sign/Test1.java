package service.sign;

import java.io.UnsupportedEncodingException;

public class Test1 {
//        String str = "刘亚仙";
//        // [-27, -120, -104, -28, -70, -102, -28, -69, -103]
//        System.out.println(Arrays.toString(str.getBytes()));

    public static void main(String[] args) throws UnsupportedEncodingException{
        ObservObject observObject = new ObservObject();
        System.out.println(observObject);//输出hahaha
        System.out.println(observObject.toString("whoami"));//只要我输入whoami就会输出我的名字
    }
}

 class ObservObject {
    private final byte[] token = {-27, -120, -104, -28, -70, -102, -28, -69, -103};

//    public void showCopyRight() {
//        try {
//            System.out.println(new String(token,"UTF-8"));
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//    }
// 这样的方法，在调用时可以看出来，还是有点不保险。下面用另一种办法：重写toString

    @Override //重写toString方法，这个知识马上会讲解
    public String toString() {
        return "hahaha";
    }
    public final String toString(String tag) {//这个toString方法可以写到父类里面，且写成final，子类继承但不能再重写这个方法。（复习一下final关键字）
        // (把一些工具都写在父类里，要想实现必须继承父类)然后交作业时父类文件只给.class类型的，就OK了。别人想改都改不了。这样就能证明是自己的作业啦
        switch (tag) {
            case "whoami":
                try {
                    return new String(token,"UTF-8");//把字节码转为utf-8格式输出
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            default:
                return this.toString();
        }
    }
}