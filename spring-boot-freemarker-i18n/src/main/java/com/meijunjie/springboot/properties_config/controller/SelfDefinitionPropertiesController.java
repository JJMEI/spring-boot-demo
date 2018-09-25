package com.meijunjie.springboot.properties_config.controller;

import com.meijunjie.springboot.common.JsonResult;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

/**
 *
 * @author meijunjie
 * @date 2018/9/21
 */

@RestController
public class SelfDefinitionPropertiesController {

    @Value("${com.app.name}")
    private String appName;

    @Value("${com.app.author}")
    private String author;

    @Value("${peter.secret}")
    private String secret;

    @Value("${peter.number}")
    private int number;

    @Value("${peter.bignumber}")
    private long bigNumber;

    @Value("${peter.uuid}")
    private String uuid;

    @Value("${peter.number.less.than.ten}")
    private int lowerTen;

    @Value("${peter.number.in.range}")
    private int numberRange;


    @RequestMapping("/selDefinitionProperties")
    public JsonResult selfDefinitionProperties(){
        class AppInfo implements Serializable{

            private static final long serialVersionUID = -5441916930153761249L;
            private String appName;
            private String author;

            public String getAppName() {
                return appName;
            }

            public void setAppName(String appName) {
                this.appName = appName;
            }

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public AppInfo(String appName, String author) {
                this.appName = appName;
                this.author = author;
            }

            public AppInfo() {
            }
        }

        return JsonResult.success(new AppInfo(appName,author));
    }


    @RequestMapping("/randomGenerate")
    public JsonResult randomGenerate(){

        @Getter
        @Setter
        @AllArgsConstructor
        @NoArgsConstructor
        class RandomInfo{
            private String secret;
            private int number;
            private long bigNumber;
            private String uuid;
            private int lowerTen;
            private int numberRange;
        }

        return JsonResult.success(new RandomInfo(secret,number,bigNumber,uuid,lowerTen,numberRange));
    }
}
