package com.meijunjie.springboot.interceptor;

import org.springframework.boot.web.servlet.server.Session;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Locale;

/**
 *
 * @author meijunjie
 * @date 2018/9/20
 */
public class I18nInterceptor extends HandlerInterceptorAdapter {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        String locale = request.getParameter("locale");
        if(locale != null && session != null){
            switch (locale) {
                case "CN":
                    session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, Locale.SIMPLIFIED_CHINESE);
                    break;
                case "US":
                    session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, new Locale("en", "US"));
                    break;
                case "HK":
                    session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, new Locale("zh", "HK"));
                    break;
                default:
                    session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, Locale.SIMPLIFIED_CHINESE);
            }
        }

        if(session != null){
            Locale localeInfo = (Locale) request.getSession().getAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
            request.setAttribute("country",localeInfo != null ? localeInfo.getCountry() : "CN");
        }

        return true;
    }
}
