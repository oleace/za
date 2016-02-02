package com.boya.kites.reel.user;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.boya.commons.Constant;
import com.boya.commons.Result;
import com.boya.kites.liberator.domain.OrganQuota;
import com.boya.kites.liberator.domain.OrganizationJSON;
import com.boya.kites.liberator.domain.UserJSON;
import com.github.moor.ActionContext;
import org.canedata.core.logging.LoggerFactory;
import org.canedata.core.util.StringUtils;
import org.canedata.logging.Logger;
import org.springframework.context.ApplicationContext;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with in boya.
 * User: lz
 * Date: 14-12-2
 */
public class UserAction {

    private static final Logger LOG = LoggerFactory.getLogger(UserAction.class);

    public static final String LOGINERROR = "/index";

    public String index() {
        HttpServletRequest request = ActionContext.getContext().getRequest();
        request.setAttribute("backward", request.getParameter("backward"));
        UserJSON user = (UserJSON) request.getSession().getAttribute(Constant.SESSIONUSER);
        if (null == user) return "/login.jsp";
        if (StringUtils.isBlank(request.getParameter("backward")) && null != user)
            return "rdt:" + request.getContextPath() + "/cms/index";
        return "rdt:" + request.getParameter("backward");
    }

    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    public String contract() {
        return "/team/user/contract.jsp";
    }

    /**
     * 接受许可协议
     *
     * @return
     */
    public Result accept() throws Exception {
        ApplicationContext spring = ActionContext.getContext().getSpring();
        HttpServletRequest request = ActionContext.getContext().getRequest();
        HttpServletResponse response = ActionContext.getContext().getResponse();
        UserJSON users = (UserJSON) request.getSession().getAttribute(
                Constant.SESSIONUSER);
        Result rlt = new Result();
//        AccountService accountService = (AccountService) spring.getBean("accountService");
//        accountService.accept(getIpAddr(request),users.getOrgan().getId(),users.getId());
//        rlt.setResultCode(Result.SUCCESS);
//        request.getSession().removeAttribute(Constants.ACCOUNT);
//        Account account = accountService.restore(users.getOrgan().getId());
//        request.getSession().setAttribute(Constants.ACCOUNT,account);

        rlt.setMsg("ok");
        return rlt;
    }
}
