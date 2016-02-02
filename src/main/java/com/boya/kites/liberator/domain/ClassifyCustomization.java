package com.boya.kites.liberator.domain;

import com.mongodb.BasicDBObject;
import org.bson.BasicBSONObject;
import org.bson.types.BasicBSONList;
import org.canedata.field.Fields;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created  IN BOYA by lz on 15-8-26.
 */
public class ClassifyCustomization implements Serializable, Base<ClassifyCustomization> {

    private static final long serialVersionUID;

    static {
        serialVersionUID = -5809782578272943999L;
    }

    private String id;
    private String name;
    private Clazz r;
    private Clazz s;
    private int copyright;
    private int catalog;
    private long crtAt;
    private long updAt;
    private int order;
    private String operator;
    private String tid;
    private String summary;
    private Display display;
    private int status;
    private List<Data> data;

    public static class Data implements Serializable {

        private static final long serialVersionUID;

        static {
            serialVersionUID = -5809782578272943999L;
        }

        private String id;
        private int order;
        private int type;
        private String title;
        private String summary;
        private String content;
        private String url;
        private String icon;
        private List<String> covers;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
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

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public List<String> getCovers() {
            return covers;
        }

        public void setCovers(List<String> covers) {
            this.covers = covers;
        }
    }

    public static class Display implements Serializable {

        private static final long serialVersionUID;

        static {
            serialVersionUID = -5809782578272943999L;
        }

        private int style;
        private int type;

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

    public Clazz getR() {
        return r;
    }

    public void setR(Clazz r) {
        this.r = r;
    }

    public Clazz getS() {
        return s;
    }

    public void setS(Clazz s) {
        this.s = s;
    }

    public int getCopyright() {
        return copyright;
    }

    public void setCopyright(int copyright) {
        this.copyright = copyright;
    }

    public int getCatalog() {
        return catalog;
    }

    public void setCatalog(int catalog) {
        this.catalog = catalog;
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

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Display getDisplay() {
        return display;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    /**
     * 这里获取全部数据
     *
     * @param field
     * @return
     */
    @Override
    public ClassifyCustomization fill(Fields field) {
        ClassifyCustomization tc = null;
        if (null != field) {
            tc = new ClassifyCustomization();
            tc.setId(field.getString("_" + Meta.ID));
            if (null != field.get(Meta.NAME))
                tc.setName(field.getString(Meta.NAME));
            BasicDBObject c = field.get("c");
            BasicDBObject r = (BasicDBObject) c.get("r");
            BasicDBObject s = (BasicDBObject) c.get("s");
            Clazz rootc = new Clazz();
            rootc.setId(r.getString("id"));
            tc.setR(rootc);
            Clazz roots = new Clazz();
            roots.setId(s.getString("id"));
            tc.setS(roots);
            if (null != field.get(Meta.COPYRIGHT))
                tc.setCopyright(field.getInt(Meta.COPYRIGHT));
            if (null != field.get(Meta.CATALOG))
                tc.setCatalog(field.getInt(Meta.CATALOG));
            if (null != field.get(Meta.CRTAT))
                tc.setCrtAt(field.getLong(Meta.CRTAT));
            if (null != field.get(Meta.UPDAT))
                tc.setUpdAt(field.getLong(Meta.UPDAT));
            if (null != field.get(Meta.OPERATOR))
                tc.setOperator(field.getString(Meta.OPERATOR));
            if (null != field.get(Meta.TID))
                tc.setTid(field.getString(Meta.TID));
            if (null != field.get(Meta.SUMMARY))
                tc.setSummary(field.getString(Meta.SUMMARY));
            if (null != field.get(Meta.STATUS))
                tc.setStatus(field.getInt(Meta.STATUS));
            if (null != field.get(Meta.ORDER))
                tc.setOrder(field.getInt(Meta.ORDER));
            if (null != field.get(Meta.DISPLAY)) {
                Display display1 = new Display();
                BasicDBObject bdis = field.get(Meta.DISPLAY);
                display1.setStyle(bdis.getInt(Meta.STYLE));
                display1.setType(bdis.getInt(Meta.TYPE));
                tc.setDisplay(display1);
            }
            BasicBSONList dataCover = (BasicBSONList) field.get(Meta.DATA);
            List<Data> datas = new ArrayList<>();
            if (null != dataCover) {
                for (int j = 0; dataCover.size() > j; j++) {
                    BasicBSONObject bb = (BasicBSONObject) dataCover.get(j);
                    Data d = new Data();
                    d.setId(bb.getString(Meta.ID));
                    d.setOrder(bb.getInt(Meta.ORDER));
                    d.setType(bb.getInt(Meta.TYPE));
                    d.setTitle(bb.getString(Meta.TITLE));
                    d.setSummary(bb.getString(Meta.SUMMARY));
                    d.setContent(bb.getString(Meta.CONTENT));
                    d.setUrl(bb.getString(Meta.URL));
                    d.setIcon(bb.getString(Meta.ICON));
                    BasicBSONList Coverbb = (BasicBSONList) bb.get(Meta.COVERS);
                    List<String> listCover = new ArrayList<>();
                    if (null != Coverbb) {
                        for (int i = 0; Coverbb.size() > i; i++) {
                            listCover.add((String) Coverbb.get(i));
                        }
                        d.setCovers(listCover);
                    }
                    datas.add(d);
                }
            }
            tc.setData(datas);
        }
        return tc;
    }

    public static final class Meta {
        public static final String TABLENAME = "classifyCustomization";
        public static final String ID = "id";
        public static final String NAME = "name";
        public static final String C = "c";
        public static final String R = "r";
        public static final String S = "s";
        public static final String COPYRIGHT = "copyright";
        public static final String CATALOG = "catalog";
        public static final String CRTAT = "crtAt";
        public static final String UPDAT = "updAt";
        public static final String OPERATOR = "operator";
        public static final String TID = "tid";
        public static final String SUMMARY = "summary";
        public static final String DISPLAY = "display";
        public static final String TYPE = "type";
        public static final String STYLE = "style";
        public static final String STATUS = "status";
        public static final String DATA = "data";
        public static final String ORDER = "order";
        public static final String TITLE = "title";
        public static final String CONTENT = "content";
        public static final String URL = "url";
        public static final String ICON = "icon";
        public static final String COVERS = "covers";
        //状态定义
        public static final int STAUTS_OPEN = 1;
        public static final int STAUTS_EDIT = 2;
        public static final int STAUTS_CLOSE = 9;
    }
}
