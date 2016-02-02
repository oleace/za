package com.boya.kites.liberator.domain;

import org.canedata.field.Fields;

import java.io.Serializable;
import java.util.List;

/**
 * Created  IN BOYA by lz on 15-4-15.
 */
public class VendorNews implements Serializable, Base<VendorNews> {

    private static final long serialVersionUID = -7683428951868158476L;
    private String id;
    private String name;
    private List<relate> relates;

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

    public List<relate> getRelates() {
        return relates;
    }

    public void setRelates(List<relate> relates) {
        this.relates = relates;
    }

    public static class relate implements Serializable {

        private static final long serialVersionUID = -7683428951868158476L;
        private String tid;
        private String oid;
        private String url;

        public String getTid() {
            return tid;
        }

        public void setTid(String tid) {
            this.tid = tid;
        }

        public String getOid() {
            return oid;
        }

        public void setOid(String oid) {
            this.oid = oid;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    /**
     * 这里获取全部数据
     *
     * @param field
     * @return
     */
    @Override
    public VendorNews fill(Fields field) {
        VendorNews tc = null;
        if (null != field) {
            tc = new VendorNews();
            tc.setId(field.getString("_" + Meta.ID));
            if (null != field.get(Meta.NAME))
                tc.setName(field.getString(Meta.NAME));
//
//            BasicBSONList listCover = (BasicBSONList)field.get(Meta.RELATE);
//            List<String> cover = new ArrayList<>();
//            if(null!=listCover) {
//                for (int j = 0; listCover.size() > j; j++) {
//                    cover.add((String) listCover.get(j));
//                }
//            }
//            tc.setRelates(cover);
        }
        return tc;
    }

    public static final class Meta {
        public static final String TABLENAME = "vendor_news";
        public static final String ID = "id";
        public static final String NAME = "name";
        public static final String RELATE = "relate";
    }
}
