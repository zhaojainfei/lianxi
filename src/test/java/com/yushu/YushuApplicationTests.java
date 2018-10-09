package com.yushu;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
// 这里后面的参数是手动写的
@SpringBootTest(classes = Application.class)
// 单元测试接口
@AutoConfigureMockMvc
public class YushuApplicationTests {
	@Autowired
	private MockMvc mockMvc;

//	@Test
//	public void TestApi() throws Exception{
//		// 模拟一个请求
//		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/getUser?cityId=100&userId=200")).andReturn();
//		TestCase.assertEquals(mvcResult.getResponse().getStatus(),200);
//	}
//
	@Test
	public void contextLoads() {
		TestCase.assertEquals(1,1);
	}
}
