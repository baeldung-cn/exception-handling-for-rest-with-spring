package cn.baeldung.demo;

import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Component
public class MyErrorController extends BasicErrorController {
    public MyErrorController(ErrorAttributes errorAttributes) {
        super(errorAttributes, new ErrorProperties());
    }

    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> jsonError(HttpServletRequest request) {
        // 如下开始自定义返回内容
        Map<String, Object> map = super.getErrorAttributes(request, isIncludeStackTrace(request, MediaType.ALL));
        map.put("test", "test value");
        return new ResponseEntity<Map<String, Object>>(
                map, getStatus(request)
        );
    }
}
