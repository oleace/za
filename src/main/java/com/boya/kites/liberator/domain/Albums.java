package com.boya.kites.liberator.domain;

import org.bson.BasicBSONObject;
import org.bson.types.BasicBSONList;
import org.canedata.field.Fields;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created  IN BOYA by ole on 15-6-3.
 */
public class Albums implements Serializable, Base<Albums> {

    private static final long serialVersionUID;

    static {
        serialVersionUID = -5809782578272943999L;
    }

    private String id;
    private String owner;
    private String name;
    private long crtAt;
    private long updAt;
    private List<String> cover = new ArrayList<String>();
    private String artist;
    private String addr;
    private int status;
    private String onlineAt;
    private String production;
    private String content;
    private String pid;
    private int order;
    private String language;
    private String from;
    private String genre;
    private List<Item> items = new ArrayList<Item>();

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getCover() {
        return cover;
    }

    public void setCover(List<String> cover) {
        this.cover = cover;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
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

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public static class Item implements Serializable {

        private static final long serialVersionUID;

        static {
            serialVersionUID = -5809782578272943999L;
        }

        private String id;
        private String name;

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
    }

    @Override
    public Albums fill(Fields field) {
        Albums a = null;
        if (null != field) {
            a = new Albums();
            a.setId(field.getString("_" + Meta.ID));
            if (null != field.get(Meta.OWNER)) a.setOwner(field.getString(Meta.OWNER));
            if (null != field.get(Meta.NAME)) a.setName(field.getString(Meta.NAME));

            BasicBSONList listCover = (BasicBSONList) field.get(Meta.COVER);
            List<String> cover = new ArrayList<>();
            if (null != listCover) {
                for (int j = 0; listCover.size() > j; j++) {
                    cover.add((String) listCover.get(j));
                }
            }
            a.setCover(cover);

            if (null != field.get(Meta.ARTIST)) a.setArtist(field.getString(Meta.ARTIST));
            if (null != field.get(Meta.ADDR)) a.setAddr(field.getString(Meta.ADDR));
            if (null != field.get(Meta.STATUS)) a.setStatus(field.getInt(Meta.STATUS));
            if (null != field.get(Meta.ONLINEAT)) a.setOnlineAt(field.getString(Meta.ONLINEAT));
            if (null != field.get(Meta.PRODUCTION)) a.setProduction(field.getString(Meta.PRODUCTION));
            if (null != field.get(Meta.CONTENT)) a.setContent(field.getString(Meta.CONTENT));
            if (null != field.get(Meta.CRTAT)) a.setCrtAt(field.getLong(Meta.CRTAT));
            if (null != field.get(Meta.UPDAT)) a.setUpdAt(field.getLong(Meta.UPDAT));
            if (null != field.get(Meta.PID)) a.setPid(field.getString(Meta.PID));
            if (null != field.get(Meta.ORDER)) a.setOrder(field.getInt(Meta.ORDER));

            if (null != field.get(Meta.LANGUAGE)) a.setLanguage(field.getString(Meta.LANGUAGE));
            if (null != field.get(Meta.FROM)) a.setFrom(field.getString(Meta.FROM));
            if (null != field.get(Meta.GENRE)) a.setGenre(field.getString(Meta.GENRE));

            BasicBSONList listitems = (BasicBSONList) field.get(Meta.ITEMS);
            List<Item> items = new ArrayList<Item>();
            if (null != listitems) {
                for (int j = 0; listitems.size() > j; j++) {
                    BasicBSONObject bo = (BasicBSONObject) listitems.get(j);
                    Item i = new Item();
                    i.setId(bo.getString(Meta.ID));
                    i.setName(bo.getString(Meta.NAME));
                    items.add(i);
                }
            }
            a.setItems(items);
        }
        return a;
    }

    public static final class Meta {
        public static final String TABLENAME = "albums";
        public static final String ID = "id";
        public static final String OWNER = "owner";
        public static final String NAME = "name";
        public static final String CRTAT = "crtAt";
        public static final String UPDAT = "updAt";
        public static final String COVER = "cover";
        public static final String ARTIST = "artist";
        public static final String ADDR = "addr";
        public static final String STATUS = "status";
        public static final String ONLINEAT = "onlineAt";
        public static final String PRODUCTION = "production";
        public static final String CONTENT = "content";
        public static final String ITEMS = "items";
        public static final String PID = "pid";
        public static final String ORDER = "order";
        public static final String LANGUAGE = "language";
        public static final String FROM = "from";
        public static final String GENRE = "genre";
        public static final int STATUS_ON = 1;
        public static final int STATUS_OFF = 2;
    }
}
