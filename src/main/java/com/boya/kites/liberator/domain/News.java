package com.boya.kites.liberator.domain;

import com.boya.commons.TimeUitls;
import com.mongodb.BasicDBObject;
import org.bson.types.BasicBSONList;
import org.canedata.field.Fields;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created  IN BOYA by BaiLiJun on 14-10-11.
 */
public class News implements Serializable, Base<News>, Comparable<News> {

    private static final long serialVersionUID;

    static {
        serialVersionUID = -5809782578272943999L;
    }

    private String id;
    private String owner;
    private long crtAt;
    private long updAt;
    private Clazz root;
    private int type;
    private List<Clazz> subClazzes;
    private int status;
    private String subject;
    private List<String> cover;
    private String icon;
    private String area;
    private long oat;
    private String oatDate;
    private double[] areall;
    private String areaLabel;
    private String content;
    private String title;
    private String subTitle;
    private String summary;
    private List<String> kw;
    private String lan;
    private List<String> tags;
    private int alone;
    private List<News> seminar;
    private int rec;
    private String author;
    private String source;
    private long hash;
    private long trans;
    private long mirror;
    private List<I18n> locales;
    private int hot;
    private boolean hasLink;
    private String url;
    //第三方id

    String tid;
    //封面标准1.普标2.固标（315*240）
    private int coverStandard;

    public int getCoverStandard() {
        return coverStandard;
    }

    public void setCoverStandard(int coverStandard) {
        this.coverStandard = coverStandard;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getOatDate() {
        return oatDate;
    }

    public void setOatDate(String oatDate) {
        this.oatDate = oatDate;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public List<I18n> getLocales() {
        return locales;
    }

    public void setLocales(List<I18n> locales) {
        this.locales = locales;
    }

    public long getHash() {
        return hash;
    }

    public void setHash(long hash) {
        this.hash = hash;
    }

    public long getTrans() {
        return trans;
    }

    public void setTrans(long trans) {
        this.trans = trans;
    }

    public long getMirror() {
        return mirror;
    }

    public void setMirror(long mirror) {
        this.mirror = mirror;
    }

    public boolean isHasLink() {
        return hasLink;
    }

    public void setHasLink(boolean hasLink) {
        this.hasLink = hasLink;
    }

    public int getHot() {
        return hot;
    }

    public void setHot(int hot) {
        this.hot = hot;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    private List<NewsPic> pics;

    public List<NewsPic> getPics() {
        return pics;
    }

    public void setPics(List<NewsPic> pics) {
        this.pics = pics;
    }

    public int getRec() {
        return rec;
    }

    public void setRec(int rec) {
        this.rec = rec;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
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

    public Clazz getRoot() {
        return root;
    }

    public void setRoot(Clazz root) {
        this.root = root;
    }

    public List<Clazz> getSubClazzes() {
        return subClazzes;
    }

    public void setSubClazzes(List<Clazz> subClazzes) {
        this.subClazzes = subClazzes;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public List<String> getCover() {
        return cover;
    }

    public void setCover(List<String> cover) {
        this.cover = cover;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public double[] getAreall() {
        return areall;
    }

    public void setAreall(double[] areall) {
        this.areall = areall;
    }

    public String getAreaLabel() {
        return areaLabel;
    }

    public void setAreaLabel(String areaLabel) {
        this.areaLabel = areaLabel;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
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

    public String getLan() {
        return lan;
    }

    public void setLan(String lan) {
        this.lan = lan;
    }

    public long getOat() {
        return oat;
    }

    public void setOat(long oat) {
        this.oat = oat;
    }

    public int getAlone() {
        return alone;
    }

    public void setAlone(int alone) {
        this.alone = alone;
    }

    public List<News> getSeminar() {
        return seminar;
    }

    public void setSeminar(List<News> seminar) {
        this.seminar = seminar;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public News fill(Fields field) {
        News news = null;
        if (null != field) {
            news = new News();
            news.setId(field.getString("_id"));
            news.setArea(field.getString(Meta.AREA));
            news.setAreaLabel(field.getString(Meta.AREALABEL));
            news.setCrtAt(field.getLong(Meta.CRTAT));
            news.setIcon(field.getString(Meta.ICON));
            news.setLan(field.getString(Meta.LANG));
            news.setUpdAt(field.getLong(Meta.UPDAT));
            news.setAlone(field.getInt(Meta.ALONE));
            news.setSource(field.getString(News.Meta.SOURCE));
            news.setType(field.getInt(Meta.TYPE));
            news.setTid(field.get("tid")!=null?field.getString("tid"):"");
            //默认都为普通标准
            news.setCoverStandard(null != field.get(Meta.COVERSTANDARD) ? field.getInt(Meta.COVERSTANDARD) : 1);
            if (null != field.get(Meta.STATUS)) {
                news.setStatus(field.getInt(Meta.STATUS));
            }
            news.setAuthor(field.getString(Meta.AUTHOR));
            if (null != field.get(Meta.HOT)) {
                news.setHot(field.getInt(Meta.HOT));
            }
            news.setOat((new Date(field.getLong(Meta.OAT))).getTime());
            news.setOatDate(TimeUitls.getInterval(field.getLong(Meta.OAT) * 1000));
            news.setRec(field.getInt(Meta.REC));
            news.setHasLink(field.getBoolean(Meta.HASLINK));
            news.setUrl(null != field.get(Meta.URL) ? field.getString(Meta.URL) : "");
            if (news.type == Meta.TYPE_PIC) {
                BasicDBObject options = field.get("options");
                if (null != options) {
                    BasicBSONList pic = (BasicBSONList) options.get("pic");
                    if (null != pic) {
                        List<NewsPic> pics = new ArrayList<>();
                        for (int i = 0; i < pic.size(); i++) {
                            BasicDBObject temp = (BasicDBObject) pic.get(i);
                            NewsPic newsPic = new NewsPic();
                            newsPic.setCover(temp.getString("cover"));
                            newsPic.setOrder(temp.getInt("order"));
                            newsPic.setContent(temp.getString("content"));
                            pics.add(newsPic);
                        }
                        Collections.sort(pics);
                        news.setPics(pics);
                    }
                }
            }
            BasicBSONList locales = (BasicBSONList) field.get("locales");
            if (null != locales) {
                for (int i = 0; i < locales.size(); i++) {
                    BasicDBObject n = (BasicDBObject) locales.get(i);
                    if (null != n && "cn".equals(n.getString("lang"))) {
                        //news.setSubject(n.getString("subject").replace("'","").replace("\"",""));
                        news.setSubject(n.getString("subject"));
                        news.setIcon(null == n.getString("icon") ? "" : n.getString("icon"));
                        news.setUrl(null == n.getString("url") ? "" : n.getString("url"));
                    }
                }
            }
        }
        return news;
    }

    @Override
    public int compareTo(News o) {
        if (o.getRoot().getOrder() < this.root.getOrder()) {
            return 1;
        } else if (o.getRoot().getOrder() > this.root.getOrder()) {
            return -1;
        } else {
            if (this.updAt > o.updAt)
                return 1;
            if (this.updAt < o.updAt)
                return -1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        News other = (News) obj;
        return this.id.equals(other.getId());
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    public static final class Meta {
        public static final String TABLENAME = "news";
        public static final String ID = "id";
        public static final String OWNER = "owner";
        public static final String SOURCE = "source";
        public static final String CRTAT = "crtAt";
        public static final String UPDAT = "updAt";
        public static final String ROOT = "r";
        public static final String SUBCLAZZ = "s";
        public static final String STATUS = "status";
        public static final String SUBJECT = "subject";
        public static final String COVER = "cover";
        public static final String ICON = "icon";
        public static final String AREA = "area";
        public static final String AREALL = "areall";
        public static final String AREALABEL = "areaLabel";
        public static final String CONTENT = "content";
        public static final String SUBTITLE = "subTitle";
        public static final String SUMMARY = "summary";
        public static final String KW = "kw";
        public static final String LANG = "lang";
        public static final String TAGS = "tags";
        public static final String ALONE = "alone";
        public static final String SEMINAR = "seminar";
        public static final String TYPE = "type";
        public static final int TYPE_TEXT = 1;
        public static final int TYPE_PIC = 2;
        public static final int TYPE_VIDEO = 3;
        public static final int TYPE_SEMINAR = 4;
        public static final String LOCALES = "locales";
        public static final String REC = "rec";
        public static final int REC_NO = 1;
        public static final int REC_YES = 2;
        public static final String AUTHOR = "author";
        public static final String HOT = "hot";
        public static final int HOT_YES = 1;
        public static final int HOT_NO = 0;
        public static final String HASLINK = "hasLink";
        public static final String HASH = "hash";
        public static final String TRANS = "trans";
        public static final String MIRROR = "mirror";
        public static final String OAT = "oat";
        public static final int STATUS_ON = 0;
        public static final int STATUS_OFF = -9;
        public static final String URL = "url";
        public static final String COVERSTANDARD = "coverStandard";
    }

    public static class NewsPic implements Serializable, Comparable<NewsPic> {

        private static final long serialVersionUID;

        static {
            serialVersionUID = -5809782578272943999L;
        }

        private String cover;
        private String content;
        private int order;

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        @Override
        public int compareTo(NewsPic o) {
            if (this.order < o.order)
                return -1;
            if (this.order > o.order)
                return 1;
            return 0;
        }

        @Override
        public int hashCode() {
            return this.content.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }
    }

    public static class I18n implements Serializable {

        private static final long serialVersionUID;

        static {
            serialVersionUID = -5809782578272943999L;
        }

        private String content;
        private String title;
        private String subTitle;
        private String summary;
        private List<String> kw;
        private String author;
        private String lang;
        private List<String> tags;
        private List<String> covers;
        private String icon;
        private String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
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

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSubTitle() {
            return subTitle;
        }

        public void setSubTitle(String subTitle) {
            this.subTitle = subTitle;
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

        public String getLang() {
            return lang;
        }

        public void setLang(String lang) {
            this.lang = lang;
        }

        public List<String> getTags() {
            return tags;
        }

        public void setTags(List<String> tags) {
            this.tags = tags;
        }
    }
}
