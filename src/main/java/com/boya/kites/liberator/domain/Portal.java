package com.boya.kites.liberator.domain;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import org.canedata.field.Fields;

import java.util.ArrayList;
import java.util.List;

/**
 * Created  IN BOYA by BaiLiJun on 14/12/24.
 */
public class Portal implements Base<Portal> {
    private News pic;
    private List<News> list;
    private String tid;
    private List<Video> videos;
    private List<App> apps;
    private List<App> games;
    private List<Seminar> seminars;
    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public News getPic() {
        return pic;
    }

    public void setPic(News pic) {
        this.pic = pic;
    }

    public List<News> getList() {
        return list;
    }

    public void setList(List<News> list) {
        this.list = list;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    public List<App> getApps() {
        return apps;
    }

    public void setApps(List<App> apps) {
        this.apps = apps;
    }

    public List<App> getGames() {
        return games;
    }

    public void setGames(List<App> games) {
        this.games = games;
    }

    public List<Seminar> getSeminars() {
        return seminars;
    }

    public void setSeminars(List<Seminar> seminars) {
        this.seminars = seminars;
    }

    @Override
    public Portal fill(Fields field) {
        Portal portal = null;
        if (null != field) {
            portal = new Portal();
            portal.setTid(field.getString(Meta.TID));
            BasicDBObject news = field.get(Meta.NEWS);
            BasicDBList list = (BasicDBList) news.get(Meta.LIST);
            List<News> newses = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                BasicDBObject _t = (BasicDBObject) list.get(i);
                News news1 = new News();
                BasicDBList locales = (BasicDBList) _t.get("locales");
                BasicDBObject locale = (BasicDBObject) locales.get(0);
                news1.setTitle(locale.getString("title"));
                news1.setIcon(locale.getString("icon"));
                news1.setSubTitle(locale.getString("subTitle"));
                news1.setContent(locale.getString("content"));
                news1.setId(_t.getString("id"));
                BasicDBObject c = (BasicDBObject) _t.get("c");
                BasicDBObject r = (BasicDBObject) c.get("r");
                Clazz root = new Clazz();
                root.setId(r.getString("id"));
                root.setName(r.getString("name"));
                newses.add(news1);
            }
            portal.setList(newses);
            BasicDBObject basicDBObject = (BasicDBObject) news.get("pic");
            News pic = new News();
            pic.setId(basicDBObject.getString("id"));
            pic.setSubject(basicDBObject.getString("subject"));
            List<String> cover = new ArrayList<>();
            BasicDBList locales = (BasicDBList) basicDBObject.get("locales");
            BasicDBObject locale = (BasicDBObject) locales.get(0);
            BasicDBList basicDBList = (BasicDBList) locale.get("cover");
            for (int i = 0; i < basicDBList.size(); i++) {
                cover.add(((BasicDBObject) basicDBList.get(i)).getString("cover"));
            }
            pic.setCover(cover);
            portal.setPic(pic);
            BasicDBList basicDBList1 = field.get(Meta.SEMINAR);
            List<Seminar> seminars = new ArrayList<>();
            for (int i = 0; i < basicDBList1.size(); i++) {
                BasicDBObject _t = (BasicDBObject) basicDBList1.get(i);
                Seminar seminar = new Seminar();
                seminar.setId(_t.getString("id"));
                seminar.setUrl(_t.getString("url"));
                BasicDBList basicDBList2 = (BasicDBList) _t.get("cover");
                List<String> secover = new ArrayList<>();
                for (int j = 0; j < basicDBList2.size(); j++) {
                    secover.add((String) basicDBList2.get(j));
                }
                seminar.setCover(secover);
                BasicDBObject bdisplay = (BasicDBObject) _t.get(Seminar.Meta.DISPLAY);
                Seminar.Display display = new Seminar.Display();
                display.setType(bdisplay.getInt(Seminar.Meta.TYPE));
                display.setStyle(bdisplay.getInt(Seminar.Meta.STYLE));
                seminar.setDisplay(display);
                seminars.add(seminar);
            }
            portal.setSeminars(seminars);
            BasicDBList basicDBListVideo = field.get("video");
            List<Video> vs = new ArrayList<>();
            for (int i = 0; i < basicDBListVideo.size(); i++) {
                BasicDBObject _t = (BasicDBObject) basicDBListVideo.get(i);
                Video video = new Video();
                video.setId(_t.getString("id"));
                video.setUrl(_t.getString("url"));
                video.setSubject(_t.getString("subject"));
                BasicDBList covers = (BasicDBList) _t.get("cover");
                List<String> lcovers = new ArrayList<>();
                for (int j = 0; j < covers.size(); j++) {
                    lcovers.add((String) covers.get(j));
                }
                video.setCover(lcovers);
                vs.add(video);
            }
            portal.setVideos(vs);
            BasicDBList abs = field.get("game");
            List<App> appList = new ArrayList<>();
            for (int i = 0; i < abs.size(); i++) {
                BasicDBObject _t = (BasicDBObject) abs.get(i);
                App app = new App();
                app.setCatalog(_t.getInt("catalog"));
                app.setEnvironment(_t.getInt("environment"));
                app.setName(_t.getString("name"));
                app.setIcon(_t.getString("icon"));
                BasicDBObject c = (BasicDBObject) _t.get("c");
                BasicDBObject r = (BasicDBObject) c.get("r");
                Clazz root = new Clazz();
                root.setId(r.getString("id"));
                root.setName(r.getString("name"));
                app.setRoot(root);
                appList.add(app);
            }
            portal.setApps(appList);
            BasicDBList gbs = field.get("app");
            List<App> gList = new ArrayList<>();
            for (int i = 0; i < gbs.size(); i++) {
                BasicDBObject _t = (BasicDBObject) gbs.get(i);
                App app = new App();
                app.setCatalog(_t.getInt("catalog"));
                app.setEnvironment(_t.getInt("environment"));
                app.setName(_t.getString("name"));
                app.setIcon(_t.getString("icon"));
                BasicDBObject c = (BasicDBObject) _t.get("c");
                BasicDBObject r = (BasicDBObject) c.get("r");
                Clazz root = new Clazz();
                root.setId(r.getString("id"));
                root.setName(r.getString("name"));
                app.setRoot(root);
                gList.add(app);
            }
            portal.setGames(gList);
        }
        return portal;
    }

    public static final class Meta {
        public static final String TABLENAME = "portal";
        public static final String TID = "tid";
        public static final String NEWS = "news";
        public static final String PIC = "pic";

        public static final String LIST = "list";

        public static final String SEMINAR = "seminar";

        public static final String VIDEO = "video";

        public static final String APP = "app";

        public static final String GAME = "game";

    }
}
