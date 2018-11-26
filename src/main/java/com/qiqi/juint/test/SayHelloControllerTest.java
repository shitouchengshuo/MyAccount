package com.qiqi.juint.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration //声明一个ApplicationContext集成测试加载WebApplicationContext，作用是模拟ServletContext
@ContextConfiguration(locations={"classpath:spring/spring-application.xml"})// 指定spring的配置文件扫描相应的注解等配置将类初始化等
public class SayHelloControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup()  {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void testHelloWorld() throws Exception {

        mockMvc.perform(get("/myTest/sayHello1"))//请求的url,请求的方法是get
                .andDo(print());//添加ResultHandler结果处理器，比如调试时打印结果到控制台


        MvcResult mvResult = mockMvc.perform(MockMvcRequestBuilders.get("/myTest/sayHello2")).
                //andExpect:添加ResultMatcher验证规则，验证控制器执行完成后结果是否正确（对返回的数据进行的判断）
                andExpect(view().name("user/view"))
                .andExpect(model().attributeExists("user"))
                .andDo(print())
                .andReturn();//最后返回相应的MvcResult

        System.out.println(mvResult.getModelAndView().getModel().get("user").toString());
    }
}
