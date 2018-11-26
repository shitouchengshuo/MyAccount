package com.qiqi.testJava8;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ZhaoQiqi on 2018/11/10.
 */
public class ForeachTest {

    public static void main(String[] args) {
            int n = 1;
            switch (n) {
                case 1:
                    System.out.println("this is one.");
                    //break;
                case 2:
                    System.out.println("this is two.");
                    break;
                default:
                    System.out.println("Others.");
        }
        Map<String,User> map =new HashMap<>();
        map.put("1",new User("aa",10));
        map.put("2",new User("bb",11));
        map.put("3",new User("cc",12));

        //匹配输出，匹配项可以为list集合元素的属性（成员变量）
        map.forEach((t,v)->System.out.println("id : " + t + " User : " + v));
    }

    RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
    //                                            RequestContextHolder.getRequestAttributes();
    //从session里面获取对应的值
    String str = (String) requestAttributes.getAttribute("name",RequestAttributes.SCOPE_SESSION);

    HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();
    HttpServletResponse response = ((ServletRequestAttributes)requestAttributes).getResponse();
}
