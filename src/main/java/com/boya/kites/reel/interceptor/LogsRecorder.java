package com.boya.kites.reel.interceptor;

import com.boya.commons.Constant;
import com.boya.kites.liberator.domain.UserJSON;
import com.boya.kites.reel.logs.Logs;
import com.boya.kites.reel.logs.LogsService;
import com.github.moor.ActionContext;
import com.github.moor.utils.ActionUtil;
import com.github.moor.utils.UriUtil;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

/**
 * Created by BaiLijun on 14-12-11.
 */
public class LogsRecorder implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        HttpServletRequest request = ActionContext.getContext().getRequest();
        HttpServletResponse response = ActionContext.getContext().getResponse();
        UserJSON userJSON = (UserJSON) request.getSession().getAttribute(Constant.SESSIONUSER);

        String uri = request.getRequestURI();

        String qs = request.getQueryString();

        String refer = request.getHeader("refer");

        Enumeration enumeration = request.getParameterNames();
        StringBuilder sb = new StringBuilder();
        while (enumeration.hasMoreElements()) {
            String p = (String) enumeration.nextElement();
            sb.append(p + "=" + request.getParameter(p));
            sb.append(" ");
        }

        LogsService logsService = ActionUtil.getBean("logsService");
        Logs logs = new Logs();
        logs.setType(Logs.Meta.TYPE_HUMAN);
        logs.setCrtAt(System.currentTimeMillis());
        UriUtil.Fragment fragment = UriUtil.fragment(request);
        logs.setUrl(uri);
        logs.setRefer(refer);
        logs.setQs(qs);
        logs.setCs(sb.toString());
        logs.setLevel(Logs.Meta.LEVEL_INFO);
        logs.setModule(fragment.first());
        logs.setTid(userJSON.getOrgan().getId());
        logs.setUid(userJSON.getId());
        logs.setSid("reelCms");
        fragment.last();
        logs.setBid(fragment.previous());
        logsService.log(logs);
        return methodInvocation.proceed();
    }
}
