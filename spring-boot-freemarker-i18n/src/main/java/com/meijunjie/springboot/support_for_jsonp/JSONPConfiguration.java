package com.meijunjie.springboot.support_for_jsonp;

import com.meijunjie.springboot.controller.ChangeLocaleController;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

/**
 *
 * @author meijunjie @date 2018/9/25
 * AbstractJsonpResponseBodyAdvice 从5.1版本开始后将被移除
 *
 * 实现跨域访问支持
 *
 */
@ControllerAdvice(basePackageClasses = {ChangeLocaleController.class})
public class JSONPConfiguration extends AbstractJsonpResponseBodyAdvice {
    public JSONPConfiguration(){
        super("callback","jsonp");
    }
}
