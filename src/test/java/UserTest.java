import dao.UserDao;
import dao.impl.UserDaoImpl;
import org.junit.Test;
import pojo.User;

/**
 * @Auther: ShallowDream7
 * @Date: 2019/3/3 10:57
 * @Description:
 */
public class UserTest {

    UserDao UserDao=new UserDaoImpl();

    @Test
    public void insert(){
        User User=new User();
        User.setId("2");
        User.setName("joke");
        System.out.print(UserDao.addByUser(User));
    }

    @Test
    public void del(){
        System.out.print(UserDao.delById("1"));
    }

    @Test
    public void update(){
        User User=new User();
        User.setId("1");
        User.setName("joke2");
        System.out.print(UserDao.updateByUser(User));
    }

    @Test
    public void findById(){
        System.out.print(UserDao.findUserByid("1").getName());
    }

    @Test
    public void findAll(){
        for(User User:UserDao.findAll()){
            System.out.println(User.getName());
        }
    }

}
