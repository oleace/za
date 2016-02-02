package com.boya.kites.liberator.domain;

import org.bson.BasicBSONObject;
import org.bson.types.BasicBSONList;
import org.canedata.field.Fields;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created  IN BOYA by lz on 15-4-2.
 */
public class Question implements Serializable, Base<Question> {

    private static final long serialVersionUID = -7683428951868158476L;
    private String id;
    private String tid;
    //1.单选2多选3单行文本输入4图片单选5图片多选
    private int type;
    private String tag;
    private int status;
    private long cat;
    private long uat;
    private List<Locale> locales;
    private String title;
    private List<Option> options;

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
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

    public long getUat() {
        return uat;
    }

    public void setUat(long uat) {
        this.uat = uat;
    }

    public List<Locale> getLocales() {
        return locales;
    }

    public void setLocales(List<Locale> locales) {
        this.locales = locales;
    }

    public static class Locale implements Serializable {

        private static final long serialVersionUID = -7683428951868158476L;
        private String lang;
        private String title;
        private List<Option> options;

        public String getLang() {
            return lang;
        }

        public void setLang(String lang) {
            this.lang = lang;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<Option> getOptions() {
            return options;
        }

        public void setOptions(List<Option> options) {
            this.options = options;
        }
    }

    public static class Option implements Serializable {

        private static final long serialVersionUID = -7683428951868158476L;
        private String id;
        private String title;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }

    /**
     * 这里获取全部数据
     *
     * @param field
     * @return
     */
    @Override
    public Question fill(Fields field) {
        Question tc = null;
        if (null != field) {
            tc = new Question();
            tc.setId(field.getString("_" + Meta.ID));
            tc.setStatus(field.getInt(Meta.STATUS));
            tc.setType(field.getInt(Meta.TYPE));
            tc.setCat(field.getLong(Meta.CAT));
            tc.setTag(field.getString(Meta.TAG));
            tc.setTid(field.getString(Meta.TID));
            tc.setUat(field.getLong(Meta.UAT));
            List<Locale> list = new ArrayList<Locale>();
            BasicBSONList locales = (BasicBSONList) field.get(Meta.LOCALES);
            List<Option> listoptionswai = new ArrayList<Option>();
            for (int i = 0; locales.size() > i; i++) {
                BasicBSONObject bo = (BasicBSONObject) locales.get(i);
                Locale locale = new Locale();
                locale.setLang(bo.getString(Meta.LANG));
                locale.setTitle(bo.getString(Meta.TITLE));
                tc.setTitle(bo.getString(Meta.TITLE));
                List<Option> listoptions = new ArrayList<Option>();
                BasicBSONList options = (BasicBSONList) bo.get(Meta.OPTIONS);
                for (int j = 0; options.size() > j; j++) {
                    BasicBSONObject booptions = (BasicBSONObject) options.get(j);
                    Option option = new Option();
                    option.setId(booptions.getString(Meta.ID));
                    option.setTitle(booptions.getString(Meta.TITLE));
                    listoptions.add(option);
                    listoptionswai.add(option);
                }
                locale.setOptions(listoptions);
                list.add(locale);
            }
            tc.setOptions(listoptionswai);
            tc.setLocales(list);
        }
        return tc;
    }

    public static final class Meta {
        public static final String TABLENAME = "question";
        public static final String ID = "id";
        public static final String TID = "tid";
        public static final String TYPE = "type";
        public static final String LOCALES = "locales";
        public static final String LANG = "lang";
        public static final String TITLE = "title";
        public static final String OPTIONS = "options";
        public static final String TAG = "tag";
        public static final String STATUS = "status";
        public static final String CAT = "cat";
        public static final String UAT = "uat";
        //状态定义
        public static final int STAUTS_OPEN = 1;
        public static final int STAUTS_DRAFT = 2;
        public static final int STAUTS_CLOSE = -9;
    }
}
