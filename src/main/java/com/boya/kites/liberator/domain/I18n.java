package com.boya.kites.liberator.domain;

import org.canedata.field.Fields;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created  IN BOYA by BaiLiJun on 14-10-11.
 */
public class I18n implements Serializable, Base<I18n> {
    private String id;
    private String lang;
    private String key;
    private String value;
    private String rid;
    private int type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public I18n fill(Fields field) {
        I18n i18n = null;
        if (null != field) {
            i18n = new I18n();
            i18n.setId(field.getString("_id"));
            i18n.setRid(field.getString(Meta.RID));
            i18n.setKey(field.getString(Meta.KEY));
            i18n.setLang(field.getString(Meta.LANG));
            i18n.setType(field.getInt(Meta.TYPE));
            i18n.setValue(field.getString(Meta.VALUE));
        }
        return i18n;
    }

    public static final class Meta {
        public static final String TABLENAME = "locales";
        public static final String ID = "id";
        public static final String LANG = "lang";
        public static final String KEY = "key";
        public static final String VALUE = "value";
        public static final String RID = "rid";
        public static final String TYPE = "type";
        public static final int TYPE_VIDEOTYPE = 1;
        public static final int TYPE_VIDEO = 2;
        public static final int TYPE_MUSICTYPE = 3;
        public static final int TYPE_MUSIC = 4;
        public static final int TYPE_NEWSTYPE = 5;
        public static final int TYPE_NEWS = 6;
        public static final int TYPE_MAGAZINETYPE = 7;
        public static final int TYPE_MAGAZINE = 8;
        public static final int TYPE_APP = 9;
        public static final int TYPE_GAME = 10;

    }

    public static final class Language {
        public static final String ARAB = "ar";
        public static final String ENGLISH = "en";
        public static final String CHINESE = "zh";
        public static final String JAPANESE = "ja";
        public static final String Belarus = "be";
        public static final String GERMANY = "de";
        public static final String KOREA = "ko";
        public static final List<String> langs = new ArrayList<>();

        static {
            langs.add(ARAB);
            langs.add(ENGLISH);
            langs.add(CHINESE);
            langs.add(JAPANESE);
            langs.add(Belarus);
            langs.add(GERMANY);
            langs.add(KOREA);
        }
    }
}

