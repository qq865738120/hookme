package top.geekarea.services.modules;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import top.geekarea.DAO.*;
import top.geekarea.DAO.repository.SpeakRepository;
import top.geekarea.DAO.repository.TellImgRepository;
import top.geekarea.DAO.repository.TellRepository;
import top.geekarea.DAO.repository.UserRepository;
import top.geekarea.config.BaiduPointCongiguration;
import top.geekarea.config.NearByServiceConfiguration;
import top.geekarea.entity.Tell;
import top.geekarea.entity.TellImg;
import top.geekarea.services.DataService;
import top.geekarea.services.bean.nearby.Speak;
import top.geekarea.utils.BaiDuPointUtil;
import top.geekarea.utils.Util;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 附近模块业务类
 * 实现了DataService接口
 */
public class NearbyModuleService implements DataService<List, BaiduPointCongiguration>{

    private TellRepository tellRepository; //获取说说数据的仓库
    private TellImgRepository tellImgRepository; //获取说说图片内容的仓库
    private SpeakRepository speakRepository; //获取评论内容的仓库

    public NearbyModuleService() {}

    public NearbyModuleService(TellRepository tellRepository,
                               TellImgRepository tellImgRepository,
                               SpeakRepository speakRepository) {
        this.tellImgRepository = tellImgRepository;
        this.tellRepository = tellRepository;
        this.speakRepository = speakRepository;
    }

    @Override
    public List<top.geekarea.services.bean.nearby.Tell> getResult(NearByServiceConfiguration nearByServiceConfiguration,
                                                                  BaiduPointCongiguration... parms) {
        double distance = nearByServiceConfiguration.getStartDistance(); //初始距离
        double latitude, longitude;
        List<top.geekarea.services.bean.nearby.Tell> result = new ArrayList<>();
        NearbyDao nearbyDao = new NearbyDaoImp();
        DaoResult<List> tellResult = null;
        DaoResult<List> speakResult = null;
        DaoResult<List> tellImgResult = null;
        List<Tell> li;
        String dateFormat = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        BaiDuPointUtil baiDuPointUtil;

        if (tellRepository != null && !tellRepository.equals(null) &&
                tellImgRepository != null && !tellImgRepository.equals(null) &&
                speakRepository != null && !speakRepository.equals(null) ) {
            /*
            获取动态数据，将结果保存在tellResult中
             */
            for (BaiduPointCongiguration baiduPointCongiguration: parms) {
                baiDuPointUtil = new BaiDuPointUtil(baiduPointCongiguration);
                latitude = baiDuPointUtil.getLatitude();
                longitude = baiDuPointUtil.getLongitude();
                tellResult = nearbyDao.query(latitude + distance, latitude - distance,
                        longitude + distance, longitude - distance,
                        latitude, longitude, tellRepository);
                while (!tellResult.isResult() || tellResult.getData() == null) { //如果查询失败或者结果为空,则继续查询操作
                    distance += distance;
                    tellResult = nearbyDao.query(latitude + distance, latitude - distance,
                            longitude + distance, longitude - distance,
                            latitude, longitude, tellRepository);
                    if (distance > nearByServiceConfiguration.getMaxDistance()) {
                        break;
                    }
                }
            }

            if (tellResult.isResult() && tellResult.getData() != null) { //如果查询成功或者结果不为
                li = tellResult.getData();
                for (Tell tell: li) {
                    speakResult = nearbyDao.query(tell, speakRepository);
                    tellImgResult = nearbyDao.query(tell, tellImgRepository);
                    top.geekarea.services.bean.nearby.Tell tel = new top.geekarea.services.bean.nearby.Tell();
                    tel.setHeadPictureUrl(tell.getUser().getIcon());
                    tel.setNickName(tell.getUser().getNickName());
                    tel.setGoodNum(tell.getGoodNum());
                    tel.setPostMsg(tell.getData());
                    tel.setShareNum(tell.getShareNum());
                    tel.setSpeachNum(tell.getSpeackNum());
                    tel.setUserName(tell.getUser().getUserName());
                    int hour = Util.timeDifferenceForHour(tell.getCreateDate(), simpleDateFormat.format(new Date()), dateFormat);
                    int day = Util.timeDifferenceForHour(tell.getCreateDate(), simpleDateFormat.format(new Date()), dateFormat);
                    String dateTimeAndDistance = "";
                    for (BaiduPointCongiguration baiduPointCongiguration: parms) {
                        baiDuPointUtil = new BaiDuPointUtil(baiduPointCongiguration);
                        int s = (int)BaiDuPointUtil.getDistance(tell.getLatitude(), tell.getLongitude(),
                                baiDuPointUtil.getLatitude(), baiDuPointUtil.getLongitude());
                        if (hour > 24) {
                            if (s < 1000) {
                                dateTimeAndDistance += ("时间："+day+"d 距离："+s+"m");
                            } else {
                                dateTimeAndDistance += ("时间："+day+"d 距离："+s/1000+"km");
                            }
                        } else {
                            if (s < 1000) {
                                dateTimeAndDistance += ("时间："+hour+"h 距离："+s+"m");
                            } else {
                                dateTimeAndDistance += ("时间："+hour+"h 距离："+s/1000+"km");
                            }
                        }
                    }
                    tel.setDateTimeAndDistance(dateTimeAndDistance);
                    List<TellImg> li2 = tellImgResult.getData();
                    List<String> li3 = new ArrayList();
                    if (tellImgResult.isResult() && li2 != null) {
                        for (TellImg img: li2) {
                            li3.add(img.getUrl());
                        }
                    }
                    tel.setImgUrl(li3);
                    List<top.geekarea.entity.Speak> li4 = speakResult.getData();
                    List<Speak> speaks = new ArrayList<>();
                    if (speakResult.isResult() && li4 != null) {
                        for (top.geekarea.entity.Speak spe: li4) {
                            Speak speak = new Speak();
                            int hour2 = Util.timeDifferenceForHour(spe.getCreateDate(), simpleDateFormat.format(new Date()), dateFormat);
                            int day2 = Util.timeDifferenceForHour(spe.getCreateDate(), simpleDateFormat.format(new Date()), dateFormat);
                            if (hour2 > 24) {
                                speak.setTimeout(day2+"d");
                            } else {
                                speak.setTimeout(hour2+"h");
                            }
                            speak.setSpeakMsg(spe.getMessage());
                            speak.setNickName(spe.getUser().getNickName());
                            speak.setHeadPictureUrl(spe.getUser().getIcon());
                            speak.setUserName(spe.getUser().getUserName());
                            speaks.add(speak);
                            tel.setSpeak(speaks);
                        }
                    }
                    result.add(tel);
                }
            }
        }
        return result;
    }
}
