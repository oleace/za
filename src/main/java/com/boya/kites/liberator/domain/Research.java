package com.boya.kites.liberator.domain;

import org.bson.BasicBSONObject;
import org.bson.types.BasicBSONList;
import org.canedata.field.Fields;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created  IN BOYA by lz on 15-6-12.
 */
public class Research implements Serializable, Base<Research> {

    private static final long serialVersionUID = -7683428951868158476L;
    private String id;
    private String refID;
    private String tid;
    private Collection collection;
    private List<As> as;
    private VoteAquestionnaire vaqs;

    public VoteAquestionnaire getVaqs() {
        return vaqs;
    }

    public void setVaqs(VoteAquestionnaire vaqs) {
        this.vaqs = vaqs;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRefID() {
        return refID;
    }

    public void setRefID(String refID) {
        this.refID = refID;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public Collection getCollection() {
        return collection;
    }

    public void setCollection(Collection collection) {
        this.collection = collection;
    }

    public List<As> getAs() {
        return as;
    }

    public void setAs(List<As> as) {
        this.as = as;
    }

    public static class Collection implements Serializable {

        private static final long serialVersionUID = -7683428951868158476L;
        private String ua;
        private String ip;
        private long time;
        private long end;
        private String phone;
        private String mail;
        private int gender;
        private String career;
        private int age;
        private String from;
        private int finish;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

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

        public long getTime() {
            return time;
        }

        public void setTime(long time) {
            this.time = time;
        }

        public long getEnd() {
            return end;
        }

        public void setEnd(long end) {
            this.end = end;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getMail() {
            return mail;
        }

        public void setMail(String mail) {
            this.mail = mail;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public String getCareer() {
            return career;
        }

        public void setCareer(String career) {
            this.career = career;
        }

        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public int getFinish() {
            return finish;
        }

        public void setFinish(int finish) {
            this.finish = finish;
        }
    }

    public static class As implements Serializable {

        private static final long serialVersionUID = -7683428951868158476L;
        private String qid;
        private String r;

        public String getQid() {
            return qid;
        }

        public void setQid(String qid) {
            this.qid = qid;
        }

        public String getR() {
            return r;
        }

        public void setR(String r) {
            this.r = r;
        }
    }

    /**
     * 这里获取全部数据
     *
     * @param field
     * @return
     */
    @Override
    public Research fill(Fields field) {
        Research tc = null;
        if (null != field) {
            tc = new Research();
            tc.setId(field.getString("_" + Meta.ID));
            tc.setRefID(field.getString(Meta.REFID));
            tc.setTid(field.getString(Meta.TID));
            BasicBSONObject bo = (BasicBSONObject) field.get(Meta.COLLECTION);
            Collection c = new Collection();
            c.setUa(bo.getString(Meta.UA));
            c.setIp(bo.getString(Meta.IP));
            c.setTime(bo.getLong(Meta.TIME));
            c.setEnd(bo.getLong(Meta.END));
            c.setPhone(bo.getString(Meta.PHONE));
            c.setMail(bo.getString(Meta.MAIL));
            c.setGender(bo.getInt(Meta.GENDER));
            c.setCareer(bo.getString(Meta.CAREER));
            c.setAge(null != bo.get(Meta.AGE) ? bo.getInt(Meta.AGE) : 0);
            c.setFrom(bo.getString(Meta.FROM));
            c.setFinish(bo.getInt(Meta.FINISH));
            tc.setCollection(c);
            List<As> list = new ArrayList<As>();
            BasicBSONList asl = (BasicBSONList) field.get(Meta.AS);
            for (int i = 0; asl.size() > i; i++) {
                BasicBSONObject aso = (BasicBSONObject) asl.get(i);
                As as = new As();
                as.setQid(aso.getString(Meta.QID));
                as.setR(aso.getString(Meta.R));
                list.add(as);
            }
            tc.setAs(list);
        }
        return tc;
    }

    public static final class Meta {
        public static final String TABLENAME = "research";
        public static final String ID = "id";
        public static final String REFID = "refID";
        public static final String TID = "tid";
        public static final String COLLECTION = "collection";
        public static final String UID = "uid";
        public static final String UA = "ua";
        public static final String IP = "ip";
        public static final String TIME = "time";
        public static final String END = "end";
        public static final String PHONE = "phone";
        public static final String MAIL = "mail";
        public static final String GENDER = "gender";
        public static final String CAREER = "career";
        public static final String AGE = "age";
        public static final String FROM = "from";
        public static final String FINISH = "finish";
        public static final String AS = "as";
        public static final String QID = "qid";
        public static final String R = "r";

        //状态定义
        public static final int STAUTS_OPEN = 1;
        public static final int STAUTS_TEMP = 9;
    }
}
