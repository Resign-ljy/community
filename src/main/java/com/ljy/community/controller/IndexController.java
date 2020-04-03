package com.ljy.community.controller;

import com.ljy.community.dto.QuestionDTO;
import com.ljy.community.mapper.QuestionMapper;
import com.ljy.community.mapper.UserMapper;
import com.ljy.community.model.Question;
import com.ljy.community.model.User;
import com.ljy.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(HttpServletRequest request,
                        Model model){
        //得到token
        Cookie[] cookies=request.getCookies();
        if (cookies != null && cookies.length != 0)
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    String token = cookie.getValue();
                    //根据token去数据库中查找是否有该用户，判断是否存在该用户,从而实现持久化登录
                    User user = userMapper.findByToken(token);
                    if (user != null) {
                        request.getSession().setAttribute("user", user);
                    }
                    break;
                }
            }
        List<QuestionDTO> questionList=questionService.list();
            model.addAttribute("question",questionList);
        return "index";
    }

}
