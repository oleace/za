package com.boya.kites.liberator.domain;

import org.canedata.field.Fields;

/**
 * Created  IN BOYA by BaiLiJun on 14/10/29.
 */
public class Ad implements Base<Ad> {
    private String id;
    private int order;
    private String content;
    private String type;
    private String url;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public Ad fill(Fields field) {
        Ad rlt = null;
        if (null != field) {
            rlt = new Ad();
            rlt.setId(field.getString("_id"));
            rlt.setContent(field.getString(Meta.CONTENT));
            rlt.setOrder(field.getInt(Meta.ORDER));
            rlt.setType(field.getString(Meta.TYPE));
            rlt.setUrl(field.getString(Meta.URL));
        }
        return rlt;
    }

    public static final class Meta {
        public static final String TABLENAME = "ads";
        public static final String ID = "id";
        public static final String ORDER = "order";
        public static final String CONTENT = "content";
        public static final String TYPE = "type";
        public static final String URL = "url";
        public static final String TYPE_TEXT = "text";
        public static final String TYPE_IMG = "image";
        public static final String TYPE_VIDEO = "video";
    }
}
