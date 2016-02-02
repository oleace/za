package com.boya.kites.liberator.domain;

import org.bson.BasicBSONObject;
import org.bson.types.BasicBSONList;
import org.canedata.field.Fields;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created  IN BOYA by lz on 15-8-13.
 */
public class Release implements Serializable, Base<Release> {
    private String id;
    private String tid;
    private String name;
    private String owner;
    private String version;
    private String url;
    private long crtAt;
    private long updAt;
    private int status; //1.启用2.发布中9停用
    private int level;//1.立刻2.紧急3.高4.普通5.低
    private int copyright;//1航空2.铁路3.轮船
    private String operator;
    private String releaseExplain;
    private String updateExplain;
    private List<Server> server;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getCrtAt() {
        return crtAt;
    }

    public void setCrtAt(long crtAt) {
        this.crtAt = crtAt;
    }

    public long getUpdAt() {
        return updAt;
    }

    public void setUpdAt(long updAt) {
        this.updAt = updAt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getCopyright() {
        return copyright;
    }

    public void setCopyright(int copyright) {
        this.copyright = copyright;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getReleaseExplain() {
        return releaseExplain;
    }

    public void setReleaseExplain(String releaseExplain) {
        this.releaseExplain = releaseExplain;
    }

    public String getUpdateExplain() {
        return updateExplain;
    }

    public void setUpdateExplain(String updateExplain) {
        this.updateExplain = updateExplain;
    }

    public List<Server> getServer() {
        return server;
    }

    public void setServer(List<Server> server) {
        this.server = server;
    }

    public static class Server implements Serializable {

        private static final long serialVersionUID = -7683428951868158476L;
        private String id;
        private String no;
        private String summary;
        private String name;
        private String addr;
        private String content;
        private int stauts;//1:已发布,2.未发布,9.下线)（*注:暂时未考虑发布后是否测试状态）
        private long releaseAt;
        private String releaseOwner;
        private long downAt;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getNo() {
            return no;
        }

        public void setNo(String no) {
            this.no = no;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddr() {
            return addr;
        }

        public void setAddr(String addr) {
            this.addr = addr;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getStauts() {
            return stauts;
        }

        public void setStauts(int stauts) {
            this.stauts = stauts;
        }

        public long getReleaseAt() {
            return releaseAt;
        }

        public void setReleaseAt(long releaseAt) {
            this.releaseAt = releaseAt;
        }

        public String getReleaseOwner() {
            return releaseOwner;
        }

        public void setReleaseOwner(String releaseOwner) {
            this.releaseOwner = releaseOwner;
        }

        public long getDownAt() {
            return downAt;
        }

        public void setDownAt(long downAt) {
            this.downAt = downAt;
        }
    }

    /**
     * 这里获取全部数据
     *
     * @param field
     * @return
     */
    public Release fill(Fields field) {
        Release tb = null;
        if (null != field) {
            tb = new Release();
            tb.setId(field.getString("_id"));
            if (null != field.get(Meta.STATUS))
                tb.setStatus(field.getInt(Meta.STATUS));
            if (null != field.get(Meta.TID))
                tb.setTid(field.getString(Meta.TID));
            if (null != field.get(Meta.NAME))
                tb.setName(field.getString(Meta.NAME));
            if (null != field.get(Meta.OWNER))
                tb.setOwner(field.getString(Meta.OWNER));
            if (null != field.get(Meta.VERSION))
                tb.setVersion(field.getString(Meta.VERSION));
            if (null != field.get(Meta.URL))
                tb.setUrl(field.getString(Meta.URL));
            if (null != field.get(Meta.CRTAT))
                tb.setCrtAt(field.getLong(Meta.CRTAT));
            if (null != field.get(Meta.UPDAT))
                tb.setUpdAt(field.getLong(Meta.UPDAT));
            if (null != field.get(Meta.LEVEL))
                tb.setLevel(field.getInt(Meta.LEVEL));
            if (null != field.get(Meta.COPYRIGHT))
                tb.setCopyright(field.getInt(Meta.COPYRIGHT));
            if (null != field.get(Meta.OPERATOR))
                tb.setOperator(field.getString(Meta.OPERATOR));
            if (null != field.get(Meta.RELEASEEXPLAIN))
                tb.setReleaseExplain(field.getString(Meta.RELEASEEXPLAIN));
            if (null != field.get(Meta.UPDATEEXPLAIN))
                tb.setUpdateExplain(field.getString(Meta.UPDATEEXPLAIN));
            List<Server> listCover = new ArrayList<Server>();
            if (null != field.get(Meta.SERVER)) {
                BasicBSONList listC = (BasicBSONList) field.get(Meta.SERVER);
                for (int j = 0; listC.size() > j; j++) {
                    BasicBSONObject bd = (BasicBSONObject) listC.get(j);
                    Server s = new Server();
                    s.setAddr(bd.getString(Meta.ADDR));
                    s.setContent(bd.getString(Meta.CONTENT));
                    s.setDownAt(bd.getLong(Meta.DOWNAT));
                    s.setId(bd.getString(Meta.ID));
                    s.setName(bd.getString(Meta.NAME));
                    s.setNo(bd.getString(Meta.NO));
                    s.setReleaseAt(bd.getLong(Meta.RELEASEAT));
                    s.setReleaseOwner(bd.getString(Meta.RELEASEOWNER));
                    s.setStauts(bd.getInt(Meta.STATUS));
                    s.setSummary(bd.getString(Meta.SUMMARY));
                    listCover.add(s);
                }
                tb.setServer(listCover);
            }
        }
        return tb;
    }

    public static final class Meta {
        public static final String TABLENAME = "release";
        public static final String ID = "id";
        public static final String STATUS = "status";
        public static final String TID = "tid";
        public static final String NAME = "name";
        public static final String OWNER = "owner";
        public static final String VERSION = "version";
        public static final String URL = "url";
        public static final String CRTAT = "crtAt";
        public static final String UPDAT = "updAt";
        public static final String LEVEL = "level";
        public static final String COPYRIGHT = "copyright";
        public static final String OPERATOR = "operator";
        public static final String RELEASEEXPLAIN = "releaseExplain";
        public static final String UPDATEEXPLAIN = "updateExplain";
        public static final String SERVER = "server";
        public static final String NO = "no";
        public static final String SUMMARY = "summary";
        public static final String ADDR = "addr";
        public static final String CONTENT = "content";
        public static final String RELEASEAT = "releaseAt";
        public static final String RELEASEOWNER = "releaseOwner";
        public static final String DOWNAT = "downAt";

        //时间格式
        public static final String date = "yyyy-MM-dd";
        public static final String dates = "yyyyMMdd";
        public static final String dateZn = "yyyy年MM月dd日";
        public static final String dateTime = "yyyy-MM-dd HH:mm:ss";
        //hours and minutes
        public static final String hoursAndMinutes = "HH:mm";
        //month and day
        public static final String monthAndDay = "MM月dd日";
    }
}
