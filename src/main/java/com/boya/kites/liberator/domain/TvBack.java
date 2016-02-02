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
public class TvBack implements Serializable, Base<TvBack> {

    private static final long serialVersionUID = -7683428951868158476L;
    private String id;
    private int status;
    private long cat;
    private String catDate;
    private long upd;
    private String updDate;
    private String tcId;
    private String vendor;
    private String startTime;
    private String endTime;
    private String wtime;
    private String time2day;
    private String time2dayDate;
    private String uid;
    private String url;
    private String subject;
    private List<String> covers;
    private String icon;
    private String content;
    private String summary;
    private List<String> kw;
    private List<String> tags;
    private String director;
    private String actor;
    private String genres;
    private int source;

    public String getTime2dayDate() {
        return time2dayDate;
    }

    public void setTime2dayDate(String time2dayDate) {
        this.time2dayDate = time2dayDate;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

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

    public String getCatDate() {
        return catDate;
    }

    public void setCatDate(String catDate) {
        this.catDate = catDate;
    }

    public long getUpd() {
        return upd;
    }

    public void setUpd(long upd) {
        this.upd = upd;
    }

    public String getUpdDate() {
        return updDate;
    }

    public void setUpdDate(String updDate) {
        this.updDate = updDate;
    }

    public String getTcId() {
        return tcId;
    }

    public void setTcId(String tcId) {
        this.tcId = tcId;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getWtime() {
        return wtime;
    }

    public void setWtime(String wtime) {
        this.wtime = wtime;
    }

    public String getTime2day() {
        return time2day;
    }

    public void setTime2day(String time2day) {
        this.time2day = time2day;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
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

    public List<String> getCovers() {
        return covers;
    }

    public void setCovers(List<String> covers) {
        this.covers = covers;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public List<String> getKw() {
        return kw;
    }

    public void setKw(List<String> kw) {
        this.kw = kw;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    /**
     * 这里获取全部数据
     *
     * @param field
     * @return
     */
    public TvBack fill(Fields field) {
        TvBack tb = null;
        if (null != field) {
            tb = new TvBack();
            tb.setId(field.getString("_id"));
            if (null != field.get(Meta.STATUS))
                tb.setStatus(field.getInt(Meta.STATUS));
            if (null != field.get(Meta.CAT)) {
                tb.setCat(field.getLong(Meta.CAT));
                tb.setCatDate(TimeUitls.getInterval(field.getLong(Meta.CAT)));
            }
            if (null != field.get(Meta.UPD)) {
                tb.setUpd(field.getLong(Meta.UPD));
                tb.setUpdDate(TimeUitls.getInterval(field.getLong(Meta.UPD)));
            }
            if (null != field.get(Meta.TCID))
                tb.setTcId(field.getString(Meta.TCID));
            if (null != field.get(Meta.VENDOR))
                tb.setVendor(field.getString(Meta.VENDOR));
            if (null != field.get(Meta.STARTTIME))
                tb.setStartTime(field.getString(Meta.STARTTIME));
            if (null != field.get(Meta.ENDTIME))
                tb.setEndTime(field.getString(Meta.ENDTIME));
            if (null != field.get(Meta.WTIME))
                tb.setWtime(field.getString(Meta.WTIME));
            if (null != field.get(Meta.TIME2DAY))
                tb.setTime2day(field.getString(Meta.TIME2DAY));
            if (null != field.get(Meta.UID))
                tb.setUid(field.getString(Meta.UID));
            if (null != field.get(Meta.URL)) {
                tb.setUrl(field.getString(Meta.URL));
            }
            if (null != field.get(Meta.SUBJECT))
                tb.setSubject(field.getString(Meta.SUBJECT));
            if (null != field.get(Meta.SOURCE))
                tb.setSource(field.getInt(Meta.SOURCE));

            List<String> listCover = new ArrayList<String>();
            if (null != field.get(Meta.COVERS)) {
                BasicBSONList listC = (BasicBSONList) field.get(Meta.COVERS);
                for (int j = 0; listC.size() > j; j++) {
                    listCover.add((String) listC.get(j));
                }
                tb.setCovers(listCover);
            }
            List<String> listKw = new ArrayList<String>();
            if (null != field.get(Meta.KW)) {
                BasicBSONList listC = (BasicBSONList) field.get(Meta.KW);
                for (int j = 0; listC.size() > j; j++) {
                    listKw.add((String) listC.get(j));
                }
                tb.setKw(listKw);
            }
            List<String> listTags = new ArrayList<String>();
            if (null != field.get("tags")) {
                BasicBSONList listC = (BasicBSONList) field.get(Meta.TAGS);
                for (int j = 0; listC.size() > j; j++) {
                    listTags.add((String) listC.get(j));
                }
                tb.setTags(listTags);
            }

            if (null != field.get(Meta.ICON))
                tb.setIcon(field.getString(Meta.ICON));
            if (null != field.get(Meta.CONTENT))
                tb.setContent(field.getString(Meta.CONTENT));
            if (null != field.get(Meta.SUMMARY))
                tb.setSummary(field.getString(Meta.SUMMARY));
            if (null != field.get(Meta.DIRECTOR))
                tb.setDirector(field.getString(Meta.DIRECTOR));
            if (null != field.get(Meta.ACTOR))
                tb.setActor(field.getString(Meta.ACTOR));
            if (null != field.get(Meta.GENRES))
                tb.setGenres(field.getString(Meta.GENRES));
        }
        return tb;
    }

    public static final class Meta {
        public static final String TABLENAME = "tv_back";
        public static final String ID = "id";
        public static final String STATUS = "status";
        public static final String CAT = "cat";
        public static final String UPD = "upd";
        public static final String TCID = "tcId";
        public static final String VENDOR = "vendor";
        public static final String STARTTIME = "startTime";
        public static final String ENDTIME = "endTime";
        public static final String WTIME = "wtime";
        public static final String TIME2DAY = "time2day";
        public static final String TIME2DAYDATE = "time2daydate";
        public static final String UID = "uid";
        public static final String URL = "url";
        public static final String SUBJECT = "subject";
        public static final String COVERS = "covers";
        public static final String ICON = "icon";
        public static final String CONTENT = "content";
        public static final String SUMMARY = "summary";
        public static final String KW = "kw";
        public static final String TAGS = "tags";
        public static final String DIRECTOR = "director";
        public static final String ACTOR = "actor";
        public static final String GENRES = "genres";
        public static final String SOURCE = "source";
        //状态定义
        public static final int STAUTS_OPEN = 1;
        public static final int STAUTS_DRAFT = 2;
        public static final int STAUTS_CLOSE = -9;
        //时间格式
        public static final String date = "yyyy-MM-dd";
        public static final String dates = "yyyyMMdd";
        public static final String dateZn = "yyyy年MM月dd日";
        public static final String dateTime = "yyyy-MM-dd HH:mm:ss";
        //hours and minutes
        public static final String hoursAndMinutes = "HH:mm";
        //month and day
        public static final String monthAndDay = "MM月dd日";
        //来源初始化定义
        public static final int SOURCE_ARTIFICIAL = 1;
        public static final int SOURCE_AUTO = 2;
    }
}
