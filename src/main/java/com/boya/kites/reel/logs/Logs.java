package com.boya.kites.reel.logs;

import com.boya.kites.liberator.domain.Base;
import org.canedata.field.Fields;

/**
 * Created  IN BOYA by BaiLiJun on 14/12/11.
 */
public class Logs implements Base<Logs> {

    private String id;

    //refer

    private String refer;

    //uri

    private String url;

    private String uid;

    private long crtAt;

    private String tid;

    private String module;

    private String bid;

    private String qs;

    private String cs;

    private String sid;

    private int type; //人操作，自动

    private int level;//1 info 2 warning 3 error

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCs() {
        return cs;
    }

    public void setCs(String cs) {
        this.cs = cs;
    }

    public String getRefer() {
        return refer;
    }

    public void setRefer(String refer) {
        this.refer = refer;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public long getCrtAt() {
        return crtAt;
    }

    public void setCrtAt(long crtAt) {
        this.crtAt = crtAt;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getQs() {
        return qs;
    }

    public void setQs(String qs) {
        this.qs = qs;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public Logs fill(Fields field) {
        Logs logs = null;
        if (null != field) {
            logs = new Logs();
            logs.setId(field.getString("_id"));
            logs.setBid(field.getString(Meta.BID));
            logs.setCrtAt(field.getLong(Meta.CRTAT));
            logs.setCs(field.getString(Meta.CONTENTSTRING));
            logs.setLevel(field.getInt(Meta.LEVEL));
            logs.setModule(field.getString(Meta.MODULE));
            logs.setQs(field.getString(Meta.QUERYSTRING));
            logs.setRefer(field.getString(Meta.REFER));
            logs.setSid(field.getString(Meta.SYSTEMID));
            logs.setTid(field.getString(Meta.TID));
            logs.setType(field.getInt(Meta.TYPE));
            logs.setUid(field.getString(Meta.UID));
            logs.setUrl(field.getString(Meta.URL));
        }
        return logs;
    }

    public static final class Meta {
        public static final String TABLENAME = "logs";

        public static final String ID = "id";

        public static final String REFER = "refer";

        public static final String URL = "url";

        public static final String UID = "uid";

        public static final String CRTAT = "crtAt";

        public static final String TID = "tid";

        public static final String MODULE = "module";

        public static final String BID = "bid";

        public static final String QUERYSTRING = "qs";

        public static final String CONTENTSTRING = "cs";

        public static final String SYSTEMID = "sid";

        public static final String TYPE = "type"; //人操作，自动

        public static final String LEVEL = "level";

        public static final int TYPE_HUMAN = 1;

        public static final int TYPE_MACHINE = 2;

        public static final int LEVEL_INFO = 1;

        public static final int LEVEL_WARNING = 2;

        public static final int LEVEL_ERROR = 3;

        public static final int IGNORE = -99;
    }
}
