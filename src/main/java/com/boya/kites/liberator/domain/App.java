package com.boya.kites.liberator.domain;

import com.boya.commons.TimeUitls;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import org.canedata.field.Fields;

import java.util.ArrayList;
import java.util.List;

/**
 * Created  IN BOYA by BaiLiJun on 14/11/28.
 */

/**
 * db.apps.save({
 * crtAt:NumberLong("1400211969226"),//创建时间
 * owner:"admin",//创建人
 * updAt:NumberLong("1400211969226"),//修改时间
 * <p/>
 * tid:""
 * <p/>
 * <p/>
 * <p/>
 * type:1,类型1 android 2 IOS 3:winphone 4 HTML5
 * catalog:2//1app 2:game
 * url:"http://img1.android.d.cn/android/new/game_image/92/36792/xxx.apk",
 * star:4//评星,
 * device: 1 手机 2 pad 3 通用
 * rec:0 不推荐 1 推荐
 * hot：1热门
 * <p/>
 * <p/>
 * <p/>
 * icon:"http://img.pconline.com.cn/images/upload/upc/tx/pcdlc/1303/01/c0/18527899_18527899_1362109294216.jpg",//图标
 * cover:""//cover
 * c:{
 * r:{
 * id:"gameAct"//分类ID
 * },
 * s:[
 * {id:""}
 * ]
 * <p/>
 * },
 * status:1,状态 1 上线，9 下线
 * locales:[
 * {
 * lang:"cn",语言
 * name:"快乐炸金花 3.0.1 官方版",//名称
 * summary:"快乐炸金花手机版是一款棋牌类休闲游戏，史上最专业最富人气手游；快乐炸金花手机版阵容豪华，高手云集，挑战智慧与运气的极限。本站提供快乐炸金花官方下载",
 * content:"战斗过程中，手动施放关键技能，技能释放无延迟，给你前所未有的战斗体验!技能自由组合，轻松实现秒杀后排，技能打断，控制技能衔接等高端战斗技巧!骨骼动画 人物表情栩栩如生",
 * skill:｛//攻略
 * type:1文本 2//s视频 3 图片 4 图集
 * content://文本或者视频地址
 * images：[,,,,,,,]
 * ｝,
 * images:["http://img1.android.d.cn/android/new/game_image/92/36792/icon.png"],//游戏截图
 * <p/>
 * size:"33.8M",软件大小
 * version:"1.1",版本
 * dcount:"2000万",下载数量
 * provider:""来源,
 * producer:生产商，
 * publish:"20140909",//上线时间
 * osMinVersion:"android2.2",//操作系统最小版本
 * <p/>
 * }
 * ]
 * });
 * <p/>
 * app_seminar{
 * id:
 * type:1,类型1 android 2 IOS 3:winphone 4 HTML5,5 url:
 * catalog:2//1app 2:game
 * cover:"",
 * url:"",
 * clazz:"",
 * owner:
 * updAt:
 * <p/>
 * <p/>
 * items:
 * [id,id,id]
 * <p/>
 * },
 * locales:[
 * {
 * lang:"cn",语言
 * subject:"xxxx",//名称
 * summary:"xxxx",
 * <p/>
 * <p/>
 * }
 * <p/>
 * app_seminar{
 * id:
 * pushType:(展现平台)1,类型1 android 2 IOS 3:winphone 4 HTML5,5 url:
 * catalog://1app 2:game
 * cover:"",
 * url:"",
 * clazz:"",
 * owner:,
 * icon:"",
 * updAt:,
 * display:{
 * type:内容类型 1聚合 2 cover 3 展开子项
 * style:显示类型：1:tiled（线状块） 2:metro(磁片) 3:slide (滑动)
 * }
 * items:
 * [
 * <p/>
 * {
 * id :"",
 * type:1 game,2 app 3 seminar
 * }
 * ]
 * <p/>
 * },
 * locales:[
 * {
 * lang:"cn",语言
 * subject:"xxxx",//名称
 * summary:"xxxx",
 * }
 */
public class App implements Base<App> {
    private String id;
    private long crtAt;
    private long updAt;
    private String updAtDate;
    private String owner;
    private String tid;
    private int environment;
    private int catalog;
    private String url;
    private double star;
    private int device;
    private String icon;
    private List<String> cover;
    private Clazz root;
    private List<Clazz> subClazz;
    private int status;
    private String lang;
    private String name;
    private String summary;
    private String content;
    private List<String> images;
    private String size;
    private String version;
    private String dcount;
    private String publish;
    private String compatibility;
    private String provider;
    private String producer;
    private int rec;
    private int hot;
    private List<Locale> locales;
    private Display display;
    private String appPackage;

    public String getAppPackage() {
        return appPackage;
    }

    public void setAppPackage(String appPackage) {
        this.appPackage = appPackage;
    }

    public String getUpdAtDate() {
        return updAtDate;
    }

    public void setUpdAtDate(String updAtDate) {
        this.updAtDate = updAtDate;
    }

    public Display getDisplay() {
        return display;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }

    public List<Locale> getLocales() {
        return locales;
    }

    public void setLocales(List<Locale> locales) {
        this.locales = locales;
    }

    public static class Locale {
        private String lang;
        private String name;
        private String summary;
        private String content;
        private Skill skill;
        private List<String> images;
        private String size;
        private String version;
        private String dcount;
        private String publish;
        private String compatibility;
        private String provider;
        private String producer;

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getDcount() {
            return dcount;
        }

        public void setDcount(String dcount) {
            this.dcount = dcount;
        }

        public String getPublish() {
            return publish;
        }

        public void setPublish(String publish) {
            this.publish = publish;
        }

        public String getCompatibility() {
            return compatibility;
        }

        public void setCompatibility(String compatibility) {
            this.compatibility = compatibility;
        }

        public String getProvider() {
            return provider;
        }

        public void setProvider(String provider) {
            this.provider = provider;
        }

        public String getProducer() {
            return producer;
        }

        public void setProducer(String producer) {
            this.producer = producer;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
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

        public Skill getSkill() {
            return skill;
        }

        public void setSkill(Skill skill) {
            this.skill = skill;
        }

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

    public static class Skill {
        private int type;
        private String content;
        private String[] images;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String[] getImages() {
            return images;
        }

        public void setImages(String[] images) {
            this.images = images;
        }
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public int getHot() {
        return hot;
    }

    public void setHot(int hot) {
        this.hot = hot;
    }

    public int getRec() {
        return rec;
    }

    public void setRec(int rec) {
        this.rec = rec;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public int getEnvironment() {
        return environment;
    }

    public void setEnvironment(int environment) {
        this.environment = environment;
    }

    public int getCatalog() {
        return catalog;
    }

    public void setCatalog(int catalog) {
        this.catalog = catalog;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public double getStar() {
        return star;
    }

    public void setStar(double star) {
        this.star = star;
    }

    public int getDevice() {
        return device;
    }

    public void setDevice(int device) {
        this.device = device;
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

    public Clazz getRoot() {
        return root;
    }

    public void setRoot(Clazz root) {
        this.root = root;
    }

    public List<Clazz> getSubClazz() {
        return subClazz;
    }

    public void setSubClazz(List<Clazz> subClazz) {
        this.subClazz = subClazz;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

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

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDcount() {
        return dcount;
    }

    public void setDcount(String dcount) {
        this.dcount = dcount;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public String getCompatibility() {
        return compatibility;
    }

    public void setCompatibility(String compatibility) {
        this.compatibility = compatibility;
    }

    public static class Display {
        private int style;

        public int getStyle() {
            return style;
        }

        public void setStyle(int style) {
            this.style = style;
        }
    }

    public static class Meta {
        public static final String TABLENAME = "apps";
        public static final String ID = "id";
        public static final String CRTAT = "crtAt";
        public static final String UPDAT = "updAt";
        public static final String OWNER = "owner";
        public static final String TID = "tid";
        public static final String ENVIRONMENT = "environment";
        public static final String CATALOG = "catalog";
        public static final String URL = "url";
        public static final String STAR = "star";
        public static final String DEVICE = "device";
        public static final String ICON = "icon";
        public static final String COVER = "cover";
        public static final String ROOT = "root";
        public static final String SUBCLAZZ = "subClazz";
        public static final String STATUS = "status";
        public static final String LANG = "lang";
        public static final String NAME = "name";
        public static final String SUMMARY = "summary";
        public static final String CONTENT = "content";
        public static final String IMAGES = "images";
        public static final String SIZE = "size";
        public static final String VERSION = "version";
        public static final String DCOUNT = "dcount";
        public static final String PUBLISH = "publish";
        public static final String COMPATIBILITY = "compatibility";
        public static final String PROVIDER = "provider";
        public static final String PRODUCER = "producer";
        public static final String REC = "rec";
        public static final String HOT = "hot";
        public static final String LOCALES = "locales";
        public static final int TYPE_ANDROID = 1;
        public static final int TYPE_IOS = 2;
        public static final int TYPE_WINPHONE = 3;
        public static final int TYPE_HTML5 = 4;
        public static final int TYPE_URL = 5;
        public static final int CATALOG_APP = 1;
        public static final int CATALOG_GAME = 2;
        public static final int STATUS_ON = 1;
        public static final int STATUS_OFF = 9;
        public static final int REC_ON = 1;
        public static final int REC_OFF = 0;
        public static final int HOT_ON = 1;
        public static final int HOT_OFF = 0;
        public static final String DISPLAY = "display";
        public static final String APPPACKAGE = "appPackage";
        public static final int DISPLAY_STYLE_NORMAL = 1;
        public static final int DISPLAY_STYLE_ONECOVER = 2;
        public static final int DISPLAY_STYLE_MULCOVER = 3;
        public static final int DISPLAY_STYLE_TEXT = 4;
        public static final String SORT = "sort";
    }

    @Override
    public App fill(Fields field) {
        App rlt = null;
        if (null != field) {
            rlt = new App();
            rlt.setId(field.getString("_id"));
            rlt.setEnvironment(field.getInt(Meta.ENVIRONMENT));
            BasicDBObject c = field.get("c");
            BasicDBObject r = (BasicDBObject) c.get("r");
            Clazz root = new Clazz();
            root.setId(r.getString("id"));
            rlt.setRoot(root);
            rlt.setCrtAt(field.getLong(Meta.CRTAT));
            rlt.setOwner(field.getString(Meta.OWNER));
            rlt.setStatus(field.getInt(Meta.STATUS));
            rlt.setUpdAt(field.getLong(Meta.UPDAT));
            rlt.setUpdAtDate(TimeUitls.getInterval(field.getLong(Meta.UPDAT)));
            rlt.setIcon(field.getString(Meta.ICON));
            rlt.setCatalog(field.getInt(Meta.CATALOG));
            rlt.setEnvironment(field.getInt(Meta.ENVIRONMENT));
            rlt.setDevice(field.getInt(Meta.DEVICE));
            rlt.setUrl(field.getString(Meta.URL));
            rlt.setStar(field.getDouble(Meta.STAR));
            if (null != field.get(Meta.DISPLAY)) {
                Display display1 = new Display();
                BasicDBObject bdis = field.get(Meta.DISPLAY);
                display1.setStyle(bdis.getInt("style"));
                rlt.setDisplay(display1);
            }
            if (null != field.get(Meta.COVER)) {
                BasicDBList basicDBList = field.get(Meta.COVER);
                List<String> cover = new ArrayList<>();
                for (int i = 0; i < basicDBList.size(); i++) {
                    cover.add((String) basicDBList.get(i));
                }
                rlt.setCover(cover);
            }
            if (null != field.get(Meta.HOT)) {
                rlt.setHot(field.getInt(Meta.HOT));
            }
            if (null != field.get(Meta.REC)) {
                rlt.setRec(field.getInt(Meta.REC));
            }
            BasicDBList locales = field.get("locales");
            if (null != locales) {
                BasicDBObject target = (BasicDBObject) locales.get(0);
                rlt.setContent(target.getString(Meta.CONTENT));
                rlt.setName(target.getString(Meta.NAME));
                rlt.setLang(target.getString(Meta.LANG));
                rlt.setSummary(target.getString(Meta.SUMMARY));
                rlt.setDcount(target.getString(Meta.DCOUNT));
                rlt.setSize(target.getString(Meta.SIZE));
                rlt.setVersion(target.getString(Meta.VERSION));
                rlt.setCompatibility(target.getString(Meta.COMPATIBILITY));
                rlt.setPublish(target.getString(Meta.PUBLISH));
                rlt.setProvider(target.getString(Meta.PROVIDER));
                rlt.setProducer(target.getString(Meta.PRODUCER));
                BasicDBList cs = (BasicDBList) target.get("images");
                if (null != cs) {
                    List<String> covers = new ArrayList<>();
                    for (int i = 0; i < cs.size(); i++) {
                        covers.add((String) cs.get(i));
                    }
                    rlt.setImages(covers);
                }
            }
        }
        return rlt;
    }

    public App fills(Fields field) {
        App rlt = null;
        if (null != field) {
            rlt = new App();
            rlt.setId(field.getString("_id"));
            rlt.setEnvironment(field.getInt(Meta.ENVIRONMENT));
            BasicDBObject c = field.get("c");
            BasicDBObject r = (BasicDBObject) c.get("r");
            Clazz root = new Clazz();
            root.setId(r.getString("id"));
            rlt.setRoot(root);
            rlt.setCrtAt(field.getLong(Meta.CRTAT));
            rlt.setOwner(field.getString(Meta.OWNER));
            rlt.setStatus(field.getInt(Meta.STATUS));
            rlt.setUpdAt(field.getLong(Meta.UPDAT));
            rlt.setIcon(field.getString(Meta.ICON));
            rlt.setCatalog(field.getInt(Meta.CATALOG));
            rlt.setEnvironment(field.getInt(Meta.ENVIRONMENT));
            rlt.setDevice(field.getInt(Meta.DEVICE));
            rlt.setUrl(field.getString(Meta.URL));
            rlt.setStar(field.getDouble(Meta.STAR));

            if (null != field.get(Meta.COVER)) {
                BasicDBList basicDBList = field.get(Meta.COVER);
                List<String> cover = new ArrayList<>();
                for (int i = 0; i < basicDBList.size(); i++) {
                    cover.add((String) basicDBList.get(i));
                }
                rlt.setCover(cover);
            }
            rlt.setHot(field.getInt(Meta.HOT));
            rlt.setRec(field.getInt(Meta.REC));
            List<App.Locale> locale = new ArrayList<App.Locale>();
            BasicDBList locales = field.get("locales");
            if (null != locales) {
                for (int j = 0; locales.size() > j; j++) {
                    App.Locale lo = new App.Locale();
                    BasicDBObject target = (BasicDBObject) locales.get(j);
                    lo.setContent(target.getString(Meta.CONTENT));
                    lo.setName(target.getString(Meta.NAME));
                    lo.setLang(target.getString(Meta.LANG));
                    lo.setSummary(target.getString(Meta.SUMMARY));
                    lo.setDcount(target.getString(Meta.DCOUNT));
                    lo.setSize(target.getString(Meta.SIZE));
                    lo.setCompatibility(target.getString(Meta.COMPATIBILITY));
                    lo.setPublish(target.getString(Meta.PUBLISH));
                    lo.setProvider(target.getString(Meta.PROVIDER));
                    lo.setProducer(target.getString(Meta.PRODUCER));
                    lo.setVersion(target.getString(Meta.VERSION));
                    BasicDBList cs = (BasicDBList) target.get("images");
                    if (null != cs) {
                        List<String> covers = new ArrayList<>();
                        for (int i = 0; i < cs.size(); i++) {
                            covers.add((String) cs.get(i));
                        }
                        lo.setImages(covers);
                    }
                    locale.add(lo);
                }
                rlt.setLocales(locale);
            }
        }
        return rlt;
    }
}
