package com.boya.commons;

import org.canedata.core.logging.LoggerFactory;
import org.canedata.logging.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * Created  IN BOYA by BaiLiJun on 14-10-14.
 */
public class Constant {

    private static final Logger LOG = LoggerFactory.getLogger(Constant.class);

    public static final String EXCEPTIONHINT = "occur Exception from method of {} in class {},reason is {}";

    public static final String SESSIONUSER = "user";

    public static final String AUTHORITYKEY = "authorityKey";

    public static final String SIGNATURE = "signature";

    public static final Map<String,String> countyNames = new HashMap<String,String>();

    static {
        countyNames.put("cn","中文");
        countyNames.put("us","英文");
    }

    public static final char[] cs = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
            'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
            'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8',
            '9' };

    public final class Storage{
        public static final String ROOT = "storage";//存储根目录
        public static final String PUBLIC = "storage.public";//公开文件存储路径，对应原来的root
        public static final String TEMPLATE = "storage.templ";//模板的存储路径
        public static final String ADS = "storage.ads";
    }

    public static  final class BoyaType{

        public static final String TYPE_VIDEO = "video";

        public static final String TYPE_MUSIC = "music";

        public static final String TYPE_NEWS = "news";

        public static final String TYPE_MAGAZINE = "magazine";

        public static final String TYPE_APP = "app";

        public static final String TYPE_GAME = "game";

        public static final String TYPE_TRAVEL = "travel";
    }
}
