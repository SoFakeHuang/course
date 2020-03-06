package cn.hhj.course.interceptor;

import cn.hhj.course.BaseInfo;
import cn.hhj.course.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 方法耗时统计拦截器
 */
public class MethodTimerInterceptor implements HandlerInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodTimerInterceptor.class);

    /**
     * 前置功能，将用户访问信息用日志记录
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        //定义开始时间
        long start = System.currentTimeMillis();
        //将开始时间放入请求域
        request.setAttribute("start",start);
        //返回true，才会找下一个拦截器，如果没有下一个，则到Controller
        //记录请求日志
        if (session == null || session.getAttribute(BaseInfo.USER) == null) {
            LOGGER.info("访问 " + request.getRequestURI());
        }else{
            User user = (User)session.getAttribute(BaseInfo.USER);
            LOGGER.info("用户:"+ user.getAccount() + " 访问 " + request.getRequestURI());
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        long start = (Long) request.getAttribute("start");
        //获得到达时间
        long end = System.currentTimeMillis();
        //记录耗时
        long spendTime = end - start;
        if(spendTime>1000){
            LOGGER.warn("方法耗时严重，请及时处理，耗时："+ spendTime + "毫秒");
        }else{
            LOGGER.info("方法耗时："+ spendTime + "毫秒，速度正常");
    }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
