package top.geekarea.DAO;

import top.geekarea.DAO.repository.SpeakRepository;
import top.geekarea.DAO.repository.TellImgRepository;
import top.geekarea.DAO.repository.TellRepository;
import top.geekarea.entity.Tell;

import java.util.List;

/**
 * 动态dao接口
 */
public interface NearbyDao {

    DaoResult<List> query(double max1, double min1, double max2, double min2,
                          double latitude, double longitude, TellRepository tellRepository);

    DaoResult<List> query (Tell tell, SpeakRepository speakRepository);

    DaoResult<List> query (Tell tell, TellImgRepository tellImgRepository);
}
