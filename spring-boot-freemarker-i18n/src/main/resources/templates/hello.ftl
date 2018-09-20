<!DOCTYPE html>
<html lang="en">
<head>
    <#import "spring.ftl" as spring>
    <meta charset="UTF-8">
    <title>国际化测试页</title>
    <script type="text/javascript" charset="utf-8" src="/static/js/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="/static/js/jquery/jquery.cookie.js"></script>
</head>
<body>
    <h1><@spring.message "分成管理平台"/></h1>

    <select id="langSel" onchange="changeLanguage(this.value);">
        <option value="CN" <#if Request["country"]?contains("CN")>selected="selected"</#if>>简体中文</option>
        <option value="US" <#if Request["country"]?contains("US")>selected="selected"</#if>>English</option>
        <option value="HK" <#if Request["country"]?contains("HK")>selected="selected"</#if>>繁體中文</option>
    </select>

    <script>
        function changeLanguage(value) {
            $.get("/changeLocale",{key:'lang',value:value},function(result){
                window.location.reload();
            });
        }
    </script>
</body>
</html>