package com.boya.kites.liberator.domain;

import org.bson.types.BasicBSONList;
import org.canedata.field.Fields;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created  IN BOYA by ole on 15-6-3.
 */
public class Music implements Serializable, Base<Music> {

    private static final long serialVersionUID;

    static {
        serialVersionUID = -5809782578272943999L;
    }

    private String id;
    private String owner;
    private long crtAt;
    private long updAt;
    private String url;
    private String lrc;
    private List<String> cover;
    private String covers;
    private Clazz root;
    private List<Clazz> subClazzes;
    private int status;
    private String onlineAt;
    private double[] areall;
    private String areaLabel;
    private String name;
    private String artist;
    private String composer;
    private String language;
    private String arranger;
    private String musicsType;
    private String musicsStyle;
    private List<String> tags;
    private String lyricist;
    private String summary;
    private String content;
    private String prodution;

    public String getCovers() {
        return covers;
    }

    public void setCovers(String covers) {
        this.covers = covers;
    }

    public String getLrc() {
        return lrc;
    }

    public void setLrc(String lrc) {
        this.lrc = lrc;
    }

    public List<String> getCover() {
        return cover;
    }

    public void setCover(List<String> cover) {
        this.cover = cover;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getArranger() {
        return arranger;
    }

    public void setArranger(String arranger) {
        this.arranger = arranger;
    }

    public String getMusicsType() {
        return musicsType;
    }

    public void setMusicsType(String musicsType) {
        this.musicsType = musicsType;
    }

    public String getMusicsStyle() {
        return musicsStyle;
    }

    public void setMusicsStyle(String musicsStyle) {
        this.musicsStyle = musicsStyle;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getLyricist() {
        return lyricist;
    }

    public void setLyricist(String lyricist) {
        this.lyricist = lyricist;
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

    public String getProdution() {
        return prodution;
    }

    public void setProdution(String prodution) {
        this.prodution = prodution;
    }

    @Override
    public Music fill(Fields field) {
        Music a = null;
        if (null != field) {
            a = new Music();
            a.setId(field.getString("_" + Meta.ID));
            if (null != field.get(Meta.OWNER)) a.setOwner(field.getString(Meta.OWNER));
            if (null != field.get(Meta.CRTAT)) a.setCrtAt(field.getLong(Meta.CRTAT));
            if (null != field.get(Meta.UPDAT)) a.setUpdAt(field.getLong(Meta.UPDAT));
            if (null != field.get(Meta.URL)) a.setUrl(field.getString(Meta.URL));
            if (null != field.get(Meta.STATUS)) a.setStatus(field.getInt(Meta.STATUS));
            if (null != field.get(Meta.ONLINEAT)) a.setOnlineAt(field.getString(Meta.ONLINEAT));
            if (null != field.get(Meta.AREALABEL)) a.setAreaLabel(field.getString(Meta.AREALABEL));
            if (null != field.get(Meta.NAME)) a.setName(field.getString(Meta.NAME));
            if (null != field.get(Meta.ARTIST)) a.setArtist(field.getString(Meta.ARTIST));
            if (null != field.get(Meta.COMPOSER)) a.setComposer(field.getString(Meta.COMPOSER));
            if (null != field.get(Meta.LANGUAGE)) a.setLanguage(field.getString(Meta.LANGUAGE));
            if (null != field.get(Meta.ARRANGER)) a.setArranger(field.getString(Meta.ARRANGER));
            if (null != field.get(Meta.MUSICSTYPE)) a.setMusicsType(field.getString(Meta.MUSICSTYPE));
            if (null != field.get(Meta.MUSICSSTYLE)) a.setMusicsStyle(field.getString(Meta.MUSICSSTYLE));
            if (null != field.get(Meta.LYRICIST)) a.setLyricist(field.getString(Meta.LYRICIST));
            if (null != field.get(Meta.SUMMARY)) a.setSummary(field.getString(Meta.SUMMARY));
            if (null != field.get(Meta.CONTENT)) a.setContent(field.getString(Meta.CONTENT));
            if (null != field.get(Meta.PRODUCTION)) a.setProdution(field.getString(Meta.PRODUCTION));
            if (null != field.get(Meta.LRC)) a.setLrc(field.getString(Meta.LRC));


            BasicBSONList listCover = (BasicBSONList) field.get(Meta.COVER);
            List<String> cover = new ArrayList<>();
            if (null != listCover) {
                for (int j = 0; listCover.size() > j; j++) {
                    cover.add((String) listCover.get(j));
                }
            }
            a.setCover(cover);
            a.setCovers(a.getCover().get(0));

            BasicBSONList listtags = (BasicBSONList) field.get(Meta.TAGS);
            List<String> tags = new ArrayList<>();
            if (null != listtags) {
                for (int j = 0; listtags.size() > j; j++) {
                    tags.add((String) listtags.get(j));
                }
            }
            a.setTags(tags);
        }
        return a;
    }

    public static final class Meta {
        public static final String TABLENAME = "musics";
        public static final String ID = "id";
        public static final String OWNER = "owner";
        public static final String CRTAT = "crtAt";
        public static final String COVER = "cover";
        public static final String UPDAT = "updAt";
        public static final String URL = "url";
        public static final String LRC = "lrc";
        public static final String ROOT = "r";
        public static final String SUBCLAZZ = "s";
        public static final String STATUS = "status";
        public static final String ONLINEAT = "onlineAt";
        public static final String AREALL = "areall";
        public static final String AREALABEL = "areaLabel";
        public static final String NAME = "name";
        public static final String ARTIST = "artist";
        public static final String COMPOSER = "composer";
        public static final String LANGUAGE = "language";
        public static final String ARRANGER = "arranger";
        public static final String MUSICSTYPE = "musicsType";
        public static final String MUSICSSTYLE = "musicsStyle";
        public static final String TAGS = "tags";
        public static final String LYRICIST = "lyricist";
        public static final String SUMMARY = "summary";
        public static final String CONTENT = "content";
        public static final String PRODUCTION = "production";
        public static final int STATUS_ON = 1;
        public static final int STATUS_OFF = 2;
    }
}
