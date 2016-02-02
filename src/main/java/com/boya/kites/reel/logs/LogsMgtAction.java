package com.boya.kites.reel.logs;

import com.github.moor.utils.ActionUtil;
import org.canedata.core.logging.LoggerFactory;
import org.canedata.core.util.StringUtils;
import org.canedata.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created  IN BOYA by BaiLiJun on 14/12/12.
 */
public class LogsMgtAction {

    private static final Logger LOG = LoggerFactory.getLogger(LogsMgtAction.class);

    public String index() {

        HttpServletRequest request = ActionUtil.getRequest();

        LogsService logsService = ActionUtil.getBean("logsService");

        String uid = request.getParameter("uid");

        String typeStr = request.getParameter("type");

        String module = request.getParameter("module");

        String levelStr = request.getParameter("level");

        String startStr = request.getParameter("start");

        String endStr = request.getParameter("endStr");

        int type = Logs.Meta.IGNORE;

        int level = Logs.Meta.IGNORE;

        long start = Logs.Meta.IGNORE;

        long end = Logs.Meta.IGNORE;

        if (StringUtils.isNotBlank(typeStr)) {

            request.setAttribute("type", typeStr);
            try {
                type = Integer.parseInt(typeStr);
            } catch (NumberFormatException nux) {
                type = Logs.Meta.IGNORE;
            }
        }

        if (StringUtils.isNotBlank(levelStr)) {
            request.setAttribute("level", levelStr);
            try {
                level = Integer.parseInt(levelStr);

            } catch (NumberFormatException nux) {
                level = Logs.Meta.IGNORE;
            }
        }

        if (StringUtils.isNotBlank(uid)) {
            request.setAttribute("uid", uid);
        }

        if (StringUtils.isNotBlank(module)) {
            request.setAttribute("module", module);
        }

        if (StringUtils.isNotBlank(startStr)) {
            request.setAttribute("start", startStr);
            try {

                start = Long.parseLong(startStr);

            } catch (NumberFormatException nux) {
                start = Logs.Meta.IGNORE;
            }
        }

        if (StringUtils.isNotBlank(endStr)) {
            request.setAttribute("end", endStr);
            try {

                end = Long.parseLong(endStr);

            } catch (NumberFormatException nux) {
                end = Logs.Meta.IGNORE;
            }
        }

        List<Logs> rlt = logsService.gets(uid, module, type, start, end, level);

        request.setAttribute("logs", rlt);

        List<String> users = logsService.getUsers();

        request.setAttribute("users", users);

        List<String> modules = logsService.getModules();

        request.setAttribute("modules", modules);

        return "/mgt/logs/index.jsp";
    }
}
