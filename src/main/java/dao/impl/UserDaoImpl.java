package dao.impl;

import dao.BaseDao;
import dao.UserDao;
import pojo.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: ShallowDream7
 * @Date: 2019/3/3 10:28
 * @Description:
 */
public class UserDaoImpl extends BaseDao implements UserDao {
    public int addByUser(User User) {
        String sql="insert into user(id,name)values(?,?)";
        Object[] objects={User.getId(),User.getName()};
        return executeUpdate(sql,objects);
    }

    public int delById(String id) {
        String sql="Delete from user where id=?";
        return executeUpdate(sql,id);
    }

    public int updateByUser(User User) {
        String sql="update user set id=?,name=? where id=?";
        Object[] objects={User.getId(),User.getName(),User.getId()};
        return executeUpdate(sql,objects);
    }

    public User findUserByid(String id) {
        String sql="select * from user where id=?";
        ResultSet rs=getRs(sql,id);
        try {
            while(rs.next()){
               return set(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            close();
        }
        return null;
    }

    public List<User> findAll() {
        String sql="select * from user";
        ResultSet rs=getRs(sql);
        List<User> userList=new ArrayList<pojo.User>();
        try {
            while(rs.next()){
                userList.add(set(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            close();
        }
        return userList;
    }

    /**
     * 设置对象的值
     * @param set
     * @return
     */
    public User set(ResultSet set){
        User User=new User();
        try {
            User.setId(set.getString(1));
            User.setName(set.getString(2));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return User;
    }

}
