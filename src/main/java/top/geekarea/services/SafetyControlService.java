package top.geekarea.services;

import top.geekarea.enums.SafetyControlResultEnum;
import top.geekarea.services.result.SafetyControlResult;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 安全控制业务类
 * Created by code_xia on 2017/5/4.
 */
public class SafetyControlService {

    /**
     * 重复提交控制
     * @param httpServletRequest
     * @param contName
     */
    public SafetyControlResult repeatCommit(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, String contName) {
        HttpSession session = httpServletRequest.getSession();
        Cookie[] cookies = httpServletRequest.getCookies();
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        SafetyControlResult safetyControlResult = null;
        String ip = null;

        /*
        把保存sessionID的cookie设置一个保存时间
        */
        if (cookies != null){
            for (Cookie c: cookies) {
                if ("JSESSIONID".equals(c.getName())) {
                    c.setMaxAge(60*60);
                    httpServletResponse.addCookie(c);
                }
            }
        }

        int cont = 0;
        if (session.getAttribute("clientIP") == null) { //session中没有保存客户端ip
            ip = httpServletRequest.getRemoteAddr();
            session.setAttribute("clientIP", ip);
        }

        ip = httpServletRequest.getRemoteAddr();
        if (ip != null && ip.equals(session.getAttribute("clientIP"))) { //ip匹配成功，客户端重复访问
            if (session.getAttribute(contName) == null) {
                session.setAttribute(contName, cont);
            }
            cont = (int)session.getAttribute(contName);
            if (!(cont == 5 || (cont > 10 && cont%2!=0))) { //在限制次数范围内
                session.setAttribute(contName, ++cont);
            }
            if (cont == 5 || (cont > 10 && cont%2!=0)){ //超出限制次数范围
                if (session.getAttribute("oldtime") == null) {
                    session.setAttribute("oldtime", format.format(new Date()));
                }
                try {
                    Long timeDiff = new Date().getTime()-format.parse((String) session.getAttribute("oldtime")).getTime(); //计算时间差
                    timeDiff %= 1493856000000l;
                    if (cont == 5) {
                        safetyControlResult = new SafetyControlResult(new Integer("0"), false, "Please wait "+(30-timeDiff/1000)+" seconds and try again");
                        if (timeDiff/1000 > 30) {
                            session.setAttribute(contName, ++cont);
                            session.setAttribute("oldtime", format.format(new Date()));
                        }
                    }
                    if (cont > 10){
                        safetyControlResult = new SafetyControlResult(new Integer("0"), false, "Please wait "+(600-timeDiff/1000)+" seconds and try again");
                        if (timeDiff/1000 > 600) {
                            session.setAttribute(contName, ++cont);
                            session.setAttribute("oldtime", format.format(new Date()));
                        }
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }

        if (cont == 5 || (cont > 10 && cont%2!=0)) {
            return safetyControlResult;
        }
        return new SafetyControlResult(SafetyControlResultEnum.REPEAT_COMMIT_SUCESS);
    }
}
