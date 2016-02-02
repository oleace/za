package com.boya.kites.liberator.domain;

import org.canedata.field.Fields;

import java.util.List;

/**
 * Created  IN BOYA by BaiLiJun on 14/12/24.
 * 首页专题
 */
public class Seminar implements Base<Seminar> {
    private String id;
    private List<String> cover;
    private String url;
    private Display display;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getCover() {
        return cover;
    }

    public void setCover(List<String> cover) {
        this.cover = cover;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Display getDisplay() {
        return display;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }

    @Override
    public Seminar fill(Fields field) {
        return null;
    }

    public static class Display {
        private int type;
        private int style;

        public int getStyle() {
            return style;
        }

        public void setStyle(int style) {
            this.style = style;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }

    public static final class Meta {
        public static final String TABLENAME = "seminar";
        public static final String ID = "id";
        public static final String COVER = "cover";
        public static final String URL = "url";
        public static final String DISPLAY = "display";
        public static final String TYPE = "type";
        public static final String STYLE = "style";
    }
}
