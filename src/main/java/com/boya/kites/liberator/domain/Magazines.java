package com.boya.kites.liberator.domain;

import org.bson.types.BasicBSONList;
import org.canedata.field.Fields;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created  IN BOYA by lz on 15-5-22.
 */
public class Magazines implements Serializable, Base<Magazines> {

    private static final long serialVersionUID;

    static {
        serialVersionUID = -5809782578272943999L;
    }

    private String id;
    private String tid;
    private String name;
    private List<String> covers;
    private String cover;
    private String icon;
    private String owner;
    private String lang;
    private String from;
    private int readType;//1成人2儿童
    private String type;
    private long crtAt;
    private long updAt;
    private long downAt;
    private String summary;
    private String content;
    private String bookConcern;
    private int copyRight;//0不限1.航空2.铁路3.轮船（预留）
    private String ascription;//(预留)
    private String periodical;
    private long publicshDate;
    private long periodValidity;
    private String chiefEditor;
    private String datePublication;
    private int order;
    private int status;//1上架2待上架9下架
    private List<String> tags;
    private List<String> articleId;//杂志文章id

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getPeriodical() {
        return periodical;
    }

    public void setPeriodical(String periodical) {
        this.periodical = periodical;
    }

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

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public int getReadType() {
        return readType;
    }

    public void setReadType(int readType) {
        this.readType = readType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public long getDownAt() {
        return downAt;
    }

    public void setDownAt(long downAt) {
        this.downAt = downAt;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getBookConcern() {
        return bookConcern;
    }

    public void setBookConcern(String bookConcern) {
        this.bookConcern = bookConcern;
    }

    public int getCopyRight() {
        return copyRight;
    }

    public void setCopyRight(int copyRight) {
        this.copyRight = copyRight;
    }

    public String getAscription() {
        return ascription;
    }

    public void setAscription(String ascription) {
        this.ascription = ascription;
    }

    public long getPublicshDate() {
        return publicshDate;
    }

    public void setPublicshDate(long publicshDate) {
        this.publicshDate = publicshDate;
    }

    public long getPeriodValidity() {
        return periodValidity;
    }

    public void setPeriodValidity(long periodValidity) {
        this.periodValidity = periodValidity;
    }

    public String getChiefEditor() {
        return chiefEditor;
    }

    public void setChiefEditor(String chiefEditor) {
        this.chiefEditor = chiefEditor;
    }

    public String getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(String datePublication) {
        this.datePublication = datePublication;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<String> getArticleId() {
        return articleId;
    }

    public void setArticleId(List<String> articleId) {
        this.articleId = articleId;
    }

    /**
     * 这里获取全部数据
     *
     * @param field
     * @return
     */
    @Override
    public Magazines fill(Fields field) {
        Magazines tc = null;
        if (null != field) {
            tc = new Magazines();
            tc.setId(field.getString("_" + Meta.ID));
            if (null != field.get(Meta.TID)) tc.setTid(field.getString(Meta.TID));
            if (null != field.get(Meta.NAME)) tc.setName(field.getString(Meta.NAME));

            BasicBSONList listCover = (BasicBSONList) field.get(Meta.COVERS);
            List<String> cover = new ArrayList<>();
            if (null != listCover) {
                for (int j = 0; listCover.size() > j; j++) {
                    cover.add((String) listCover.get(j));
                    tc.setCover((String) listCover.get(j));
                }
            }
            tc.setCovers(cover);

            if (null != field.get(Meta.ICON)) tc.setIcon(field.getString(Meta.ICON));
            if (null != field.get(Meta.OWNER)) tc.setOwner(field.getString(Meta.OWNER));
            if (null != field.get(Meta.LANG)) tc.setLang(field.getString(Meta.LANG));
            if (null != field.get(Meta.FROM)) tc.setFrom(field.getString(Meta.FROM));
            if (null != field.get(Meta.READTYPE)) tc.setReadType(field.getInt(Meta.READTYPE));
            if (null != field.get(Meta.TYPE)) tc.setType(field.getString(Meta.TYPE));
            if (null != field.get(Meta.CRTAT)) tc.setCrtAt(field.getLong(Meta.CRTAT));
            if (null != field.get(Meta.UPDAT)) tc.setUpdAt(field.getLong(Meta.UPDAT));
            if (null != field.get(Meta.DOWNAT)) tc.setDownAt(field.getLong(Meta.DOWNAT));
            if (null != field.get(Meta.PERIODICAL)) tc.setPeriodical(field.getString(Meta.PERIODICAL));
            if (null != field.get(Meta.SUMMARY)) tc.setSummary(field.getString(Meta.SUMMARY));
            if (null != field.get(Meta.CONTENT)) tc.setContent(field.getString(Meta.CONTENT));
            if (null != field.get(Meta.BOOKCONCERN)) tc.setBookConcern(field.getString(Meta.BOOKCONCERN));
            if (null != field.get(Meta.COPYRIGHT)) tc.setCopyRight(field.getInt(Meta.COPYRIGHT));
            if (null != field.get(Meta.ASCRIPTION)) tc.setAscription(field.getString(Meta.ASCRIPTION));
            if (null != field.get(Meta.PUBLICSHDATE)) tc.setPublicshDate(field.getLong(Meta.PUBLICSHDATE));
            if (null != field.get(Meta.PERIODVALIDITY)) tc.setPeriodValidity(field.getLong(Meta.PERIODVALIDITY));
            if (null != field.get(Meta.CHIEFEDITOR)) tc.setChiefEditor(field.getString(Meta.CHIEFEDITOR));
            if (null != field.get(Meta.DATEPUBLICATION)) tc.setDatePublication(field.getString(Meta.DATEPUBLICATION));
            if (null != field.get(Meta.ORDER)) tc.setOrder(field.getInt(Meta.ORDER));
            if (null != field.get(Meta.STATUS)) tc.setStatus(field.getInt(Meta.STATUS));

            BasicBSONList listtags = (BasicBSONList) field.get(Meta.TAGS);
            List<String> tags = new ArrayList<>();
            if (null != listtags) {
                for (int j = 0; listtags.size() > j; j++) {
                    tags.add((String) listtags.get(j));
                }
            }
            tc.setTags(tags);

            BasicBSONList lista = (BasicBSONList) field.get(Meta.ARTICLEID);
            List<String> aid = new ArrayList<>();
            if (null != lista) {
                for (int j = 0; lista.size() > j; j++) {
                    aid.add((String) lista.get(j));
                }
            }
            tc.setArticleId(aid);
        }
        return tc;
    }

    public static final class Meta {
        public static final String TABLENAME = "magazines";
        public static final String ID = "id";
        public static final String TID = "tid";
        public static final String NAME = "name";
        public static final String COVERS = "covers";
        public static final String ICON = "icon";
        public static final String OWNER = "owner";
        public static final String LANG = "lang";
        public static final String FROM = "from";
        public static final String READTYPE = "readType";
        public static final String TYPE = "type";
        public static final String CRTAT = "crtAt";
        public static final String UPDAT = "updAt";
        public static final String DOWNAT = "downAt";
        public static final String SUMMARY = "summary";
        public static final String CONTENT = "content";
        public static final String BOOKCONCERN = "bookConcern";
        public static final String COPYRIGHT = "copyRight";
        public static final String ASCRIPTION = "ascription";
        public static final String PUBLICSHDATE = "publicshDate";
        public static final String PERIODVALIDITY = "periodValidity";
        public static final String CHIEFEDITOR = "chiefEditor";
        public static final String PERIODICAL = "periodical";
        public static final String DATEPUBLICATION = "datePublication";
        public static final String ORDER = "order";
        public static final String STATUS = "status";
        public static final String TAGS = "tags";
        public static final String ARTICLEID = "articleId";


        public static final int READTYPE_ADULT = 1;
        public static final int READTYPE_CHILDREN = 2;

        //状态定义
        public static final int STAUTS_OPEN = 1;
        public static final int STAUTS_DRAFT = 2;
        public static final int STAUTS_CLOSE = 9;
    }
}
