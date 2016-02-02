package com.boya.kites.liberator.domain;

import org.canedata.field.Fields;

import java.io.Serializable;
import java.util.Map;

/**
 * Created  IN BOYA by BaiLiJun o 14-10-11.
 */
public class Clazz implements Serializable, Base<Clazz>, Comparable<Clazz> {
    private String id;
    private int type;
    private String name;
    private String owner;
    private long cat;
    private long updAt;
    private String pid;
    private int order;
    private Map<String, I18n> i18ns;

    public Map<String, I18n> getI18ns() {
        return i18ns;
    }

    public void setI18ns(Map<String, I18n> i18ns) {
        this.i18ns = i18ns;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    private String icon;
    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public long getCat() {
        return cat;
    }

    public void setCat(long cat) {
        this.cat = cat;
    }

    public long getUpdAt() {
        return updAt;
    }

    public void setUpdAt(long updAt) {
        this.updAt = updAt;
    }

    public Clazz parent;

    public Clazz getParent() {
        return parent;
    }

    public void setParent(Clazz parent) {
        this.parent = parent;
    }

    @Override
    public Clazz fill(Fields field) {
        Clazz rlt = null;
        if (null != field) {
            rlt = new Clazz();
            rlt.setId(field.getString("_id"));
            rlt.setType(field.getInt(Meta.TYPE));
            rlt.setCat(field.getLong(Meta.CAT));
            if (null != field.get(Meta.PID)) {
                rlt.setPid(field.getString(Meta.PID));
            }
            rlt.setOrder(field.getInt(Meta.ORDER));
            rlt.setUpdAt(field.getLong(Meta.UPDAT));
            rlt.setIcon(field.getString(Meta.ICON));
            if (null != field.get(Meta.STATUS)) {
                rlt.setStatus(field.getInt(Meta.STATUS));
            }
        }
        return rlt;
    }

    @Override
    public int compareTo(Clazz o) {
        if (o.getOrder() < this.order) {
            return 1;
        } else if (o.getOrder() > this.order) {
            return -1;
        }
        return this.id.compareTo(o.getId());
    }

    @Override
    public boolean equals(Object obj) {
        Clazz target = (Clazz) obj;
        return this.getId().equals(target.getId());
    }

    @Override
    public int hashCode() {
        //return super.hashCode();
        return this.getId().hashCode();
    }

    public static final class Meta {
        public static final String TABLENAME = "class";
        public static final String ID = "id";
        public static final String NAME = "name";
        public static final String TYPE = "type";
        public static final String CAT = "cat";
        public static final String UPDAT = "updAt";
        public static final String PID = "pid";
        public static final String ORDER = "order";
        public static final String LOCALES = "locales";
        public static final String LANG = "lang";
        public static final String ICON = "icon";
        public static final String OWNER = "owner";
        public static final String STATUS = "status";
        public static final int STATUS_OPEN = 1;
        public static final int STATUS_CLOSE = 9;
        public static final int TYPE_IGNORE = -99;
        public static final int VIDEO = 1;
        public static final int NEWS = 2;
        public static final int GAME = 4;
        public static final int APP = 5;
        public static final int NOVEL = 6;
    }

    public static class I18n implements Serializable {

        private static final long serialVersionUID;

        static {
            serialVersionUID = -5809782578272943999L;
        }

        private String lang;
        private String name;

        public String getLang() {
            return lang;
        }

        public void setLang(String lang) {
            this.lang = lang;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}


