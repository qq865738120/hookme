package top.geekarea.DAO.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.geekarea.entity.Speak;
import top.geekarea.entity.Tell;

import java.util.List;

/**
 * 评论的Repository接口
 */
public interface SpeakRepository extends JpaRepository<Speak, Long> {

    List<Speak> findAllByTell(Tell tell);
}
