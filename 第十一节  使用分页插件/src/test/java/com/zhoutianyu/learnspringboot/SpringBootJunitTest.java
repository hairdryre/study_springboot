package com.zhoutianyu.learnspringboot;

import com.alibaba.fastjson.JSON;
import com.zhoutianyu.learnspringboot.test.Address;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
public class SpringBootJunitTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringBootJunitTest.class);

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void testGet() throws Exception {
        String url = "/get_test";
        Map<String, String> map = new HashMap<>();
        map.put("location", "NanJing");
        map.put("number", "123456");
        String data = get(url, map);
        System.out.println("GET请求返回值是:" + data);
    }

    @Test
    public void testPost() throws Exception {
        String url = "/post_test";
        Address address = new Address();
        address.setLocation("BeiJing");
        address.setNumber(654321L);
        String data = post(url , address);
        System.out.println("POST请求返回值是:" + data);
    }


    private String get(String url, Map<String, String> params) throws Exception {
        final MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.setAll(params);
        return mockMvc.perform(
                MockMvcRequestBuilders.get(url)
                        .params(map)
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk()).
                        andReturn().getResponse().getContentAsString();
    }

    private String post(String url, Object object) throws Exception {
        return mockMvc.perform(MockMvcRequestBuilders.post(url)
//                .header("wecSchoolId", 1).header("id", "1")
                .contentType(MediaType.APPLICATION_JSON_UTF8).content(JSON.toJSONString(object)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andReturn().getResponse().getContentAsString();
    }
}
