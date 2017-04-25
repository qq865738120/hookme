package top.geekarea.DAO.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.geekarea.entity.Tell;

/**
 * 说说的Repository接口
 * Created by Hasee on 2017/3/23.
 */
@Repository
public interface TellRepository extends JpaRepository<Tell, Long> {

}
