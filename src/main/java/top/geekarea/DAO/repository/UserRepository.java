package top.geekarea.DAO.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.geekarea.entity.User;

/**
 * 用户repository接口
 * Created by Hasee on 2017/3/23.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {//该接口继承了PagingAndSortingRepository具有分页查找和排序的方法

    User findByUserName(String userName); //通过userName查询User

    User findByUserNameOrEmail(String userName, String email); //通过userName或者email查询User
}
