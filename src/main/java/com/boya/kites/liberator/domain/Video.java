package com.boya.kites.liberator.domain;

import com.boya.commons.TimeUitls;
import com.mongodb.BasicDBObject;
import org.bson.types.BasicBSONList;
import org.canedata.field.Fields;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created  IN BOYA by BaiLiJun on 14-10-11.
 */
public class Video implements Serializable, Base<Video> {

    private static final long serialVersionUID = -7683428951868158476L;
    private String id;
    private String owner;
    private long crtAt;
    private long updAt;
    private String updAtDate;
    private String url;
    private int type;
    private String lang;
    private Clazz root;
    private List<Clazz> subClazzes;
    private int status;
    private String onlineAt;
    private int ep;//是否分级
    private List<Ep> options;
    private String subTitle;
    //评分
    private double score;
    //播放次数
    private String pcount;
    private List<Locale> locales;
    private String subject;
    private List<String> cover;
    private String icon;
    private String area;
    private double[] areall;
    private String areaLabel;
    private String content;
    private String summary;
    private List<String> kw;
    private String lan;
    private List<String> tags;
    private String director;
    private String actor;
    private int order;
    private String genres;

    public String getUpdAtDate() {
        return updAtDate;
    }

    public void setUpdAtDate(String updAtDate) {
        this.updAtDate = updAtDate;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public List<Locale> getLocales() {
        return locales;
    }

    public void setLocales(List<Locale> locales) {
        this.locales = locales;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getPcount() {
        return pcount;
    }

    public void setPcount(String pcount) {
        this.pcount = pcount;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    private Map<String, List<Map<String, String>>> i18ns;

    public Map<String, List<Map<String, String>>> getI18ns() {
        return i18ns;
    }

    public void setI18ns(Map<String, List<Map<String, String>>> i18ns) {
        this.i18ns = i18ns;
    }

    public List<Ep> getOptions() {
        return options;
    }

    public void setOptions(List<Ep> options) {
        this.options = options;
    }

    public int getEp() {
        return ep;
    }

    public void setEp(int ep) {
        this.ep = ep;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public String getOnlineAt() {
        return onlineAt;
    }

    public void setOnlineAt(String onlineAt) {
        this.onlineAt = onlineAt;
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

    /**
     * 这里只是获取与国际化无关的数据
     *
     * @param field
     * @return
     */
    @Override
    public Video fill(Fields field) {
        Video video = null;
        if (null != field) {
            video = new Video();
            video.setId(field.getString("_id"));
            if (null != field.get(Meta.CRTAT))
                video.setCrtAt(field.getLong(Meta.CRTAT));
            if (null != field.get(Meta.UPDAT))
                video.setUpdAt(field.getLong(Meta.UPDAT));
            if (null != field.get(Meta.UPDAT))
                video.setUpdAtDate(TimeUitls.getInterval(field.getLong(Meta.UPDAT)));
            if (null != field.get(Meta.COVER)) {

                BasicBSONList covers = field.get(Meta.COVER);
                video.setCover(cover);
            }
            if (null != field.get(Meta.ISEP)) {
                video.setEp(field.getInt(Meta.ISEP));
            }
            video.setIcon(field.getString(Meta.ICON));
            if (null != field.get(Meta.PCOUNT)) {
                video.setPcount(field.getString(Meta.PCOUNT));
            } else {
                video.setPcount("1000+");
            }
            if (null != field.get(Meta.SCORE)) {
                video.setScore(field.getDouble(Meta.SCORE));
            } else {
                video.setScore(7.5f);
            }

            if (null != field.get("c")) {
                BasicDBObject c = field.get("c");
                BasicDBObject root = (BasicDBObject) c.get(Meta.ROOT);

                Clazz clazz = new Clazz();
                clazz.setId(root.getString("id"));
                video.setRoot(clazz);

                if (null != c.get("s")) {
                    BasicBSONList basicBSONList = (BasicBSONList) c.get("s");
                    List<Clazz> subClazzes = new ArrayList<Clazz>();
                    for (int i = 0; i < basicBSONList.size(); i++) {
                        BasicDBObject basicDBObject = (BasicDBObject) basicBSONList.get(i);
                        Clazz clazz1 = new Clazz();
                        clazz1.setId(basicDBObject.getString("id"));
                        subClazzes.add(clazz1);
                    }
                    video.setSubClazzes(subClazzes);
                }
            }

            if (null != field.get(Meta.OPTIONS)) {
                BasicBSONList list = field.get(Meta.OPTIONS);
                List<Ep> options = new ArrayList<>();
                for (int i = 0; i < list.size(); i++) {
                    BasicDBObject _temp = (BasicDBObject) list.get(i);
                    Ep ep = new Ep();
                    if (null != _temp.get("name")) {
                        ep.setName(_temp.getString("name"));
                    }

                    ep.setEp(_temp.getString("ep"));
                    if (null != _temp.get("subject")) {
                        ep.setSubject(_temp.getString("subject"));
                    }
                    ep.setUrl(_temp.getString("url"));
                    if (null != _temp.get("summary")) {
                        ep.setSummary(_temp.getString("summary"));
                    }
                    BasicBSONList listCover = (BasicBSONList) _temp.get("cover");
                    List<String> cover = new ArrayList<>();
                    for (int j = 0; listCover.size() > j; j++) {
                        cover.add((String) listCover.get(j));
                    }
                    ep.setCover(cover);
                    options.add(ep);

                }
                video.setOptions(options);
            }
            video.setOnlineAt(field.getString(Meta.ONLINEAT));
            video.setStatus(field.getInt(Meta.STATUS));
            video.setUrl(field.getString(Meta.URL));
        }
        return video;

    }

    /**
     * 这里获取全部数据
     *
     * @param field
     * @return
     */
    public Video fills(Fields field) {

        Video video = null;
        if (null != field) {
            video = new Video();
            video.setId(field.getString("_id"));
            if (null != field.get(Meta.CRTAT))
                video.setCrtAt(field.getLong(Meta.CRTAT));
            if (null != field.get(Meta.UPDAT))
                video.setUpdAt(field.getLong(Meta.UPDAT));
            if (null != field.get(Meta.UPDAT))
                video.setUpdAtDate(TimeUitls.getInterval(field.getLong(Meta.UPDAT)));
            if (null != field.get(Meta.OWNER))
                video.setOwner(field.getString(Meta.OWNER));
            if (null != field.get(Meta.URL))
                video.setUrl(field.getString(Meta.URL));
            if (null != field.get(Meta.TYPE))
                video.setType(field.getInt(Meta.TYPE));
            if (null != field.get(Meta.LANG))
                video.setLang(field.getString(Meta.LANG));
            if (null != field.get(Meta.STATUS))
                video.setStatus(field.getInt(Meta.STATUS));
            if (null != field.get(Meta.ONLINEAT))
                video.setOnlineAt(field.getString(Meta.ONLINEAT));
            if (null != field.get(Meta.ISEP))
                video.setEp(field.getInt(Meta.ISEP));
            if (null != field.get(Meta.ORDER))
                video.setOrder(field.getInt(Meta.ORDER));
            if (null != field.get(Meta.SCORE)) {
                video.setScore(field.getDouble(Meta.SCORE));
            } else {
                video.setScore(7.5f);
            }
            if (null != field.get(Meta.PCOUNT))
                video.setPcount(field.getString(Meta.PCOUNT));

            if (null != field.get("c")) {
                BasicDBObject c = field.get("c");
                BasicDBObject root = (BasicDBObject) c.get(Meta.ROOT);

                Clazz clazz = new Clazz();
                clazz.setId(root.getString("id"));
                video.setRoot(clazz);

                if (null != c.get("s")) {
                    BasicBSONList basicBSONList = (BasicBSONList) c.get("s");
                    List<Clazz> subClazzes = new ArrayList<Clazz>();
                    for (int i = 0; i < basicBSONList.size(); i++) {
                        BasicDBObject basicDBObject = (BasicDBObject) basicBSONList.get(i);
                        Clazz clazz1 = new Clazz();
                        clazz1.setId(basicDBObject.getString("id"));
                        subClazzes.add(clazz1);
                    }
                    video.setSubClazzes(subClazzes);
                }
            }

            if (null != field.get(Meta.OPTIONS)) {
                BasicBSONList list = field.get(Meta.OPTIONS);
                List<Ep> options = new ArrayList<>();
                for (int i = 0; i < list.size(); i++) {
                    BasicDBObject _temp = (BasicDBObject) list.get(i);
                    Ep ep = new Ep();
                    if (null != _temp.get("name")) {
                        ep.setName(_temp.getString("name"));
                    }
                    if (null != _temp.get("order")) {
                        ep.setOrder(_temp.getInt("order"));
                    }
                    if (null != _temp.get("ep")) {
                        ep.setEp(_temp.getString("ep"));
                    }
                    if (null != _temp.get("subject")) {
                        ep.setSubject(_temp.getString("subject"));
                    }
                    if (null != _temp.get("url")) {
                        ep.setUrl(_temp.getString("url"));
                    }
                    if (null != _temp.get("summary")) {
                        ep.setSummary(_temp.getString("summary"));
                    }
                    BasicBSONList listCover = (BasicBSONList) _temp.get("cover");
                    List<String> cover = new ArrayList<>();
                    if (null != listCover) {
                        for (int j = 0; listCover.size() > j; j++) {
                            cover.add((String) listCover.get(j));
                        }
                    }
                    ep.setCover(cover);
                    options.add(ep);
                }
                video.setOptions(options);
            }

            if (null != field.get(Meta.LOCALES)) {
                BasicBSONList list = field.get(Meta.LOCALES);
                List<Locale> locales = new ArrayList<>();
                for (int i = 0; i < list.size(); i++) {
                    BasicDBObject t = (BasicDBObject) list.get(i);
                    Locale l = new Locale();
                    if (null != t.get("lang") && "cn".equals(t.getString("lang"))) {
                        video.setSubject(t.getString("subject"));
                        video.setIcon(t.getString("icon"));
                    }

                    if (null != t.get("lang")) {
                        l.setLang(t.getString("lang"));
                    }
                    if (null != t.get("subject")) {
                        l.setSubject(t.getString("subject"));
                    }
                    if (null != t.get("subTitle")) {
                        l.setSubTitle(t.getString("subTitle"));
                    }
                    if (null != t.get("icon")) {
                        l.setIcon(t.getString("icon"));
                    }
                    if (null != t.get("language")) {
                        l.setLanguage(t.getString("language"));
                    }
                    if (null != t.get("area")) {
                        l.setArea(t.getString("area"));
                    }
                    if (null != t.get("areaLabel")) {
                        l.setAreaLabel(t.getString("areaLabel"));
                    }
                    if (null != t.get("content")) {
                        l.setContent(t.getString("content"));
                    }
                    if (null != t.get("summary")) {
                        l.setSummary(t.getString("summary"));
                    }
                    if (null != t.get("director")) {
                        l.setDirector(t.getString("director"));
                    }
                    if (null != t.get("actor")) {
                        l.setActor(t.getString("actor"));
                    }
                    if (null != t.get("genres")) {
                        l.setGenres(t.getString("genres"));
                    }
                    List<String> listCover = new ArrayList<String>();
                    if (null != t.get("cover")) {
                        BasicBSONList listC = (BasicBSONList) t.get(Meta.COVER);
                        for (int j = 0; listC.size() > j; j++) {
                            listCover.add((String) listC.get(j));
                        }
                        l.setCover(listCover);
                    }
                    List<String> listKw = new ArrayList<String>();
                    if (null != t.get("kw")) {
                        BasicBSONList listC = (BasicBSONList) t.get(Meta.KW);
                        for (int j = 0; listC.size() > j; j++) {
                            listKw.add((String) listC.get(j));
                        }
                        l.setKw(listKw);
                    }
                    List<String> listTags = new ArrayList<String>();
                    if (null != t.get("tags")) {
                        BasicBSONList listC = (BasicBSONList) t.get(Meta.TAGS);
                        for (int j = 0; listC.size() > j; j++) {
                            listTags.add((String) listC.get(j));
                        }
                        l.setTags(listTags);
                    }

                    if (null != t.get("areall")) {
                        BasicBSONList listC = (BasicBSONList) t.get(Meta.AREALL);
                        if (listC.size() >= 2) {
                            l.setLat((Double) listC.get(0));
                            l.setLnt((Double) listC.get(1));
                        }
                    }
                    locales.add(l);
                }
                video.setLocales(locales);
            }
        }
        return video;
    }

    public static class Ep implements Serializable {

        private static final long serialVersionUID = -7683428951868158476L;
        private String url;
        private String subject;
        private String summary;
        private String name;
        private String ep;
        private int order;
        private List<String> cover;

        public List<String> getCover() {
            return cover;
        }

        public void setCover(List<String> cover) {
            this.cover = cover;
        }

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
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

        public String getEp() {
            return ep;
        }

        public void setEp(String ep) {
            this.ep = ep;
        }
    }

    public static class Locale implements Serializable {

        private static final long serialVersionUID = -7683428951868158476L;
        private String lang;
        private String subject;
        private String icon;
        private List<String> cover;
        private String language;
        private String area;
        private Double lat;
        private Double lnt;
        private String subTitle;
        private String areaLabel;
        private String content;
        private String summary;
        private List<String> kw;
        private List<String> tags;
        private String director;
        private String actor;
        private String genres;

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public String getSubTitle() {
            return subTitle;
        }

        public void setSubTitle(String subTitle) {
            this.subTitle = subTitle;
        }

        public String getLang() {
            return lang;
        }

        public void setLang(String lang) {
            this.lang = lang;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public List<String> getCover() {
            return cover;
        }

        public void setCover(List<String> cover) {
            this.cover = cover;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public Double getLat() {
            return lat;
        }

        public void setLat(Double lat) {
            this.lat = lat;
        }

        public Double getLnt() {
            return lnt;
        }

        public void setLnt(Double lnt) {
            this.lnt = lnt;
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
    }

    public static final class Meta {
        public static final String TABLENAME = "videos";
        public static final String ID = "id";
        public static final String OWNER = "owner";
        public static final String CRTAT = "crtAt";
        public static final String UPDAT = "updAt";
        public static final String URL = "url";
        public static final String ROOT = "r";
        public static final String SUBCLAZZ = "s";
        public static final String STATUS = "status";
        public static final String ONLINEAT = "onlineAt";
        public static final String SUBJECT = "subject";
        public static final String COVER = "cover";
        public static final String TYPE = "type";
        public static final String ICON = "icon";
        public static final String AREA = "area";
        public static final String AREALL = "areall";
        public static final String AREALABEL = "areaLabel";
        public static final String CONTENT = "content";
        public static final String SUMMARY = "summary";
        public static final String KW = "kw";
        public static final String LANG = "lang";
        public static final String LANGUAGE = "language";
        public static final String TAGS = "tags";
        public static final String DIRECTOR = "director";
        public static final String ACTOR = "actor";
        public static final int STATUS_ON = 1;
        public static final int STATUS_OFF = 2;
        public static final String ORDER = "order";
        public static final String ISEP = "ep";
        public static final int EP_NO = 0;
        public static final int EP_YES = 1;
        public static final String OPTIONS = "options";
        public static final String SUBTITLE = "subTitle";
        public static final String LOCALES = "locales";
        public static final String GENRES = "genres";
        public static final String SCORE = "score";
        public static final String PCOUNT = "pcount";
    }
}
