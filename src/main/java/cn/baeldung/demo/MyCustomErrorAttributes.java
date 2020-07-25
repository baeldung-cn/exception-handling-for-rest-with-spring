package cn.baeldung.demo;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@Component
public class MyCustomErrorAttributes extends DefaultErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(
            WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> errorAttributes =
                super.getErrorAttributes(webRequest, includeStackTrace);
        // 添加local信息
        errorAttributes.put("locale", webRequest.getLocale()
                                                .toString());
        // 移除原error信息
        errorAttributes.remove("error");

        //...

        return errorAttributes;
    }
}
