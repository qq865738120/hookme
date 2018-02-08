package top.geekarea.DAO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.geekarea.DAO.repository.UserRepository;
import top.geekarea.entity.User;
import top.geekarea.enums.DaoResultEnum;
import top.geekarea.utils.UUIDUtil;

/**
 * 用户dao实现类
 * Created by code_xia on 2017/4/18.
 */
public class UserDaoImp implements UserDao {

    private final static Logger logger = LoggerFactory.getLogger(UserDaoImp.class);

    public UserDaoImp() {

    }

    /**
     * 用户信息持久化
     * @param user
     * @param userRepository
     * @return
     */
    @Override
    public DaoResult save(User user, UserRepository userRepository) {

        DaoResult daoResult;
        if (user.getUserName() == null || user.getPassword() == null || user.getAge() ==null) { //用户名，密码和年龄有一个为空则不存入数据库
            daoResult = new DaoResult(DaoResultEnum.USER_INCOMPLETE_INFORMATION);
            return daoResult;
        }
        if (user.getEmail() == null) { //没有邮箱
            if (userRepository.findByUserName(user.getUserName()) == null) { //用户名没有重复
                user.setActiveCode(UUIDUtil.createCode());
                userRepository.save(user);
                logger.info("save={}", user.toString());
                daoResult = new DaoResult(DaoResultEnum.USER_SAVE_SUCCESS_TO_NAME);
                return daoResult;
            } else {
                daoResult = new DaoResult(DaoResultEnum.USER_USER_NAME_REPETITION);
                return daoResult;
            }
        } else { //有邮箱要同时验证用户名和邮箱
            if (userRepository.findByUserNameOrEmail(user.getUserName(), user.getEmail()) == null) {
                user.setActiveCode(UUIDUtil.createCode());
                userRepository.save(user); //把用户数据写入数据库
                logger.info("save={}", user.toString());
                daoResult = new DaoResult(DaoResultEnum.USER_SAVE_SUCCESS_TO_EMAIL);
                return daoResult;
            } else {
                daoResult = new DaoResult(DaoResultEnum.USER_USER_NAME_OR_EMAIL_REPETITION);
                return daoResult;
            }
        }
    }

    /**
     * 根据用户id查找用户
     * @param id
     * @param userRepository
     * @return
     */
    @Override
    public DaoResult<User> query(Long id, UserRepository userRepository) {
        User user = userRepository.findOne(id);
        DaoResult<User> daoResult = null;
        if (user == null) { //如果查询结果为空
            daoResult = new DaoResult<User>(DaoResultEnum.QUERY_NULL);
        } else { //如果查询结果不为空
            daoResult = new DaoResult<>(DaoResultEnum.QUERY_SUCCESS);
            daoResult.setData(user);
        }
        return null;
    }
}
