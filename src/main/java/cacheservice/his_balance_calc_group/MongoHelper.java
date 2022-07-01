package cacheservice.his_balance_calc_group;

import com.mongodb.*;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Mongo连接池（Mongo对象内部实现了一个连接池。Mongo对象是线程安全的，因此可以只创建一个，在多线程环境下安全使用。）
 */
public class MongoHelper {

    private static final Logger logger = Logger.getLogger(MongoHelper.class);

    private static final List<ServerAddress> MONGO_REPLSET_ADDR = new ArrayList<ServerAddress>();

    private static Mongo mongo = null;

    private static final String DEFAULT_DB_NAME = "fund";

    private static final ReentrantLock LOCK = new ReentrantLock();

    /**
     * 私有化构造方法
     */
    private MongoHelper() {
    }


    private static final  String zlfund_mongodb_replset = "172.18.10.72:27017";
    private static final  String zlfund_mongodb_user = "zlfund";
    private static final  String zlfund_mongodb_password = "zlfundzlfund";
    private static final  String zlfund_mongodb_auth = "1";
    private static final  String zlfund_mongodb_poolsize = "100";

    /**
     * 获取DB
     *
     * @param dbName
     * @return
     * @create: 2013-4-25 下午02:01:55
     * @author: 徐文凡
     * @history:
     */
    public static DB getDB(String dbName) {
        String db = StringUtils.isEmpty(dbName) ? DEFAULT_DB_NAME : dbName;
        if (null == mongo) {
            init(100,db);
        }
        return mongo.getDB(db);
    }

    public static DB getDB() {
        return getDB(null);
    }

    /**
     * 关闭MongoDB连接池
     *
     * @create: 2015-7-8 上午08:59:04
     * @author: 徐文凡
     * @history:
     */
    public static void closePool() {
        if (mongo != null) {
            mongo.close();
        }
    }

    /**
     * 初始化连接池,设置参数.
     * @param poolSize
     * @param db
     * @create: 2013-4-25 下午02:02:03
     * @author: 徐文凡
     * @history:
     */
    private static void init(int poolSize,String db) {
        System.setProperty("MONGO.POOLSIZE", String.valueOf(poolSize));
        try {
            // new Mongo(seeds)
            List<ServerAddress> addrList = getMongoReplSetAddr();
            logger.info("MongoDB replset addr list:" + addrList);

            // 改变默认设置
            MongoClientOptions.Builder optBuilder = MongoClientOptions.builder();
            // 自动重连,默认15秒
            //optBuilder.autoConnectRetry(true);
            // 连接池最大连接数
            optBuilder.connectionsPerHost(poolSize);
            // 最大等待线程数
            optBuilder.threadsAllowedToBlockForConnectionMultiplier(20);
            // 设置等待连接池超时
            optBuilder.maxWaitTime(5000);
            // 设置连接超时
            optBuilder.connectTimeout(5000);
            // 设置读超时
            optBuilder.socketTimeout(4 * 1000 * 60);
            // 解决can't say something问题
            optBuilder.socketKeepAlive(true);

            MongoClientOptions mongoOptions = optBuilder.build();

            if ("1".equals(zlfund_mongodb_auth)) {
                //认证
                String user =zlfund_mongodb_user;
                String password = zlfund_mongodb_password;
                MongoCredential credential = MongoCredential.createCredential(user, db, password.toCharArray());
                mongo = new MongoClient(addrList, Arrays.asList(credential), mongoOptions);
            }else{
                mongo = new MongoClient(addrList, mongoOptions);
            }

            // 从从节点读取数据
            mongo.setReadPreference(ReadPreference.secondaryPreferred());
            // 使用安全模式写入
            mongo.setWriteConcern(WriteConcern.SAFE);

            // 新的创建方式，尚未进行测试
            // MongoOptions option = new MongoOptions();
            // // 自动重连,默认15秒
            // option.setAutoConnectRetry(true);
            // // 连接池最大连接数
            // option.setConnectionsPerHost(poolSize);
            // // 最大等待线程数
            // option.setThreadsAllowedToBlockForConnectionMultiplier(20);
            // // 设置等待连接池超时
            // option.setMaxWaitTime(5000);
            // // 设置连接超时
            // option.setConnectTimeout(5000);
            // // 设置读超时
            // option.setSocketTimeout(2 * 1000 * 60);
            // // 优先Master
            // option.setReadPreference(ReadPreference.primaryPreferred());
            // // SAFE
            // option.setSafe(true);
            //
            // mongo = new Mongo(SystemConfig.getMongoReplSetAddr(), option);
        } catch (Exception e) {
            logger.error("", e);
        }
    }

    /**
     * 根据指定的配置手工获取DB
     * @param host
     * @param port
     * @param poolsize
     * @param user
     * @param password
     * @param auth
     * @param dbName
     * @return
     */
    @SuppressWarnings("deprecation")
    public static DB manualGetDB(String host, int port, int poolsize, String user, String password,
                                 boolean auth, String dbName) {
        String db = StringUtils.isBlank(dbName) ? DEFAULT_DB_NAME : dbName;
        Mongo mongo = manualInit(host, port, poolsize, auth,user, password, db);
        return mongo.getDB(db);
    }

    /**
     * 根据IP地址，端口等手工初始化
     * @param host
     * @param port
     * @param poolSize
     * @return
     */
    @SuppressWarnings("deprecation")
    private static Mongo manualInit(String host, int port, int poolSize,boolean auth,String user, String password, String db) {
        System.setProperty("MONGO.POOLSIZE", String.valueOf(poolSize));
        try {
            ServerAddress addr = new ServerAddress(host, port);
            // 改变默认设置
            MongoClientOptions.Builder optBuilder = MongoClientOptions.builder();
            // 自动重连,默认15秒
            //optBuilder.autoConnectRetry(true);
            // 连接池最大连接数
            optBuilder.connectionsPerHost(poolSize);
            // 最大等待线程数
            optBuilder.threadsAllowedToBlockForConnectionMultiplier(20);
            // 设置等待连接池超时
            optBuilder.maxWaitTime(5000);
            // 设置连接超时
            optBuilder.connectTimeout(5000);
            // 设置读超时
            optBuilder.socketTimeout(4 * 1000 * 60);
            // 解决can't say something问题
            optBuilder.socketKeepAlive(true);

            MongoClientOptions mongoOptions = optBuilder.build();
            Mongo mongo = null;
            if (auth) {
                MongoCredential credential = MongoCredential.createCredential(user, db, password.toCharArray());
                mongo = new MongoClient(addr,Arrays.asList(credential),mongoOptions);
            }else{
                mongo = new MongoClient(addr,mongoOptions);
            }

            // 从最近的节点读取数据 内部实现是根据ping的最短时间
            mongo.setReadPreference(ReadPreference.secondaryPreferred());
            // 使用安全模式写入
            mongo.setWriteConcern(WriteConcern.SAFE);

            // 新的创建方式，尚未进行测试
            // MongoOptions option = new MongoOptions();
            // // 自动重连,默认15秒
            // option.setAutoConnectRetry(true);
            // // 连接池最大连接数
            // option.setConnectionsPerHost(poolSize);
            // // 最大等待线程数
            // option.setThreadsAllowedToBlockForConnectionMultiplier(20);
            // // 设置等待连接池超时
            // option.setMaxWaitTime(5000);
            // // 设置连接超时
            // option.setConnectTimeout(5000);
            // // 设置读超时
            // option.setSocketTimeout(2 * 1000 * 60);
            // // 优先Master
            // option.setReadPreference(ReadPreference.primaryPreferred());
            // // SAFE
            // option.setSafe(true);
            //
            // mongo = new Mongo(SystemConfig.getMongoReplSetAddr(), option);

            return mongo;
        } catch(Exception e) {
            logger.error("", e);
            return null;
        }
    }

    public static Double getDouble(DBObject dbObject, String key, Double defaultVal) {
        if (dbObject == null || StringUtils.isBlank(key) || !dbObject.containsField(key)) {
            return defaultVal;
        }
        Object value = dbObject.get(key);
        if (value != null) {
            if (StringUtils.isBlank(value.toString())){
                return defaultVal;
            }
            return Double.parseDouble(value.toString());
        }
        return defaultVal;
    }

    public static Double getDouble(DBObject dbObject, String key) {
        return getDouble(dbObject, key, null);
    }

    public static <T> T getValue(DBObject dbObject, String key, T defaultValue) {
        if (dbObject == null || key == null || !dbObject.containsField(key)) {
            return defaultValue;
        }
        Object value = dbObject.get(key);
        if (value == null) {
            return defaultValue;
        } else {
            T retValue = (T)value;
            if (retValue instanceof String && StringUtils.isBlank((String)retValue)) {
                return defaultValue;
            }
            return retValue;
        }
    }


    public static void main(String[] args) throws InterruptedException {
        /*
         * DBCollection collDev = MongoHelper.manualGetDB("10.234.99.246", 27017, 50, "", "", false,
         * null).getCollection( SysConstant.HIS_NAV_COLLECTION); DBCollection collPro =
         * MongoHelper.manualGetDB("192.168.0.12", 27017, 50, "zlfund", "1qaz2wsx", true, null)
         * .getCollection(SysConstant.HIS_NAV_COLLECTION);
         *
         * DBCursor cur = collDev.find(new BasicDBObject("inner_code", new Long(1000010044))).sort( new
         * BasicDBObject("tradedate", 1));
         */
        DB db = getDB("fund");
        DBCollection coll = db.getCollection("pf_capitalaccount");
        DBCursor cur = coll.find().addOption(Bytes.QUERYOPTION_NOTIMEOUT);
        while (cur.hasNext()) {
            DBObject dbObject = cur.next();
            System.out.println(dbObject.get("_id"));
            Thread.sleep(3000);
        }
        cur.close();
    }


    /**
     * 获取MongoDB复制集地址
     *
     * @return
     * @create: 2015-1-20 上午10:05:39
     * @author: 徐文凡
     * @history:
     */
    public static List<ServerAddress> getMongoReplSetAddr() {
        LOCK.lock();
        try {
            if (MONGO_REPLSET_ADDR.isEmpty()) {
                // 加载
                try {
                    initMongoReplsetAddr();
                } catch (Exception e) {
                    logger.error("getMongoReplSetAddr erroe", e);
                }
            }
        } finally {
            LOCK.unlock();
        }

        return MONGO_REPLSET_ADDR;
    }

    private static void initMongoReplsetAddr() throws UnknownHostException {
        MONGO_REPLSET_ADDR.clear();
        String[] array = StringUtils.splitByWholeSeparator(zlfund_mongodb_replset, ",");
        String[] ipAndPort = null;
        for (String add : array) {
            ipAndPort = StringUtils.splitByWholeSeparator(add, ":");
            if (StringUtils.isNotBlank(ipAndPort[0]) && StringUtils.isNotBlank(ipAndPort[1])) {
                MONGO_REPLSET_ADDR.add(new ServerAddress(ipAndPort[0], Integer.parseInt(ipAndPort[1])));
            }
        }

    }

}

