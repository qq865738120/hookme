package top.geekarea.DAO.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.geekarea.entity.Tell;

import java.util.List;

/**
 * 说说的Repository接口
 * Created by Hasee on 2017/3/23.
 */
@Repository
public interface TellRepository extends JpaRepository<Tell, Long> {

    /**
     * 查询一定经纬度范围内的数据
     * @param max1 纬度最大值
     * @param min1 纬度最小值
     * @param max2 经度最大值
     * @param min2 经度最小值
     * @return
     */
    List<Tell> findAllByLatitudeBetweenAndLongitudeBetween(double min1, double max1, double min2, double max2);
}
