package dao;

import pojo.User;

import java.util.List;

/**
 * @Auther: ShallowDream7
 * @Date: 2019/3/3 10:28
 * @Description:
 */
public interface UserDao {
    int addByUser(User User);
    int delById(String id);
    int updateByUser(User User);
    User findUserByid(String id);
    List<User> findAll();
}
