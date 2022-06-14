package service.ssl证书;

import net.sf.json.JSONObject;
import service.DocumentGeneratorServiceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Test3291获取指定域名下的证书文件  extends DocumentGeneratorServiceImpl {

    private static final  String bizcode = "3291";
    private static final  String bizcodeDesc = "获取指定域名下的证书文件";

    public static void main(String[] args) throws Exception {
        long starttime = System.currentTimeMillis();

        // 需要鉴权的接口 custNo 不为为空
        String custNo = "1001883551";
        // 需要数据交易密码的接口
        String tradeacco = "";
        // 交易密码 111111
        String passwd = "";
        JSONObject bodyJson = setBody(bizcode, custNo, "jjmmw.com");;

        List<String> domainList = new ArrayList<>();
        domainList.add("jjmmw.com");
        domainList.add("xuezhanggui.com");
//        domainList.add("appapi.zlfund.cn");
//        domainList.add("officeapi.zlfund.cn");
        domainList.add("zljys.cn");
        domainList.add("zlfund.cn");
//        (int corePoolSize,
//        int maximumPoolSize,
//        long keepAliveTime,
//        TimeUnit unit,
//        BlockingQueue<Runnable> workQueue,
//        ThreadFactory threadFactory,
//        RejectedExecutionHandler handler) {
        // 核心线程数量
        int corePoolSize = 10000;
        // 最大线程数量；
        int maximumPoolSize = 10002;
        // 线程池维护线程所允许的空闲时间。当线程池中的线程数量大于corePoolSize的时候，如果这时没有新的任务提交，核心线程外的线程不会立即销毁，而是会等待，直到等待的时间超过了keepAliveTime；
        long keepAliveTime = 1000;
        TimeUnit unit = TimeUnit.DAYS;
        // 等待队列，当任务提交时，如果线程池中的线程数量大于等于corePoolSize的时候，把该任务封装成一个Worker对象放入等待队列；
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<Runnable>();
        // 它是ThreadFactory类型的变量，用来创建新线程。默认使用Executors.defaultThreadFactory() 来创建线程。使用默认的ThreadFactory来创建线程时，会使新创建的线程具有相同的NORM_PRIORITY优先级并且是非守护线程，同时也设置了线程的名称。
        ThreadFactory threadFactory =  Executors.defaultThreadFactory();;
        // 它是RejectedExecutionHandler类型的变量，表示线程池的饱和策略。如果阻塞队列满了并且没有空闲的线程，这时如果继续提交任务，就需要采取一种策略处理该任务。线程池提供了4种策略：
        RejectedExecutionHandler handler =  new ThreadPoolExecutor.DiscardPolicy();;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                corePoolSize,
                maximumPoolSize,
                keepAliveTime,
                unit,
                workQueue,
                threadFactory,
                handler
        );
        for (int i = 0; i < 1; i++) {
            threadPoolExecutor.execute(() -> {
                for (String domain : domainList) {
                    JSONObject bodyJson12 = setBody(bizcode, custNo, domain);
                    try {
                        requestUrl(custNo, tradeacco, passwd, bizcode, bizcodeDesc, bodyJson12);
                        System.out.println("domain" + domain + "当前线程：" + Thread.currentThread().getName() +  threadPoolExecutor.getActiveCount() +" dd:" +  Thread.currentThread().getPriority());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        long endtime = System.currentTimeMillis();
        System.out.println("耗时： "+ (starttime - endtime)/ 1000);
    }
    public static  JSONObject setBody(String bizcode, String custNo, String domain){
        JSONObject bodyJson = new JSONObject();
        bodyJson.put("domain", domain);
        return bodyJson;
    }
}
