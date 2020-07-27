package cn.baeldung.demo;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomExceptionHandlerExceptionResolver extends AbstractHandlerExceptionResolver {
    @Override
    protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        try {
            if (ex instanceof IllegalArgumentException) {
                return handleIllegalArgument(
                        (IllegalArgumentException) ex, request, response);
            }
        } catch (Exception handlerException) {
            logger.warn("处理异常过程当中发生了异常");
        }
        return null;
    }

    private ModelAndView
    handleIllegalArgument(IllegalArgumentException ex, HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String accept = request.getHeader(MediaType.APPLICATION_JSON_VALUE);
        logger.info(accept);
        response.sendError(HttpServletResponse.SC_CONFLICT);
        return new ModelAndView();
    }
}