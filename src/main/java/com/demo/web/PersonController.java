package com.demo.web;



import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import com.demo.entity.Person;
import com.demo.manager.PersonService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/person")
public class PersonController {

    @Resource(name = "personService")
    private PersonService personService;

    @SuppressWarnings({ "unchecked" })
    @RequestMapping("")
    public String loginJsp(HttpServletRequest	request,ModelMap model){
        Person person = (Person) request.getSession().getAttribute("person");
        if (person!=null ) {
                return "redirect:/person";
            }else {
                return "personLogin";
            }
        }




    @RequestMapping(value="/regist",method=RequestMethod.POST)
    public String regist(@Valid @ModelAttribute("person") Person person, BindingResult result, HttpServletRequest request) {
       // System.out.print(result.hasErrors()+"=====come here====");
            if(result.hasErrors()){
                Map<String, String> err = new HashMap<String, String>();
                List<FieldError> list = result.getFieldErrors();
                FieldError error = null;
                for (int i = 0; i < list.size(); i++) {
                    error = list.get(i);
                    err.put(error.getField(), error.getDefaultMessage());
                }
                //仍在request中,jsp页面可以直接获取。
                request.setAttribute("errfields", err);
                return "/regist";
            }else if(personService.getPerson().contains(person.getUserName())){
          request.setAttribute("registPerson", "用户名已经存在！");
          return "/regist";
        }else {
          personService.regist(person);
          request.setAttribute("registPerson", "恭喜" + person.getUserName() + "注册成功，请登录！");
          return "/personLogin";
      }
    }




    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("person")Person person ,HttpServletRequest request, HttpServletResponse response, HttpSession session,String code) {
        //String name = request.getParameter("userName");
        //String pwd = request.getParameter("password");
        //String code = request.getParameter("code");
        System.out.println("用户名：" + person.getUserName() + "；密码为:" + person.getUserPassword());
        Person p = personService.login(person.getUserName(), person.getUserPassword());
        if(null==session.getAttribute("code")){
            request.setAttribute("message", "验证码失效，请刷新后重试！");
            return "/personLogin";
        }
        if (session.getAttribute("code").toString()!=null&&!(code.equalsIgnoreCase(session.getAttribute("code").toString()))) {
            request.setAttribute("message", "验证码错误！");
            request.getSession().removeAttribute("code");
            return "/personLogin";
        }else{
            request.getSession().removeAttribute("code");
        }
        if (null != p) {
            request.setAttribute("message", "欢迎" + p.getUserName() + "登录本系统！");
            request.getSession().setAttribute("person",person);
            request.getSession().setAttribute("personId",person.getId());
            return "redirect:/user/getAllUser";
        }else{
            request.setAttribute("message", "用户名或密码错误！");
            return "/personLogin";
        }
    }

    @RequestMapping("/loginOut")
    public String loginOut(HttpServletRequest request){
        request.getSession().removeAttribute("person");
        System.out.print("====session清除完毕====");
        return "/personLogin";
    }


    @RequestMapping(value="/toRegist")
	public String toAddUser(){
		return "/regist";
	}
	
}
