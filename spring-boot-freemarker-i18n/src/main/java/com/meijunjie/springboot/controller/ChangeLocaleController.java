package com.meijunjie.springboot.controller;

import com.meijunjie.springboot.common.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.servlet.http.HttpSession;
import java.util.Locale;

/**
 *
 * @author meijunjie
 * @date 2018/9/20
 */
@Controller
public class ChangeLocaleController {

    @RequestMapping("/changeLocale")
    @ResponseBody
    public JsonResult changeLocale(HttpSession session, String value){
        if(value != null){
            switch (value) {
                case "CN":
                    session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, Locale.SIMPLIFIED_CHINESE);
                    break;
                case "US":
                    session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, new Locale("en", value));
                    break;
                case "HK":
                    session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, new Locale("zh", "HK"));
                    break;
                default:
                    session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, new Locale("en", value));
            }
        }
        return JsonResult.success(null);
    }



}
