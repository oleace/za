package com.boya.kites.liberator.domain;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import org.canedata.field.Fields;

import java.util.*;

/**
 * Created  IN BOYA by BaiLiJun on 15/2/10.
 */
public class IndexModule implements Base<IndexModule> {

    private String id;

    private String name;

    private int status;

    private int siteType;

    private int pos;

    private String tid;

    private long crtAt;

    private long activeTime;

    private long updAt;

    private String auser;

    private String muser;

    private int catalog;

    private DisPlay disPlay;

    private List<Item> datas;

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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getSiteType() {
        return siteType;
    }

    public void setSiteType(int siteType) {
        this.siteType = siteType;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public long getCrtAt() {
        return crtAt;
    }

    public void setCrtAt(long crtAt) {
        this.crtAt = crtAt;
    }

    public long getActiveTime() {
        return activeTime;
    }

    public void setActiveTime(long activeTime) {
        this.activeTime = activeTime;
    }

    public long getUpdAt() {
        return updAt;
    }

    public void setUpdAt(long updAt) {
        this.updAt = updAt;
    }

    public String getAuser() {
        return auser;
    }

    public void setAuser(String auser) {
        this.auser = auser;
    }

    public String getMuser() {
        return muser;
    }

    public void setMuser(String muser) {
        this.muser = muser;
    }

    public int getCatalog() {
        return catalog;
    }

    public void setCatalog(int catalog) {
        this.catalog = catalog;
    }

    public DisPlay getDisPlay() {
        return disPlay;
    }

    public void setDisPlay(DisPlay disPlay) {
        this.disPlay = disPlay;
    }

    public List<Item> getDatas() {
        return datas;
    }

    public void setDatas(List<Item> datas) {
        this.datas = datas;
    }

    @Override
    public IndexModule fill(Fields field) {
        IndexModule indexModule = null;
        if (null != field) {
            indexModule = new IndexModule();
            indexModule.setId(field.getString(Meta.ID));
            indexModule.setCatalog(field.getInt(Meta.CATALOG));
            indexModule.setSiteType(field.getInt(Meta.SITETYPE));
            indexModule.setName(field.getString(Meta.NAME));
            indexModule.setPos(field.getInt(Meta.POS));
            indexModule.setCrtAt(field.getLong(Meta.CRTAT));
            indexModule.setActiveTime(null != field.get(Meta.ACTIVETIME) ? field.getLong(Meta.ACTIVETIME) : 0);
            BasicDBObject display = field.get(Meta.DISPLAY);
            DisPlay target = new DisPlay();
            target.setStyle(display.getInt(Meta.DISPLAY_STYLE));
            target.setType(display.getInt(Meta.DISPLAY_TYPE));
            indexModule.setDisPlay(target);
            indexModule.setStatus(field.getInt(Meta.STATUS));
            BasicDBList basicDBList = field.get(Meta.DATAS);
            List<Item> datas = new ArrayList<Item>();
            if (null != basicDBList) {
                for (int i = 0; i < basicDBList.size(); i++) {
                    Item item = new Item();
                    BasicDBObject _t = (BasicDBObject) basicDBList.get(i);
                    item.setId(_t.getString(Meta.ITEM_ID));
                    item.setOrder(_t.getInt(Meta.ITEM_ORDER));
                    datas.add(item);
                }
            }
            Collections.sort(datas);
            indexModule.setDatas(datas);
        }
        return indexModule;
    }

    public static class DisPlay {
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

    public static class Item implements Comparable<Item> {
        private String id;
        private int order;
        private Object target;

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

        public Object getTarget() {
            return target;
        }

        public void setTarget(Object target) {
            this.target = target;
        }

        @Override
        public int compareTo(Item o) {
            if (this.order > o.getOrder())
                return 1;
            if (this.order < o.getOrder()) {
                return -1;
            }
            return 0;
        }
    }

    public static final class Meta {

        public static final String TABLENAME = "index_module";

        public static final String ID = "_id";

        public static final String NAME = "name";

        public static final String STATUS = "status";

        public static final String SITETYPE = "siteType";

        public static final String POS = "pos";

        public static final String TID = "tid";

        public static final String CRTAT = "crtAt";

        public static final String ACTIVETIME = "activeTime";

        public static final String MUSER = "muser";

        public static final String AUSER = "auser";

        public static final String UPDAT = "updAt";

        public static final String CATALOG = "catalog";

        public static final String DISPLAY = "display";

        public static final String DISPLAY_TYPE = "type";

        public static final String DISPLAY_STYLE = "style";

        public static final String DATAS = "datas";

        public static final int STATUS_ONLINE = 1;

        public static final int CATALOG_APP = 1;

        public static final int CATALOG_GAME = 2;

        public static final int CATALOG_NOVEL = 3;

        public static final int CATALOG_NEWS = 4;

        public static final int CATALOG_VIDEO = 5;

        public static final int CATALOG_SEMINAR = 6;

        public static final int CATALOG_PIC = 7;

        public static final String ITEM_ID = "id";

        public static final String ITEM_ORDER = "order";

        public static final int SITETYPE_COMMON = 1;

        public static final int SITETYPE_RAILWAY = 2;

        public static final int SITETYPE_AIR = 3;

    }
}
