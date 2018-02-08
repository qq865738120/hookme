package top.geekarea.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.geekarea.DAO.repository.SpeakRepository;
import top.geekarea.DAO.repository.TellImgRepository;
import top.geekarea.DAO.repository.TellRepository;
import top.geekarea.DAO.repository.UserRepository;
import top.geekarea.config.BaiduPointCongiguration;
import top.geekarea.config.NearByServiceConfiguration;
import top.geekarea.services.modules.NearbyModuleService;
import top.geekarea.utils.ResultUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

import static java.lang.System.out;

/**
 * 应用页数据接口控制类
 * Created by code_xia on 2017/4/9.
 */
@RestController
@RequestMapping(value = "/hook")
public class HookRestController {

    @Autowired
    TellRepository tellRepository;
    @Autowired
    TellImgRepository tellImgRepository;
    @Autowired
    SpeakRepository speakRepository;
    @Autowired
    BaiduPointCongiguration baiduPointCongiguration; //百度定位api配置类
    @Autowired
    NearByServiceConfiguration nearByServiceConfiguration; //附近模块配置类

    /**
     * 附近模块数据接口
     */
    @GetMapping(value = "/nearbyModule")
    public List nearbyModule(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        NearbyModuleService nearbyModuleService = new NearbyModuleService(tellRepository, tellImgRepository,
                speakRepository);
        baiduPointCongiguration.setIp("117.152.92.231");
//        baiduPointCongiguration.setIp(httpServletRequest.getRemoteAddr());
        return nearbyModuleService.getResult(nearByServiceConfiguration, baiduPointCongiguration);
    }
}
