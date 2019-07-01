package com.test.designpattern;

import java.util.Objects;

/**
 * @author cyf
 * @description  工厂模式
 *   适用场景，创建复杂对象，如果是直接可以new 出的对象，不需要用工厂模式
 * @create 2019-04-30 13:41
 **/
public class FactoryTest {

    /**
     *  真正使用的时候将 MongoTemplateFactory 加入springIOC中，然后通过 @Autowired 注入使用
     *  host 和 dbId 参数，如果多可以封装为一个对象。
     * @param args
     */
    public static void main(String[] args) {
        MongoTemplateFactory templateFactory = new MongoTemplateFactory();
        MongoClient mongo = templateFactory.createMongo("192.168.120.75","data_collection");
        mongo.doSomething();
    }
}

class Mongo {

    private String host;
    private String dbId;

    public void showMongo() {
        System.out.println("host is : " + host);
        System.out.println("dbId is : " + dbId);
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getDbId() {
        return dbId;
    }

    public void setDbId(String dbId) {
        this.dbId = dbId;
    }
}

interface IMongoFactory {
    MongoClient createMongo(String host, String dbId);
}

class MongoTemplateFactory implements IMongoFactory {
    @Override
    public MongoClient createMongo(String host, String dbId) {
        Mongo mongo = new Mongo();
        mongo.setHost(host);
        mongo.setDbId(dbId);
        MongoClient mongoClient = null;
        if(!Objects.isNull(mongo)){
            mongoClient = new MongoClient(mongo);
        }
        return mongoClient;
    }
}

class MongoClient{
    private Mongo mongo;

    public MongoClient(Mongo mongo){
        this.mongo = mongo;
    }

    public Mongo getMongo() {
        return mongo;
    }

    public void setMongo(Mongo mongo) {
        this.mongo = mongo;
    }

    public void doSomething(){
        mongo.showMongo();
        System.out.println("MongoClient.doSomething");
    }
}
