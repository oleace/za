package com.boya.kites.liberator.domain;

import com.boya.commons.TimeUitls;
import org.bson.types.BasicBSONList;
import org.canedata.field.Fields;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created  IN BOYA by lz on 15-3-3.
 */
public class TvChannel implements Serializable, Base<TvChannel> {

    private static final long serialVersionUID = -7683428951868158476L;
    private String id;
    private String name;
    private List<String> covers;
    private String summary;
    private String vendor;
    private int pos;
    private int status;
    private long cat;
    private String catDate;
    private long upd;
    private String updDate;
    private String uid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getCovers() {
        return covers;
    }

    public void setCovers(List<String> covers) {
        this.covers = covers;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
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

    public long getUpd() {
        return upd;
    }

    public void setUpd(long upd) {
        this.upd = upd;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getCatDate() {
        return catDate;
    }

    public void setCatDate(String catDate) {
        this.catDate = catDate;
    }

    public String getUpdDate() {
        return updDate;
    }

    public void setUpdDate(String updDate) {
        this.updDate = updDate;
    }

    /**
     * 这里获取全部数据
     *
     * @param field
     * @return
     */
    @Override
    public TvChannel fill(Fields field) {
        TvChannel tc = null;
        if (null != field) {
            tc = new TvChannel();
            tc.setId(field.getString("_" + Meta.ID));
            if (null != field.get(Meta.NAME))
                tc.setName(field.getString(Meta.NAME));
            if (null != field.get(Meta.SUMMARY))
                tc.setSummary(field.getString(Meta.SUMMARY));
            if (null != field.get(Meta.VENDOR))
                tc.setVendor(field.getString(Meta.VENDOR));
            if (null != field.get(Meta.POS))
                tc.setPos(field.getInt(Meta.POS));
            if (null != field.get(Meta.STATUS))
                tc.setStatus(field.getInt(Meta.STATUS));
            if (null != field.get(Meta.CAT)) {
                tc.setCat(field.getLong(Meta.CAT));
                tc.setCatDate(TimeUitls.getInterval(field.getLong(Meta.CAT)));
            }
            if (null != field.get(Meta.UPD)) {
                tc.setUpd(field.getLong(Meta.UPD));
                tc.setUpdDate(TimeUitls.getInterval(field.getLong(Meta.UPD)));
            }
            if (null != field.get(Meta.UID))
                tc.setUid(field.getString(Meta.UID));
            BasicBSONList listCover = (BasicBSONList) field.get(Meta.COVERS);
            List<String> cover = new ArrayList<>();
            if (null != listCover) {
                for (int j = 0; listCover.size() > j; j++) {
                    cover.add((String) listCover.get(j));
                }
            }
            tc.setCovers(cover);
        }
        return tc;
    }

    public static final class Meta {
        public static final String TABLENAME = "tv_channel";
        public static final String ID = "id";
        public static final String NAME = "name";
        public static final String COVERS = "covers";
        public static final String SUMMARY = "summary";
        public static final String VENDOR = "vendor";
        public static final String POS = "pos";
        public static final String STATUS = "status";
        public static final String CAT = "cat";
        public static final String UPD = "upd";
        public static final String UID = "uid";
        //状态定义
        public static final int STAUTS_OPEN = 1;
        public static final int STAUTS_DRAFT = 2;
        public static final int STAUTS_CLOSE = -9;
    }
}
