package com.demo.interceptor;

import com.demo.entity.Person;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by x250 on 2016/10/27.
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

    //private static Map<String,String> loginInfo = new HashMap<String, String>();
    @SuppressWarnings("unchecked")
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{

        Person person = (Person) request.getSession().getAttribute("person");
        //System.out.print(person);
        if (person == null) {
            request.setAttribute("message", "您尚未登录或您的登录已过期，请先登录！！！");
            request.getRequestDispatcher("/person").forward(request, response);
            System.out.println("拦截器起作用了");
            return false;
        } else {
            //Object sessionId = request.getSession().getId();
            //System.out.print(sessionId);
            //System.out.print(request.getSession().getAttribute("personId"));
            //&& sessionId.equals(request.getSession().getAttribute("personId"))
             //if (sessionId != null) {
                 return true;
             //} else {
               // request.getSession().removeAttribute("person");
                // request.setAttribute("message", "您的帐号已在其它地方登录！！！");
                 //request.getRequestDispatcher("/personLogin").forward(request, response);
             }

            // loginInfo.remove(key);
        }
        //return false;
        }


