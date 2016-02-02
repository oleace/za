package com.boya.kites.liberator.domain;

import com.mongodb.BasicDBObject;
import org.bson.types.BasicBSONList;
import org.canedata.field.Fields;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created  IN BOYA by lz on 15-5-22.
 */
public class Magazine_article implements Serializable, Base<Magazine_article> {

    private static final long serialVersionUID;

    static {
        serialVersionUID = -5809782578272943999L;
    }

    private String id;
    private String tid;
    private String name;
    private List<String> covers;
    private String icon;
    private String owner;
    private String bbsSection;
    private String lang;
    private int type;//1原文2原广3原创4软广
    private int isAd;
    private long adsAt;
    private long adeAt;
    private int isHeadline;
    private int isBoutique;
    private long crtAt;
    private long updAt;
    private String summary;
    private List<Content> content;
    private Display display;
    private long publishDate;
    private String author;
    private int order;
    private int status;//1上架2待上架9下架
    private List<String> tags;

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

    public String getBbsSection() {
        return bbsSection;
    }

    public void setBbsSection(String bbsSection) {
        this.bbsSection = bbsSection;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getIsAd() {
        return isAd;
    }

    public void setIsAd(int isAd) {
        this.isAd = isAd;
    }

    public long getAdsAt() {
        return adsAt;
    }

    public void setAdsAt(long adsAt) {
        this.adsAt = adsAt;
    }

    public long getAdeAt() {
        return adeAt;
    }

    public void setAdeAt(long adeAt) {
        this.adeAt = adeAt;
    }

    public int getIsHeadline() {
        return isHeadline;
    }

    public void setIsHeadline(int isHeadline) {
        this.isHeadline = isHeadline;
    }

    public int getIsBoutique() {
        return isBoutique;
    }

    public void setIsBoutique(int isBoutique) {
        this.isBoutique = isBoutique;
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

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public List<Content> getContent() {
        return content;
    }

    public void setContent(List<Content> content) {
        this.content = content;
    }

    public Display getDisplay() {
        return display;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }

    public long getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(long publishDate) {
        this.publishDate = publishDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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

    public static class Display implements Serializable {

        private static final long serialVersionUID;

        static {
            serialVersionUID = -5809782578272943999L;
        }

        private int type;
        private int style;

        public int getStyle() {
            return style;
        }

        public void setStyle(int style) {
            this.style = style;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }

    public static class Content implements Serializable {

        private static final long serialVersionUID;

        static {
            serialVersionUID = -5809782578272943999L;
        }

        private String content;
        private int page;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }
    }

    /**
     * 这里获取全部数据
     *
     * @param field
     * @return
     */
    @Override
    public Magazine_article fill(Fields field) {
        Magazine_article tc = null;
        if (null != field) {
            tc = new Magazine_article();
            tc.setId(field.getString("_" + Meta.ID));
            if (null != field.get(Meta.TID)) tc.setTid(field.getString(Meta.TID));
            if (null != field.get(Meta.NAME)) tc.setName(field.getString(Meta.NAME));

            BasicBSONList listCover = (BasicBSONList) field.get(Meta.COVERS);
            List<String> cover = new ArrayList<>();
            if (null != listCover) {
                for (int j = 0; listCover.size() > j; j++) {
                    cover.add((String) listCover.get(j));
                }
            }
            tc.setCovers(cover);

            if (null != field.get(Meta.ICON)) tc.setIcon(field.getString(Meta.ICON));
            if (null != field.get(Meta.OWNER)) tc.setOwner(field.getString(Meta.OWNER));
            if (null != field.get(Meta.BBSSECTION)) tc.setBbsSection(field.getString(Meta.BBSSECTION));
            if (null != field.get(Meta.LANG)) tc.setLang(field.getString(Meta.LANG));
            if (null != field.get(Meta.TYPE)) tc.setType(field.getInt(Meta.TYPE));
            if (null != field.get(Meta.ISAD)) tc.setIsAd(field.getInt(Meta.ISAD));
            if (null != field.get(Meta.ADSAT)) tc.setAdsAt(field.getLong(Meta.ADSAT));
            if (null != field.get(Meta.ADEAT)) tc.setAdeAt(field.getLong(Meta.ADEAT));
            if (null != field.get(Meta.ISHEADLINE)) tc.setIsHeadline(field.getInt(Meta.ISHEADLINE));
            if (null != field.get(Meta.ISBOUTIQUE)) tc.setIsBoutique(field.getInt(Meta.ISBOUTIQUE));
            if (null != field.get(Meta.CRTAT)) tc.setCrtAt(field.getLong(Meta.CRTAT));
            if (null != field.get(Meta.UPDAT)) tc.setUpdAt(field.getLong(Meta.UPDAT));
            if (null != field.get(Meta.SUMMARY)) tc.setSummary(field.getString(Meta.SUMMARY));
            if (null != field.get(Meta.PUBLISHDATE)) tc.setPublishDate(field.getLong(Meta.PUBLISHDATE));
            if (null != field.get(Meta.AUTHOR)) tc.setAuthor(field.getString(Meta.AUTHOR));
            if (null != field.get(Meta.ORDER)) tc.setOrder(field.getInt(Meta.ORDER));
            if (null != field.get(Meta.STATUS)) tc.setStatus(field.getInt(Meta.STATUS));

            BasicBSONList listcon = field.get(Meta.CONTENTS);
            List<Content> listcontent = new ArrayList<Content>();
            if (null != listcon) {
                for (int i = 0; listcon.size() > i; i++) {
                    BasicDBObject bd = (BasicDBObject) listcon.get(i);
                    Content content = new Content();
                    content.setContent(bd.getString(Meta.CONTENT));
                    content.setPage(bd.getInt(Meta.PAGE));
                    listcontent.add(content);
                }
            }
            tc.setContent(listcontent);

            if (null != field.get(Meta.DISPLAY)) {
                Display display1 = new Display();
                BasicDBObject bdis = field.get(Meta.DISPLAY);
                if (null != bdis) {
                    if (null != bdis.get(Meta.STYLE)) display1.setStyle(bdis.getInt(Meta.STYLE));
                    if (null != bdis.get(Meta.TYPE)) display1.setType(bdis.getInt(Meta.TYPE));
                    tc.setDisplay(display1);
                }
            }

            BasicBSONList listTags = (BasicBSONList) field.get(Meta.TAGS);
            List<String> tags = new ArrayList<>();
            if (null != listTags) {
                for (int j = 0; listTags.size() > j; j++) {
                    tags.add((String) listTags.get(j));
                }
            }
            tc.setTags(tags);
        }
        return tc;
    }

    public static final class Meta {
        public static final String TABLENAME = "magazine_article";
        public static final String ID = "id";
        public static final String TID = "tid";
        public static final String NAME = "name";
        public static final String COVERS = "covers";
        public static final String ICON = "icon";
        public static final String OWNER = "owner";
        public static final String BBSSECTION = "bbsSection";
        public static final String LANG = "lang";
        public static final String TYPE = "type";
        public static final String ISAD = "isAd";
        public static final String ADSAT = "adsAt";
        public static final String ADEAT = "adeAt";
        public static final String ISHEADLINE = "isHeadline";
        public static final String ISBOUTIQUE = "isBoutique";
        public static final String CRTAT = "crtAt";
        public static final String UPDAT = "updAt";
        public static final String SUMMARY = "summary";
        public static final String CONTENTS = "contents";
        public static final String CONTENT = "content";
        public static final String PAGE = "page";
        public static final String DISPLAY = "display";
        public static final String STYLE = "style";
        public static final String PUBLISHDATE = "publishDate";
        public static final String AUTHOR = "author";
        public static final String ORDER = "order";
        public static final String STATUS = "status";
        public static final String TAGS = "tags";

        //状态定义
        public static final int STAUTS_OPEN = 1;
        public static final int STAUTS_DRAFT = 2;
        public static final int STAUTS_CLOSE = 9;
    }
}
