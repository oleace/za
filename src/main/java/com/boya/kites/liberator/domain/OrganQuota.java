package com.boya.kites.liberator.domain;

import java.io.Serializable;

/**
 * Created  IN boya by lz on 14-12-2.
 */
public class OrganQuota implements Serializable {

    private static final long serialVersionUID = -7683428951868158476L;
    private String id;
    private String oid;
    private String kei;
    private String name;
    private String pop;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPop() {
        return pop;
    }

    public void setPop(String pop) {
        this.pop = pop;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKei() {
        return kei;
    }

    public void setKei(String kei) {
        this.kei = kei;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public static final class Key {
        //发送数量
        public static final String SENDAMOUNT = "sendAmount";
        //开始时间
        public static final String START = "start";
        public static final String END = "end";
        public static final String REQUESTAMOUNT = "requestAmount";
    }
}
