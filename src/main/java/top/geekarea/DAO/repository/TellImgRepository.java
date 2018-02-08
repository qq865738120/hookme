package top.geekarea.DAO.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.geekarea.entity.Tell;
import top.geekarea.entity.TellImg;

import java.util.List;

/**
 * 说说图片的Repository接口
 */
public interface TellImgRepository extends JpaRepository<TellImg, Long> {

    List<TellImg> findAllByTell(Tell tell);
}
