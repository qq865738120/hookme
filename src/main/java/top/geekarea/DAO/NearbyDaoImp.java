package top.geekarea.DAO;

import top.geekarea.DAO.repository.SpeakRepository;
import top.geekarea.DAO.repository.TellImgRepository;
import top.geekarea.DAO.repository.TellRepository;
import top.geekarea.entity.Speak;
import top.geekarea.entity.Tell;
import top.geekarea.entity.TellImg;
import top.geekarea.enums.DaoResultEnum;
import top.geekarea.utils.BaiDuPointUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 动态dao接口实现类
 */
public class NearbyDaoImp implements NearbyDao {

    /**
     * 查询一定范围内的动态
     * @param max1 最大纬度
     * @param min1 最小纬度
     * @param max2 最大经度
     * @param min2 最小经度
     * @param tellRepository tell仓库
     * @return 查询结果
     */
    @Override
    public DaoResult<List> query(double max1, double min1, double max2, double min2,
                                 double latitude, double longitude, TellRepository tellRepository) {
        List<Tell> list = tellRepository.findAllByLatitudeBetweenAndLongitudeBetween(min1, max1, min2, max2);
        double r = BaiDuPointUtil.getDistance(max1, longitude, latitude, longitude);
        List<Tell> list2 = new ArrayList<>();
        DaoResult<List> daoResult = null;
        if (list.size() == 0) { //查询结果为空
            daoResult = new DaoResult<List>(DaoResultEnum.QUERY_NULL);
        } else { //查询结果不为空
            for (Tell tell: list) {
                double latitude2 = tell.getLatitude();
                double longitude2 = tell.getLongitude();
                double s = BaiDuPointUtil.getDistance(latitude, longitude, latitude2, longitude2);
                if (!(s > r)) { //如果距离不大于半径
                    list2.add(tell);
                }
            }
            if (list2.size() == 0) { //删选结果为空
                daoResult = new DaoResult<List>(DaoResultEnum.QUERY_NULL);
            } else { //删选结果不为空
                daoResult = new DaoResult<List>(DaoResultEnum.QUERY_SUCCESS);
                daoResult.setData(list2);
            }
        }
        return daoResult;
    }

    /**
     * 根据动态查找所有评论
     * @param tell
     * @return daoResult
     */
    @Override
    public DaoResult<List> query(Tell tell, SpeakRepository speakRepository) {
        DaoResult<List> daoResult;
        List<Speak> data = speakRepository.findAllByTell(tell);
        if (data.size() != 0) { //结果不为空
            daoResult = new DaoResult<>(DaoResultEnum.QUERY_SUCCESS);
            daoResult.setData(data);
        } else { //结果为空
            daoResult = new DaoResult<>(DaoResultEnum.QUERY_NULL);
        }
        return daoResult;
    }

    /**
     * 根据动态查找所有图片内容
     * @param tell
     * @param tellImgRepository
     * @return daoResult
     */
    @Override
    public DaoResult<List> query(Tell tell, TellImgRepository tellImgRepository) {
        DaoResult<List> daoResult;
        List<TellImg> data = tellImgRepository.findAllByTell(tell);
        if (data.size() != 0) { //结果不为空
            daoResult = new DaoResult<>(DaoResultEnum.QUERY_SUCCESS);
            daoResult.setData(data);
        } else { //结果为空
            daoResult = new DaoResult<>(DaoResultEnum.QUERY_NULL);
        }
        return daoResult;
    }
}
