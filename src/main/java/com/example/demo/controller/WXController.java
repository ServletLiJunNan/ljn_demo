package com.example.demo.controller;

import com.example.demo.util.SHA1;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
//import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by za-lijunnan on 2018/8/20.
 */
@Controller
public class WXController {
    private static final String token ="WXLiJunNan";
    @ResponseBody
    @RequestMapping(value="/wx",method = RequestMethod.GET)
    public void  wx(HttpServletRequest request, HttpServletResponse response) throws IOException{
       System.out.print("11111111111111111111");
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");
        List<String> list = new ArrayList<String>();
        list.add(token);
        list.add(timestamp);
        list.add(nonce);
        //先排序
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        //在加密
        String code =  SHA1.encode(list.get(0)+list.get(1)+list.get(2));
        if(StringUtils.equals(code,signature)){
            response.getWriter().write(echostr);
           // return echostr;
        }
       // return "";
    }
    @ResponseBody
    @RequestMapping("/findList")
    public String findDemo(){
        return "拿到值了";
    }


}
