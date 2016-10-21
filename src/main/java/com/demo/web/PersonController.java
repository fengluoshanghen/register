package com.demo.web;



import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.demo.entity.Person;
import com.demo.manager.PersonService;

@Controller
@RequestMapping("/person")
public class PersonController {

    @Resource(name = "personService")
    private PersonService personService;

    @RequestMapping("/regist")
    public String regist(Person person, HttpServletRequest request) {
      if(personService.getPerson().contains(person.getUserName())){
          request.setAttribute("registPerson", "用户名已经存在！");
          return "/regist";
        }else {
          personService.regist(person);
          request.setAttribute("registPerson", "恭喜" + person.getUserName() + "注册成功，请登录！");
          return "/personLogin";
      }
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        String name = request.getParameter("userName");
        String pwd = request.getParameter("password");
        String code = request.getParameter("code");
        System.out.println("用户名：" + name + "；密码为:" + pwd);
        Person p = personService.login(name, pwd);
        if(session.getAttribute("code").toString()==null){
            request.setAttribute("message", "验证码失效，请刷新后重试！");
            return "/personLogin";
        }
        if (session.getAttribute("code").toString()!=null&&!(code.equalsIgnoreCase(session.getAttribute("code").toString()))) {
            request.setAttribute("message", "验证码错误！");
            return "/personLogin";
        }
        if (null != p) {
            request.setAttribute("message", "欢迎" + p.getUserName() + "登录本系统！");
            return "redirect:/user/getAllUser";
        }else{
            request.setAttribute("message", "用户名或密码错误！");
            return "/personLogin";
        }
    }


    @RequestMapping(value={"/toRegist", "person/toRegist"})
	public String toAddUser(){
		return "/regist";
	}
	
}
