package top.geekarea.controller;

import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by code_xia on 2017/3/28.
 */
@RestController
public class Test {

    @GetMapping(value = "/word", params = "word")
    public String word(@Param(value = "word")String word){
        return word;
    }

    @GetMapping(value = "/test")
    public String test(){
        return "test";
    }

    @GetMapping(value = "/test1")
    public String test1(){
        return "test1";
    }

//    @PostMapping(value = "/loginpost")
//    public HTTPResult loginPost() throws Exception {
////        User user = new User();
////        user.setAge(20);
////        user.setSex("nam");
////        user.setUserName("user");
////        User user1 = new User();
////        user1.setAge(210);
////        user1.setSex("nam1");
////        user1.setUserName("user1");
//        List list = new ArrayList();
////        list.add(user);
////        list.add(user1);
//        return ResultUtil.success(list);
//    }
}
