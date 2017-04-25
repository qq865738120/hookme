package top.geekarea.DAO.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.geekarea.entity.User2User;

/**
 * 用户绑定关系Repository接口
 * Created by Hasee on 2017/3/23.
 */
@Repository
public interface User2UserRepository extends JpaRepository<User2User, Long> {

}
