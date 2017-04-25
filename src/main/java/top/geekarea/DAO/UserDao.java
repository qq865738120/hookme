package top.geekarea.DAO;

import com.alibaba.fastjson.JSONObject;
import top.geekarea.DAO.repository.UserRepository;
import top.geekarea.entity.User;

/**
 * 用户dao接口
 * Created by code_xia on 2017/4/18.
 */
public interface UserDao {

    DaoResult save(User user, UserRepository userRepository);
}
