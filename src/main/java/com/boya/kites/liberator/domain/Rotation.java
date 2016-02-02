package com.boya.kites.liberator.domain;

import org.canedata.field.Fields;

/**
 * Created  IN BOYA by BaiLiJun on 14/11/19.
 */
public class Rotation implements Base<Rotation> {
    private String id;
    private String cover;
    private String url;
    private String subject;
    private String type;
    private String channel;
    private int loc;
    private int status;
    private int delete;
    private long cat;
    private long uat;
    private String tid;
    private String uid;

    public long getCat() {
        return cat;
    }

    public void setCat(long cat) {
        this.cat = cat;
    }

    public long getUat() {
        return uat;
    }

    public void setUat(long uat) {
        this.uat = uat;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public int getDelete() {
        return delete;
    }

    public void setDelete(int delete) {
        this.delete = delete;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public int getLoc() {
        return loc;
    }

    public void setLoc(int loc) {
        this.loc = loc;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public Rotation fill(Fields field) {
        Rotation rlt = null;
        if (null != field) {
            rlt = new Rotation();
            rlt.setType(field.getString(Meta.TYPE));
            rlt.setUrl(field.getString(Meta.URL));
            rlt.setCover(field.getString(Meta.COVER));
            rlt.setId(field.getString("_id"));
            rlt.setChannel(field.getString(Meta.CHANNEL));
            rlt.setSubject(field.getString(Meta.SUBJECT));
            rlt.setLoc(field.getInt(Meta.LOC));
            if (null != field.get(Meta.DELETE)) {
                rlt.setDelete(field.getInt(Meta.DELETE));
            }
            if (null != field.get(Meta.CAT)) {
                rlt.setCat(field.getLong(Meta.CAT));
            }
            if (null != field.get(Meta.UAT)) {
                rlt.setUat(field.getLong(Meta.UAT));
            }
            if (null != field.get(Meta.STATUS)) {
                rlt.setStatus(field.getInt(Meta.STATUS));
            }
        }
        return rlt;
    }

    public static final class Meta {
        public static final String TABLENAME = "rotations";
        public static final String ID = "id";
        public static final String COVER = "cover";
        public static final String URL = "url";
        public static final String SUBJECT = "title";
        public static final String TYPE = "type";
        public static final String CHANNEL = "channel";
        public static final String LOC = "loc";
        public static final String STATUS = "status";
        //自动
        public static final int STATUS_AUTO = 0;
        //手动
        public static final int STATUS_ASSIGN = 1;
        public static final String DELETE = "delete";
        public static final int DELETE_YES = 1;
        public static final int DELETE_NO = 0;
        public static final String CAT = "cat";
        public static final String UAT = "uat";
        public static final String TID = "tid";
        public static final String UID = "uid";
        public static final String SORT = "sort";
    }
}
