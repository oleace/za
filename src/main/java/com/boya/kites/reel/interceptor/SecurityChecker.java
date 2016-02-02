package com.boya.kites.reel.interceptor;

import com.boya.commons.Constant;
import com.boya.kites.liberator.domain.UserJSON;
import com.github.moor.ActionContext;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.canedata.core.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Enumeration;

/**
 * Created by yitao on 14-3-12.
 */
public class SecurityChecker implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        HttpServletRequest request = ActionContext.getContext().getRequest();
        HttpServletResponse response = ActionContext.getContext().getResponse();
        UserJSON userJSON = (UserJSON) request.getSession().getAttribute(Constant.SESSIONUSER);
        String parameter = "", name = "", value = "";
        Boolean b = false;
        if (null == userJSON) {
            Enumeration<String> en = request.getParameterNames();
            while (en.hasMoreElements()) {
                if (b) parameter += "&";
                name = en.nextElement();
                value = request.getParameter(name);
                parameter += name + "=" + value;
                b = true;
            }

            response.sendRedirect(request.getContextPath() + "/index?backward=" + URLEncoder.encode(parameter.length() > 0 ? request.getRequestURI() + "?" + parameter : request.getRequestURI(), request.getCharacterEncoding()));
            return null;
        }

        // String action = "real:login";
        String userAction = userJSON.getActions();


        if (StringUtils.isBlank(userAction)) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return null;
            //request.getSession().setAttribute("msg", "用户权限不够，请您联系管理员。");
            //return "rdt:" + request.getContextPath() + "/index?backward=" + URLEncoder.encode(request.getRequestURI(), request.getCharacterEncoding());
        }

        if ("[null]".equals(userAction)) {

            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return null;
            //request.getSession().setAttribute("msg", "用户权限不够，请您联系管理员。");
            //return "rdt:" + request.getContextPath() + "/index?backward=" + URLEncoder.encode(request.getRequestURI(), request.getCharacterEncoding());
        }
        userAction = userAction.substring(1, userAction.length() - 1);

        String[] acts = userAction.split(",");

        if (acts.length == 0) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return null;
            //request.getSession().setAttribute("msg", "用户权限不够，请您联系管理员。");
            //return "rdt:" + request.getContextPath() + "/index?backward=" + URLEncoder.encode(request.getRequestURI(), request.getCharacterEncoding());
        }
        Arrays.sort(acts);
        /*String action = "kite:reel:Cms:syslog";
        if (Arrays.binarySearch(acts, action) < 0) {
            request.getSession().removeAttribute(Constant.SESSIONUSER);
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return null;
            //request.getSession().setAttribute("msg", "用户权限不够，请您联系管理员。");
           // return "rdt:" + request.getContextPath() + "/index?backward=" + URLEncoder.encode(request.getRequestURI(), request.getCharacterEncoding());
        }*/

       /* String module = UriUtil.fragment(request).first();

        request.setAttribute("module",module);*/

        return methodInvocation.proceed();
    }
}
