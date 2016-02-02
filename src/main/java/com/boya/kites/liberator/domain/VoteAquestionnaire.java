package com.boya.kites.liberator.domain;

import com.boya.commons.TimeUitls;
import com.mongodb.BasicDBObject;
import org.bson.types.BasicBSONList;
import org.canedata.field.Fields;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created  IN BOYA by lz on 15-4-2.
 */
public class VoteAquestionnaire implements Serializable, Base<VoteAquestionnaire> {

    private static final long serialVersionUID = -7683428951868158476L;
    private String id;
    private String tid;
    private long crtAt;
    private long updAt;
    private String alias;
    private int itemEdiable;
    private String uid;
    private int status;
    private int type;
    private Body body;
    private Conﬁg config;
    private List<Items> items;
    //主体信息显示字段（中文主体信息）
    private String title;
    private String icon;
    private String closeMsg;
    private String summary;
    private String giveUP;
    private List<String> cover;
    //设置项
    private int cookie;
    private int ip;
    private int count;
    private long time;
    private String timeAt;
    private int phone;
    private int gender;
    private int email;
    private int age;
    private int pro;
    private int share;
    private int showResult;
    private int way;

    //统计使用字段区
    private int actor;
    private int complete;

    public int getActor() {
        return actor;
    }

    public void setActor(int actor) {
        this.actor = actor;
    }

    public int getComplete() {
        return complete;
    }

    public void setComplete(int complete) {
        this.complete = complete;
    }

    public String getTimeAt() {
        return timeAt;
    }

    public void setTimeAt(String timeAt) {
        this.timeAt = timeAt;
    }

    public int getWay() {
        return way;
    }

    public void setWay(int way) {
        this.way = way;
    }

    public int getCookie() {
        return cookie;
    }

    public void setCookie(int cookie) {
        this.cookie = cookie;
    }

    public int getIp() {
        return ip;
    }

    public void setIp(int ip) {
        this.ip = ip;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getEmail() {
        return email;
    }

    public void setEmail(int email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPro() {
        return pro;
    }

    public void setPro(int pro) {
        this.pro = pro;
    }

    public int getShare() {
        return share;
    }

    public void setShare(int share) {
        this.share = share;
    }

    public int getShowResult() {
        return showResult;
    }

    public void setShowResult(int showResult) {
        this.showResult = showResult;
    }

    public String getCloseMsg() {
        return closeMsg;
    }

    public void setCloseMsg(String closeMsg) {
        this.closeMsg = closeMsg;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getGiveUP() {
        return giveUP;
    }

    public void setGiveUP(String giveUP) {
        this.giveUP = giveUP;
    }

    public List<String> getCover() {
        return cover;
    }

    public void setCover(List<String> cover) {
        this.cover = cover;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
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

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public int getItemEdiable() {
        return itemEdiable;
    }

    public void setItemEdiable(int itemEdiable) {
        this.itemEdiable = itemEdiable;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public Conﬁg getConfig() {
        return config;
    }

    public void setConfig(Conﬁg config) {
        this.config = config;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }

    public static class Items implements Serializable {

        private static final long serialVersionUID = -7683428951868158476L;
        private String id;
        private String uuid;
        private String lang;
        private String title;
        private int type;
        private Con config;
        private List<Options> options;

        public String getUuid() {
            return uuid;
        }

        public void setUuid(String uuid) {
            this.uuid = uuid;
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

        public Con getConfig() {
            return config;
        }

        public void setConfig(Con config) {
            this.config = config;
        }

        public List<Options> getOptions() {
            return options;
        }

        public void setOptions(List<Options> options) {
            this.options = options;
        }
    }

    public static class Options implements Serializable {

        private static final long serialVersionUID = -7683428951868158476L;
        private String id;
        private int pos;
        private String title;
        private String cover;
        private String per;
        private Rule rule;

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getPos() {
            return pos;
        }

        public void setPos(int pos) {
            this.pos = pos;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPer() {
            return per;
        }

        public void setPer(String per) {
            this.per = per;
        }

        public Rule getRule() {
            return rule;
        }

        public void setRule(Rule rule) {
            this.rule = rule;
        }
    }

    public static class Rule implements Serializable {

        private static final long serialVersionUID = -7683428951868158476L;
        private int type;
        private List<String> include;
        private List<String> exclude;
        private String includes;
        private String excludes;

        public String getIncludes() {
            return includes;
        }

        public void setIncludes(String includes) {
            this.includes = includes;
        }

        public String getExcludes() {
            return excludes;
        }

        public void setExcludes(String excludes) {
            this.excludes = excludes;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public List<String> getInclude() {
            return include;
        }

        public void setInclude(List<String> include) {
            this.include = include;
        }

        public List<String> getExclude() {
            return exclude;
        }

        public void setExclude(List<String> exclude) {
            this.exclude = exclude;
        }
    }

    public static class Con implements Serializable {

        private static final long serialVersionUID = -7683428951868158476L;
        private int skip;
        private int display;

        public int getSkip() {
            return skip;
        }

        public void setSkip(int skip) {
            this.skip = skip;
        }

        public int getDisplay() {
            return display;
        }

        public void setDisplay(int display) {
            this.display = display;
        }
    }

    public static class Conﬁg implements Serializable {

        private static final long serialVersionUID = -7683428951868158476L;
        private Appearance appearance;
        private Settings settings;

        public Appearance getAppearance() {
            return appearance;
        }

        public void setAppearance(Appearance appearance) {
            this.appearance = appearance;
        }

        public Settings getSettings() {
            return settings;
        }

        public void setSettings(Settings settings) {
            this.settings = settings;
        }
    }

    public static class Settings implements Serializable {

        private static final long serialVersionUID = -7683428951868158476L;
        private Collect collect;
        private EndShow endShow;

        public Collect getCollect() {
            return collect;
        }

        public void setCollect(Collect collect) {
            this.collect = collect;
        }

        public EndShow getEndShow() {
            return endShow;
        }

        public void setEndShow(EndShow endShow) {
            this.endShow = endShow;
        }
    }

    public static class Collect implements Serializable {

        private static final long serialVersionUID = -7683428951868158476L;
        private Limit limit;
        private Record record;

        public Limit getLimit() {
            return limit;
        }

        public void setLimit(Limit limit) {
            this.limit = limit;
        }

        public Record getRecord() {
            return record;
        }

        public void setRecord(Record record) {
            this.record = record;
        }
    }

    public static class Record implements Serializable {

        private static final long serialVersionUID = -7683428951868158476L;
        private String ua;
        private String ip;
        private String from;
        private int phone;
        private int gender;
        private int email;
        private int age;
        private int pro;

        public String getUa() {
            return ua;
        }

        public void setUa(String ua) {
            this.ua = ua;
        }

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public int getPhone() {
            return phone;
        }

        public void setPhone(int phone) {
            this.phone = phone;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public int getEmail() {
            return email;
        }

        public void setEmail(int email) {
            this.email = email;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int getPro() {
            return pro;
        }

        public void setPro(int pro) {
            this.pro = pro;
        }
    }

    public static class Limit implements Serializable {

        private static final long serialVersionUID = -7683428951868158476L;
        private int cookie;
        private int ip;
        private int count;
        private long time;

        public int getCookie() {
            return cookie;
        }

        public void setCookie(int cookie) {
            this.cookie = cookie;
        }

        public int getIp() {
            return ip;
        }

        public void setIp(int ip) {
            this.ip = ip;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public long getTime() {
            return time;
        }

        public void setTime(long time) {
            this.time = time;
        }
    }

    public static class EndShow implements Serializable {

        private static final long serialVersionUID = -7683428951868158476L;
        private int share;
        private int showResult;

        public int getShare() {
            return share;
        }

        public void setShare(int share) {
            this.share = share;
        }

        public int getShowResult() {
            return showResult;
        }

        public void setShowResult(int showResult) {
            this.showResult = showResult;
        }
    }

    public static class Appearance implements Serializable {

        private static final long serialVersionUID = -7683428951868158476L;
        private Common common;
        private Phone phone;
        private Pad pad;
        private Display display;

        public Common getCommon() {
            return common;
        }

        public void setCommon(Common common) {
            this.common = common;
        }

        public Phone getPhone() {
            return phone;
        }

        public void setPhone(Phone phone) {
            this.phone = phone;
        }

        public Pad getPad() {
            return pad;
        }

        public void setPad(Pad pad) {
            this.pad = pad;
        }

        public Display getDisplay() {
            return display;
        }

        public void setDisplay(Display display) {
            this.display = display;
        }
    }

    public static class Display implements Serializable {

        private static final long serialVersionUID = -7683428951868158476L;
        private int way;

        public int getWay() {
            return way;
        }

        public void setWay(int way) {
            this.way = way;
        }
    }

    public static class Pad implements Serializable {

        private static final long serialVersionUID = -7683428951868158476L;
        private String theme;
        private String bgk;

        public String getTheme() {
            return theme;
        }

        public void setTheme(String theme) {
            this.theme = theme;
        }

        public String getBgk() {
            return bgk;
        }

        public void setBgk(String bgk) {
            this.bgk = bgk;
        }
    }

    public static class Phone implements Serializable {

        private static final long serialVersionUID = -7683428951868158476L;
        private String theme;
        private String bgk;

        public String getTheme() {
            return theme;
        }

        public void setTheme(String theme) {
            this.theme = theme;
        }

        public String getBgk() {
            return bgk;
        }

        public void setBgk(String bgk) {
            this.bgk = bgk;
        }
    }

    public static class Common implements Serializable {

        private static final long serialVersionUID = -7683428951868158476L;
        private String theme;
        private String bgk;

        public String getTheme() {
            return theme;
        }

        public void setTheme(String theme) {
            this.theme = theme;
        }

        public String getBgk() {
            return bgk;
        }

        public void setBgk(String bgk) {
            this.bgk = bgk;
        }
    }

    public static class Body implements Serializable {

        private static final long serialVersionUID = -7683428951868158476L;
        private List<Locales> locales;

        public List<Locales> getLocales() {
            return locales;
        }

        public void setLocales(List<Locales> locales) {
            this.locales = locales;
        }
    }

    public static class Locales implements Serializable {

        private static final long serialVersionUID = -7683428951868158476L;
        private String lang;
        private String title;
        private String closeMsg;
        private String summary;
        private String giveUp;
        private List<String> cover;
        private String icon;

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

        public String getCloseMsg() {
            return closeMsg;
        }

        public void setCloseMsg(String closeMsg) {
            this.closeMsg = closeMsg;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getGiveUp() {
            return giveUp;
        }

        public void setGiveUp(String giveUp) {
            this.giveUp = giveUp;
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
    }

    /**
     * 这里获取全部数据
     *
     * @param field
     * @return
     */
    @Override
    public VoteAquestionnaire fill(Fields field) {
        VoteAquestionnaire tc = null;
        if (null != field) {
            tc = new VoteAquestionnaire();
            tc.setId(field.getString("_" + Meta.ID));
            tc.setTid(field.getString(Meta.TID));
            tc.setCrtAt(field.getLong(Meta.CRTAT));
            tc.setUpdAt(field.getLong(Meta.UPDAT));
            tc.setAlias(field.getString(Meta.ALIAS));
            tc.setType(field.getInt(Meta.TYPE));
            tc.setItemEdiable(field.getInt(Meta.ITEMEDIABLE));
            tc.setUid(field.getString(Meta.UID));
            tc.setStatus(field.getInt(Meta.STATUS));

            BasicDBObject body = field.get(Meta.BODY);
            BasicBSONList locales = (BasicBSONList) body.get(Meta.LOCALES);
            Body bodys = new Body();
            if (null != locales) {
                List<Locales> listLocales = new ArrayList<Locales>();
                for (int i = 0; locales.size() > i; i++) {
                    BasicDBObject locale = (BasicDBObject) locales.get(i);
                    Locales loc = new Locales();
                    loc.setLang(locale.getString(Meta.LANG));
                    loc.setTitle(locale.getString(Meta.TITLE));
                    loc.setCloseMsg(locale.getString(Meta.CLOSEMSG));
                    loc.setSummary(locale.getString(Meta.SUMMARY));
                    loc.setGiveUp(locale.getString(Meta.GIVEUP));
                    loc.setIcon(locale.getString(Meta.ICON));

                    tc.setTitle(locale.getString(Meta.TITLE));
                    tc.setIcon(locale.getString(Meta.ICON));
                    tc.setCloseMsg(locale.getString(Meta.CLOSEMSG));
                    tc.setSummary(locale.getString(Meta.SUMMARY));
                    tc.setGiveUP(locale.getString(Meta.GIVEUP));

                    List<String> listCover = new ArrayList<String>();

                    BasicBSONList covers = (BasicBSONList) locale.get(Meta.COVER);
                    if (null != covers) {
                        for (int j = 0; covers.size() > j; j++) {
                            listCover.add((String) covers.get(j));
                        }
                    }
                    tc.setCover(listCover);
                    loc.setCover(listCover);
                    listLocales.add(loc);
                }
                bodys.setLocales(listLocales);
            }
            tc.setBody(bodys);

            BasicDBObject configf = field.get(Meta.CONFIG);
            Conﬁg config = new Conﬁg();
            BasicDBObject appearancef = (BasicDBObject) configf.get(Meta.APPEARANCE);
            Appearance appearance = new Appearance();
            BasicDBObject commonf = (BasicDBObject) appearancef.get(Meta.COMMON);
            if (null != commonf) {
                Common common = new Common();
                common.setBgk(null != commonf.get(Meta.BGK) ? commonf.getString(Meta.BGK) : "");
                common.setTheme(null != commonf.get(Meta.THEME) ? commonf.getString(Meta.THEME) : "");
                appearance.setCommon(common);
            }
            BasicDBObject phonef = (BasicDBObject) appearancef.get(Meta.PHONE);
            if (null != phonef) {
                Phone phone = new Phone();
                phone.setTheme(null != phonef.get(Meta.THEME) ? phonef.getString(Meta.THEME) : "");
                phone.setBgk(null != phonef.get(Meta.BGK) ? phonef.getString(Meta.BGK) : "");
                appearance.setPhone(phone);
            }
            BasicDBObject padf = (BasicDBObject) appearancef.get(Meta.PAD);
            if (null != padf) {
                Pad pad = new Pad();
                pad.setTheme(null != padf.get(Meta.THEME) ? padf.getString(Meta.THEME) : "");
                pad.setBgk(null != padf.get(Meta.BGK) ? padf.getString(Meta.BGK) : "");
                appearance.setPad(pad);
            }
            BasicDBObject displayf = (BasicDBObject) appearancef.get(Meta.DISPLAY);
            if (null != displayf) {
                Display display = new Display();
                display.setWay(null != displayf.get(Meta.WAY) ? displayf.getInt(Meta.WAY) : 2);
                tc.setWay(null != displayf.get(Meta.WAY) ? displayf.getInt(Meta.WAY) : 2);
                appearance.setDisplay(display);
            }
            config.setAppearance(appearance);
            BasicDBObject settingsf = (BasicDBObject) configf.get(Meta.SETTINGS);
            Settings settings = new Settings();
            BasicDBObject endshowf = (BasicDBObject) settingsf.get(Meta.ENDSHOW);
            EndShow endshow = new EndShow();
            endshow.setShare(endshowf.getInt(Meta.SHARE));
            tc.setShare(endshowf.getInt(Meta.SHARE));
            endshow.setShowResult(endshowf.getInt(Meta.SHOWRESULT));
            tc.setShowResult(endshowf.getInt(Meta.SHOWRESULT));
            settings.setEndShow(endshow);
            BasicDBObject collectf = (BasicDBObject) settingsf.get(Meta.COLLECT);
            Collect collect = new Collect();
            BasicDBObject limitf = (BasicDBObject) collectf.get(Meta.LIMIT);
            Limit limit = new Limit();
            limit.setCookie(limitf.getInt(Meta.COOKIE));
            tc.setCookie(limitf.getInt(Meta.COOKIE));
            limit.setCount(limitf.getInt(Meta.COUNT));
            tc.setCount(limitf.getInt(Meta.COUNT));
            limit.setIp(limitf.getInt(Meta.IP));
            tc.setIp(limitf.getInt(Meta.IP));
            limit.setTime(limitf.getLong(Meta.TIME));
            tc.setTime(limitf.getLong(Meta.TIME));
            tc.setTimeAt(TimeUitls.formatTime(limitf.getLong(Meta.TIME)));
            collect.setLimit(limit);
            BasicDBObject recordf = (BasicDBObject) collectf.get(Meta.RECORD);
            Record record = new Record();
            record.setAge(recordf.getInt(Meta.AGE));
            tc.setAge(recordf.getInt(Meta.AGE));
            record.setEmail(recordf.getInt(Meta.EMAIL));
            tc.setEmail(recordf.getInt(Meta.EMAIL));
            record.setFrom(recordf.getString(Meta.FROM));
            record.setGender(recordf.getInt(Meta.GENDER));
            tc.setGender(recordf.getInt(Meta.GENDER));
            record.setIp(recordf.getString(Meta.IP));
            record.setPhone(recordf.getInt(Meta.PHONE));
            tc.setPhone(recordf.getInt(Meta.PHONE));
            record.setPro(recordf.getInt(Meta.PRO));
            tc.setPro(recordf.getInt(Meta.PRO));
            record.setUa(recordf.getString(Meta.UA));
            collect.setRecord(record);
            settings.setCollect(collect);
            config.setSettings(settings);
            tc.setConfig(config);

            BasicBSONList itemsf = (BasicBSONList) field.get(Meta.ITEMS);
            List<Items> listItems = new ArrayList<Items>();
            if (null != itemsf) {
                for (int i = 0; itemsf.size() > i; i++) {
                    BasicDBObject item = (BasicDBObject) itemsf.get(i);
                    Items items = new Items();
                    items.setId(item.getString(Meta.ID));
                    items.setUuid(item.getString(Meta.UUID));
                    items.setLang(item.getString(Meta.LANG));
                    items.setTitle(item.getString(Meta.TITLE));
                    items.setType(item.getInt(Meta.TYPE));
                    BasicDBObject conf = (BasicDBObject) item.get(Meta.CONFIG);
                    Con con = new Con();
                    con.setDisplay(conf.getInt(Meta.DISPLAY));
                    con.setSkip(conf.getInt(Meta.SKIP));
                    items.setConfig(con);
                    BasicBSONList optionsf = (BasicBSONList) item.get(Meta.OPTIONS);
                    List<Options> listOptions = new ArrayList<Options>();
                    if (null != optionsf) {
                        for (int j = 0; optionsf.size() > j; j++) {
                            BasicDBObject optionsbf = (BasicDBObject) optionsf.get(j);
                            Options options = new Options();
                            options.setId(optionsbf.getString(Meta.ID));
                            options.setCover(optionsbf.getString(Meta.COVER));
                            options.setTitle(optionsbf.getString(Meta.TITLE));
                            options.setPer(optionsbf.getString(Meta.PER));
                            options.setPos(optionsbf.getInt(Meta.POS));
                            BasicDBObject rulef = (BasicDBObject) optionsbf.get(Meta.RULE);
                            if (null != rulef) {
                                Rule rule = new Rule();
                                rule.setType(rulef.getInt(Meta.TYPE));
                                BasicBSONList excludef = (BasicBSONList) rulef.get(Meta.EXCLUDE);
                                List<String> listExcludef = new ArrayList<String>();
                                String exs = "";
                                Boolean be = false;
                                if (null != excludef) {
                                    for (int k = 0; excludef.size() > k; k++) {
                                        if (be) exs += ",";
                                        listExcludef.add((String) excludef.get(k));
                                        exs += (String) excludef.get(k);
                                        be = true;
                                    }
                                }
                                rule.setExcludes(exs);
                                rule.setExclude(listExcludef);
                                BasicBSONList includef = (BasicBSONList) rulef.get(Meta.INCLUDE);
                                List<String> listIncludef = new ArrayList<String>();
                                String ins = "";
                                Boolean bi = false;
                                if (null != includef) {
                                    for (int k = 0; includef.size() > k; k++) {
                                        if (bi) ins += ",";
                                        listIncludef.add((String) includef.get(k));
                                        ins += (String) includef.get(k);
                                        bi = true;
                                    }
                                }
                                rule.setIncludes(ins);
                                rule.setInclude(listIncludef);
                                options.setRule(rule);
                            }
                            listOptions.add(options);
                        }
                        items.setOptions(listOptions);
                    }
                    listItems.add(items);
                }
                tc.setItems(listItems);
            }
        }
        return tc;
    }

    public static final class Meta {
        public static final String TABLENAME = "questionnaire";
        public static final String ID = "id";
        public static final String TID = "tid";
        public static final String CRTAT = "crtAt";
        public static final String UPDAT = "updAt";
        public static final String ALIAS = "alias";
        public static final String UUID = "uuid";
        public static final String ITEMEDIABLE = "itemEdiable";
        public static final String UID = "uid";
        public static final String STATUS = "status";
        public static final String BODY = "body";
        public static final String LOCALES = "locales";
        public static final String LANG = "lang";
        public static final String TITLE = "title";
        public static final String CLOSEMSG = "closeMsg";
        public static final String SUMMARY = "summary";
        public static final String GIVEUP = "giveUP";
        public static final String COVER = "cover";
        public static final String ICON = "icon";
        public static final String CONFIG = "conﬁg";
        public static final String APPEARANCE = "appearance";
        public static final String COMMON = "common";
        public static final String THEME = "theme";
        public static final String BGK = "bgk";
        public static final String PHONE = "phone";
        public static final String PAD = "pad";
        public static final String DISPLAY = "display";
        public static final String WAY = "way";
        public static final String SETTINGS = "settings";
        public static final String COLLECT = "collect";
        public static final String LIMIT = "limit";
        public static final String COOKIE = "cookie";
        public static final String IP = "ip";
        public static final String COUNT = "count";
        public static final String TIME = "time";
        public static final String RECORD = "record";
        public static final String UA = "ua";
        public static final String FROM = "from";
        public static final String GENDER = "gender";
        public static final String EMAIL = "email";
        public static final String AGE = "age";
        public static final String PRO = "pro";
        public static final String ENDSHOW = "endShow";
        public static final String SHARE = "share";
        public static final String SHOWRESULT = "showResult";
        public static final String ITEMS = "items";
        public static final String SKIP = "skip";
        public static final String OPTIONS = "options";
        public static final String POS = "pos";
        public static final String PER = "per";
        public static final String RULE = "rule";
        public static final String TYPE = "type";
        public static final String INCLUDE = "include";
        public static final String EXCLUDE = "exclude";
        //状态定义
        public static final int STAUTS_OPEN = 1;
        public static final int STAUTS_DRAFT = 2;
        public static final int STAUTS_CLOSE = 9;
    }
}
