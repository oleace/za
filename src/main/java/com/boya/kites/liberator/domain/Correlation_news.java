package com.boya.kites.liberator.domain;

import org.bson.types.BasicBSONList;
import org.canedata.field.Fields;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created  IN BOYA by lz on 15-4-20.
 */
public class Correlation_news implements Serializable, Base<Correlation_news> {

    private static final long serialVersionUID;

    static {
        serialVersionUID = -5809782578272943999L;
    }

    private String id;
    private String newsId;
    private List<String> nid;
    private int status;
    private long cat;
    private long uat;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getCat() {
        return cat;
    }

    public void setCat(long cat) {
        this.cat = cat;
    }

    public List<String> getNid() {
        return nid;
    }

    public void setNid(List<String> nid) {
        this.nid = nid;
    }

    public long getUat() {
        return uat;
    }

    public void setUat(long uat) {
        this.uat = uat;
    }

    public String getNewsId() {
        return newsId;
    }

    public void setNewsId(String newsId) {
        this.newsId = newsId;
    }

    /**
     * 这里获取全部数据
     *
     * @param field
     * @return
     */
    @Override
    public Correlation_news fill(Fields field) {
        Correlation_news tc = null;
        if (null != field) {
            tc = new Correlation_news();
            tc.setId(field.getString("_" + Meta.ID));
            tc.setStatus(field.getInt(Meta.STATUS));
            tc.setNewsId(field.getString(Meta.NEWSID));
            tc.setCat(field.getLong(Meta.CAT));
            tc.setUat(field.getLong(Meta.UAT));

            BasicBSONList listNid = (BasicBSONList) field.get(Meta.NID);
            List<String> nid = new ArrayList<>();
            if (null != listNid) {
                for (int j = 0; listNid.size() > j; j++) {
                    nid.add((String) listNid.get(j));
                }
            }
            tc.setNid(nid);
        }
        return tc;
    }

    public static final class Meta {
        public static final String TABLENAME = "correlation_news";
        public static final String ID = "id";
        public static final String NID = "nid";
        public static final String STATUS = "status";
        public static final String CAT = "cat";
        public static final String UAT = "uat";
        public static final String NEWSID = "newsId";
        //状态定义
        public static final int STAUTS_OPEN = 1;
        public static final int STAUTS_DRAFT = 2;
        public static final int STAUTS_CLOSE = -9;

    }
}
