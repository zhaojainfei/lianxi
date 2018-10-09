package com.yushu.controller;

import com.yushu.model.HsCardkind;
import com.yushu.service.CardKindService;
import com.yushu.task.AsyncTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;

@RestController
// 扫描application.prooerties注入配置文件中的变量 -- 不写也可以解析出来
//@PropertySource({"classpath:application.properties"})
public class OnlyApiController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AsyncTask asyncTask;

    @Value("${file.uploadPath}")
    private String filePath;

    @Autowired
    CardKindService cardKindService;

    private Map<String,Object> map = new HashMap<>();

    @RequestMapping(path = "/{city_id}/{user_id}",method = RequestMethod.GET)
    public Object findUser(@PathVariable("city_id")String cityId, @PathVariable("user_id")String userId){
        map.clear();
        map.put("cityId",cityId);
        map.put("userId",userId);
        map.put("filePath",filePath);
        return map;
    }

    // 简化上面的 http://localhost:8080/getUser?cityId=100&userId=200
    @GetMapping(value="/api/getUser")
    public Object findUser1(@RequestParam(defaultValue = "0",name = "cityId") String cityId,String userId){
        map.clear();
        map.put("cityId",cityId);
        map.put("userId",userId);
        map.put("userId1222","rebushu");
        return map;
    }

    // @RequestBody只能post提交,这里要修改postman的Header和Body中的参数形式
    // Content-Type : application/json
    //raw {"id":1,"name":"test"}
    @RequestMapping("/addUser")
    public Object addUser(@RequestBody HsCardkind user){
        map.clear();
        map.put("user",user);
        return map;
    }

    @RequestMapping(value = "/getHeader",method = RequestMethod.GET)
    public Object getHeader(@RequestHeader("access_token") String accessToken){
        map.clear();
        map.put("access_token",accessToken);
        return map;
    }

    @RequestMapping(value = "test_request",method = RequestMethod.GET)
    public Object test_request(HttpServletRequest request){
        String id = request.getParameter("id");
        map.clear();
        map.put("id",id);
        return map;
    }

    @RequestMapping(value = "/testAsync",method = RequestMethod.GET)
    public Object testAsync(){
        map.clear();
        asyncTask.test();
        Future<String> task = asyncTask.testResult();
        for (;;){
            if(task.isDone()){
                map.put("result",task);
                break;
            }
        }
        return map;
    }
}
