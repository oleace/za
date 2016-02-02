package com.boya.kites.liberator.domain;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import org.canedata.field.Fields;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created  IN BOYA by BaiLiJun on 14/12/5.
 */
public class AppSeminar implements Base<AppSeminar> {
    private String id;
    private int environment;
    private int catalog;
    private String cover;
    private String icon;
    private String url;
    private String clazz;
    private String cname;
    private String owner;
    private String tid;
    private long updAt;
    //用于显示的格式化时间
    private String updAtDate;
    private List<Item> items;
    private Display display;
    private List<Locale> locales;
    private String lang;
    private String subject;
    private String summary;
    private int status;

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getUpdAtDate() {
        return updAtDate;
    }

    public void setUpdAtDate(String updAtDate) {
        this.updAtDate = updAtDate;
    }

    public List<Locale> getLocales() {
        return locales;
    }

    public void setLocales(List<Locale> locales) {
        this.locales = locales;
    }

    public int getEnvironment() {
        return environment;
    }

    public void setEnvironment(int environment) {
        this.environment = environment;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCatalog() {
        return catalog;
    }

    public void setCatalog(int catalog) {
        this.catalog = catalog;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public long getUpdAt() {
        return updAt;
    }

    public void setUpdAt(long updAt) {
        this.updAt = updAt;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Display getDisplay() {
        return display;
    }

    public void setDisplay(Display display) {
        this.display = display;
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

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public AppSeminar fill(Fields field) {
        AppSeminar as = null;
        if (null != field) {
            as = new AppSeminar();
            as.setId(field.getString("_" + Meta.ID));
            as.setEnvironment(field.getInt(Meta.ENVIRONMENT));
            as.setCatalog(field.getInt(Meta.CATALOG));
            as.setCover(field.getString(Meta.COVER));
            as.setIcon(field.getString(Meta.ICON));
            as.setUrl(field.getString(Meta.URL));
            as.setClazz(field.getString(Meta.CLAZZ));
            as.setOwner(field.getString(Meta.OWNER));
            as.setTid(field.getString(Meta.TID));
            as.setUpdAt(field.getLong(Meta.UPDAT));
            as.setUpdAtDate(formatSysmillis(field.getLong(Meta.UPDAT)));
            as.setStatus(field.getInt(Meta.STATUS));

            BasicDBObject basicDBObject = field.get(Meta.DISPLAY);
            Display display1 = new Display();
            if (null != basicDBObject) {
                display1.setStyle(basicDBObject.getInt(Meta.DISPLAY_STYLE));
                display1.setType(basicDBObject.getInt(Meta.DISPLAY_TYPE));
                as.setDisplay(display1);
            }

            BasicDBList bitems = field.get(Meta.ITEMS);
            List<Item> items = new ArrayList<>();
            for (int i = 0; i < bitems.size(); i++) {
                BasicDBObject bdb = (BasicDBObject) bitems.get(i);
                Item item = new Item();
                item.setType(bdb.getInt("type"));
                item.setId(bdb.getString("id"));
                if (null != bdb.get("name"))
                    item.setName(bdb.getString("name"));
                if (null != bdb.get("environment"))
                    item.setEnvironment(bdb.getInt("environment"));
                items.add(item);
            }
            as.setItems(items);

            BasicDBList locales = field.get("locales");
            if (null != locales) {
                BasicDBObject target = (BasicDBObject) locales.get(0);
                as.setSubject(target.getString(Meta.SUBJECT));
                as.setSummary(target.getString(Meta.SUMMARY));
                as.setLang(target.getString("lang"));
            }
        }
        return as;
    }

    public AppSeminar fills(Fields field) {
        AppSeminar as = null;
        if (null != field) {
            as = new AppSeminar();
            as.setId(field.getString("_" + Meta.ID));
            as.setEnvironment(field.getInt(Meta.ENVIRONMENT));
            as.setCatalog(field.getInt(Meta.CATALOG));
            as.setCover(field.getString(Meta.COVER));
            as.setIcon(field.getString(Meta.ICON));
            as.setUrl(field.getString(Meta.URL));
            as.setClazz(field.getString(Meta.CLAZZ));
            as.setOwner(field.getString(Meta.OWNER));
            as.setTid(field.getString(Meta.TID));
            as.setUpdAt(field.getLong(Meta.UPDAT));
            as.setUpdAtDate(formatSysmillis(field.getLong(Meta.UPDAT)));
            as.setStatus(field.getInt(Meta.STATUS));

            BasicDBObject basicDBObject = field.get(Meta.DISPLAY);
            Display display1 = new Display();
            if (null != basicDBObject) {
                display1.setStyle(basicDBObject.getInt(Meta.DISPLAY_STYLE));
                display1.setType(basicDBObject.getInt(Meta.DISPLAY_TYPE));
                as.setDisplay(display1);
            }

            BasicDBList bitems = field.get(Meta.ITEMS);
            List<Item> items = new ArrayList<>();
            for (int i = 0; i < bitems.size(); i++) {
                BasicDBObject bdb = (BasicDBObject) bitems.get(i);
                Item item = new Item();
                item.setType(bdb.getInt("type"));
                item.setId(bdb.getString("id"));
                if (null != bdb.get("name"))
                    item.setName(bdb.getString("name"));
                if (null != bdb.get("environment"))
                    item.setEnvironment(bdb.getInt("environment"));
                items.add(item);
            }
            as.setItems(items);

            BasicDBList locales = field.get("locales");
            List<Locale> locale = new ArrayList<>();
            for (int i = 0; i < locales.size(); i++) {
                BasicDBObject target = (BasicDBObject) locales.get(i);
                Locale l = new Locale();
                l.setLang(target.getString("lang"));
                l.setSummary(target.getString(Meta.SUMMARY));
                l.setSubject(target.getString(Meta.SUBJECT));
                locale.add(l);
            }
            as.setLocales(locale);
        }
        return as;
    }

    public static String formatSysmillis(long l) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(l);
    }

    public static class Item {
        private String id;
        private int type;
        private int environment;
        private String icon;
        private String name;
        private String summary;

        public int getEnvironment() {
            return environment;
        }

        public void setEnvironment(int environment) {
            this.environment = environment;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getIcon() {
            return icon;
        }

        public List<String> cover;

        public List<String> getCover() {
            return cover;
        }

        public void setCover(List<String> cover) {
            this.cover = cover;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }

    public static final class Display {
        private int type;
        private int style;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getStyle() {
            return style;
        }

        public void setStyle(int style) {
            this.style = style;
        }
    }

    public static final class Locale {
        private String lang;
        private String subject;
        private String summary;

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

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }
    }

    public static class Meta {
        public static final String TABLENAME = "appSeminar";
        public static final String ID = "id";
        public static final String ENVIRONMENT = "environment";
        public static final String CATALOG = "catalog";
        public static final String COVER = "cover";
        public static final String ICON = "icon";
        public static final String URL = "url";
        public static final String CLAZZ = "clazz";
        public static final String OWNER = "owner";
        public static final String TID = "tid";
        public static final String UPDAT = "updAt";
        public static final String ITEMS = "items";
        public static final String DISPLAY = "display";
        public static final String SORT = "sort";
        public static final String LANG = "lang";
        public static final String LOCALES = "locales";
        public static final String SUBJECT = "subject";
        public static final String SUMMARY = "summary";
        public static final String STATUS = "status";
        public static final int STATUS_ON = 1;
        public static final int STATUS_OFF = 9;
        public static final String DISPLAY_TYPE = "type";
        public static final String DISPLAY_STYLE = "style";
        public static final int DISPLAY_TYPE_COLLECTION = 1;
        public static final int DISPLAY_TYPE_COVER = 2;
        public static final int DISPLAY_TYPE_ITEMS = 3;
        public static final int DISPLAY_STYLE_TILED = 1;
        public static final int DISPLAY_STYLE_TILED2X = 2;
        public static final int DISPLAY_STYLE_METRO = 3;
        public static final int DISPLAY_STYLE_SLIDE = 4;
        public static final int IGNORE = 99;
        public static final int ITEM_TYPE_APP = 1;
        public static final int ITEM_TYPE_GAME = 2;
        public static final int ITEM_TYPE_SEMINAR = 3;
    }
}
