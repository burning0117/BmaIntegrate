package test;

import domain.Category;
import domain.CategorySecond;
import domain.Order;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

import java.util.List;

/**
 * Created by lily on 2016/5/10.
 */
public class OrderTest {
    private static SessionFactory sessionFactory;

    static {
        Configuration configuration = new Configuration();
        //加载配置文件
        configuration.configure();
        //采用了工厂模式创建sessionFactory
        sessionFactory = configuration.buildSessionFactory();
    }

    @Test
    public void test1() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Order order = new Order();
        order.setName("test");
        session.save(order);
        transaction.commit();
        session.close();
    }

    @Test
    public void category() {
        String[] test = {
                "计算资源",
                "Web和移动",
                "数据和存储",
                "分析",
                "物联网"
        };
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        for (int i = 0; i < test.length; i++) {
            Category category = new Category();
            category.setCname(test[i]);
            session.save(category);
        }
        transaction.commit();
        session.close();
    }

    @Test
    public void categorySecond() {
        String[] test = {
                "云服务",
                "批处理",
                "Web应用",
                "移动服务",
                "通知中心",
                "SQL数据库",
                "Redis缓存",
                "存储",
                "MySql DataBase",
                "HDInsight",
                "流分析",
                "事件中心",
                "流分析",
                "通知中心",
                "虚拟机"
        };
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        for (int i = 0; i < test.length; i++) {
            CategorySecond category = new CategorySecond();
            category.setCsname(test[i]);
            session.save(category);
        }
        transaction.commit();
        session.close();
    }

    @Test
    public void preuser() {
        String[] test = {
                "burning", "张西安", "zhang123", "15764236737", "青大三路浮山公寓", "aaa@shop.com", "1", "200fb5cd4b22438a8d902c3ab5f1e2a8e6e66525bdfc4751a499f10ee455128d"
        };
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        for (int i = 0; i < test.length; i++) {
        }
        transaction.commit();
        session.close();
    }

    @Test
    public void BinaryMatch() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Order> orderList= (List<Order>) session.createQuery("from Order");

        for (Order order:orderList){
            System.out.println(order.getOid());
        }
    }
}
