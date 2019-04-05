package kr.ac.jejunu.userdao;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class UserDaoTests {
    private UserDao userDao;

    @Before
    public void setup() {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(DaoFactory.class);
        userDao = applicationContext.getBean("userDao", UserDao.class);
    }
    @Test
    public void testGet() throws SQLException, ClassNotFoundException {
        Long id = 1l;
        String name = "허윤호";
        String password = "1234";
//        DaoFactory daoFactory = new DaoFactory();
//        UserDao userDao = daoFactory.userDao();
        User user = userDao.get(id);
        assertThat(user.getId(), is(id));
        assertThat(user.getName(), is(name));
        assertThat(user.getPassword(), is(password));
    }
    @Test
    public void testAdd() throws SQLException, ClassNotFoundException {
        User user = new User();
        String name = "헐크";
        user.setName(name);
        String password = "!111";
        user.setPassword(password);
//        DaoFactory daoFactory = new DaoFactory();
//        UserDao userDao = daoFactory.userDao();
        Long id = userDao.add(user);
        User resultUser = userDao.get(id);
        assertThat(resultUser.getId(), is(id));
        assertThat(resultUser.getName(), is(name));
        assertThat(resultUser.getPassword(), is(password));
    }
//    @Test
//    public void testUpdatte() throws SQLException, ClassNotFoundException {
//        User user = new User();
//        String name = "헐크";
//        user.setName(name);
//        String password = "!111";
//        user.setPassword(password);
//        DaoFactory daoFactory = new DaoFactory();
//        UserDao userDao = daoFactory.userDao();
//        Long id = userDao.add(user);
//
//        user.setId(id);
//
//        String changedName= null;
//        user.setName(changedName);
//        String changedPassword = null;
//        user.setPassword(changedPassword);
//
//        userDao.update(user);
//
//        User resultUser = userDao.get(id);
//        assertThat(resultUser.getId(), is(id));
//        assertThat(resultUser.getName(), is(changedName));
//        assertThat(resultUser.getPassword(), is(changedPassword);
//
//
//    }



//    @Test
//    public void testHallaGet() throws SQLException, ClassNotFoundException {
//        Long id = 1l;
//        String name = "헐크";
//        String password = "1111";
//        DaoFactory daoFactory = new DaoFactory();
//        UserDao userDao = daoFactory.userDao();
//        User user = userDao.get(id);
//        assertThat(user.getId(), is(id));
//        assertThat(user.getName(), is(name));
//        assertThat(user.getPassword(), is(password));
//    }
}
